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
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
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
public class AfficherQuizController implements Initializable {

    @FXML
    private TextArea Q1;
    @FXML
    private TextArea R11;
    @FXML
    private TextArea R12;
    @FXML
    private TextArea R13;
    @FXML
    private TextArea R14;
    @FXML
    private TextArea Q2;
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
    private TextArea R24;
    @FXML
    private TextArea R23;
    @FXML
    private TextArea R22;
    @FXML
    private TextArea R21;
    @FXML
    private TextArea R31;
    @FXML
    private TextArea R32;
    @FXML
    private TextArea R33;
    @FXML
    private TextArea R34;
    @FXML
    private CheckBox C31;
    @FXML
    private CheckBox C32;
    @FXML
    private CheckBox C34;
    @FXML
    private CheckBox C33;
    @FXML
    private TextArea Q3;
    @FXML
    private TextArea Q4;
    @FXML
    private CheckBox C43;
    @FXML
    private CheckBox C44;
    @FXML
    private CheckBox C42;
    @FXML
    private CheckBox C41;
    @FXML
    private TextArea R44;
    @FXML
    private TextArea R43;
    @FXML
    private TextArea R42;
    @FXML
    private TextArea R41;
    @FXML
    private TextArea Q5;
    @FXML
    private CheckBox C52;
    @FXML
    private TextArea R54;
    @FXML
    private TextArea R53;
    @FXML
    private TextArea R52;
    @FXML
    private TextArea R51;
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
    public int note;
    int f = 0;
    String pnomc;

    public void setPnomc(String pnomc) {
        this.pnomc = pnomc;
         TextArea[] tfQ = {Q1, Q2, Q3, Q4, Q5};
        TextArea[] tfR = {
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
        DAOChapitre daoc1 = new DAOChapitre();
        int q = daoc1.FindIdQuizbychapitre(pnomc);
        System.out.println(q);
        DAOQuiz daoq1 = new DAOQuiz();
        String t = daoq1.findTitreQuizByTitreSelonId(q);

        ltitre.setText(t);

        DAOQuestion daoqe = new DAOQuestion();
        List lsq = daoqe.FindIdQuestionbyQuiz(q);
        System.out.println("les questions:" + lsq);

        for (int i = 0; i < 5; i++) {

            Question s = (Question) lsq.get(i);
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
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//         int etatquiz = 0;
//        if (btrChronometre.isSelected()) {
//            etatquiz = 1;
//        } else if (btrNonChronometre.isSelected()) {
//            etatquiz = 0;
//        }
       
    }

    @FXML
    private void btnValiderQuizAction(ActionEvent event) throws IOException {
        TextArea[] tfQ = {Q1, Q2, Q3, Q4, Q5};
        TextArea[] tfR = {
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
             note=0;
        for (int i = 0; i < 5; i++) {
            DAOQuestion daoqe = new DAOQuestion();
            int Qid = daoqe.findQuestionSelonId(tfQ[i].getText());

            for (int j = 0; j < 4; j++) {
                DAOReponse daor = new DAOReponse();
                int et=daor.findEtatReponse(tfR[j].getText());

                if (tfC[j].isSelected() && et==1) {
                    note = note + 4;
                } 
                else if (tfC[j].isSelected() && et==0){
                    note = note - 1;
                }
                else{
                    note=note -1;
                }

            }
            
       
        }
        //Note.setText("la note"+note);
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/Note.fxml"));
        AnchorPane frame =loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        NoteController nt  = loader.getController();
        nt.setNote(note);
        stage.setTitle("Note");
        stage.show();
    }

    }

//       public Timer timer; 
////     public void gffgfgf(){
////     timer.schedule(null, null);
////     }
