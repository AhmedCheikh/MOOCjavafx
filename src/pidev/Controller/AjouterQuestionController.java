/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.awt.Label;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.dao.classes.*;
import pidev.entities.*;

/**
 * FXML Controller class
 *
 * @author Gumus
 */
public class AjouterQuestionController {

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

    int test = 0;
    int r = 0;
    int etat = 0;
    public int w;
    public Quiz q;
    @FXML
    private ComboBox<?> CmbQuestions;
    @FXML
    private Button btnModifierQuestion;
    @FXML
    private Button btnSupprimerQuestion;
    @FXML
    private Button btnback;
    @FXML
    private Button btnPlus;

    public void setQuiz(Quiz q) {
        this.q = q;
        DAOQuiz dq = new DAOQuiz();
        w = dq.findQuizByTitreSelonId(q.getTitre());

    }

    public void btnAjouterAction(ActionEvent event) throws IOException {

        TextField[] tfR = {
            R11, R12, R13, R14};

        CheckBox[] tfC = {
            C11, C12, C13, C14};

        Question qe = new Question(Q1.getText(), w);
        DAOQuestion daoqe = new DAOQuestion();
        daoqe.addQuestion(qe);

        int Qid = daoqe.findQuestionSelonId(Q1.getText());
        System.out.println("!!!!!!!!!!!!!!!!!!" + Qid);
        for (int j = 0; j < 4; j++) {

            if (tfC[r].isSelected()) {
                etat = 1;
            } else {
                etat = 0;
            }

            Reponse r11 = new Reponse(etat, tfR[r].getText(), Qid);
            r++;
            DAOReponse daor11 = new DAOReponse();
            daor11.addReponse(r11);

        }

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("Add successfully!");

        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/AjouterChapitre.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        AjouterChapitreController pac = loader.getController();

        stage.show();

    }

    @FXML
    private void btnPlusAction(ActionEvent event) throws IOException {
        TextField[] tfR = {
            R11, R12, R13, R14};

        CheckBox[] tfC = {
            C11, C12, C13, C14};

        Question qe = new Question(Q1.getText(), w);
        DAOQuestion daoqe = new DAOQuestion();
        daoqe.addQuestion(qe);

        int Qid = daoqe.findQuestionSelonId(Q1.getText());
        System.out.println("!!!!!!!!!!!!!!!!!!" + Qid);
        for (int j = 0; j < 4; j++) {

            if (tfC[r].isSelected()) {
                etat = 1;
            } else {
                etat = 0;
            }

            Reponse r11 = new Reponse(etat, tfR[r].getText(), Qid);
            r++;
            DAOReponse daor11 = new DAOReponse();
            daor11.addReponse(r11);

        }

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("Add successfully!");

        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/AjouterQuestion.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        AjouterQuestionController pac = loader.getController();
        pac.setQuiz(q);
        stage.show();

    }

    @FXML
    private void btnexitAction(ActionEvent event) {
        Stage stage = (Stage) btnexit.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void CmbQuestionsAction(ActionEvent event) {
    }

    @FXML
    private void btnModifierQuestionAction(ActionEvent event) {
    }

}
