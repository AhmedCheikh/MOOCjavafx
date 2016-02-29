
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import javafx.stage.Stage;

import pidev.dao.classes.*;
import pidev.entities.Formateur;
import pidev.entities.Organisme;


public class ControllerAthentification implements Initializable {
 public static ControllerAthentification c ;
    public static String connection;
    private MyBrowser myBrowser;
    private Scene scene;
    Stage browserStage;
    Stage stage;
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
    private Hyperlink idcontact ;
    public Stage getStage(){
        return browserStage;
    }
   @FXML
   private void btnfbAction(ActionEvent event)
   {
       myBrowser = new MyBrowser();
        scene = new Scene(myBrowser, 640, 480);
        browserStage = new Stage();
        browserStage.setScene(scene);
        browserStage.show();
        connection = "FB";
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
                stage.show();
            } else {
                message.setText(" CIN ou Password Incorrecte ");
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
            Organisme org3 = new Organisme();

            if (org.authentificationOrganisme(login.getText(), password.getText()) && org.getEtat(login.getText()) == 1 && org.getComplete(login.getText()).equals("complete")) {

//               Organisme o = new Organisme(nom);
                //lblmessage.setText(" vos identifiant sont correcte ");
                        Organisme Org = new Organisme(login.getText());
log=login.getText();
                ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ProfileOrganismeA.fxml"));
        loader.load();
        Parent parent = loader.getRoot();
        ProfileOrganismeAController poc = loader.getController();
        
        Stage stage = new Stage();
        stage.setTitle("Profil Organisme");
        stage.setScene(new Scene(parent));
        stage.getIcons().add(new javafx.scene.image.Image("pidev/gui/img/icone.png"));
        stage.show();
                
            } else if (org.authentificationOrganisme(login.getText(), password.getText()) && org.getEtat(login.getText()) ==1 && org.getComplete(login.getText()).equals("pas complete")) {
                 Organisme Org = new Organisme(login.getText());

                ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/InscrireOrganisme.fxml"));
        loader.load();
        Parent parent = loader.getRoot();
        InscrireOrganismeController ioc = loader.getController();
        ioc.setOg(Org);
        Stage stage = new Stage();
        stage.setTitle("Profil Organisme");
        stage.setScene(new Scene(parent));
        stage.getIcons().add(new javafx.scene.image.Image("pidev/gui/img/icone.png"));
        stage.show();
            } 
            else if(org.authentificationOrganisme(login.getText(), password.getText()) && org.getEtat(login.getText()) ==0 ){
                  message.setText("Vous etes classe dans la liste d'attente");
                login.setText("");
                password.setText(""); 
            
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
    @FXML
        public void pwdAction(ActionEvent event) throws IOException {
      
                
         ((Node) (event.getSource())).getScene().getWindow().hide();
                Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/RetrouverCompte.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
                stage.setScene(scene);
                stage.setTitle("Retrouver votre compte");
                stage.show();  }
@FXML
        public void contactAction(ActionEvent event) throws IOException {
      
                
         ((Node) (event.getSource())).getScene().getWindow().hide();
                Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/Mail.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
                stage.setScene(scene);
                stage.setTitle("Mail");
                stage.show();  }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      c = this;
    }    
   
}
