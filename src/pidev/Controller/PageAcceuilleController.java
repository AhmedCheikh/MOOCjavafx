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
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class PageAcceuilleController  implements  Initializable{
    public String v;
@FXML
private ComboBox role ;
    private Object fxmlLoader;
    @FXML
    private ComboBox role1 ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       role.getItems().addAll(
    "administrateur",
    "apprenant",
    "formateur",
    "organisme"           
);
       role1.getItems().addAll(
    
    "apprenant",
    "formateur",
    "organisme"           
);
    }

   public void btnAuthentifAction(Event event){
       role.setDisable(false);
       role.setVisible(true);
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
    public void btnInscriAction(Event event){
       role1.setDisable(false);
       role1.setVisible(true);
   }
    public void click1Action(Event event) throws IOException{
          if(role1.getValue().toString().equals("apprenant"))
          {
              ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pidev/gui/InscriptionApprenant.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setTitle("Inscrire Apprenant");
             stage.show();
          }
          else if(role1.getValue().toString().equals("formateur"))
          {
              ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pidev/gui/InscrireFormateur.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setTitle("Inscrire Formateur");
             stage.show();
          }
          else if(role1.getValue().toString().equals("organisme"))
          {
              ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pidev/gui/InscrireOrganisme.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setTitle("Inscrire Formateur");
             stage.show();
          }
    }
}
