/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pidev.dao.classes.DAOChapitre;
import pidev.dao.classes.DAOQuestion;
import pidev.dao.classes.DAOQuiz;
import pidev.dao.classes.DAOReponse;
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
    private Button btnAjouterQuizAction;
    
    @FXML
    private Button btnModifierQuiz;
    @FXML
    private Label er1;
    @FXML
    private Label ltitre;
    @FXML
    private Label Note;
    int qi;
    int r;
    int qu;
    List lr;
    String pnomc;
    static List lmodifidquestion;
    static List lmodifidrep;
    
    public void setPnomc(String pnomc) {
        this.pnomc = pnomc;
        int et;
        int f = 0;
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
        qi = daoc1.FindIdQuizbychapitre(pnomc);
        
        DAOQuiz daoq1 = new DAOQuiz();
        String t = daoq1.findTitreQuizByTitreSelonId(qi);
        int type = daoq1.findTypeQuiz(qi);
        if (type == 1) {
            btrChronometre.setSelected(true);
        } else {
            btrNonChronometre.setSelected(true);
        }
        txtTitre.setText(t);
        
        DAOQuestion daoqe = new DAOQuestion();
        List lsq = daoqe.FindIdQuestionbyQuiz(qi);
        lmodifidquestion = new ArrayList();
        lmodifidrep = new ArrayList();
        for (int i = 0; i < 5; i++) {
            
            Question s = (Question) lsq.get(i);
            tfQ[i].setText(s.getQuestion());
            qu = daoqe.findQuestionSelonId(s);
            
            lmodifidquestion.add(qu);
            DAOReponse r = new DAOReponse();
            lr = r.FindIdReponsebyQuestion(qu);
            
            for (int j = 0; j < 4; j++) {
                Reponse s1 = (Reponse) lr.get(j);
                tfR[f].setText(s1.getReponse());
                lmodifidrep.add(s1.getIdReponse());
                et = r.findEtatReponse(tfR[f].getText());
                
                if (et == 1) {
                    tfC[f].setSelected(true);
                }
                f++;
            }
        }
        
    }
    
    @FXML
    private void btnModifierQuizAction(ActionEvent event) {
        
        int etatquiz = 0;
        if (btrChronometre.isSelected()) {
            etatquiz = 1;
        } else if (btrNonChronometre.isSelected()) {
            etatquiz = 0;
        }
        
        Quiz q = new Quiz(txtTitre.getText(), etatquiz, 0);
        System.out.println(q);
        System.out.println(qi);
        DAOQuiz daoq1 = new DAOQuiz();
        daoq1.updateQuiz(qi, q);
        
        r = 0;
        int c;
        
        int etat = 0;
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
        System.out.println(lmodifidquestion);
        System.out.println(lmodifidrep);
        for (int i = 0; i < 5; i++) {
            
            Question qe = new Question(tfQ[i].getText());
            DAOQuestion daoqe = new DAOQuestion();
            System.out.println(qe);
            System.out.println(lmodifidquestion.get(i));
            daoqe.updateQuestion((int) lmodifidquestion.get(i), qe);
            
            for (int j = 0; j < 4; j++) {
                if (tfC[r].isSelected()) {
                    etat = 1;
                } else {
                    etat = 0;
                }
                Reponse r11 = new Reponse(etat, tfR[r].getText());
                DAOReponse daor11 = new DAOReponse();
                System.out.println(lmodifidrep.get(r));
                daor11.updateReponse((int) lmodifidrep.get(r), r11);
                r++;
            }
        }
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
    private void btnSupprimerQuizAction(ActionEvent event
    ) {
        DAOChapitre daoc1 = new DAOChapitre();
        qi = daoc1.FindIdQuizbychapitre(pnomc);
        DAOQuiz daoq1 = new DAOQuiz();
        daoq1.removeQuiz(qi);
        for (int i = 0; i < 5; i++) {
            DAOQuestion daoqe = new DAOQuestion();
            daoqe.removeQuestion((int) lmodifidquestion.get(i));
            
            for (int j = 0; j < 4; j++) {
                DAOReponse daor11 = new DAOReponse();
                daor11.removeReponse((int) lmodifidrep.get(r));
                r++;
            }
        }
        
    }
}
