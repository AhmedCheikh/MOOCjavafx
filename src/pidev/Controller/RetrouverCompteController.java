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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidev.dao.classes.DAOOrganisme;
import pidev.entities.Organisme;

/**
 *
 * @author Rimy Jeljeli
 */
public class RetrouverCompteController implements Initializable {

    @FXML
    private TextField recherche;
    @FXML
    private ComboBox role;
    @FXML
    public Button btnChercher;
    public static String log;
    public static String type;

    @FXML
    void btnChercherAction(ActionEvent event) throws IOException {

        log = recherche.getText();
        type = role.getValue().toString();

        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ConfirmeMail.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();

    }
//     else if(role.getValue().toString().equals("formateur"))
//          {
//}
//          else if(role.getValue().toString().equals("administrateur"))
//          {
//}
//             else 
//          {
//} 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        role.getItems().addAll(
                "apprenant",
                "formateur",
                "organisme"
        );
    }
}
