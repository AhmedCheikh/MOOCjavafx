/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class EditerCoursController implements Initializable {

     @FXML
    private Button btnChapitre;
    @FXML
    private Button btnQuiz;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       DropShadow shadow = new DropShadow();
//Adding the shadow when the mouse cursor is on
        btnexit.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        shadow.setColor(Color.RED);
                        btnexit.setEffect(shadow);
                    }
                });
//Removing the shadow when the mouse cursor is off
        btnexit.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        
                        btnexit.setEffect(null);
                    }
                });
    }    
    
    @FXML
    private void btnexitAction(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Warning");
alert.setHeaderText("Your are leaving application !");
alert.setContentText("Are you sure to leave?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    
      ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/FXMLAuthentification.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        stage.setTitle("Authentification");
        
        stage.show();
    
} else {
   alert.close();
}
        
    }
    
    @FXML
    private void btnbackAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ProfilFormateur.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        stage.setTitle("Profil Formateur");
//        ProfilApprenantController pac  = loader.getController();
//        pac.setApprenant(apprenant);
        stage.show();
    }
    
    @FXML
    private void btnChapitreAction(ActionEvent event) throws IOException
    {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/AjouterChapitre.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        stage.setTitle("Ajouter Chapitre");
        stage.show();
    }
    
    @FXML
    public void btnQuizAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/AjouterQuiz.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.setTitle("Ajouter Quiz");

        stage.show();

    }
    
}
