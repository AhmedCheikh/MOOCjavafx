/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import pidev.dao.classes.*;
import pidev.entities.Comite;


public class ProfilComiteController implements Initializable {

     @FXML private Label txtCin ;
     @FXML private Label txtNom, txtNom2 ; 
     @FXML private Label txtPrenom ;
     @FXML private Label txtEmail ;
     private String info;
     public static Comite comite;
    @FXML private Button validerVideo ;
    @FXML private Button validerDescription ;
    @FXML private Button validerCours ;
    @FXML private Button validerQuiz ;
    @FXML private Button validerCandidature ;
    @FXML private Button validerIntegration ;
    @FXML private Button btnDeconnecter ;
    @FXML
    private Hyperlink btnEditProfil;
    
    
    @FXML
    private void btnEditProfilAction(ActionEvent event) throws IOException {
           
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pidev/gui/EditProfilComite.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage =new Stage();
            stage.setScene(new Scene(p));
            EditProfilComiteController epcc  = loader.getController();
            epcc.setComite(comite);
            stage.setTitle("Editer Mon Profil");
            stage.show();
        
    }
    
    @FXML
    private void validerVideoAction (ActionEvent event) throws IOException {
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ValiderVideo.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        ValiderVideoController vvc  = loader.getController();
        vvc.setComite(comite);
        stage.setTitle("Valider les Vidéos");
        stage.show();
        
    }
    
    @FXML
    private void validerDescriptionAction (ActionEvent event) throws IOException {
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ValiderDescription.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        ValiderDescriptionController vdc  = loader.getController();
        vdc.setComite(comite);
        stage.setTitle("Valider les descriptions");
        stage.show();
        
    }
    
    @FXML
    private void validerCoursAction(ActionEvent event) throws IOException {       
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ValiderCours.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        ValiderCoursController vcc  = loader.getController();
        vcc.setComite(comite);
        stage.setTitle("Valider les Cours");
        stage.show();
    }
    
    @FXML
    private void validerQuizAction (ActionEvent event) throws IOException {
       ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ValiderQuiz.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        ValiderQuizController vqc  = loader.getController();
        vqc.setComite(comite);
        stage.setTitle("Valider les Quiz");
        stage.show();
    }
    @FXML
    private void validerCandidatureAction (ActionEvent event) throws IOException {
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ValiderCandidature.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        ValiderCandidatureController vcc  = loader.getController();
        vcc.setComite(comite);
        stage.setTitle("Valider les Candidatures");
        stage.show();
        
    }
    
    @FXML
    private void validerIntegrationAction (ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ValiderDemandeIntegration.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        ValiderDemandeIntegrationController vdic  = loader.getController();
        vdic.setComite(comite);
        stage.setTitle("Valider les candidatures");
        stage.show();
        
    }
    
        @FXML
    private void btnDeconnecterAction(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("Your are leaving application !");
        alert.setContentText("Are you sure to leave?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
    
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/FXMLAuthentification.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        stage.setTitle("Authentification");
        
        stage.show();
    
         } else {
        alert.close();
         }
        
        
    }
    
    public void setInfo(String info) throws IOException {
        
        DAOComite da = new DAOComite();
        
        comite = da.getComiteByLogin(info);
        //apprenant1 = da.getApprenantByLogin(info);
//        String filename =comite.getNom(); 
        
        //imageView.setImage(new Image(getClass().getResourceAsStream("pidev/gui/img/"+filename+".jpg")));
        txtCin.setText(comite.getCIN());
        
        txtNom.setText(comite.getNom());
        txtPrenom.setText(comite.getPrenom());
        txtEmail.setText(comite.getEmail());
        txtNom2.setText("Bonjour "+ comite.getPrenom() +" !");
        
        
        this.info = info;
    }
    
    public void setComite(Comite comite) {
        txtCin.setText(comite.getCIN());
        txtNom.setText(comite.getNom());
        txtPrenom.setText(comite.getPrenom());
        txtEmail.setText(comite.getEmail());
        txtNom2.setText("Bonjour "+ comite.getPrenom() +" !");
       
        this.comite=comite ; 
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
