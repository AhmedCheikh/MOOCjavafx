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
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pidev.dao.classes.DAOFormateur;
import pidev.entities.Formateur;

public class ProfilFormateurController implements Initializable {

    @FXML
    private ImageView imgAvatar = new ImageView("/pidev/gui/img/defaut.jpg");
    @FXML
    private Label lblNom;
    @FXML
    private Label lblPrenom;
    @FXML
    private Label lblNominf;
    @FXML
    private Label lblLogininf;
    @FXML
    private Label lblEmailinf;
    @FXML
    private Label lblPrenominf;
    @FXML
    private Label lblCininf;
    private Formateur f;

    DAOFormateur daof = new DAOFormateur();
    Formateur f2 = new Formateur();
    @FXML
    private Hyperlink hpEditerProfil;
    @FXML
    private Button btnDeconnecter;
    @FXML
    private Button btnPublierCour;
    @FXML
    private Button btnLstOrganisme;

    @FXML
    public void btnDeconnecterAction(ActionEvent event) throws IOException {
//        ((Node) (event.getSource())).getScene().getWindow().hide();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("/pidev/gui/FXMLAuthentification.fxml"));
//        loader.load();
//        Parent p = loader.getRoot();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(p));
//        stage.show();

    }

    @FXML
    public void hpEditerProfilAction(ActionEvent event) throws IOException {
        Formateur feditProfil = new Formateur(lblCininf.getText());
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/EditProfilFormateur.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        EditProfilFormateurController epfc = loader.getController();
        epfc.setF(feditProfil);
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }

    @FXML
    public void btnPublierCourAction(ActionEvent event) throws IOException {
        Formateur fpubc = new Formateur(lblCininf.getText());
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/PublierCour.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        PublierCourController pc = loader.getController();
        pc.setfrm(fpubc);
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
                  
                   
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public void setF(Formateur f) {
        lblCininf.setText(f.getCinFormateur());
        f2 = daof.getFormateurByCIN(f.getCinFormateur());
        lblNom.setText(f2.getNom());
        lblPrenom.setText(f2.getPrenom());
        lblNominf.setText(f2.getNom());
        lblLogininf.setText(f2.getLogin());
        lblEmailinf.setText(f2.getMail());
        lblPrenominf.setText(f2.getPrenom());
        //Image img = new Image("C:\\Users\\akoubi\\Downloads\\smart.png");
        //imgAvatar.setImage(img);
//      lblPrenominf.setText(f2.getAvatar().getAbsolutePath());
        this.f = f;

    }

    @FXML
    private void btnLstOrganismeAction(ActionEvent event) throws IOException {
        Formateur fpubc = new Formateur(lblCininf.getText());
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ListeOrganisme.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        ListeOrganismeController pc = loader.getController();
        //pc.setfrm(fpubc);
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }

}
