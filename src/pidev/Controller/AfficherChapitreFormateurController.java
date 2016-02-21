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
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.dao.classes.DAOChapitre;
import pidev.dao.classes.DAOCours;
import pidev.entities.Chapitre;
import pidev.gui.video.VideoFXDemo;

/**
 * FXML Controller class
 *
 * @author Gumus
 */
public class AfficherChapitreFormateurController implements Initializable {

    @FXML
    private Button btnModifierQuiz;
    @FXML
    private Button btnModifierChapitre;
    @FXML
    private MediaView mvVideo;
    @FXML
    private TextArea txtObjectives;
    @FXML
    private Hyperlink hpChapitre;
    @FXML
    private Hyperlink hpCours;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    public Chapitre ch;
    String nameCh = "JavaFX";

    private MediaPlayer mediaPlayer;
    final double mediaWidth = 480;
    final double mediaHeight = 270;

    public void setCh(Chapitre ch) {
        this.ch = ch;
        ch.getTitre();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        hpChapitre.setText(">" + nameCh);
       DAOChapitre dch = new DAOChapitre();
        System.out.println(nameCh);
        System.out.println(dch.findChapitreByTitre(nameCh));
        List l = dch.findChapitreByTitre(nameCh);

        Chapitre s = (Chapitre) l.get(0);

        DAOCours dc = new DAOCours();

        hpCours.setText(dc.findTitreCoursById(s.getIdCours()));

        txtObjectives.setText(s.getObjectif());

    }

    public void init(Stage primaryStage) {
        DAOChapitre dch = new DAOChapitre();
        Group root = new Group();
        primaryStage.setScene(new Scene(root, 480, 270));
        mediaPlayer = new MediaPlayer(new Media("file:///" + dch.FindVideobychapitre(nameCh)));
        mediaPlayer.setAutoPlay(true);
        VideoFXDemo.PlayerPane playerPane = new VideoFXDemo.PlayerPane(mediaPlayer);
        playerPane.setMinSize(mediaWidth, mediaHeight);
        playerPane.setPrefSize(mediaWidth, mediaHeight);
        playerPane.setMaxSize(mediaWidth, mediaHeight);

        root.getChildren().add(playerPane);
    }

    @FXML
    private void btnVideoAction(ActionEvent event) {

        Stage stage = new Stage();
        init(stage);
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        stage.setTitle("VIDEO");
        stage.show();
        play();
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

    @FXML
    private void btnModifierQuizAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ModifierQuiz.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        ModifierQuizController aq = loader.getController();
        aq.setPnomc(nameCh);
        stage.show();
    }

    @FXML
    private void btnModifierChapitreAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ModifierChapitre.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        ModifierChapitreController aq = loader.getController();
        aq.setPnomc(nameCh);
        stage.show();
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
