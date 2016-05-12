
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
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pidev.dao.classes.DAOChapitre;
import pidev.dao.classes.DAOCours;
import pidev.dao.classes.DAOQuestion;
import pidev.dao.classes.DAOQuiz;
import pidev.dao.classes.DAOReponse;
import pidev.entities.Chapitre;
import pidev.entities.Cours;
import pidev.entities.Question;
import pidev.entities.Quiz;
import pidev.entities.Reponse;

/**
 * FXML Controller class
 *
 * @author Gumus
 */
public class AfficherQuizChronoController implements Initializable {

 
    @FXML
    private Label Q1;
    @FXML
    private Label R11;
    @FXML
    private Label R12;
    @FXML
    private Label R13;
    @FXML
    private Label R14;
    @FXML
    private Label Q2;
    @FXML
    private CheckBox C11;
    @FXML
    private CheckBox C12;
    @FXML
    private CheckBox C14;
    @FXML
    private CheckBox C13;
    @FXML
    private CheckBox C23;
    @FXML
    private CheckBox C24;
    @FXML
    private CheckBox C22;
    @FXML
    private CheckBox C21;
    @FXML
    private Label R24;
    @FXML
    private Label R23;
    @FXML
    private Label R22;
    @FXML
    private Label R21;
    @FXML
    private Label R31;
    @FXML
    private Label R32;
    @FXML
    private Label R33;
    @FXML
    private Label R34;
    @FXML
    private CheckBox C31;
    @FXML
    private CheckBox C32;
    @FXML
    private CheckBox C34;
    @FXML
    private CheckBox C33;
    @FXML
    private Label Q3;
    @FXML
    private Label Q4;
    @FXML
    private CheckBox C43;
    @FXML
    private CheckBox C44;
    @FXML
    private CheckBox C42;
    @FXML
    private CheckBox C41;
    @FXML
    private Label R44;
    @FXML
    private Label R43;
    @FXML
    private Label R42;
    @FXML
    private Label R41;
    @FXML
    private Label Q5;
    @FXML
    private CheckBox C52;
    @FXML
    private Label R54;
    @FXML
    private Label R53;
    @FXML
    private Label R52;
    @FXML
    private Label R51;
    @FXML
    private CheckBox C51;
    @FXML
    private CheckBox C53;
    @FXML
    private CheckBox C54;
    @FXML
    private Button btnValiderQuiz;
    @FXML
    private Label Note;
    @FXML
    private Label ltitre;
    @FXML
    private Label LTime;
    public double note;
    int f = 0;
    int info;
    public int q;

    public void setCours(int info) {
        this.info = info;
        DAOCours daoc1 = new DAOCours();
        //q = daoc1.FindIdQuizbycours(info.getNomCours());
        System.out.println("ddddd"+info);
        //System.out.println(q);

        
           Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int M = 60;

            @Override
            public void run() {
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        LTime.setText("00:00:" + M);
                        M = M - 1;
                        if (M == 0) {
                            try {
                                btnValiderQuizAction(null);
                                LTime.setVisible(false);
                            } catch (IOException ex) {
                                Logger.getLogger(AfficherQuizChronoController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
                });

            }

        }, 1000, 1000);

        this.info = info;
        Label[] tfQ = {Q1, Q2, Q3, Q4, Q5};
        Label[] tfR = {
            R11, R12, R13, R14,
            R21, R22, R23, R24,
            R31, R32, R33, R34,
            R41, R42, R43, R44,
            R51, R52, R53, R54};
        CheckBox[] tfC = {
            C11, C12, C13, C14,
            C21, C22, C23, C24,
            C31, C32, C33, C34,
            C41, C42, C43, C44,
            C51, C52, C53, C54};

        DAOQuiz daoq1 = new DAOQuiz();
        String t = daoq1.findTitreQuizByTitreSelonId(info);

        ltitre.setText(t);

        DAOQuestion daoqe = new DAOQuestion();
        List lsq = daoqe.FindIdQuestionbyQuiz(info);
        System.out.println("les questions:" + lsq);

        for (int i = 0; i < 5; i++) {

            
          int   rand=randomWithRange(0, (lsq.size())-1);
            Question s = (Question) lsq.get(rand);
            tfQ[i].setText(s.getQuestion());
            int Qid = daoqe.findQuestionSelonId(s);
            System.out.println("l'id de question" + Qid);

            DAOReponse r = new DAOReponse();
            List Lr = r.FindIdReponsebyQuestion(Qid);
            System.out.println("les reponses:" + Lr);
            for (int j = 0; j < 4; j++) {
                Reponse s1 = (Reponse) Lr.get(j);
                tfR[f].setText(s1.getReponse());
                f++;
            }

        }
    }
    
        int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

     
    }

    @FXML
    private void btnValiderQuizAction(ActionEvent event) throws IOException {
        Label[] tfQ = {Q1, Q2, Q3, Q4, Q5};
        Label[] tfR = {
            R11, R12, R13, R14,
            R21, R22, R23, R24,
            R31, R32, R33, R34,
            R41, R42, R43, R44,
            R51, R52, R53, R54};
        CheckBox[] tfC = {
            C11, C12, C13, C14,
            C21, C22, C23, C24,
            C31, C32, C33, C34,
            C41, C42, C43, C44,
            C51, C52, C53, C54};
        for (int i = 0; i < 5; i++) {
            DAOQuestion daoqe = new DAOQuestion();
            int Qid = daoqe.findQuestionSelonId(tfQ[i].getText());

            DAOReponse r = new DAOReponse();
            List Lr = r.FindIdReponsebyQuestion(Qid);

            for (int j = 0; j < 4; j++) {
                DAOReponse daor = new DAOReponse();
                Reponse s = (Reponse) Lr.get(j);
                int et = s.getEtat();
                System.out.println(et);
                if (tfC[j].isSelected() && et == 1) {
                    note = note + 1;
                } else if (tfC[j].isSelected() && et == 0) {
                    note = note - 1;
                }
                else{
                    note=note+0.5;
                }

                System.out.println(note);
            }
        }
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/Note.fxml"));
        AnchorPane frame = loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        NoteController nt = loader.getController();
        nt.setNote(note);
        stage.setTitle("Note");
        stage.show();
    }
}
