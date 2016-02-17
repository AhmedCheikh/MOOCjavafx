
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
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
    
    public ComboBox roleAuth ;
    
    private String info;
    @FXML
    private WebView browser ;
    @FXML
    private void btnConnexionAction(ActionEvent event) throws IOException  {
       if(roleAuth.getValue().toString().equals("apprenant"))
       {
           DAOApprenant app= new DAOApprenant();
           info = login.getText();
          if(app.authentification(login.getText(), password.getText()))
          {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pidev/gui/ProfilApprenant.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setTitle("Profil Apprenant");
            ProfilApprenantController pac  = loader.getController();
            pac.setInfo(info);
            stage.show();
           
          }
          else
          {
               message.setText("mot de passe ou login erroné");
               login.setText("");
               password.setText("");
          }
       }
       else if (roleAuth.getValue().toString().equals("administrateur"))
       {
           DAOAdministrateur admin= new DAOAdministrateur() ;
           
       }
       else if (roleAuth.getValue().toString().equals("formateur"))
       {
           DAOFormateur formateur= new DAOFormateur() ;
           
       }
       else if (roleAuth.getValue().toString().equals("organisme"))
       {
           DAOOrganisme org=new DAOOrganisme() ;
           if(org.authentificationOrganisme(login.getText(), password.getText()) && org.getEtat(login.getText())==1)
           {
              ((Node) (event.getSource())).getScene().getWindow().hide();
                 Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ProfilOrganismeA.fxml"));
            Stage stage =  new Stage();
            Scene scene = new Scene(parent);
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setScene(scene);
            stage.setTitle("Profil Organisme");
            stage.show();
          }
           else
          {
               message.setText("mot de passe ou login erroné");
               login.setText("");
               password.setText("");
          }
       }
       
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       WebEngine engine = browser.getEngine();
		String a = "http://www.facebook.com";
		engine.load(a);
    }    
    
}
