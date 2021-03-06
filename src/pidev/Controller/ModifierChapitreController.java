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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static pidev.Controller.ProfilFormateurController.f;
import pidev.dao.classes.DAOChapitre;
import pidev.dao.classes.DAOCours;
import pidev.dao.classes.DAOFormateur;
import pidev.dao.classes.DAOQuiz;
import pidev.entities.Chapitre;
import pidev.entities.Cours;
import pidev.entities.Formateur;

/**
 * FXML Controller class
 *
 * @author Gumus
 */
public class ModifierChapitreController {

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
    private TextField lVideo;
    @FXML
    private TextField lPresentation;
    @FXML
    private Button btnAjouterQuiz;
    @FXML
    private Label LVideo1;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    @FXML
    public static File presentation;

    private String idq;
    List l;
    List l1;
    public static int idlo, idc;
    public static Formateur formateur;
    @FXML
    private Label er1;
    @FXML
    private Label er2;
    int z;
    Chapitre pnomc;
    Chapitre c;
    Cours cs;
    public Formateur form;

    public void setFormateur(Formateur form) {
        this.form = form;
    }

    public void setPnomc(Chapitre pnomc) {
        this.pnomc = pnomc;
        idc = pnomc.getIdCours();
        DAOQuiz daoQuiz = new DAOQuiz();
        l1 = daoQuiz.findQuizByType(1);
        for (int i = 0; i < l1.size(); i++) {
            CmbQuiz.getItems().add(l1.get(i));

        }

        txtTitre.setText(pnomc.getTitre());
        txtAObjectif.setText(pnomc.getObjectif());
        lVideo.setText(pnomc.getVideo());
        lPresentation.setText(pnomc.getPresentation());
        idlo = pnomc.getIdChapitre();
        DAOQuiz z = new DAOQuiz();
        idq = z.findTitreQuizByTitreSelonId(pnomc.getIdQuiz());
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

                lVideo.setText(path.getName());

            } else {

                lVideo.setText("Video selection cancelled.");

            }

        }

    }

    @FXML
    private void btnChoisirDocAction(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            fileChooser.setTitle("Open resource file");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Video Files", "*.PDF"));
            Chapitre c = new Chapitre();
            if (selectedFile != null) {
                File path = selectedFile.getAbsoluteFile();

                lPresentation.setText(path.getName());

            } else {

                lPresentation.setText("Video selection cancelled.");

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
    private void btnSupprimerAction(ActionEvent event) throws IOException {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Do you want to delete");
        alert.setHeaderText("");
        alert.setContentText("Delete successfully!");
        alert.showAndWait();
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            DAOChapitre dc = new DAOChapitre();
            dc.removeChapitre(idlo);

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
            System.out.println("couuuuuuuuuurs"+cs);
            ACCA.setInfo(cs);
            stage.show();
        } else {
            alert.close();
        }

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
        AfficherChapitreFormateurController pac = loader.getController();
        pac.setCh(pnomc);
        pac.setFormateur(form);
        stage.show();
    }

    @FXML
    public void btnModifierAction(ActionEvent event) {

        int test = 0;
        if (txtTitre.getText().isEmpty()) {
            er1.setText("Vous devez Renseigez ce champs");
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
        if (lPresentation.getText().isEmpty()) {
            shadow.setColor(Color.RED);
            lPresentation.setEffect(shadow);
            test -= 1;
        } else {
            shadow.setColor(Color.GREEN);
            lPresentation.setEffect(shadow);
            test += 1;
        }

        if (test == 4) {
            DAOQuiz d = new DAOQuiz();
            z = d.findQuizByTitreSelonId((String) CmbQuiz.getValue());
            DAOChapitre dc = new DAOChapitre();
//            idlo = dc.FindIdbychapitre(pnomc.getTitre());
            System.out.println("ssss" + z);
//            int q=dc.FindIdbychapitre(pnomc.getTitre());
            c = new Chapitre(txtTitre.getText(), lPresentation.getText(), txtAObjectif.getText(), z, lVideo.getText());
            DAOChapitre daoc = new DAOChapitre();
            daoc.updateChapitre(c, idlo);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("update successfully!");
            alert.showAndWait();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pidev/gui/AfficherChapitreFormateur.fxml"));
            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(AffichageCoursFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setTitle("Affichage Chapitre");
            AfficherChapitreFormateurController pac = loader.getController();
            pac.setCh(c);
            pac.setFormateur(form);
            stage.show();

        }

    }
}
