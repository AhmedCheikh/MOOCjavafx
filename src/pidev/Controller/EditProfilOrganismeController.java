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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pidev.dao.classes.DAOOrganisme;
import pidev.entities.Apprenant;
import pidev.entities.Organisme;

/**
 *
 * @author Rimy Jeljeli
 */
public class EditProfilOrganismeController implements Initializable {

    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    private Label l5;
    @FXML
    private Label l6;
    @FXML
    private Label l7;
    @FXML
    private Label l8;
    @FXML
    private Label l9;
    @FXML
    private Label l10;

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
    private PasswordField txtPassword2;
    @FXML
    private TextField txtTel;
    @FXML
    private TextField txtSite;
    @FXML
    private TextArea txtDesc;
    @FXML
    private Label login;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnAnnuller;
    @FXML
    private Button btnChoisirImg;
    ControllerAthentification ca = new ControllerAthentification();
    private Organisme o;
    DAOOrganisme daoO = new DAOOrganisme();
    Organisme o1;
Organisme o2;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        o1 = daoO.getOrganisme(ca.log);

        txtNom.setText(o1.getNom());
        txtAdresse.setText(o1.getAdresse());
        txtEmail.setText(o1.getEmail());
        txtLogin.setText(o1.getLogin());
       txtPassword.setText(o1.getPassword());
        txtTel.setText(o1.getTelephone());
        txtSite.setText(o1.getSiteweb());
        txtDesc.setText(o1.getDescription());
    }

    @FXML
    public void btnModifierAction(Event event) throws IOException {
              o2=new Organisme(txtNom.getText(),txtLogin.getText(), txtPassword.getText(), txtEmail.getText(),txtSite.getText(), txtAdresse.getText(),txtTel.getText(),txtDesc.getText());

        daoO.updateOrganisme(o2);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modification profile");
        alert.setHeaderText(null);
        alert.setContentText("Votre Profile à été modifier avec succès");
        alert.showAndWait();
        ((Node) (event.getSource())).getScene().getWindow().hide();
                Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ProfileOrganismeA.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
                stage.setScene(scene);
                stage.setTitle("Profile Organisme");
                stage.show(); 
    }
}
