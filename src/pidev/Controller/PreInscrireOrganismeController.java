/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.awt.Image;
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
import javafx.stage.FileChooser;
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
    private Image tick1;

    @FXML
    public static File document;
    public void setCv(File dacument) {
        this.document = document;
    }

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
    private TextField txtpassword2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void btnValiderAction(ActionEvent event) {

        if (txtNom.getText().isEmpty()) {
            l1.setText("Vous devez Renseigez ce champs");
        } else {
            l1.setText(" ");
        }
        if (txtAdresse.getText().isEmpty()) {
            l2.setText("Vous devez Renseigez ce champs");

        } else {
            l2.setText(" ");
        }
        if (txtEmail.getText().isEmpty()) {
            l3.setText("Vous devez Renseigez ce champs");
        } else {
            l3.setText(" ");
        }
        if (txtLogin.getText().isEmpty()) {
            l4.setText("Vous devez Renseigez ce champs");
        } else {
            l4.setText(" ");
        }
        if (txtPassword.getText().isEmpty()) {
            l5.setText("Vous devez Renseigez ce champs");
        } else {
            l5.setText(" ");
        }
        if (txtpassword2.getText().isEmpty()) {
            l6.setText("Vous devez Renseigez ce champs");
        } else {
            l6.setText(" ");
        }
        String p = txtPassword.getText();
        if (!txtpassword2.getText().equals(p)) {
            l6.setText("Le Mot de passe n'est pas identique!!");
        } else {
            l6.setText(" ");
        }
        System.out.println(txtNom.getText());
         Organisme o2=new Organisme();
       Organisme o1 = new Organisme(o2.getId(),txtNom.getText(), txtLogin.getText(), txtPassword.getText(), txtEmail.getText(), txtAdresse.getText(),document,0);
      
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

    public void btnAnullerAction(ActionEvent event) {
        txtNom.setText("");
        txtLogin.setText("");
        txtAdresse.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtpassword2.setText("");

    }

    public void btnexitAction(ActionEvent event) {

    }

    public void btnbackAction(ActionEvent event) {

    }

    public void btnChoisireAction() {
        
        FileChooser fileChooser = new FileChooser();

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            fileChooser.setTitle("Open resource file");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.pdf"));
            Organisme o = new Organisme();
            if (selectedFile != null) {
                File path = selectedFile.getAbsoluteFile();
                document=path;
                l7.setText("File selected: " + selectedFile.getName());
               o.setDocument(path);
            }
            else {

    l7.setText("File selection cancelled.");

}

        }

    }}
