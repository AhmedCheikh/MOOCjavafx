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
import javafx.scene.control.ComboBox;
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
public class ModifierQuestionController {

    @FXML
    private TextField Q1;
    @FXML
    private TextField R11;
    @FXML
    private TextField R12;
    @FXML
    private TextField R13;
    @FXML
    private TextField R14;
    @FXML
    private CheckBox C11;
    @FXML
    private CheckBox C12;
    @FXML
    private CheckBox C14;
    @FXML
    private CheckBox C13;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    @FXML
    private Button btnSupprimerQuestion;
    @FXML
    private Button btnModifierQuestion;

    @FXML
    private ComboBox CmbQuestions;
    int qi;
    int r;
    int qu;
    List lr;
    int id;
    int etat = 0;
    String s;
    List lmodifidrep;
    List l;
    int z;
    Question qe;

    public void setId(int id) {
        this.id = id;
        DAOQuestion daoqe = new DAOQuestion();
        l = daoqe.FindIdQuestionbyQuiz(id);
        System.out.println("aaaaaaaaa" + l);
        for (int i = 0; i < l.size(); i++) {
            Question ques = (Question) l.get(i);
            CmbQuestions.getItems().add(ques.getQuestion());
        }

    }

    @FXML
    private void btnModifierQuestionAction(ActionEvent event) throws IOException {
        TextField[] tfR = {
            R11, R12, R13, R14};

        CheckBox[] tfC = {
            C11, C12, C13, C14};
        DAOQuestion d = new DAOQuestion();
        s = (String) CmbQuestions.getValue();
        z = d.findQuestionSelonId(s);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + s);
//        Q1.setText((String) CmbQuestions.getValue());
        DAOReponse rd = new DAOReponse();
        List Lr = rd.FindIdReponsebyQuestion(z);

        DAOQuestion daoqe = new DAOQuestion();
        System.out.println(Q1.getText());
        daoqe.updateQuestion(z, Q1.getText());

        for (int j = 0; j < 4; j++) {
            if (tfC[j].isSelected()) {
                etat = 1;
            } else {
                etat = 0;
            }
            Reponse s1 = (Reponse) Lr.get(j);
            Reponse r11 = new Reponse(etat, tfR[j].getText());
            DAOReponse daor11 = new DAOReponse();
            System.out.println(lr);
//                    System.out.println("eeeeeeeee"+().getIdReponse());
            daor11.updateReponse(s1.getIdReponse(), r11);

        }

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ModifierQuiz.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        ModifierQuizController aq = loader.getController();
        aq.setPnomc(id);
        stage.show();
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
    private void btnSupprimerQuestionAction(ActionEvent event
    ) throws IOException {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Do you want to delete");
        alert.setHeaderText("");
        alert.setContentText("Delete successfully!");
        alert.showAndWait();

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            DAOQuestion d = new DAOQuestion();

            z = d.findQuestionSelonId((String) CmbQuestions.getValue());

            d.removeQuestion(z);

            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pidev/gui/ModifierQuiz.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            ModifierQuizController aq = loader.getController();
            aq.setPnomc(id);
            stage.show();

        } else {
            alert.close();
        }
    }

    @FXML
    private void CmbQuestionsAction(ActionEvent event
    ) {
        DAOQuestion d = new DAOQuestion();
        int et = 0;
        int f = 0;
        z = d.findQuestionSelonId((String) CmbQuestions.getValue());
        System.out.println("aaaa" + z);
        TextField[] tfR = {
            R11, R12, R13, R14};
        CheckBox[] tfC = {
            C11, C12, C13, C14};
        Q1.setText((String) CmbQuestions.getValue());
        DAOReponse r = new DAOReponse();
        List Lr = r.FindIdReponsebyQuestion(z);
        System.out.println("les reponses:" + Lr);
        for (int j = 0; j < 4; j++) {
            Reponse s1 = (Reponse) Lr.get(j);
            tfR[j].setText(s1.getReponse());

            et = s1.getEtat();
            if (et == 1) {
                tfC[j].setSelected(true);
            }

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
        loader.setLocation(getClass().getResource("/pidev/gui/ModifierQuiz.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        ModifierQuizController aq = loader.getController();
        aq.setPnomc(id);
        stage.show();

    }
}
