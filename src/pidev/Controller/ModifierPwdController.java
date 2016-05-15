/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pidev.dao.classes.*;



/**
 *
 * @author Rimy Jeljeli
 */
public class ModifierPwdController implements Initializable {

    @FXML
    private TextField logintxt;
    @FXML
    private TextField pwd;
    @FXML
    private TextField pwd2;
    @FXML
    private Button btnValider;
    String type = RetrouverCompteController.type;
    String login = RetrouverCompteController.log;
    DAOOrganisme daoo = new DAOOrganisme();
    DAOFormateur daof=new DAOFormateur();
    DAOApprenant daoa = new DAOApprenant();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logintxt.setText(RetrouverCompteController.log);

    }

    @FXML
    public void btnValiderAction(Event event) throws IOException {
        if(pwd.getText().equals(pwd2.getText()))
        {
        if (type.equals("organisme")) {
             daoo.setPwd(login, pwd.getText());
         
        }
        else if (type.equals("formateur")) {
            
            daof.setPwd(login, pwd.getText());
            
        }
         else if (type.equals("apprenant")) {
            
            daoa.setPwd(login, pwd.getText());
        }
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Success");
alert.setHeaderText("Modification Avec Success !");
alert.setContentText("Redirection Page Acceuille");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    
         ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pidev/gui/FXMLPageAcceuille.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
              p.setStyle("-fx-background-image: url(/pidev/gui/img/moocBack.png ); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
            stage.setTitle("Page Acceuille");
             stage.show();
  } else {
   alert.close();
}
    }
    else 
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Erreur");
alert.setHeaderText("Mot de passe non correcte !");
DropShadow shadow = new DropShadow();
               shadow.setColor(Color.RED);
pwd2.setEffect(shadow);
pwd2.setText("");
alert.showAndWait();
    }
}
    
}
