
package pidev.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.tests.test;
import pidev.dao.classes.*;
/**
 *
 * @author akoubi
 */
public class ControllerAthentification implements Initializable {
    
    @FXML
    private Label message;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    private DAOAdministrateur ad ;
    
    @FXML
    private void btnConnexionAction(ActionEvent event) throws IOException  {
        
//        if (login.toString().equals(ad.getLoginAdmin()) && password.toString().equals(ad.getPasswordAdmin()))
//        {
        ((Node) (event.getSource())).getScene().getWindow().hide();
                 Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/FXMLAffichageCours.fxml"));
            Stage stage =  new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Profil");
            stage.show();
//        }
//        else
//            message.setText("mot de passe ou login erroné");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
