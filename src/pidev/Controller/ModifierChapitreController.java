/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.dao.classes.DAOChapitre;
import pidev.dao.classes.DAOQuiz;
import pidev.entities.Chapitre;

/**
 * FXML Controller class
 *
 * @author Gumus
 */
public class ModifierChapitreController implements Initializable {

    @FXML
    private TextField txtTitre;
    @FXML
    private TextArea txtAObjectif;
    @FXML
    private Button btnChoisirVideo;
    @FXML
    private Button btnChoisirDoc;
    @FXML
    private ComboBox CmbQuiz;
    @FXML
    private Label LVideo;
    @FXML
    private Label LPresentation;
    @FXML
    private Button btnAjouterQuiz;
    @FXML
    private Label LVideo1;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnAnuller;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    @FXML
    public static File presentation;
    private String idq;
    List l;
    List l1;
    int idlocal;

    public void setPresentation(File presentation) {
        this.presentation = presentation;
    }

    @FXML
    public static File video;

    public void setVideo(File video) {
        this.video = video;
    }
    @FXML
    private Label er1;
    @FXML
    private Label er2;
    int z;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        DAOQuiz daoQuiz = new DAOQuiz();
        l1 = daoQuiz.findQuizByType(1);
        for (int i = 0; i < l1.size(); i++) {
            CmbQuiz.getItems().add(l1.get(i));

        }

        DAOChapitre c = new DAOChapitre();
        List l = c.findChapitreByTitre("JavaFx");
        
        Chapitre s = (Chapitre) l.get(0);
         idlocal = s.getIdChapitre();
        txtTitre.setText(s.getTitre());
        txtAObjectif.setText(s.getObjectif());
        LVideo.setText(s.getVideo().getAbsolutePath());
        LPresentation.setText(s.getPresentation().getAbsolutePath());

        DAOQuiz z = new DAOQuiz();
        idq = z.findTitreQuizByTitreSelonId(s.getIdQuiz());
        System.out.println(idq);
        CmbQuiz.setPromptText(idq);

    }

    @FXML
    private void btnChoisirVideoAction(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            fileChooser.setTitle("Open resource file");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Video Files", "*.MP4"));
            Chapitre c = new Chapitre();
            if (selectedFile != null) {
                File path = selectedFile.getAbsoluteFile();
                video = path;
                LVideo.setText("Video selected:" + selectedFile.getName());
                c.setPresentation(path);
            } else {

                LPresentation.setText("Video selection cancelled.");

            }

        }

    }

    @FXML
    private void btnChoisirDocAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            fileChooser.setTitle("Open resource file");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.pdf"));
            Chapitre c = new Chapitre();
            if (selectedFile != null) {
                File path = selectedFile.getAbsoluteFile();
                presentation = path;
                LPresentation.setText("File selected: " + selectedFile.getName());
                c.setPresentation(path);
            } else {

                LPresentation.setText("File selection cancelled.");

            }

        }
    }

    @FXML
    private void btnAjouterQuizAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/AjouterQuiz.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.setTitle("Ajouter Quiz");

        stage.show();

    }

    @FXML
    private void btnAnullerAction(ActionEvent event) {
        txtTitre.setText("");
        txtAObjectif.setText("");

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
        loader.setLocation(getClass().getResource("/pidev/gui/AfficherChapitreFormateur.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.setTitle("Afficher chapitre");
        ProfilApprenantController pac = loader.getController();
        stage.show();

    }

    @FXML
    private void btnModifierAction(ActionEvent event) {
        
         DAOQuiz d = new DAOQuiz();
        z = d.findQuizByTitreSelonId((String) CmbQuiz.getValue());
        Chapitre c = new Chapitre(idlocal,1,z, txtTitre.getText(), presentation, txtAObjectif.getText(), 1, video);
         System.out.println(c);
        DAOChapitre daoc = new DAOChapitre();
        daoc.updateChapitre(c);
    }
}
