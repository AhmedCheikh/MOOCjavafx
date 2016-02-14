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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import pidev.dao.classes.*;
import pidev.entities.* ;


public class AffichageCoursController  implements Initializable{
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
  @FXML
  private Label labelCours;
  @FXML private TableView<DAOChapitre> tableChapites;
  @FXML private TableColumn chapitreId ;
  @FXML private TableColumn objectifId ;
    ObservableList<Chapitre> chap ;
    
 @FXML
     private void btnrechAction(ActionEvent event) throws IOException  {
        if (idtextrech.getText().isEmpty())
        {
            idtextrech.setStyle("-fx-background-color: red;");
        }
        else
        {
            DAOCours d= new DAOCours();
            int id=d.findIdCoursByTitre(idtextrech.getText());
            
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final File file = new File("C:\\Users\\Ahmed\\Desktop\\iphone.mp4"); 
        final Media media = new Media(file.toURI().toString()); 
        final MediaPlayer mediaPlayer = new MediaPlayer(media); 
        mediaPlayer.setOnReady(new Runnable(){//dès que le lecteur est prêt, on set les start et stop times
            public void run() {
                mediaPlayer.setStartTime(Duration.ZERO);
                mediaPlayer.setStopTime(media.getDuration().subtract(Duration.valueOf("50")));
            }
        });
        mediaPlayer.setOnEndOfMedia(new Runnable(){//dès qu'on arrive à la fin du média : stop
            public void run() {
                mediaPlayer.stop();
            }
        });
        video1= new  MediaView(mediaPlayer);
        mediaPlayer.play(); 
        Group fonctions = new Group();
         Rectangle fond = new Rectangle(300,30,Color.web("#333333"));
        fond.setOpacity(0.5);
        fonctions.setTranslateY(200-30);
       
    }

    

   
}
