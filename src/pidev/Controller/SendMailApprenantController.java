/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.mail.Session;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * FXML Controller class
 *
 * @author Khoubaib
 */
public class SendMailApprenantController implements Initializable {

    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtDestinataire;
    @FXML
    private Button btnPieceJoindre;
    @FXML
    private TextField txtObjet;
    @FXML
    private TextArea txtMessage;
    @FXML
    private Label er1;
    @FXML
    private Label er2;
    @FXML
    private Label er3;
    @FXML
    private Label er4;
    @FXML
    private Button btnEnvoyer;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnBack;
    
    public File file;
    String username  ;
    String password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DropShadow shadow = new DropShadow();

        btnExit.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        shadow.setColor(Color.RED);
                        btnExit.setEffect(shadow);
                    }
                });

        btnExit.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        
                        btnExit.setEffect(null);
                    }
                });
        btnBack.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        shadow.setColor(Color.DODGERBLUE);
                        btnBack.setEffect(shadow);
                    }
                });

        btnBack.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        
                        btnBack.setEffect(null);
                    }
                });
        
        txtEmail.setText(ProfilApprenantController.apprenant.getEmail());
        
    }    

    @FXML
    private void btnPieceJoindreAction(ActionEvent event) {
           
        FileChooser fileChooser = new FileChooser();
//
//        FileChooser.ExtensionFilter extFilterPDF = 
//                    new FileChooser.ExtensionFilter("PDF files (*.PDF)", "*.PDF");
//        FileChooser.ExtensionFilter extFilterZIP = 
//                    new FileChooser.ExtensionFilter("ZIP files (*.ZIP)", "*.ZIP");
        fileChooser.selectedExtensionFilterProperty();

        file = fileChooser.showOpenDialog(null);
        if(file != null){
            er4.setText(file.getName());
        }
    }

    @FXML
    private void btnEnvoyerAction(ActionEvent event) {
        int test = 0;

        Pattern p1 = Pattern.compile("^[A-Z0-9._-]+@[A-Z0-9]+\\.[A-Z]{2,4}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p1.matcher(txtEmail.getText());
        boolean mail = matcher.find();
        
        if (txtEmail.getText().isEmpty()|| (mail == false)) {
            er1.setText("Email non valide");
            test -=1;
        } else {
            er1.setText("");
            test +=1;
        }
       
        if (txtPassword.getText().isEmpty()) {
            er2.setText("Ce champ est obligatoire");
            test -=1;
        } else {
            er2.setText("");
            test +=1;
        }
        
        Pattern p2 = Pattern.compile("^[A-Z0-9._-]+@[A-Z0-9]+\\.[A-Z]{2,4}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = p2.matcher(txtDestinataire.getText());
        boolean mailD = matcher2.find();
              
        if (txtDestinataire.getText().isEmpty()|| (mailD == false)) {
            er3.setText("Email non valide");
            test -=1;
        } else {
            er3.setText("");
            test +=1;
        }   
            
        if( test == 3 ){
              
     username = txtEmail.getText() ;
     password= txtPassword.getText();
    
    Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            try {
             
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(txtMessage.getText());
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            
            if (file != null) {
            BodyPart attachmentPart = new MimeBodyPart();
            DataSource source = new FileDataSource(file);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName(file.getName());
            multipart.addBodyPart(attachmentPart);
            }
            

            MimeMessage message = new MimeMessage(session);
            
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(txtDestinataire.getText()));
                message.setSubject(txtObjet.getText());
                message.setContent(multipart);
                Transport.send(message);
                System.out.println("Was the Email Send : Done"); 
               
            } catch (MessagingException ex) {
                Logger.getLogger(SendMailApprenantController.class.getName()).log(Level.SEVERE, null, ex);
            }
   
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("Mail envoyer avec succée !");
            alert.showAndWait();
    
        }   
        
        
    }

    @FXML
    private void btnExitAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("Your are leaving application !");
        alert.setContentText("Are you sure to leave?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
         Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
        } else {
        alert.close();
        }
    }

    @FXML
    private void btnBackAction(ActionEvent event) throws IOException {
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ProfilApprenant.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.setTitle("Profil Apprenant");
        ProfilApprenantController pac  = loader.getController();
        pac.setApprenant(ProfilApprenantController.apprenant);
        stage.show();
    }

}
