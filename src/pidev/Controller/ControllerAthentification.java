
package pidev.Controller;

import com.restfb.LegacyFacebookClient;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import pidev.entities.Formateur;

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
   private void btnfbAction(ActionEvent event)
   {
       
   }
   
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
          DAOFormateur daof = new DAOFormateur();
            try {
                if (daof.Connecter(login.getText(), password.getText())) {
                Formateur f = new Formateur(login.getText());
                message.setText(" vos identifiant sont correcte ");
                ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/pidev/gui/ProfilFormateur.fxml"));
                loader.load();  
                Parent p = loader.getRoot();
                ProfilFormateurController pfc = loader.getController();
                pfc.setF(f);
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
                } else {
            message.setText(" CIN ou Password Incorrecte ");
        }
            } catch (IOException ex) {
                Logger.getLogger(ControllerAthentification.class.getName()).log(Level.SEVERE, null, ex);
            }
           
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
        
      
    }    
    
}
