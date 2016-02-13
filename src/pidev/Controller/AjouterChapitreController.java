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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.dao.classes.DAOChapitre;
import pidev.entities.Chapitre;

/**
 *
 * @author Gumus
 */
public class AjouterChapitreController {

    @FXML
    private TextField txtTitre;
    @FXML
    private TextArea txtAObjectif;

    @FXML
    private Label er1;
    @FXML
    private Label er2;

    public void btnAjouterAction(ActionEvent event) throws IOException {

        if (txtTitre.getText().isEmpty()) {
            er1.setText("Vous devez Renseigez ce champs");
        } else {
            er1.setText(" ");
        }
        if (txtAObjectif.getText().isEmpty()) {
            er2.setText("Vous devez Renseigez ce champs");
        } else {
            er2.setText(" ");
        }

//         Chapitre c = new Chapitre(1, 1, 1, txtTitre.getText(), null, txtAObjectif.getText(), 1, null);
        Chapitre c1 = new Chapitre();
        Chapitre c = new Chapitre(c1.getIdChapitre(), txtTitre.getText(), txtAObjectif.getText());

        DAOChapitre daoc = new DAOChapitre();
        daoc.addChapitre(c);
    }

    @FXML
    public void btnAnullerAction(ActionEvent event) {
        txtTitre.setText("");
        txtAObjectif.setText("");

    }

    @FXML
    public void btnChoisirDocAction(ActionEvent event) {
        FileChooser fileshoser = new FileChooser();
        File f = fileshoser.showOpenDialog(null);

        if (fileshoser != null) {
            System.out.println(f.getName());
        }

    }

    @FXML
    public void btnChoisirVideoAction(ActionEvent event) {

    }

    @FXML
    public void btnAjouterQuizAction(ActionEvent event) {

    }

    @FXML
    public void btnexitAction(ActionEvent event) {

    }

    @FXML
    public void btnbackAction(ActionEvent event) {

    }

}
