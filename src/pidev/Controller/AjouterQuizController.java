/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.awt.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pidev.dao.classes.*;
import pidev.entities.*;

/**
 * FXML Controller class
 *
 * @author Gumus
 */
public class AjouterQuizController {

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
    private TextField txtTitre;
    @FXML
    private RadioButton btrChronometre;
    @FXML
    private RadioButton btrNonChronometre;
    @FXML
    private Button btnAjouterQuiz;
//    @FXML
//    private Label er1;

    @FXML
    private void btrChronometreAction(ActionEvent event) {
    }

    @FXML
    private void btrNonChronometreAction(ActionEvent event) {
    }

    @FXML
    private void btnAjouterQuizAction(ActionEvent event) {
        int etatquiz = 0;
//        //quiz
//        if (!btrChronometre.isSelected() || !btrNonChronometre.isSelected()) {
//            er1.setText("Vous devez choisir le type de quiz");
//        } else {
            if (btrChronometre.isSelected()) {
                etatquiz = 1;
            } else if (btrNonChronometre.isSelected()) {
                etatquiz = 0;
            }

            Quiz q1 = new Quiz();
            Quiz q = new Quiz(q1.getIdQuiz(), txtTitre.getText(),etatquiz, 0);
            DAOQuiz daoq = new DAOQuiz();
            daoq.addQuiz(q);

            int id = daoq.findQuizByTitreSelonId(txtTitre.getText());

            /**
             * ****************************************************************************************
             */
            //1ere question
            int e11;
            int e12;
            int e13;
            int e14;

            Question qe = new Question();
            Question qe1 = new Question(qe.getIdQuestion(), Q1.getText(), id);
            DAOQuestion daoqe1 = new DAOQuestion();
            daoqe1.addQuestion(qe1);
            //1ere reponse
            int id1 = daoqe1.findQuestionSelonId(Q1.getText());

            if (C11.isSelected()) {
                e11 = 1;
            } else {
                e11 = 0;
            }

            Reponse rr1 = new Reponse();
            Reponse r11 = new Reponse(rr1.getIdReponse(), e11, R11.getText(), id1);
            DAOReponse dr1 = new DAOReponse();
            dr1.addReponse(r11);
            //2eme reponse
            if (C12.isSelected()) {
                e12 = 1;
            } else {
                e12 = 0;
            }

            Reponse rr2 = new Reponse();
            Reponse r12 = new Reponse(rr2.getIdReponse(), e12, R12.getText(), id1);
            DAOReponse dr2 = new DAOReponse();
            dr2.addReponse(r12);
            //3eme reponse
            if (C13.isSelected()) {
                e13 = 1;
            } else {
                e13 = 0;
            }
            Reponse rr3 = new Reponse();
            Reponse r13 = new Reponse(rr3.getIdReponse(), e13, R13.getText(), id1);
            DAOReponse dr3 = new DAOReponse();
            dr3.addReponse(r13);
            //4eme reponse
            if (C14.isSelected()) {
                e14 = 1;
            } else {
                e14 = 0;
            }
            Reponse rr4 = new Reponse();
            Reponse r14 = new Reponse(rr4.getIdReponse(), e14, R14.getText(), id1);
            DAOReponse dr4 = new DAOReponse();
            dr4.addReponse(r14);

            /**
             * *****************************************************************************************
             */
            int e21;
            int e22;
            int e23;
            int e24;

            //2eme question
            Question Qu2 = new Question();
            Question qe2 = new Question(Qu2.getIdQuestion(), Q2.getText(), id);
            DAOQuestion daoqe2 = new DAOQuestion();
            daoqe2.addQuestion(qe2);
            //1ere reponse
            int id2 = daoqe2.findQuestionSelonId(Q2.getText());

            if (C21.isSelected()) {
                e21 = 1;
            } else {
                e21 = 0;
            }

            Reponse rrR2 = new Reponse();
            Reponse r21 = new Reponse(rrR2.getIdReponse(), e21, R21.getText(), id2);
            DAOReponse drr2 = new DAOReponse();
            drr2.addReponse(r21);
            System.out.println(r21);
            //2eme reponse
            if (C22.isSelected()) {
                e22 = 1;
            } else {
                e22 = 0;
            }

            Reponse rrRR2 = new Reponse();
            Reponse r22 = new Reponse(rrRR2.getIdReponse(), e22, R22.getText(), id2);
            DAOReponse drR2 = new DAOReponse();
            drR2.addReponse(r22);
            System.out.println(r22);
            //3eme reponse
            if (C23.isSelected()) {
                e23 = 1;
            } else {
                e23 = 0;
            }
            Reponse rrR3 = new Reponse();
            Reponse r23 = new Reponse(rrR3.getIdReponse(), e23, R23.getText(), id2);
            DAOReponse drR3 = new DAOReponse();
            drR3.addReponse(r23);
            System.out.println(r23);
            //4eme reponse
            if (C24.isSelected()) {
                e24 = 1;
            } else {
                e24 = 0;
            }
            Reponse rrR4 = new Reponse();
            Reponse r24 = new Reponse(rrR4.getIdReponse(), e24, R24.getText(), id2);
            DAOReponse drR4 = new DAOReponse();
            drR4.addReponse(r24);
            System.out.println(r24);

            /**
             * *********************************************************************************************
             */
            int e31;
            int e32;
            int e33;
            int e34;

            //3eme question
            Question qee = new Question();
            Question qe3 = new Question(qee.getIdQuestion(), Q3.getText(), id);
            DAOQuestion daoqe3 = new DAOQuestion();
            daoqe3.addQuestion(qe3);
            //1ere reponse
            int id3 = daoqe3.findQuestionSelonId(Q3.getText());

            if (C31.isSelected()) {
                e31 = 1;
            } else {
                e31 = 0;
            }

            Reponse rrrR3 = new Reponse();
            Reponse r31 = new Reponse(rrrR3.getIdReponse(), e31, R31.getText(), id3);
            DAOReponse drrR3 = new DAOReponse();
            drrR3.addReponse(r31);
            //2eme reponse
            if (C32.isSelected()) {
                e32 = 1;
            } else {
                e32 = 0;
            }

            Reponse rrRRR2 = new Reponse();
            Reponse r32 = new Reponse(rrRRR2.getIdReponse(), e32, R32.getText(), id3);
            DAOReponse drRR2 = new DAOReponse();
            drRR2.addReponse(r32);
            //3eme reponse
            if (C33.isSelected()) {
                e33 = 1;
            } else {
                e33 = 0;
            }
            Reponse rrRRR3 = new Reponse();
            Reponse r33 = new Reponse(rrRRR3.getIdReponse(), e33, R33.getText(), id3);
            DAOReponse drRR3 = new DAOReponse();
            drRR3.addReponse(r33);
            //4eme reponse
            if (C34.isSelected()) {
                e34 = 1;
            } else {
                e34 = 0;
            }
            Reponse rrRRR4 = new Reponse();
            Reponse r34 = new Reponse(rrRRR4.getIdReponse(), e34, R34.getText(), id3);
            DAOReponse drRR4 = new DAOReponse();
            drRR4.addReponse(r34);

            /**
             * **************************************************************************************************
             */
            int e41;
            int e42;
            int e43;
            int e44;

            //4eme question
            Question qeEe = new Question();
            Question qe4 = new Question(qeEe.getIdQuestion(), Q4.getText(), id);
            DAOQuestion daoqeE3 = new DAOQuestion();
            daoqeE3.addQuestion(qe4);
            //1ere reponse
            int id4 = daoqe3.findQuestionSelonId(Q4.getText());

            if (C41.isSelected()) {
                e41 = 1;
            } else {
                e41 = 0;
            }

            Reponse rrrR4 = new Reponse();
            Reponse r41 = new Reponse(rrrR4.getIdReponse(), e41, R41.getText(), id4);
            DAOReponse drrR4 = new DAOReponse();
            drrR4.addReponse(r41);
            //2eme reponse
            if (C42.isSelected()) {
                e42 = 1;
            } else {
                e42 = 0;
            }

            Reponse rrRRRR4 = new Reponse();
            Reponse r42 = new Reponse(rrRRRR4.getIdReponse(), e42, R42.getText(), id4);
            DAOReponse drRRR4 = new DAOReponse();
            drRRR4.addReponse(r42);
            //3eme reponse
            if (C43.isSelected()) {
                e43 = 1;
            } else {
                e43 = 0;
            }
            Reponse rrRRRr3 = new Reponse();
            Reponse r43 = new Reponse(rrRRRr3.getIdReponse(), e43, R43.getText(), id4);
            DAOReponse drRRRR3 = new DAOReponse();
            drRRRR3.addReponse(r43);
            //4eme reponse
            if (C44.isSelected()) {
                e44 = 1;
            } else {
                e44 = 0;
            }
            Reponse rrRRR44 = new Reponse();
            Reponse r44 = new Reponse(rrRRR44.getIdReponse(), e44, R44.getText(), id4);
            DAOReponse drRR44 = new DAOReponse();
            drRR44.addReponse(r44);

            /**
             * *********************************************************************************************
             */
            int e51;
            int e52;
            int e53;
            int e54;

            //5eme question
            Question qee5 = new Question();
            Question qe5 = new Question(qee5.getIdQuestion(), Q5.getText(), id);
            DAOQuestion daoqe5 = new DAOQuestion();
            daoqe5.addQuestion(qe5);
            //1ere reponse
            int id5 = daoqe5.findQuestionSelonId(Q5.getText());

            if (C51.isSelected()) {
                e51 = 1;
            } else {
                e51 = 0;
            }

            Reponse rrrR5 = new Reponse();
            Reponse r51 = new Reponse(rrrR5.getIdReponse(), e51, R51.getText(), id5);
            DAOReponse drrR5 = new DAOReponse();
            drrR5.addReponse(r51);
            //2eme reponse
            if (C52.isSelected()) {
                e52 = 1;
            } else {
                e52 = 0;
            }

            Reponse rrRRR5 = new Reponse();
            Reponse r52 = new Reponse(rrRRR5.getIdReponse(), e52, R52.getText(), id5);
            DAOReponse drRR5 = new DAOReponse();
            drRR5.addReponse(r52);
            //3eme reponse
            if (C53.isSelected()) {
                e53 = 1;
            } else {
                e53 = 0;
            }
            Reponse rrRRRR5 = new Reponse();
            Reponse r53 = new Reponse(rrRRRR5.getIdReponse(), e53, R53.getText(), id5);
            DAOReponse drRRR5 = new DAOReponse();
            drRRR5.addReponse(r53);
            //4eme reponse
            if (C54.isSelected()) {
                e54 = 1;
            } else {
                e54 = 0;
            }
            Reponse rrRRRRR5 = new Reponse();
            Reponse r54 = new Reponse(rrRRRRR5.getIdReponse(), e54, R54.getText(), id5);
            DAOReponse drRRRR5 = new DAOReponse();
            drRRRR5.addReponse(r54);
        }
    }

