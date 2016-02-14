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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.dao.classes.DAOFormateur;
import pidev.entities.Formateur;

/**
 * FXML Controller class
 *
 * @author akoubi
 */
public class InscrireFormateurController implements Initializable {

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
    //
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
    
    public void btnValiderAction(ActionEvent event) throws IOException {

        if (txtCin.getText().equals("") == true) {
            er1.setText("Vous devez Renseigez ce champs");
        } else {
            er1.setText(" ");
        }
        if (txtNom.getText().equals("") == true) {
            er2.setText("Vous devez Renseigez ce champs");
        } else {
            er2.setText(" ");
        }
        if (txtPrenom.getText().equals("") == true) {
            er3.setText("Vous devez Renseigez ce champs");
        } else {
            er3.setText(" ");
        }
        if (txtMail.getText().equals("") == true) {
            er4.setText("Vous devez Renseigez ce champs");
        } else {
            er4.setText(" ");
        }
        if (txtLogin.getText().equals("") == true) {
            er5.setText("Vous devez Renseigez ce champs");
        } else {
            er5.setText(" ");
        }
        if (txtPassword.getText().equals("") == true) {
            er6.setText("Vous devez Renseigez ce champs");
        } else {
            er6.setText(" ");
        }
        if (txtRepaet.getText().equals("") == true) {
            er7.setText("Vous devez Renseigez ce champs");
        } else {
            er7.setText(" ");
        }
   
//                Formateur f1 = new Formateur(txtCin.getText(), txtNom.getText(), txtPrenom.getText(), txtMail.getText(), txtLogin.getText(), txtPassword.getText(), null, null, 0);
                DAOFormateur daof = new DAOFormateur();
//                daof.inscrire(f1);
            }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        }
//    }

//    public void btnAnullerAction(ActionEvent event) {
//        txtCin.setText("");
//        txtNom.setText("");
//        txtPrenom.setText("");
//        txtMail.setText("");
//        txtLogin.setText("");
//        txtPassword.setText("");
//        txtRepaet.setText("");
//    }
//    public void btnChoisirCvAction(ActionEvent event){
//
//    }
//    
//    public void btnexitAction(ActionEvent event) {
//    
//    }
//
//    public void btnbackAction(ActionEvent event) {
//
//    }
//
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }

//}
