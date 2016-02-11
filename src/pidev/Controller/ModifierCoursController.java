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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class ModifierCoursController {
    @FXML
    private TextField txttitre ;
    @FXML
    private TextArea textDescription;
    
    @FXML
private Label titre;
    @FXML
    private Label Description ;
    @FXML
private Label Difficulte ;
    
@FXML
    public void btnexitAction(ActionEvent event)
    {
        
    }
  
    @FXML
    public void btnValiderAction(ActionEvent event)
    {
        String t= txttitre.getText() ;
        if (t.isEmpty() )
        {
            
            titre.setText("da5el valeur ya bhim");
        }
        else
        {
           
            showAlert();
        } 
        
    }
    
    public  void showAlert() {
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Modification Reussite");
        alert.setContentText("vous avez modifier le cours avec succes");
        alert.showAndWait();
    }
     @FXML
    public void btnbackAction(ActionEvent event)
    {
        
    }
     @FXML
    public void btnAnullerAction(ActionEvent event)
    {
        
    }
    
    
}
