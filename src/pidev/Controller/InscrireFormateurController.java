/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import jdk.nashorn.internal.codegen.CompilerConstants;
import pidev.dao.classes.DAOFormateur;
import pidev.entities.Formateur;

/**
 * FXML Controller class
 *
 * @author akoubi
 */
public class InscrireFormateurController implements Initializable {
    //déclaration des textFields
    @FXML
    private TextField txtCin;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtMail;
    @FXML
    private TextField txtLogin;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtRepaet;
    //declation des labels
    @FXML
    private Label er1;
    @FXML
    private Label er2;
    @FXML
    private Label er3;
    @FXML
    private Label er4;
    @FXML
    private Label er5;
    @FXML
    private Label er6;
    @FXML
    private Label er7;
    @FXML
    private Label er8;
    @FXML
    private Label lbltimer;
    @FXML
    private Pane paneImg1;
    @FXML
    private Pane paneImg2;
    
    public static File cv ;
    Alert alert = new Alert(Alert.AlertType.WARNING);
    
    public void setCv(File cv) {
        this.cv = cv;
    }
   
    public boolean textFieldEmpty(TextField i){
       boolean r = false;
       if(i.getText() != null && !i.getText().isEmpty()){
       r = true;
       i.setStyle("-fx-border-color:#84D41D");
       }
       return r;
    }
    public boolean textFieldEmpty(TextField i,Label l, String sValidationText){
    boolean r =true;
    String c = null;
       if(!textFieldEmpty(i)){
       r= false;
       c = sValidationText;
       i.setStyle("-fx-border-color:red");
       }
       l.setText(c);
       return r;
    }
    
    public boolean validationCin(TextField txtf){
    boolean verif = false;            
    Pattern p = Pattern.compile("[0-9]{8}");
    Matcher m = p.matcher(txtCin.getText());
    if(m.find() && m.group().equals(txtf.getText())){
    verif = true;
    txtf.setStyle("-fx-border-color:#84D41D");
    paneImg1.setStyle("-fx-background-image: url(pidev/gui/img/vrai.png)");
    }
    return verif;
    }

    public boolean validationCin(TextField ft, Alert alert, String msg){
    boolean verif = true;    
    if(!validationCin(ft)){
    verif = false;
    alert.setTitle("Validation CIN");
    alert.setHeaderText(null);
    alert.setContentText(msg);
    ft.setText(""); 
    ft.setStyle("-fx-border-color:red");
    alert.showAndWait();
    }  
    return verif;
    } 
    
    public boolean validationEmail(TextField txte){
    boolean verife = false;
    Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    Matcher m = p.matcher(txte.getText());
    if(m.find() && m.group().equals(txte.getText())){
    verife = true;
    txte.setStyle("-fx-border-color:#84D41D");
    paneImg2.setStyle("-fx-background-image: url(pidev/gui/img/vrai.png)");
    }
    return verife;
    }
    
    public boolean validationEmail(TextField txtem, Label el, String sValidationEmail){
        boolean verife = true;
        String str = null;
        if(!validationEmail(txtem)){
        str = sValidationEmail;
        txtem.setStyle("-fx-border-color:red");
        }
        el.setText(str);
        return verife;
    }
    
    public void btnChoisirCvAction(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open resource file");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Text Files", "*.pdf"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null){
        File path = selectedFile.getAbsoluteFile();
        er8.setText(selectedFile.getAbsolutePath());
        
        //mpth = path;
        setCv(path);
        }else{
           er8.setText("File Invalide");
        }
        //Formateur f2 = new Formateur("12345678","zied","agoubi","zou","zou","12345",null,pth, 0);
        //DAOFormateur daof2 = new DAOFormateur();
        //daof2.inscrire(f2);
    }
    
    public void btnValiderAction(ActionEvent event) throws IOException {
           
          boolean nom = textFieldEmpty(txtNom, er2, "Ce champs doit etre remplie");
          boolean prenom = textFieldEmpty(txtPrenom, er3, "Ce champs doit etre remplie");
          boolean login = textFieldEmpty(txtLogin, er5, "Ce champs doit etre remplie");
          boolean password = textFieldEmpty(txtPassword, er6, "Ce champs doit etre remplie");
          boolean repeat = textFieldEmpty(txtRepaet, er7, "Ce champs doit etre remplie");
          boolean cin = validationCin(txtCin, alert,"CIN non Valide");
          boolean email = validationEmail(txtMail, er4,"Email Invalide");
          if(cin && nom && prenom && email && login && password && repeat){
             if(txtPassword.getText().equals(txtRepaet.getText())){
                  Formateur f1 = new Formateur(txtCin.getText(), txtNom.getText(), txtPrenom.getText(), txtMail.getText(), txtLogin.getText(), txtPassword.getText(), null,cv, 0);
                  DAOFormateur daof = new DAOFormateur();
                  daof.inscrire(f1);
//                  Timer timer = new Timer();
//                  timer.schedule(new TimerTask() {
//                      @Override
//                      public void run() {
//                          Platform.runLater(new Runnable() {
//                              int i = 0;
//                              @Override
//                              public void run() {
//                              lbltimer.setText("Patientez Vous: "+i);
//                              i++;
//                              }
//                          });
//                      }
//                  },1000,1000);
                 // DAOFormateur da = new DAOFormateur();
                  
                  //da.getFormateurByCIN(txtCin.getText());
                  
//                  ((Node) (event.getSource())).getScene().getWindow().hide();
//                  Parent root = FXMLLoader.load(getClass().getResource("/pidev/gui/ProfilFormateur.fxml"));
//                  Stage stage = new Stage();
//                  Scene scene = new Scene(root);
//                  stage.setScene(scene);
//                  stage.show();
             }else{
             er7.setText("Les 2 mots de passe ne sont pas identiques");
             txtPassword.setStyle("-fx-border-color:red");
             txtRepaet.setStyle("-fx-border-color:red");
             }
          }
  
//        if(txtCin.getText().isEmpty()){   
//        }else{er1.setText(" ");}
//        if (txtNom.getText().isEmpty()) {
//            er2.setText("Vous devez Renseigez ce champs");
//            txtNom.setStyle("-fx-border-color:red");
//        }else{er2.setText(" ");}
//        if (txtPrenom.getText().isEmpty()) {
//            er3.setText("Vous devez Renseigez ce champs");
//        }else{er3.setText(" ");}
//        if (txtMail.getText().isEmpty()) {
//            er4.setText("Vous devez Renseigez ce champs");
//        }else{er4.setText(" ");}
//        if (txtLogin.getText().isEmpty()) {
//            er5.setText("Vous devez Renseigez ce champs");
//        }else{er5.setText(" ");}
//        if (txtPassword.getText().isEmpty()) {
//            er6.setText("Vous devez Renseigez ce champs");
//        }else{er6.setText(" ");}
//        if (txtRepaet.getText().isEmpty()) {
//            er7.setText("Vous devez Renseigez ce champs");
//        }else{ er7.setText(" ");}

//                Formateur f1 = new Formateur(txtCin.getText(), txtNom.getText(), txtPrenom.getText(), txtMail.getText(), txtLogin.getText(), txtPassword.getText(), null,cv, 0);
//                DAOFormateur daof = new DAOFormateur();
//                daof.inscrire(f1);

    }

    public void btnAnullerAction(ActionEvent event) {
        txtCin.setText("");
        txtNom.setText("");
        txtPrenom.setText("");
        txtMail.setText("");
        txtLogin.setText("");
        txtPassword.setText("");
        txtRepaet.setText("");
    }
    
    public void btnexitAction(ActionEvent event) {
    
    }

    public void btnbackAction(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
