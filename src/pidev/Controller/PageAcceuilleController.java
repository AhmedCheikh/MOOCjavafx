/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class PageAcceuilleController  implements  Initializable{
    public String v;
@FXML
private ComboBox role ;
    private Object fxmlLoader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       role.getItems().addAll(
    "administrateur",
    "apprenant",
    "formateur",
    "organisme"           
);
    }

   public void btnAuthentifAction(Event event){
       role.setDisable(false);
   }
    public void clickAction(Event event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/pidev/gui/FXMLAuthentification.fxml"));
        AnchorPane frame = fxmlLoader.load();

//            ((Node) (event.getSource())).getScene().getWindow().hide();
//            Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/FXMLAuthentification.fxml"));
            ControllerAthentification c = (ControllerAthentification) fxmlLoader.getController();
            c.roleAuth=role ;
            Stage stage =  new Stage();
            Scene scene = new Scene(frame);
            stage.setScene(scene);
            stage.setTitle("Authentification");
            stage.show();
   }
    
}
