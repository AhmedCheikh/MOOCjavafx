/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class AfficherChapitreApprenantController implements Initializable {
    @FXML
    private Button btnPasserQuiz;
    @FXML
    private Button btnTelecharger;
    @FXML
    private MediaView mvVideo;
    @FXML
    private TextArea txtObjectives;
    @FXML
    private Hyperlink hpChapitre1;
    @FXML
    private Hyperlink hpCours1;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnPasserQuizAction(ActionEvent event) {
    }

    @FXML
    private void btnTelechargerAction(ActionEvent event) {
    }

    @FXML
    private void btnexitAction(ActionEvent event) {
    }

    @FXML
    private void btnbackAction(ActionEvent event) {
    }
    

}
