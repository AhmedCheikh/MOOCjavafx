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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import pidev.tests.test;


public class AffichageCoursController  {
@FXML
private Hyperlink formateur1 ;
@FXML
private Hyperlink chapitre1 ;
 @FXML
private MediaView video1 ;   
 @FXML
private TextField idtextrech ;
@FXML
private Hyperlink chapitre2 ;
@FXML
private Hyperlink chapitre3 ;
@FXML
private Hyperlink chapitre4;
@FXML
private TextArea description ;
@FXML
private TextArea desc1 ;
@FXML
private TextArea desc2 ;
@FXML
private TextArea desc3 ;
@FXML
private TextArea desc4 ;
   @FXML
private Hyperlink telecharger;
   @FXML
   private void chapitre1Action(ActionEvent event) throws IOException 
   {
   ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/modifierCours.fxml"));
            Stage stage =  new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
//            stage.setTitle("Profil Formateur");
            stage.show();
   }
    
 @FXML
     private void btnrechAction(ActionEvent event)  {
        
        
    }
   @FXML
   private void faireQuizAction(ActionEvent event)  {
        
   }
@FXML
private void Formateur1Action(ActionEvent event) throws IOException  {
        ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ProfilFormateur.fxml"));
            Stage stage =  new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Profil Formateur");
            stage.show();
   }

@FXML
private void telechargerAction(ActionEvent event)  {
        
   }
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    

   
}
