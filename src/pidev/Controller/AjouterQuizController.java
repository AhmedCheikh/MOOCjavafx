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
public class AjouterQuizController {

    @FXML
    private TextField txtTitre;
    @FXML
    private RadioButton btrChronometre;
    @FXML
    private RadioButton btrNonChronometre;
    @FXML
    private Button btnAjouterQuizAction;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;

    @FXML
    private javafx.scene.control.Label lt;
    @FXML
    private Label ltitre;
    int etatquiz = 0;

    @FXML
    private void btnAjouterQuizAction(ActionEvent event) throws IOException {

        int test = 0;
        DAOQuiz dtest = new DAOQuiz();

        if (txtTitre.getText().isEmpty()) {
            lt.setText("Ce champ est obligatoire");
            test -= 1;
        } else if (true == dtest.ChercherTitre(txtTitre.getText())) {
            lt.setText("Titre de quiz existe déja");
            test -= 1;
        } else {
            lt.setText(" ");
            test += 1;
        }

        if (test == 1) {
            if (btrChronometre.isSelected()) {
                etatquiz = 1;
            } else if (btrNonChronometre.isSelected()) {
                etatquiz = 0;
            }

            Quiz q = new Quiz(txtTitre.getText(), etatquiz);
            DAOQuiz dq = new DAOQuiz();
            dq.addQuiz(q);
            System.out.println(""+q.getIdQuiz());
            ((Node) (event.getSource())).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pidev/gui/AjouterQuestion.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            AjouterQuestionController pac = loader.getController();
            System.out.println("QQQQQQQQ"+q);
            pac.setQuiz(q);
            stage.show();
            
            
            

        }
    }

    @FXML
    private void btrChronometreAction(ActionEvent event) {
    }

    @FXML
    private void btrNonChronometreAction(ActionEvent event) {
    }

    @FXML
    private void btnexitAction(ActionEvent event) throws IOException {
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
    private void btnbackAction(ActionEvent event) throws IOException {
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
}
