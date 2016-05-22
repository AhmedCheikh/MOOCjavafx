/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pidev.dao.classes.DAOFormateur;
import pidev.dao.classes.DAOOrganisme;
import pidev.entities.Formateur;
import pidev.entities.Invitation;
import pidev.entities.Organisme;

/**
 *
 * @author Rimy Jeljeli
 */
public class listeInvitationFormateursController implements Initializable {

    @FXML
    private TableView<Invitation> tbvInvit;
    @FXML
    private TableColumn<Invitation, String> tcNomExp;
    //@FXML
    //private TableColumn<Invitation, String> tcNomDes;
    @FXML
    private TableColumn<Invitation, String> tcDateInvit;
  //  @FXML
   // private TableColumn<Invitation, Integer> tcEtat;
    @FXML
    private Label lblNomfor;
    @FXML
    private Label lblprenom;
    @FXML
    private Label lblemail;
    
    @FXML
    private Button brnAccepter;
    @FXML
    private Button brnRefuser;
    @FXML
    private TextArea txtDescription;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    @FXML
    private Label lblTelephone;
    @FXML
    private Label lblNomorg;
       @FXML
    private Label cin;
 
 @FXML
  private  ImageView  imageV;
    private Organisme t;
    DAOOrganisme daoO = new DAOOrganisme();
    Organisme o2 = new Organisme();
    @FXML
    private Button Actualiser;

    public void setO(Organisme o) {
       
        lblNomorg.setText(o.getLogin());
        System.out.println("nom organisme="+o.getLogin());
        tcNomExp.setCellValueFactory(new PropertyValueFactory<Invitation, String>("nom_exp"));
        //tcNomDes.setCellValueFactory(new PropertyValueFactory<Invitation, String>("nom_des"));
        tcDateInvit.setCellValueFactory(new PropertyValueFactory<Invitation, String>("date_invit"));
        //tcEtat.setCellValueFactory(new PropertyValueFactory<Invitation, Integer>("etat"));
        DAOOrganisme daoo = new DAOOrganisme();
        listInvit = daoo.FindInvitationByNom(o.getLogin());
        System.out.println("size="+listInvit.size());
        tbvInvit.setItems(listInvit);
        this.t = o;
    }
    public ObservableList<Invitation> listInvit = FXCollections.observableArrayList();
    public ObservableList<Invitation> listInvit2 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Actualiser.setStyle("-fx-background-image: url('/pidev/gui/img/actualiser.png');-fx-background-position: center center; -fx-background-repeat:stretch;-fx-background-size:30 30; -fx-effect: dropshadow(three-pass-box, #AEEE00, 10, 0.5, 0, 0);");
        brnAccepter.setStyle("-fx-background-image: url('/pidev/gui/img/accept.jpg');-fx-background-position: center center; -fx-background-repeat:stretch;-fx-background-size:47 47; -fx-effect: dropshadow(three-pass-box, #AEEE00, 10, 0.5, 0, 0);");
        brnRefuser.setStyle("-fx-background-image: url('/pidev/gui/img/refuse.png');-fx-background-position: center center; -fx-background-repeat:stretch;-fx-background-size:50 50; -fx-effect: dropshadow(three-pass-box, red, 10, 0.5, 0, 0);");
        //tbvInvit.refresh();
    }

    @FXML
    private void brnAccepterAction(ActionEvent event) {
        if (!lblNomfor.getText().isEmpty()) {
           
            System.out.println("cin formateur="+cin.getText());
            DAOOrganisme daoo=new DAOOrganisme();
            Organisme o1=daoo.getOrganisme(lblNomorg.getText());
            System.out.println("id organisme="+o1.getId());
            daoO.AccepterInvit(cin.getText(),o1.getId());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("" + lblNomfor.getText()+" est maintenant l'un de vos formateurs");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Pas dinvitation selectionner");
            alert.showAndWait();
        }

    }

    @FXML
    private void brnRefuserAction(ActionEvent event) {
        if (!lblNomfor.getText().isEmpty()) {
            daoO.refuserInvitation(cin.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Vous avez refuser une invitation de la pard de " + lblNomfor.getText());
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Pas dinvitation selectionner");
            alert.showAndWait();
        }

    }

    @FXML
    private void btnexitAction(ActionEvent event) {
        Stage stage = (Stage) btnexit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnbackAction(ActionEvent event) throws IOException {
        Organisme o = new Organisme(lblNomorg.getText());
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

    @FXML
    private void clickAction(MouseEvent event) {
        if (event.getClickCount() > 1) {
            lblNomfor.setText(tcNomExp.getCellData(tbvInvit.getSelectionModel().getSelectedIndex()));
            DAOOrganisme daO = new DAOOrganisme();
            Formateur fr = new Formateur();
            fr = daO.AllInfoFormateur(lblNomfor.getText());
            lblNomfor.setText(fr.getNom());
            lblprenom.setText(fr.getPrenom());
            lblemail.setText(fr.getMail());
            cin.setText(fr.getCinFormateur());
            System.out.println("cin formateur ="+fr.getCinFormateur());
            
               System.out.println("avatar="+fr.getAvatar());
           File file = new File("src/pidev/gui/img/"+fr.getAvatar());
        Image image = new Image(file.toURI().toString());
        imageV.setImage(image);
           
        }
    }
 @FXML
   private void btntelechargerAction(ActionEvent event) {
             DAOOrganisme dao = new DAOOrganisme();
     Formateur fr = new Formateur();
            fr = dao.AllInfoFormateur(lblNomfor.getText());
            System.out.println("cv="+fr.getCv());
            System.out.println("cin="+fr.getCinFormateur());
            dao.downloadCV(fr);
    }
    @FXML
    private void ActualiserAction(ActionEvent event) {
//        tcNomExp.setCellValueFactory(new PropertyValueFactory<Invitation, String>("nom_exp"));
//        tcNomDes.setCellValueFactory(new PropertyValueFactory<Invitation, String>("nom_des"));
//        tcDateInvit.setCellValueFactory(new PropertyValueFactory<Invitation, String>("date_invit"));
//        tcEtat.setCellValueFactory(new PropertyValueFactory<Invitation, Integer>("etat"));
        DAOOrganisme d = new DAOOrganisme();
        listInvit2 = d.FindInvitationByNom(lblNomorg.getText());
        tbvInvit.getItems().remove(listInvit);
        tbvInvit.setItems(listInvit2);

    }

}

