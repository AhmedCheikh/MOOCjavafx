/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import static pidev.Controller.ProfilFormateurController.c;
import static pidev.Controller.ProfilFormateurController.f2;
import pidev.dao.classes.DAOOrganisme;
import pidev.entities.Formateur;
import pidev.entities.Invitation;
import pidev.entities.Organisme;

/**
 * FXML Controller class
 *
 * @author Rimy Jeljeli
 */
public class ProfileOrganismeAController implements Initializable {
    @FXML
    private Label nom;
  @FXML
    private TextArea desc;
  @FXML
    private Label adresse;
 @FXML
    private Label tel;
  @FXML
    private Label site,notif;
@FXML
private Button dec;
@FXML
private ImageView imageV;


private  Organisme o;
    
    DAOOrganisme daoO = new DAOOrganisme();
    Organisme o1 = new Organisme();
    @FXML
    private Button listeFormateur;
    @FXML
    private Button btnListeFormateur1organisme;
    @FXML
    private Button btnModifier;
    public ObservableList<Invitation> listInvit = FXCollections.observableArrayList();

public void btnDeconnecterAction(ActionEvent event) throws IOException{
                ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/pidev/gui/FXMLAuthentification.fxml"));
                loader.load();                
                Parent p = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
    }
    @FXML
    public void btnListeFormateurAction(ActionEvent event) throws IOException{
                    Organisme o5 = new Organisme(nom.getText());
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ListeFormateurs.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        ListeFormateursController lstFor = loader.getController();
        lstFor.setO(o5);
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }

    @FXML
    public void BtnlisteInvitAction(ActionEvent event) throws IOException{
                     Organisme o5 = new Organisme(nom.getText());
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/listeInvitationFormateurs.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        listeInvitationFormateursController lstinvitFor = loader.getController();
        lstinvitFor.setO(o5);
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }
        @FXML
    public void btnListeFormateur1organismeAction(ActionEvent event) throws IOException{
      
                     Organisme o5 = new Organisme(nom.getText());
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ListeFormateur1Organisme.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        ListeFormateur1OrganismeController ListeFormateur1Organisme = loader.getController();
        ListeFormateur1Organisme.setO(o5);
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }
    
    
                @FXML
    public void btnConcurentsAction(ActionEvent event) throws IOException{
       Organisme o5 = new Organisme(nom.getText());
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ListeConcurrents.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        ListeConcurrentsController ListeConcurrents = loader.getController();
        ListeConcurrents.setO(o5);
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }
    
@FXML
public  void btnModifierAction(ActionEvent event) throws IOException{
     ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/pidev/gui/EditProfilOrganisme.fxml"));
                loader.load();                
                Parent p = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
}
                @FXML
public  void btnDecAction(ActionEvent event) throws IOException{
     ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/pidev/gui/PageAcceuille.fxml"));
              
                loader.load();                
                Parent p = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                
                stage.show();
} 

    public void setO(Organisme o) {
        Organisme o2=new Organisme();
        o2 = daoO.getOrganisme(o.getLogin());
        
      
        this.o = o;

    }
    
    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
   ControllerAthentification ca=new ControllerAthentification();
  
        o1 = daoO.getOrganisme(ca.log);
        System.out.println(""+o1.getDescription());
         System.out.println(""+o1.getAdresse());
          System.out.println(""+o1.getTelephone());
           System.out.println(""+o1.getSiteweb());
        nom.setText(o1.getNom());
        desc.setText(o1.getDescription());
        adresse.setText(o1.getAdresse());
        tel.setText(o1.getTelephone());
        site.setText(o1.getSiteweb());
  DAOOrganisme daoo = new DAOOrganisme();
        listInvit = daoo.FindInvitationByNom(nom.getText());
       int x= listInvit.size();
       notif.setText("   "+x);
        System.out.println("logo="+o1.getLogo());
       File file = new File("src/pidev/gui/img/"+o1.getLogo());
        Image image = new Image(file.toURI().toString());
        imageV.setImage(image);
    }    
    
    
    

}
