/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.dao.classes.DAOApprenant;
import pidev.entities.Apprenant;

/**
 * FXML Controller class
 *
 * @author Khoubaib
 */
public class InscriptionApprenantController implements Initializable {

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
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtRepaet;
    @FXML
    private CheckBox checkbox;    
    @FXML
    private Button btnValider;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    @FXML
    private Button btnAnnuller;
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
    public void btnValiderAction(ActionEvent event) throws IOException {
        
        
        int test = 0;
        
        Pattern p = Pattern.compile("[0-9]{8}");
        Matcher m = p.matcher(txtCin.getText());
        boolean b = m.matches();
        if(b == false){
        er1.setText("Cin non valide");
            test -=1;
        } else {
            er1.setText("");
            test +=1;
        }
        if (txtNom.getText().isEmpty() || (txtNom.getText().matches("[a-zA-Z]+")==false)) {
            er2.setText("Ce champ est obligatoire");
            test -=1;
        } else {
            er2.setText("");
            test +=1;
        }
        if (txtPrenom.getText().isEmpty() || (txtPrenom.getText().matches("[a-zA-Z]+")==false)) {
            er3.setText("Ce champ est obligatoire");
            test -=1;
        } else {
            er3.setText("");
            test +=1;
        }
        
        Pattern p1 = Pattern.compile("^[A-Z0-9._-]+@[A-Z0-9]+\\.[A-Z]{2,4}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p1.matcher(txtMail.getText());
        boolean mail = matcher.find();
        
        if (txtMail.getText().isEmpty()|| (mail == false)) {
            er4.setText("Email non valide");
            test -=1;
        } else {
            er4.setText("");
            test +=1;
        }
        if (txtLogin.getText().isEmpty()|| (txtLogin.getText().matches("[a-zA-Z0-9]+")==false)) {
            er5.setText("Login non valide");
            test -=1;
        } else {
            er5.setText("");
            test +=1;
        }
        if (txtPassword.getText().isEmpty()) {
            er6.setText("Ce champ est obligatoire");
            test -=1;
        } else {
            er6.setText("");
            test +=1;
        }
        if (txtRepaet.getText().isEmpty()) {
            er7.setText("Ce champ est obligatoire");
            test -=1;
        } else {
            er7.setText("");
            test +=1;
        }
        
        if(txtPassword.getText().equals(txtRepaet.getText()) == false){
            er7.setText("Mots de passes non identiques");
             test -=1;
        }
        else {
            er7.setText("");
            test +=1;
        }
        
        if(checkbox.isSelected()){
            
             test +=1;
             er8.setText("");
        }
        else {
        
            test -=1;
            er8.setText("Ce champ est obligatoire");
        }
        

            
        
        if( test == 9 ){
            Apprenant a = new Apprenant(txtCin.getText(), txtNom.getText(), txtPrenom.getText(), txtMail.getText(), txtLogin.getText(), txtPassword.getText());
            DAOApprenant da = new DAOApprenant();
            da.add(a);
            
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/FXMLAuthentification.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Authentification");
            stage.show();
    
        }

    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnbackAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/FXMLAuthentification.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Authentification");
        stage.show();
    }

    @FXML
    private void btnexitAction(ActionEvent event) {
        Stage stage = (Stage) btnexit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnAnnullerAction(ActionEvent event) {
        txtCin.clear();
    
        txtNom.clear();
    
        txtPrenom.clear();
    
        txtMail.clear();
    
        txtLogin.clear();
    
        txtPassword.clear();
    
        txtRepaet.clear();
    }
    
}
