/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.dao.classes.DAOFormateur;
import pidev.entities.Cours;
import pidev.entities.Formateur;

/**
 * FXML Controller class
 *
 * @author akoubi
 */
public class PublierCourController implements Initializable {

    @FXML
    private Label lblcinf;
    @FXML
    private TextField txtNomCour;
    @FXML
    private TextArea txtDescription;
    @FXML
    private ComboBox cmbDifficulté;
    @FXML
    private TextField txtObjectif;
    @FXML
    private Button btnPublier;
    @FXML
    private Button btnAnuller;
    @FXML
    private Button btnChoisirVedio;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    @FXML

    private Label lblcheminvideo;

    public static String video;

    public void setVideo(String video) {
        this.video = video;
    }

    public static String CheminVid;

    public void setCheminVid(String CheminVid) {
        this.CheminVid = CheminVid;
    }

    public static String url;

    public void setUrl(String url) {
        this.url = url;
    }

    @FXML
    public void btnexitAction(ActionEvent event) {
        Stage stage = (Stage) btnexit.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void btnbackAction(ActionEvent event) throws IOException {
        Formateur frr = new Formateur(lblcinf.getText());
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ProfilFormateur.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        ProfilFormateurController pfc = loader.getController();
        pfc.setF(frr);
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }

    @FXML
    public void btnChoisirVedioAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open resource file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.mp4"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            String path = selectedFile.getName();
            lblcheminvideo.setText(selectedFile.getAbsolutePath());
            String ur = selectedFile.getAbsolutePath();
            String nomvid = "C:/Users/akoubi/Documents/NetBeansProjects/MOOC_3A2-master-0325060b914cc6125f9059397e5f87da2754141e/src/pidev/video/" + selectedFile.getName();
            setCheminVid(nomvid);
            setUrl(ur);
            setVideo(path);
        } else {
            lblcheminvideo.setText("File Invalide");
        }
    }

    private Formateur f;
    DAOFormateur daof = new DAOFormateur();
    Formateur f2 = new Formateur();

    @FXML
    public void cmbDifficultéAction(ActionEvent event) {
        if (cmbDifficulté.getItems().get(1).equals("facile")) {

        }
    }

    @FXML
    public void btnPublierAction(ActionEvent event) throws IOException {
        if (txtNomCour.getText().isEmpty()) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");

            if (runnable != null) {
                runnable.run();
            }
            alert1.setTitle("Erreur");
            alert1.setHeaderText(null);
            alert1.setContentText("Vous devez saisir le nom du cour");
            alert1.showAndWait();

        } else if (txtDescription.getText().isEmpty()) {

            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");

            if (runnable != null) {
                runnable.run();
            }
            alert2.setTitle("Erreur");
            alert2.setHeaderText(null);
            alert2.setContentText("Vous devez saisir la description du cour");
            alert2.showAndWait();
        } else if (txtObjectif.getText().isEmpty()) {
            Alert alert3 = new Alert(Alert.AlertType.ERROR);
            final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");

            if (runnable != null) {
                runnable.run();
            }
            alert3.setTitle("Erreur");
            alert3.setHeaderText(null);
            alert3.setContentText("Vous devez saisir les objectif des cours");
            alert3.showAndWait();
        } else if (cmbDifficulté.getValue().toString().isEmpty()) {
            Alert alert4 = new Alert(Alert.AlertType.ERROR);
            final Runnable runnable = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");

            if (runnable != null) {
                runnable.run();
            }
            alert4.setTitle("Erreur");
            alert4.setHeaderText(null);
            alert4.setContentText("Vous devez choisir la difficulté du cour");
            alert4.showAndWait();
        } else {
            Alert alert5 = new Alert(Alert.AlertType.CONFIRMATION);
            alert5.setTitle("mrigla ye zayda");
            alert5.setHeaderText(null);
            alert5.setContentText("sa7it si zied ^_^");
            alert5.showAndWait();

            Cours c = new Cours(txtNomCour.getText(), txtDescription.getText(), cmbDifficulté.getValue().toString(), txtObjectif.getText(), video);
            daof.publierCour(c);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            Path source = Paths.get(url);
            System.out.println(source.toRealPath(LinkOption.NOFOLLOW_LINKS));
            Path destination = Paths.get(CheminVid);
            Files.copy(source, destination);
            alert.setTitle("Publuer cours");
            alert.setHeaderText(null);
            alert.setContentText("Votre cours a été publier avec succès");
            alert.showAndWait();
        }
    }

    @FXML
    public void btnAnullerAction(ActionEvent event) {
        txtNomCour.clear();
        txtDescription.clear();
        txtObjectif.clear();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbDifficulté.getItems().add(
                "Débutant");
        cmbDifficulté.getItems().add(
                "Intermédiaire");
        cmbDifficulté.getItems().add(
                "Avancé");
    }

    public void setfrm(Formateur f) {
        lblcinf.setText(f.getCinFormateur());
        this.f = f;

    }

}
