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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.dao.classes.DAOApprenant;
import pidev.entities.Apprenant;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class EditProfilApprenantController implements Initializable {
   
    
    @FXML
    private Label er1;
    @FXML
    private Label er2;
    @FXML
    private Label er5;
    @FXML
    private Label er3;
    @FXML
    private Label er4;
    @FXML
    private Label er6;
    @FXML
    private TextField txtCin;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtLogin;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtAvatar;

    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnAnnuller;
    
    private Apprenant apprenant;
    private Apprenant newApprenant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setApprenant(Apprenant apprenant) {
        txtCin.setText(apprenant.getCin());
        txtNom.setText(apprenant.getNom());
        txtPrenom.setText(apprenant.getPrenom());
        txtPassword.setText(apprenant.getPassword());
        txtLogin.setText(apprenant.getLogin());
        this.apprenant = apprenant;
    }

 

    @FXML
    private void btnModifierAction(ActionEvent event) throws IOException {
         
        int test = 0;
        
//        Pattern p = Pattern.compile("[0-9]{8}");
//        Matcher m = p.matcher(txtCin.getText());
//        boolean b = m.matches();
//        if(b == false){
//        er1.setText("Cin non valide");
//            test -=1;
//        } else {
//            er1.setText("");
//            test +=1;
//        }
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
        
        if (txtLogin.getText().isEmpty()|| (txtLogin.getText().matches("[a-zA-Z0-9]+")==false)) {
            er4.setText("Login non valide");
            test -=1;
        } else {
            er4.setText("");
            test +=1;
        }
        if (txtPassword.getText().isEmpty()) {
            er5.setText("Ce champ est obligatoire");
            test -=1;
        } else {
            er5.setText("");
            test +=1;
        }

        
        if( test == 4 ){
            newApprenant = new Apprenant(apprenant.getCin(), txtNom.getText(), txtPrenom.getText(),apprenant.getEmail() ,txtLogin.getText(), txtPassword.getText());
            DAOApprenant da = new DAOApprenant();
            da.update(newApprenant , apprenant.getCin());
        }
    }

    @FXML
    private void btnAnnullerAction(ActionEvent event) {

        txtNom.clear();
    
        txtPrenom.clear();
    
        txtLogin.clear();
    
        txtPassword.clear();

    }

    @FXML
    private void btnexitAction(ActionEvent event) {
        Stage stage = (Stage) btnexit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnbackAction(ActionEvent event) throws IOException {

        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ProfilApprenant.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.setTitle("Profil Apprenant");
        ProfilApprenantController pac  = loader.getController();
        pac.setApprenant(newApprenant);
        stage.show();
        
    }
    
    

    
}
