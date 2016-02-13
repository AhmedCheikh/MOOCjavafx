/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.dao.classes.DAOOrganisme;
import pidev.entities.*;

/**
 *
 * @author Rimy Jeljeli
 */
public class PreInscrireOrganismeController implements Initializable {
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    private Label l5;
    @FXML
    private Label l6;
    @FXML
    private Label l7;
  
        
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtAdresse;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtLogin;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtPassword2;
    
   
    @Override
    public void initialize(URL location, ResourceBundle resources) { }


        public void btnValiderAction(ActionEvent event){
    
    
        if (txtNom.getText().isEmpty()) {
        l1.setText("Vous devez Renseigez ce champs");
        }else{
        l1.setText(" ");
        }
        if (txtAdresse.getText().isEmpty()) {
        l2.setText(" ");
        }else{
        l2.setText("Vous devez Renseigez ce champs");
        }
        if (txtEmail.getText().isEmpty()) {
        l3.setText("Vous devez Renseigez ce champs");
        }else{
        l3.setText(" ");
        }
        if (txtLogin.getText().isEmpty()) {
        l4.setText("Vous devez Renseigez ce champs");
        }else{
        l4.setText(" ");
        }
        if (txtPassword.getText().isEmpty()) {
        l5.setText("Vous devez Renseigez ce champs");
        }else{
        l5.setText(" ");
        }
        if (txtPassword2.getText().isEmpty()) {
        l6.setText("Vous devez Renseigez ce champs");
        }else{
        l6.setText(" ");
        }
        String p=txtPassword.getText();
         if (!txtPassword2.getText().equals(p)) {
        l6.setText("Le Mot de passe n'est pas identique!!");
        }else{
        l6.setText(" ");
        }
         
                Organisme o1 = new Organisme(3,txtNom.getText(),txtLogin.getText(),txtPassword.getText(),txtEmail.getText(),null,txtAdresse.getText(),null,null,null,null,10);
                DAOOrganisme d1 = new DAOOrganisme();
                d1.addOrganisme(o1);
                 

//         ((Node) (event.getSource())).getScene().getWindow().hide();
//            Parent parent;
//     
//            parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ProfileOrganismeA.fxml"));
//      
//            Stage stage =  new Stage();
//            Scene scene = new Scene(parent);
//            stage.setScene(scene);
//            stage.setTitle("Profil Organisme");
//            stage.show();
    }

  public void btnAnullerAction(ActionEvent event){
    txtNom.setText("");
    txtLogin.setText("");
    txtPassword.setText("");
    txtPassword2.setText("");
    txtEmail.setText("");
    txtAdresse.setText("");
    }
     public void btnexitAction(ActionEvent event){
    
    }
    public void btnbackAction(ActionEvent event){
    
    }
}

