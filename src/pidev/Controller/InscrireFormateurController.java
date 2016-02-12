/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

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
import javafx.stage.Stage;

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
        if (txtCin.getText().equals("")) {
            er1.setText("Vous devez Renseigez ce champs");
        } else {
            er1.setText(" ");
        }
        if (txtNom.getText().equals("")) {
            er2.setText(" ");
        } else {
            er2.setText("Vous devez Renseigez ce champs");
        }
        if (txtMail.getText().equals("")) {
            er3.setText("Vous devez Renseigez ce champs");
        } else {
            er3.setText(" ");
        }
        if (txtMail.getText().equals("")) {
            er4.setText("Vous devez Renseigez ce champs");
        } else {
            er4.setText(" ");
        }
        if (txtLogin.getText().equals("")) {
            er5.setText("Vous devez Renseigez ce champs");
        } else {
            er5.setText(" ");
        }
        if (txtPassword.getText().equals("")) {
            er6.setText("Vous devez Renseigez ce champs");
        } else {
            er6.setText(" ");
        }
        if (txtRepaet.getText().equals("")) {
            er7.setText("Vous devez Renseigez ce champs");
        } else {
            er7.setText(" ");
        }
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ProfilFormateur.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Profil Formateur");
        stage.show();
    }

    @FXML
    public void btnAnullerAction(ActionEvent event) {

    }

    @FXML
    public void btnexitAction(ActionEvent event) {

    }

    @FXML
    public void btnbackAction(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
