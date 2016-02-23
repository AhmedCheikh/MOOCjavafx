/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.Button;
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
        
        
            Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ValiderVideo.fxml"));
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage =  new Stage();
            Scene scene = new Scene(parent);
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setScene(scene);
            stage.setTitle("Profil Apprenant");
            stage.show();
        
    }
    
    @FXML
    private void validerDescriptionAction (ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ValiderDescription.fxml"));
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage =  new Stage();
            Scene scene = new Scene(parent);
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setScene(scene);
            stage.setTitle("Valider les descriptions");
            stage.show();
        
    }
    
    @FXML
    private void validerCoursAction (ActionEvent event) throws IOException {
        
        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ValiderCours.fxml"));
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage =  new Stage();
            Scene scene = new Scene(parent);
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setScene(scene);
            stage.setTitle("Valider les cours");
            stage.show();
        
    }
    
    @FXML
    private void validerQuizAction (ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ValiderQuiz.fxml"));
           ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage =  new Stage();
            Scene scene = new Scene(parent);
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setScene(scene);
            stage.setTitle("Valider les Quiz");
            stage.show();
        
    }
    @FXML
    private void validerCandidatureAction (ActionEvent event) throws IOException {
        
//        ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ValiderCandidature.fxml"));
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage =  new Stage();
            Scene scene = new Scene(parent);
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setScene(scene);
            stage.setTitle("Valider les candidatures");
            stage.show();
        
    }
    
    @FXML
    private void validerIntegrationAction (ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ValiderDemandeIntegration.fxml"));
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage =  new Stage();
            Scene scene = new Scene(parent);
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setScene(scene);
            stage.setTitle("Valider les demandes d'intégration à la comité");
            stage.show();
        
    }
    
        @FXML
    private void btnDeconnecterAction(ActionEvent event) throws IOException {
//        ((Node) (event.getSource())).getScene().getWindow().hide();
//        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/FXMLAuthentification.fxml"));
//        Stage stage = new Stage();
//        Scene scene = new Scene(parent);
//        stage.setScene(scene);
//        stage.setTitle("Authentification");
//        stage.show();
        Stage stage = (Stage) btnDeconnecter.getScene().getWindow();
        stage.close();
        
    }
    
    public void setInfo(String info) throws IOException {
        
        DAOComite da = new DAOComite();
        System.out.println(info);
        comite = da.getComiteByLogin(info);
        //apprenant1 = da.getApprenantByLogin(info);
//        String filename =comite.getNom(); 
        
        //imageView.setImage(new Image(getClass().getResourceAsStream("pidev/gui/img/"+filename+".jpg")));
        txtCin.setText(comite.getCIN());
        
        txtNom.setText(comite.getNom());
        txtPrenom.setText(comite.getPrenom());
        txtEmail.setText(comite.getEmail());
        txtNom2.setText("Bonjour "+ comite.getPrenom());
        
        
        this.info = info;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
