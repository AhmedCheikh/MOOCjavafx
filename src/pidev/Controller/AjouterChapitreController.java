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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Gumus
 */
public class AjouterChapitreController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @FXML
    private TextField txtTitre;
    @FXML
    private TextArea txtAObjectif;
    @FXML
    private ComboBox CmbQuiz;

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

    public void btnAjouterAction(ActionEvent event) throws IOException {
        if (txtTitre.getText().equals("")) {
            er1.setText("Vous devez Renseigez ce champs");
        } else {
            er1.setText(" ");
        }
        if (txtAObjectif.getText().equals("")) {
            er2.setText(" ");
        } else {
            er2.setText("Vous devez Renseigez ce champs");
        }
        if (CmbQuiz.getValue().equals("")) {
            er3.setText("Vous devez Renseigez ce champs");
        } else {
            er3.setText(" ");
        }

        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/AjouterChapitre.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("AjouterChapitre");
        stage.show();
    }

    public void btnAnullerAction(ActionEvent event) {

    }

    public void btnChoisirDocAction(ActionEvent event) {

        
    }

    public void btnChoisirVideoAction(ActionEvent event) {

    }

    public void btnexitAction(ActionEvent event) {

    }

    public void btnbackAction(ActionEvent event) {

    }

}
