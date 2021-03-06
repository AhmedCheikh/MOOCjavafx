/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;


import java.io.File;
import java.io.IOException;
import java.net.URL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;

import pidev.dao.classes.*;
import pidev.entities.* ;
import pidev.techniques.DataSource;
import pidev.gui.video.*;
import pidev.tests.test;
public class FXMLAffichageCours2Controller  implements Initializable{

@FXML
private TextArea description ;

  @FXML
  private Label labelCours;
  @FXML private TableView<Chapitre> table;
  @FXML private TableColumn chapitre ;
  @FXML private TableColumn objectif ;
    public String nom ;
    public Cours info; 
    public String formateur ;
private Connection connection ; 
private Media me ;
    private RadioButton radioExcellent;
    private RadioButton radioMoyen;
    private RadioButton radioMauvais;
    
    public CoursSuivie cs;
    private ToggleGroup appreciation;
    public Apprenant apprenant;
    @FXML
    private Button btnVideo;
    @FXML
    private Button faireQuiz;
    @FXML
    private Button Formateur1;
    
    @FXML
    private TextField txtNote;
    @FXML
    private TextArea txtCommentaire;
    @FXML
    private Label txtJour;

        @FXML
    private TextField txtDateDebut;
    @FXML
    private TextField txtDateFin;

    public FXMLAffichageCours2Controller() {
            connection = (DataSource.getInstance()).getConnection();
    
    }
//   private String MEDIA_URL ="http://download.oracle.com/otndocs/javafx/JavaRap_ProRes_H264_768kbit_Widescreen.mp4";
   public static String pathFile ;
  
    private MediaPlayer mediaPlayer;
    final double mediaWidth = 480;  
    final double mediaHeight = 270;  
 
    public void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root,480,270));
         String path = new File("src/pidev/gui/video/"+pathFile).getAbsolutePath();
        me = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(me);
        
        mediaPlayer.setAutoPlay(true);
        VideoFXDemo.PlayerPane playerPane = new VideoFXDemo.PlayerPane(mediaPlayer);
        playerPane.setMinSize(mediaWidth, mediaHeight);  
        playerPane.setPrefSize(mediaWidth, mediaHeight);
        playerPane.setMaxSize(mediaWidth, mediaHeight);
        
        root.getChildren().add(playerPane);
    }
     public void play() {
        MediaPlayer.Status status = mediaPlayer.getStatus();
        if (status == MediaPlayer.Status.UNKNOWN || status == MediaPlayer.Status.HALTED) {
            return;
        }
        if (status == MediaPlayer.Status.PAUSED || status == MediaPlayer.Status.STOPPED || status == MediaPlayer.Status.READY) {
            mediaPlayer.play();
        }
    }
 
//    @Override public void stop() {
//        mediaPlayer.stop();
//    }
          @FXML
   private void btnVideoAction(ActionEvent event)  {
       
           
            Stage stage = new Stage();
init(stage);
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setTitle("VIDEO");
            stage.show();
               play();
   }
   @FXML
   private void faireQuizAction(ActionEvent event)  {
        FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/pidev/gui/AfficherQuizChrono.fxml"));
                try {
                    loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AfficherCoursEtChapitreApprenantController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Parent p = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
                stage.setTitle("Faire Quiz");
                AfficherQuizChronoController pac  = loader.getController();
//                pac.setPnomc(nom);
                stage.show();
   }
@FXML
private void Formateur1Action(ActionEvent event) throws IOException  {
        ((Node) (event.getSource())).getScene().getWindow().hide();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pidev/gui/ProfilFormateur.fxml"));
                    try {
                        loader.load();
                    } catch (IOException ex) {
                        Logger.getLogger(AfficherCoursEtChapitreApprenantController.class.getName()).log(Level.SEVERE, null, ex);
                    }
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setTitle("Profil Formateur");
            ProfilFormateurController pac  = loader.getController();
//            pac.setFormateur(formateur);
            stage.show();
   }


    @Override
    public void initialize(URL location, ResourceBundle resources)  {

    }

    public void setInfo(Cours info) {
        
        this.info = info;
          labelCours.setText(info.getNomCours());
          description.setText(info.getDescription());
          formateur=info.getCinFormateur() ;
          nom=info.getNomCours();
          pathFile=info.getVideo();
          
    }
    @FXML
    private void btnCommenterAction(ActionEvent event) {

    }
    
    
   @FXML
    private void changerAppreciation(MouseEvent event) {
//        DAOCoursSuivie dcs = new DAOCoursSuivie();
//        radioExcellent.setToggleGroup(appreciation);
//        radioMoyen.setToggleGroup(appreciation);
//        radioMauvais.setToggleGroup(appreciation);
//          
//        appreciation.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//        @Override
//        public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {
//
//            RadioButton chk = (RadioButton)t1.getToggleGroup().getSelectedToggle();
//            dcs.donnerAppreciation(chk.getText(), apprenant.getCin());
//        }
//    });
          
        }
    

   
}
