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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import pidev.dao.classes.DAOOrganisme;
import pidev.entities.Organisme;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class ProfileOrganismeAController implements Initializable {
   @FXML
    private Label login;
    @FXML
    private Label nom;
  @FXML
    private TextArea desc;
  @FXML
    private Label adresse;
 @FXML
    private Label tel;
  @FXML
    private Label site;

  
private  Organisme o;
    
    DAOOrganisme daoO = new DAOOrganisme();
    Organisme o1 = new Organisme();

public void btnDeconnecterAction(ActionEvent event) throws IOException{
                ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/pidev/gui/FXMLAuthentification.fxml"));
                loader.load();                
                Parent p = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
    }
public void btnListeFormateurAction(ActionEvent event) throws IOException{
                ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/pidev/gui/ListeFormateurs.fxml"));
                loader.load();                
                Parent p = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
    }

public void btnListeFormateur1organismeAction(ActionEvent event) throws IOException{
                ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/pidev/gui/ListeFormateur1Organisme.fxml"));
                loader.load();                
                Parent p = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
    }
@FXML
public  void btnModifierAction(ActionEvent event) throws IOException{
     ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/pidev/gui/EditProfilOrganisme.fxml"));
                loader.load();                
                Parent p = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
} 
    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
   ControllerAthentification ca=new ControllerAthentification();
        o1 = daoO.getOrganisme(ca.log);
        
        nom.setText(o1.getLogin());
        desc.setText(o1.getDescription());
        adresse.setText(o1.getAdresse());
        tel.setText(o1.getTelephone());
        site.setText(o1.getSiteweb());
    }    
    
    
    

}
