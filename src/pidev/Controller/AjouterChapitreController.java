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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.dao.classes.DAOChapitre;
import pidev.dao.classes.DAOCours;
import pidev.dao.classes.DAOQuiz;
import pidev.entities.Chapitre;
import pidev.entities.Cours;

/**
 *
 * @author Gumus
 */
public class AjouterChapitreController implements Initializable {

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
    @FXML
    private Label er1;
    @FXML
    private Label er2;
    @FXML
    public Button btnChoisirDoc;
    List l;
    int z;
    int w;
    public Cours cours;

    public void setPresentation(File presentation) {
        this.presentation = presentation;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
        DAOCours dc=new DAOCours();
        w=dc.FindIdQuizbycours(cours.getNomCours());
    }

    public void btnAjouterAction(ActionEvent event) throws IOException {
        int test = 0;
        DAOChapitre dtest = new DAOChapitre();
        if (txtTitre.getText().isEmpty()) {
            er1.setText("Vous devez Renseigez ce champs");
            test -= 1;
        } else if (true == dtest.ChercherTitre(txtTitre.getText())) {
            er1.setText("Titre de chapitre existe déja");
            test -= 1;
        } else {
            er1.setText(" ");
            test += 1;
        }

        if (txtAObjectif.getText().isEmpty()) {
            er2.setText("Vous devez Renseigez ce champs");
            test -= 1;
        } else {
            er2.setText(" ");
            test += 1;
        }

        DropShadow shadow = new DropShadow();

        if (lVideo.getText().isEmpty()) {
            shadow.setColor(Color.RED);
            lVideo.setEffect(shadow);
            test -= 1;
        } else {
            shadow.setColor(Color.GREEN);
            lVideo.setEffect(shadow);
            test += 1;
        }
        if (LPresentation.getText().isEmpty()) {
            shadow.setColor(Color.RED);
            btnChoisirDoc.setEffect(shadow);
            test -= 1;
        } else {
            shadow.setColor(Color.GREEN);
            btnChoisirDoc.setEffect(shadow);
            test += 1;
        }

        if (test == 4) {
            DAOQuiz d = new DAOQuiz();
            z = d.findQuizByTitreSelonId((String) CmbQuiz.getValue());
            Chapitre c = new Chapitre(1, z, txtTitre.getText(), presentation, txtAObjectif.getText(), lVideo.getText());

            DAOChapitre daoc = new DAOChapitre();
            daoc.addChapitre(c);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("Add successfully!");
            alert.showAndWait();
        }
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

                lVideo.setText(path.getName());

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
