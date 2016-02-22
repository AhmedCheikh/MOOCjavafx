/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Properties;
import javafx.event.ActionEvent;
import javafx.scene.web.HTMLEditor;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import pidev.dao.classes.DAOOrganisme;
/**
 *
 * @author Rimy Jeljeli
 */
public class MailController extends Application{
    
     @FXML
    private TextField objet;
    @FXML
    private TextField emailExp;
    @FXML
    private HTMLEditor msg;

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      



@FXML
    public void btnEnvoyerAction(ActionEvent event) throws IOException {
    DAOOrganisme daoo=new DAOOrganisme();
    daoo.envoyerMsg(emailExp.getText(),objet.getText(),msg.getHtmlText());

 }

    

}
