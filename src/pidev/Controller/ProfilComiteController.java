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
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ProfilComiteController implements Initializable {

     
    
    @FXML private Button validerVideo ;
    @FXML private Button validerDescription ;
    @FXML private Button validerCours ;
    @FXML private Button validerQuiz ;
    @FXML private Button validerCandidature ;
    @FXML private Button validerIntegration ;
    
    @FXML
    private void validerVideoAction (ActionEvent event) throws IOException {
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ValiderVideo.fxml"));
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
        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ValiderIntegration.fxml"));
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Stage stage =  new Stage();
            Scene scene = new Scene(parent);
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setScene(scene);
            stage.setTitle("Valider les demandes d'intégration à la comité");
            stage.show();
        
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
