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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class EditProfilOrganismeController implements Initializable {
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnAnuller;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtAdresse;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtRepaet;
    @FXML
    private Label er21;
    @FXML
    private Label er31;
    @FXML
    private Label er61;
    @FXML
    private Label er71;
    @FXML
    private Label er81;
    @FXML
    private Label er92;
    @FXML
    private Label er91;
    @FXML
    private TextField txtTel;
    @FXML
    private TextField txtSite;
    @FXML
    private Label er911;
    @FXML
    private Label er9113;
    @FXML
    private Label er9112;
    @FXML
    private Label er9111;
    @FXML
    private Button btnDeconnecter;
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
    private void btnModifierAction(ActionEvent event) {
        if (txtNom.getText().isEmpty())
        {
            er21.setVisible(true);
             DropShadow shadow = new DropShadow();
               shadow.setColor(Color.RED);
txtNom.setEffect(shadow);
        }
        if (txtAdresse.getText().isEmpty())
        {
            er31.setVisible(true);
             DropShadow shadow = new DropShadow();
               shadow.setColor(Color.RED);
txtAdresse.setEffect(shadow);
        }
        if (txtEmail.getText().isEmpty())
        {
            er61.setVisible(true);
             DropShadow shadow = new DropShadow();
               shadow.setColor(Color.RED);
txtEmail.setEffect(shadow);
        }
        if (txtLogin.getText().isEmpty())
        {
            er71.setVisible(true);
             DropShadow shadow = new DropShadow();
               shadow.setColor(Color.RED);
txtLogin.setEffect(shadow);
        }
        if (txtPassword.getText().isEmpty())
        {
            er81.setVisible(true);
             DropShadow shadow = new DropShadow();
               shadow.setColor(Color.RED);
txtPassword.setEffect(shadow);
        }
        if (txtRepaet.getText().isEmpty() || !(txtPassword.getText().equals(txtRepaet.getText())))
        {
            er92.setVisible(true);
             DropShadow shadow = new DropShadow();
               shadow.setColor(Color.RED);
txtRepaet.setEffect(shadow);
        }
        
    }

    @FXML
    private void btnAnullerAction(ActionEvent event) {
    }

    @FXML
    private void btnDeconnecterAction(ActionEvent event) throws IOException {
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
        loader.setLocation(getClass().getResource("/pidev/gui/ProfilOrganismeA.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        stage.setTitle("Profil Apprenant");
        
        stage.show();
    }
    
}
