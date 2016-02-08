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
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ControllerAffichageCours implements Initializable {
    @FXML
    private void OnClick(ActionEvent event)
    {
        Stage window =new Stage() ;
        AnchorPane layout= new AnchorPane();
        Scene scene= new Scene(layout);
        window.setScene(scene);
        window.show();
    }
    
 @FXML
     private void btnRecherche(ActionEvent event)  {
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
