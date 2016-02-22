/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pidev.dao.classes.DAOFormateur;
import pidev.dao.classes.DAOOrganisme;

/**
 *
 * @author Rimy Jeljeli
 */
public class ModifierPwdController implements Initializable {

    @FXML
    private TextField logintxt;
    @FXML
    private TextField pwd;
    @FXML
    private Button btnValider;
    String type = RetrouverCompteController.type;
    String login = RetrouverCompteController.log;
    DAOOrganisme daoo = new DAOOrganisme();
    DAOFormateur daof=new DAOFormateur();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logintxt.setText(RetrouverCompteController.log);

    }

    @FXML
    public void btnValiderAction(Event event) {
        if (type.equals("organisme")) {
            System.out.println("pwd=" + pwd.getText());
            System.out.println("login=" + login);
            daoo.setPwd(login, pwd.getText());
        }
        else if (type.equals("formateur")) {
            System.out.println("pwd=" + pwd.getText());
            System.out.println("login=" + login);
            daof.setPwd(login, pwd.getText());
        }
    }
}
