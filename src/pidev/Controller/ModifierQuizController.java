/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.dao.classes.DAOChapitre;
import pidev.dao.classes.DAOQuestion;
import pidev.dao.classes.DAOQuiz;
import pidev.dao.classes.DAOReponse;
import pidev.entities.Chapitre;
import pidev.entities.Question;
import pidev.entities.Quiz;
import pidev.entities.Reponse;

/**
 * FXML Controller class
 *
 * @author Gumus
 */
public class ModifierQuizController {

    @FXML
    private TextField txtTitre;
    @FXML
    private RadioButton btrChronometre;
    @FXML
    private RadioButton btrNonChronometre;
    @FXML
    private Button btnSupprimerQuiz;
    @FXML
    private Button btnModifierQuestions;
    @FXML
    private Button btnModifierQuiz;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    @FXML
    private Label er1;
    @FXML
    private Label ltitre;
    @FXML
    private Label Note;

    @FXML
    private javafx.scene.control.Label ltype;

    @FXML
    private javafx.scene.control.Label lt;
    int qi;
    int r;
    int qu;
    List lr;
    int pnomc;
    static List lmodifidquestion;
    static List lmodifidrep;

    public void setPnomc(int pnomc) {
        this.pnomc = pnomc;

       

        DAOQuiz daoq1 = new DAOQuiz();
        String t = daoq1.findTitreQuizByTitreSelonId(pnomc);
        int type = daoq1.findTypeQuiz(pnomc);
        if (type == 1) {
            btrChronometre.setSelected(true);
        } else {
            btrNonChronometre.setSelected(true);
        }
        txtTitre.setText(t);
    }

    @FXML
    private void btnModifierQuizAction(ActionEvent event) {
        int test = 0;
        System.out.println("hhhhh");

        int etatquiz = 0;

        if (btrChronometre.isSelected()) {
            etatquiz = 1;
        } else if (btrNonChronometre.isSelected()) {
            etatquiz = 0;
        }
        System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§");
        Quiz q = new Quiz(txtTitre.getText(), etatquiz);
        DAOQuiz daoq1 = new DAOQuiz();
        System.out.println("ssssssssssssssssssss" + q);
        daoq1.updateQuiz(qi, q);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("update successfully!");
        alert.showAndWait();
    }

    @FXML
    private void btrChronometreAction(ActionEvent event
    ) {
    }

    @FXML
    private void btrNonChronometreAction(ActionEvent event
    ) {
    }

    @FXML
    private void btnModifierQuestionsAction(ActionEvent event
    ) throws IOException {

        ((Node) (event.getSource())).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ModifierQuestion.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        ModifierQuestionController aq = loader.getController();
        aq.setId(pnomc);
        stage.show();
    }

    @FXML
    private void btnSupprimerQuizAction(ActionEvent event
    ) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Do you want to delete");
        alert.setHeaderText("");
        alert.setContentText("Delete successfully!");
        alert.showAndWait();

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            DAOChapitre daoc1 = new DAOChapitre();
            
            DAOQuiz daoq1 = new DAOQuiz();
            daoq1.removeQuiz(pnomc);

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

    }
}
