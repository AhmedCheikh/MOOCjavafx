/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.dao.classes.DAOChapitre;
import pidev.dao.classes.DAOQuiz;
import pidev.entities.Chapitre;

/**
 *
 * @author Gumus
 */
public class AjouterChapitreController implements Initializable {

    List l;

    @FXML
    private TextField txtTitre;
    @FXML
    private Button btnexit;
    @FXML
    private Label LPresentation;
    @FXML
    private TextField lVideo;
    @FXML
    private TextArea txtAObjectif;
    @FXML
    public static File presentation;
    @FXML
    private ComboBox CmbQuiz;

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

    public void btnAjouterAction(ActionEvent event) throws IOException {

        /*
         if (txtTitre.getText().isEmpty()) {
         er1.setText("Vous devez Renseigez ce champs");
         } else {
         er1.setText(" ");
         }
         if (txtAObjectif.getText().isEmpty()) {
         er2.setText("Vous devez Renseigez ce champs");
         } else {
         er2.setText(" ");
         }
         */
        DAOQuiz d = new DAOQuiz();
        z = d.findQuizByTitreSelonId((String) CmbQuiz.getValue());
        Chapitre c = new Chapitre(2, z, txtTitre.getText(), presentation, txtAObjectif.getText(), 1, lVideo.getText());

        DAOChapitre daoc = new DAOChapitre();
        daoc.addChapitre(c);
    }

    @FXML
    public void btnAnullerAction(ActionEvent event) {
        txtTitre.setText("");
        txtAObjectif.setText("");

    }

    @FXML
    public void btnChoisirDocAction(ActionEvent event) {
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
    public void btnChoisirVideoAction(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            fileChooser.setTitle("Open resource file");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Video Files", "*.MP4"));
            Chapitre c = new Chapitre();
            if (selectedFile != null) {
                File path = selectedFile.getAbsoluteFile();
                
                lVideo.setText(path.getAbsolutePath());
               
            } else {

                lVideo.setText("Video selection cancelled.");

            }

        }

    }

    @FXML
    public void btnAjouterQuizAction(ActionEvent event) throws IOException {
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
    public void btnexitAction(ActionEvent event) {
        Stage stage = (Stage) btnexit.getScene().getWindow();
        stage.close();

    }

    @FXML
    public void btnbackAction(ActionEvent event) throws IOException {

        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/FXMLAffichageCours.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.setTitle("Afficher cours");
        AffichageCoursController pac = loader.getController();
        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DAOQuiz daoQuiz = new DAOQuiz();
        l = daoQuiz.findQuizByType(1);
        for (int i = 0; i < l.size(); i++) {
            CmbQuiz.getItems().add(l.get(i));

        }

    }

}
