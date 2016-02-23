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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pidev.dao.classes.DAOApprenant;
import pidev.dao.classes.DAOComite;
import pidev.entities.Apprenant;
import pidev.entities.Comite;


/**
 * FXML Controller class
 *
 * @author WiKi
 */
public class EditProfilComiteController implements Initializable {
    
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
    private Button btnexit;
    @FXML
    private Button btnback;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnAnnuller;
    
    private Comite c ;
    public Comite newComite ; 
    
    @FXML
    private Button btnChoisirImage;
    
    public File file;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setComite(Comite c) {
        txtCin.setText(c.getCIN());
        txtNom.setText(c.getNom());
        txtPrenom.setText(c.getPrenom());
        txtPassword.setText(c.getPasswordComite());
        txtLogin.setText(c.getLoginComite());
        this.c = c;
    }
    
    @FXML
    private void btnAnnullerAction(ActionEvent event) {

        txtNom.clear();
    
        txtPrenom.clear();
    
        txtLogin.clear();
    
        txtPassword.clear();

    }
    
    @FXML
    private void btnModifierAction(ActionEvent event) throws IOException {
         
        int test = 0;

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
        
        if (test == 4) {
            DAOComite comiteDAO = new DAOComite();
            newComite = new Comite(c.getCIN(), c.getNom(), c.getPrenom(), c.getEmail(), c.getLoginComite(), c.getPasswordComite());
            comiteDAO.update(newComite, c.getCIN());
            c=newComite ; 
        }
        
    }
    
 @FXML
    private void btnexitAction(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("Your are leaving application !");
alert.setContentText("Are you sure to leave?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    
      ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/FXMLAuthentification.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        stage.setTitle("Authentification");
        
        stage.show();
    
} else {
   alert.close();
}
        
    }

    @FXML
    private void btnbackAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ProfilComite.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        stage.setTitle("Profil Comite");

        stage.show();
    }   
   
        
 
    
}
