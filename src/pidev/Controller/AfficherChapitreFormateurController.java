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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import static pidev.Controller.ModifierChapitreController.idc;
import pidev.dao.classes.DAOChapitre;
import pidev.dao.classes.DAOCours;
import pidev.entities.Chapitre;
import pidev.entities.Cours;
import pidev.entities.Formateur;
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
    public Cours cs;
    int qi;
    public static int a,idc;
    private Media me;
    private MediaPlayer mediaPlayer;
    final double mediaWidth = 480;
    final double mediaHeight = 270;
    public static String v;
    public  Formateur form;

    public void setCh(Chapitre ch) {
        this.ch = ch;
        idc=ch.getIdCours();
        hpChapitre.setText(ch.getTitre());
        txtObjectives.setText(ch.getObjectif());
        idc=ch.getIdCours();
        DAOChapitre dc = new DAOChapitre();
        a = ch.getIdChapitre();
        v = ch.getVideo();
        System.out.println("videoooooooooo" + a);
        System.out.println("videoooooooooo" + v);
    }

    public void setFormateur(Formateur form) {
        this.form = form;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void init(Stage primaryStage) {

        DAOChapitre dch = new DAOChapitre();
        Group root = new Group();
        primaryStage.setScene(new Scene(root, 480, 270));
        String path = new File("src/pidev/gui/video/" + v).getAbsolutePath();
        me = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(me);
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
        DAOChapitre daoc1 = new DAOChapitre();
        if ((daoc1.FindIdQuizbychapitre(ch.getTitre())) != 0) {

            ((Node) (event.getSource())).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pidev/gui/ModifierQuiz.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            ModifierQuizController aq = loader.getController();
            DAOChapitre daoc = new DAOChapitre();
            qi = daoc.FindIdQuizbychapitre(ch.getTitre());
            aq.setPnomc(qi);
            stage.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("Pas de quiz pour ce chapitre!");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnModifierChapitreAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ModifierChapitre.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        ModifierChapitreController aq = loader.getController();
        aq.setPnomc(ch);
        aq.setFormateur(form);
        System.out.println("page3Form"+form);
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
            loader.setLocation(getClass().getResource("/pidev/gui/FXMLAffichageCoursForm.fxml"));
            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(AffichageCoursFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setTitle("Affichage Cours");
            AffichageCoursFormController ACCA = loader.getController();
            System.out.println("page4" + form);
            ACCA.setFormateur(form);
            DAOCours dcc=new DAOCours();
            cs=dcc.findCoursByID(idc);
            ACCA.setInfo(cs);
            stage.show();
    }

}
