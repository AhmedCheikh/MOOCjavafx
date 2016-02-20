/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import com.sun.media.jfxmedia.track.Track;
import java.io.File;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.media.VideoTrack;
import javafx.stage.FileChooser;
import static pidev.Controller.InscrireFormateurController.cv;
import static pidev.Controller.InscrireFormateurController.im;
import pidev.dao.classes.DAOCours;
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
    
    public static File vedio;
    @FXML
    private Label lblcheminvideo;

    public void setVedio(File vedio) {
        PublierCourController.vedio = vedio;
    }

    @FXML
    public void btnexitAction(ActionEvent event) {
      
    }

    @FXML
    public void btnbackAction(ActionEvent event) {

    }

    @FXML
    public void btnChoisirVedioAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open resource file");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Text Files", "*.3gp"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            File path = selectedFile.getAbsoluteFile();
            lblcheminvideo.setText(selectedFile.getAbsolutePath());
            //mpth = path;
            setVedio(path);
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
    public void btnPublierAction(ActionEvent event) {
       
        Cours cou = new Cours(1, txtNomCour.getText(), lblcinf.getText(),0, txtDescription.getText(), cmbDifficulté.getValue().toString(), txtObjectif.getText(), 0, vedio);
        DAOCours dac = new DAOCours();
        dac.addCours(cou);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Publication de cour");
        alert.setHeaderText(null);
        alert.setContentText("Votre cours a été publier avec succès");
        alert.showAndWait();
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

