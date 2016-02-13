/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

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

    @FXML
    private void btrChronometreAction(ActionEvent event) {
    }

    @FXML
    private void btrNonChronometreAction(ActionEvent event) {
    }

    @FXML
    private void btnAjouterQuizAction(ActionEvent event) {
        Quiz q1 = new Quiz();
        Quiz q = new Quiz(q1.getIdQuiz(), txtTitre.getText(), 0, 0);
        DAOQuiz daoq = new DAOQuiz();
        daoq.addQuiz(q);
        
         int id=daoq.findQuizByTitreSelonId(txtTitre.getText());
        Question qe = new Question();
        Question qe1 = new Question(qe.getIdQuestion(), Q1.getText(), q.getIdQuiz());
        DAOQuestion daoqe1 = new DAOQuestion();
        daoqe1.addQuestion(qe1);

//        Reponse r1 = new Reponse();
//        Reponse r11 = new Reponse(r1.getIdReponse(), 1, R11.getText(), qe1.getIdQuestion());
//        DAOReponse dr1 = new DAOReponse();
//        dr1.addReponse(r1);
    }
}
//        Reponse r2=new Reponse();
//        Reponse r12=new Reponse(r2.getIdReponse(), 1, R12.getText(), qe1.getIdQuestion());
//        DAOReponse daor2 = new DAOReponse();
//        daor2.addReponce(r12);
//        Reponse r3=new Reponse();
//        Reponse r13=new Reponse(r3.getIdReponse(), 1, R13.getText(), qe1.getIdQuestion());
//        DAOReponse daor3 = new DAOReponse();
//        daor3.addReponce(r13);
//        Reponse r4=new Reponse();
//        Reponse r14=new Reponse(r4.getIdReponse(), 1, R11.getText(), qe1.getIdQuestion());
//        DAOReponse daor4 = new DAOReponse();
//        daor4.addReponce(r14);
//    
//        Question qe2=new Question(1, Q2.getText(), q.getIdQuiz());
//        DAOQuestion daoqe2 = new DAOQuestion();
//        daoqe2.addQuestion(qe2);
//        
//        
//        Reponse r21=new Reponse(1, 1, R21.getText(), qe2.getIdQuestion());
//        DAOReponse daor21 = new DAOReponse();
//        daor21.addReponce(r21);
//        Reponse r22=new Reponse(2, 1, R22.getText(), qe2.getIdQuestion());
//        DAOReponse daor22 = new DAOReponse();
//        daor22.addReponce(r22);
//        Reponse r23=new Reponse(3, 1, R23.getText(), qe2.getIdQuestion());
//        DAOReponse daor23 = new DAOReponse();
//        daor23.addReponce(r23);
//        Reponse r24=new Reponse(4, 1, R21.getText(), qe2.getIdQuestion());
//        DAOReponse daor24 = new DAOReponse();
//        daor24.addReponce(r24);
//        
//        
//        Question qe3=new Question(1, Q3.getText(), q.getIdQuiz());
//        DAOQuestion daoqe3 = new DAOQuestion();
//        daoqe3.addQuestion(qe3);
//        
//        
//        Reponse r31=new Reponse(1, 1, R31.getText(), qe3.getIdQuestion());
//        DAOReponse daor31 = new DAOReponse();
//        daor31.addReponce(r31);
//        Reponse r32=new Reponse(2, 1, R32.getText(), qe3.getIdQuestion());
//        DAOReponse daor32 = new DAOReponse();
//        daor32.addReponce(r32);
//        Reponse r33=new Reponse(3, 1, R33.getText(), qe3.getIdQuestion());
//        DAOReponse daor33 = new DAOReponse();
//        daor33.addReponce(r33);
//        Reponse r34=new Reponse(4, 1, R31.getText(), qe3.getIdQuestion());
//        DAOReponse daor34 = new DAOReponse();
//        daor34.addReponce(r34);
//        
//        
//        Question qe4=new Question(1, Q4.getText(), q.getIdQuiz());
//        DAOQuestion daoqe4 = new DAOQuestion();
//        daoqe4.addQuestion(qe4);
//        
//        
//        Reponse r41=new Reponse(1, 1, R41.getText(), qe4.getIdQuestion());
//        DAOReponse daor41 = new DAOReponse();
//        daor41.addReponce(r41);
//        Reponse r42=new Reponse(2, 1, R42.getText(), qe4.getIdQuestion());
//        DAOReponse daor42 = new DAOReponse();
//        daor42.addReponce(r42);
//        Reponse r43=new Reponse(3, 1, R43.getText(), qe4.getIdQuestion());
//        DAOReponse daor43 = new DAOReponse();
//        daor43.addReponce(r43);
//        Reponse r44=new Reponse(4, 1, R41.getText(), qe4.getIdQuestion());
//        DAOReponse daor44 = new DAOReponse();
//        daor44.addReponce(r44);
//        
//        
//        Question qe5=new Question(1, Q5.getText(), q.getIdQuiz());
//        DAOQuestion daoqe5 = new DAOQuestion();
//        daoqe5.addQuiz(qe5);
//        
//        
//        Reponse r51=new Reponse(1, 1, R51.getText(), qe5.getIdQuestion());
//        DAOReponse daor51 = new DAOReponse();
//        daor51.addReponce(r51);
//        Reponse r52=new Reponse(2, 1, R52.getText(), qe2.getIdQuestion());
//        DAOReponse daor52 = new DAOReponse();
//        daor52.addReponce(r52);
//        Reponse r53=new Reponse(3, 1, R53.getText(), qe2.getIdQuestion());
//        DAOReponse daor53 = new DAOReponse();
//        daor53.addReponce(r53);
//        Reponse r54=new Reponse(4, 1, R51.getText(), qe2.getIdQuestion());
//        DAOReponse daor54 = new DAOReponse();
//        daor54.addReponce(r54);
//    }
//    }
