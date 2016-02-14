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
import javafx.stage.Stage;
import pidev.entities.Apprenant;

/**
 * FXML Controller class
 *
 * @author Khoubaib
 */
public class RechercherCourController implements Initializable {

    @FXML
    private Button btnExit;
    @FXML
    private Button btnBack;
    private Apprenant apprenant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnExitAction(ActionEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnBackAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ProfilApprenant.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.setTitle("Profil Apprenant");
        ProfilApprenantController pac  = loader.getController();
        pac.setApprenant(apprenant);
        stage.show();
    }

    public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }
    
    
    
}
