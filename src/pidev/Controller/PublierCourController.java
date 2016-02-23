/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;


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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
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
      
    }

    @FXML
    public void btnbackAction(ActionEvent event) {

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
            String nomvid = "C:/Users/akoubi/Documents/NetBeansProjects/MOOC_3A2-master-0325060b914cc6125f9059397e5f87da2754141e/src/pidev/video/"+selectedFile.getName();
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
