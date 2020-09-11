
package logica;

import Conexao.Conexao;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author muril
 */
public class TelaController implements Initializable {
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    @FXML
    private TextField txt_email;
    @FXML
    private PasswordField txt_senha;
    
    @FXML
        private void EntrarLogin(ActionEvent event){
            String email;
            email = txt_email.getText();
            
            conn=Conexao.ConnectDB();
            String sql="SELECT*FROM usuarios WHERE Email=? and senha=?";
            
         try{
             pst=(PreparedStatement) conn.prepareStatement(sql);
             pst.setString(1, txt_email.getText());
             pst.setString(2, txt_senha.getText());
             rs=pst.executeQuery();
             
         if(rs.next()){
             System.out.println("Bem Vindo");
             
         }else{
             System.out.print("Erro, informação não econtrada");
         }
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }   
         
        }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
