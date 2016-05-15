/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static pidev.Controller.PreInscrireOrganismeController.document;
import pidev.dao.classes.DAOOrganisme;
import pidev.entities.Apprenant;
import pidev.entities.Organisme;

/**
 *
 * @author Rimy Jeljeli
 */
public class EditProfilOrganismeController implements Initializable {
   @FXML
    public String logo;
    @FXML
   public void setLogo(String logo) {
        this.logo = logo;
    }
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
    private Label lblogo;
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
        System.out.println("------------------"+ca.log);
        o1 = daoO.getOrganisme(ca.log);
        System.out.println("          "+o1.getDescription());
        txtNom.setText(o1.getNom());
        txtAdresse.setText(o1.getAdresse());
        txtEmail.setText(o1.getEmail());
        txtLogin.setText(o1.getLogin());
       txtPassword.setText(o1.getPassword());
        txtPassword2.setText(o1.getPassword());
        txtTel.setText(o1.getTelephone());
        txtSite.setText(o1.getSiteweb());
 txtDesc.setText(o1.getDescription());
 lblogo.setText(o1.getLogo());
    }
@FXML
    public void btnAnnulerAction(Event event) throws IOException {
   txtNom.setText("");
    txtAdresse.setText("");
   txtEmail.setText("");
     txtLogin.setText("");
    txtPassword.setText("");
    txtPassword2.setText("");
    txtTel.setText("");
    txtSite.setText("");
   txtDesc.setText("");
   lblogo.setText("");
    
    }
    @FXML
    public void btnModifierAction(Event event) throws IOException {
            //Organisme  o5=new Organisme(txtNom.getText(),txtLogin.getText(), txtPassword.getText(), txtEmail.getText(),txtSite.getText(), txtAdresse.getText(),txtTel.getText(),txtDesc.getText(),logo);
        Organisme  o5=new Organisme(txtNom.getText(),txtLogin.getText(), txtPassword.getText(), txtEmail.getText(),txtSite.getText(), txtAdresse.getText(),txtTel.getText(),txtDesc.getText(),logo);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa :"+o5.getNom());
        DAOOrganisme d1 = new DAOOrganisme();
      
        d1.updateOrganisme(o5,o1.getLogin());
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
  public void btnChoisireAction() throws IOException {
        
        FileChooser fileChooser = new FileChooser();

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            fileChooser.setTitle("Open resource file");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.pdf"));
            Organisme o = new Organisme();
            if (selectedFile != null) {
                File path = selectedFile.getAbsoluteFile();
                logo=selectedFile.getName();
                lblogo.setText("File selected: " + selectedFile.getName());
              String url = "src/pidev/gui/img/"+ selectedFile.getName();
                Path des = Paths.get(url);
                Path source = Paths.get(selectedFile.getAbsolutePath());
                Files.copy(source , des);
            }
            else {

   lblogo.setText("File selection cancelled.");

}

        }

    }
@FXML
    private void btnexitAction(ActionEvent event) {
        Stage stage = (Stage) btnexit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnbackAction(ActionEvent event) throws IOException {
        Organisme o = new Organisme(txtLogin.getText());
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ProfileOrganismeA.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        ProfileOrganismeAController poac = loader.getController();
        poac.setO(o);
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }
}
