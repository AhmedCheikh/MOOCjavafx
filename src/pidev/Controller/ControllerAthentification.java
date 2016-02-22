
package pidev.Controller;


import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import javafx.stage.Stage;

import pidev.dao.classes.*;
import pidev.entities.Formateur;


public class ControllerAthentification implements Initializable {
public static String log;
    @FXML
    private Label message;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private Button btnfb;
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
               DropShadow shadow = new DropShadow();
               shadow.setColor(Color.RED);
login.setEffect(shadow);
                               password.setEffect(shadow);
                    }
               
          }
       
       else if (roleAuth.getValue().toString().equals("administrateur"))
       {
           DAOAdministrateur admin= new DAOAdministrateur() ;
           if(admin.authentification(login.getText(), password.getText()))
           {
               ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pidev/gui/ProfilAdministrateur.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setTitle("Profil Admin");
//            ProfilApprenantController pac  = loader.getController();
//            pac.setInfo(info);
            stage.show();
           }
           
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
                 stage.setTitle("Profil Formateur");
                stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
                stage.show();
                } else {
           message.setText("mot de passe ou login erroné");
               login.setText("");
               password.setText("");
               DropShadow shadow = new DropShadow();
               shadow.setColor(Color.RED);
login.setEffect(shadow);
                               password.setEffect(shadow);
        }
            } catch (IOException ex) {
                Logger.getLogger(ControllerAthentification.class.getName()).log(Level.SEVERE, null, ex);
            }
           
       }
       else if (roleAuth.getValue().toString().equals("organisme")) {
            DAOOrganisme org = new DAOOrganisme();
            if (org.authentificationOrganisme(login.getText(), password.getText()) && org.getEtat(login.getText()) == 1) {
                log=login.getText();
                ((Node) (event.getSource())).getScene().getWindow().hide();
                Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ProfilOrganismeA.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
                stage.setScene(scene);
                stage.setTitle("Profil Organisme");
                stage.show();
            } else {
                message.setText("mot de passe ou login erroné");
                login.setText("");
                password.setText("");
                DropShadow shadow = new DropShadow();
               shadow.setColor(Color.RED);
login.setEffect(shadow);
                               password.setEffect(shadow);
            }
        }else if (roleAuth.getValue().toString().equals("comite")) {
            DAOComite com= new DAOComite();
            info = login.getText();
            if(com.authentification(login.getText(), password.getText()))
            {
                ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pidev/gui/ProfilComite.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setTitle("Profil Comite");
            ProfilComiteController pac  = loader.getController();
            pac.setInfo(info);
            stage.show();
            }
        }
       
        
    }
    public void pwdAction(ActionEvent event) throws IOException {
      
                
         ((Node) (event.getSource())).getScene().getWindow().hide();
                Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/RetrouverCompte.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
                stage.setScene(scene);
                stage.setTitle("Retrouver votre compte");
                stage.show();  }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
    }    
   
}
