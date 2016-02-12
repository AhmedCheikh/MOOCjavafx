/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import pidev.dao.classes.DAOChapitre;
import pidev.entities.Chapitre ;


public class AffichageCoursController  {
@FXML
private Hyperlink formateur1 ;

 @FXML
private MediaView video1 ;   
 @FXML
private TextField idtextrech ;

@FXML
private TextArea description ;

   @FXML
private Hyperlink telecharger;
   
  @FXML private TableView<DAOChapitre> tableChapites;
  @FXML private TableColumn chapitreId ;
  @FXML private TableColumn objectifId ;
    ObservableList<Chapitre> chap ;
    
 @FXML
     private void btnrechAction(ActionEvent event)  {
        if (idtextrech.getText().isEmpty())
        {
            idtextrech.setStyle("-fx-background-color: red;");
        }
        
    }
     
    @FXML
     private void  textChangeColorAction(ActionEvent event)  {
         idtextrech.setStyle("-fx-background-color: white;");
          description.setText("saisir nom Cours ...");
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

    

   
}
