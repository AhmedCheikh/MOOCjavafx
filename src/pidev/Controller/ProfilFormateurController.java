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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pidev.dao.classes.DAOFormateur;
import pidev.entities.Formateur;

public class ProfilFormateurController implements Initializable {

//    = new ImageView("/pidev/gui/img/defaut.jpg");
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
    @FXML
    private Label lblnbrInvit;

    private Formateur f;

    DAOFormateur daof = new DAOFormateur();
 public static   Formateur f2 ;
    @FXML
    private Pane idpaneimg;
    @FXML
    private Hyperlink hpEditerProfil;
    @FXML
    private Button btnDeconnecter;
    @FXML
    private ImageView imgAvatar;
    @FXML
    private ImageView imgv;
    @FXML
    private Button btnPublierCour;
    @FXML
    private Button btnLstOrganisme;
    @FXML
    private Button btnMesinvitation;

    @FXML
    public void btnDeconnecterAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/FXMLAuthentification.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();

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
    public static String c;

    public void setF(Formateur f) {
        lblCininf.setText(f.getCinFormateur());
        f2 = daof.getFormateurByCIN(f.getCinFormateur());
        c=f2.getCinFormateur();
        lblNom.setText(f2.getNom());
        lblPrenom.setText(f2.getPrenom());
        lblNominf.setText(f2.getNom());
        lblLogininf.setText(f2.getLogin());
        lblEmailinf.setText(f2.getMail());
        lblPrenominf.setText(f2.getPrenom());
        String width = "150";
        String height = "150";
        // idpaneimg.setStyle("-fx-background-image:url(/pidev/avatar/"+f2.getAvatar()+")");
        idpaneimg.setStyle("-fx-background-image:url(/pidev/avatar/" + f2.getAvatar() + ");-fx-background-position: center center; -fx-background-repeat:stretch;-fx-background-size:" + width + " " + height + "; -fx-effect: dropshadow(three-pass-box, #FFDA8C, 30, 0.5, 0, 0);");
        //Image img = new Image("C:\\Users\\akoubi\\Downloads\\smart.png");
        //imgAvatar.setImage(img);
        //lblPrenominf.setText(f2.getAvatar().getAbsolutePath());
        int nbrinvit;
        nbrinvit = daof.nbrInvit(f.getCinFormateur());
        lblnbrInvit.setText(nbrinvit + "");
        this.f = f;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void btnLstOrganismeAction(ActionEvent event) throws IOException {
        Formateur flstOrg = new Formateur(lblCininf.getText());
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ListeOrganisme.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        ListeOrganismeController lstOrg = loader.getController();
        lstOrg.setFrm(flstOrg);
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }

    @FXML
    private void btnMesinvitation(ActionEvent event) throws IOException {
        Formateur fi = new Formateur(lblCininf.getText());
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ListeInvitationOrganisme.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        ListeInvitationOrganismeController lstinvitOrg = loader.getController();
        lstinvitOrg.setF(fi);
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }
    @FXML
    private void btncoursAction(ActionEvent event) throws IOException {
         ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(getClass().getResource("/pidev/gui/AfficheListCoursSuivis.fxml"));
        loader.setLocation(getClass().getResource("/pidev/gui/AfficherCoursEtChapitreFormateur.fxml")); 
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        AfficherCoursEtChapitreFormController ACCA  = loader.getController();
        System.out.println(f.getNom());
        ACCA.setFormateur(f);
        stage.setTitle("List Cours Publiers");
        stage.show();
    }
@FXML
    private void btnDemmandeIntegrationAction(ActionEvent event) throws IOException {
       Formateur flstOrg = new Formateur(lblCininf.getText());
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ListeOrganisme.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        ListeOrganismeController lstOrg = loader.getController();
        lstOrg.setFrm(flstOrg);
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }
}
