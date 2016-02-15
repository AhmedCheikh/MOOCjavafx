package pidev.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ProfilFormateurController implements Initializable {
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
private String formateur ;
    
   @FXML
    private void  btnexitAction(ActionEvent event) {
        
    }
          @FXML
    private void   btnbackAction(ActionEvent event) {
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setFormateur(String formateur) {
        this.formateur = formateur;
        System.out.println(formateur);
    }

}
