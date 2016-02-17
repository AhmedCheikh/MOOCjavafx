/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.dao.classes.DAOChapitre;
import pidev.dao.classes.DAOCours;
import pidev.entities.Chapitre;

/**
 * FXML Controller class
 *
 * @author Gumus
 */
public class AfficherChapitreApprenantController implements Initializable {

    @FXML
    private Button btnPasserQuiz;
    @FXML
    private Button btnTelecharger;
    @FXML
    private MediaView mvVideo;
    @FXML
    private TextArea txtObjectives;
    @FXML
    private Hyperlink hpChapitre1;
    @FXML
    private Hyperlink hpCours1;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    public Chapitre ch;

    public void setCh(Chapitre ch) {
        this.ch = ch;
        ch.getTitre();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        final File file = new File("E:\\---iPhone 7 Trailer 2016.mp4");
        final Media media = new Media(file.toURI().toString());
        final MediaPlayer mediaPlayer = new MediaPlayer(media);
        mvVideo = new MediaView(mediaPlayer);
        mediaPlayer.play();

        hpChapitre1.setText("> Mobile");
        DAOChapitre dch = new DAOChapitre();
        List l = dch.findChapitreByTitre("Mobile");
 
        Chapitre s = (Chapitre) l.get(0);
     
        DAOCours dc = new DAOCours();
        
 
        hpCours1.setText(dc.findTitreCoursById(s.getIdCours()));
 
        txtObjectives.setText(s.getObjectif());
     


    }

    @FXML
    private void btnPasserQuizAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/AfficherQuiz.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));

        stage.show();
    }

    @FXML
    private void btnTelechargerAction(ActionEvent event)  {
//         FileChooser fileChooser = new FileChooser();
//
//        File selectedFile = fileChooser.showOpenDialog(null);
//           FileOutputStream fos = new FileOutputStream("E:\\xampp\\htdocs\\Tests\\MOOC_3A2\\src\\pidev\\gui\\img" + "\\" + filename + ".pdf");
//                int b = 0;
//                while ((b = is.read()) != -1) {
//                    fos.write(b);
//                } 
//            fileChooser.setTitle("Open resource file");
//            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.pdf"));
//            Chapitre c = new Chapitre();
           
        
    }

    @FXML
    private void btnexitAction(ActionEvent event) {
        Stage stage = (Stage) btnexit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnbackAction(ActionEvent event) throws IOException {
       ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/FXMLAffichageCours.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.setTitle("Afficher cours");
        ProfilApprenantController pac = loader.getController();
        stage.show();
    }

}
