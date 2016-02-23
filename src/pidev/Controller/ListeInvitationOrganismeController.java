/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pidev.dao.classes.DAOFormateur;
import pidev.entities.Formateur;
import pidev.entities.Invitation;
import pidev.entities.Organisme;

/**
 *
 * @author akoubi
 */
public class ListeInvitationOrganismeController implements Initializable {

    @FXML
    private TableView<Invitation> tbvInvit;
    @FXML
    private TableColumn<Invitation, String> tcNomExp;
    @FXML
    private TableColumn<Invitation, String> tcNomDes;
    @FXML
    private TableColumn<Invitation, String> tcDateInvit;
    @FXML
    private TableColumn<Invitation, Integer> tcEtat;
    @FXML
    private Label lblNomorg;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblSiteweb;
    @FXML
    private Label lblAdresse;
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
    private Label lblNomfrm;
    @FXML
    private Label lblcinfrm;

    private Formateur fedit;
    DAOFormateur daof = new DAOFormateur();
    Formateur f2 = new Formateur();
    @FXML
    private Button Actualiser;

    public void setF(Formateur f) {
        lblcinfrm.setText(f.getCinFormateur());
        f2 = daof.getFormateurByCIN(f.getCinFormateur());
        lblNomfrm.setText(f2.getNom());

        tcNomExp.setCellValueFactory(new PropertyValueFactory<Invitation, String>("nom_exp"));
        tcNomDes.setCellValueFactory(new PropertyValueFactory<Invitation, String>("nom_des"));
        tcDateInvit.setCellValueFactory(new PropertyValueFactory<Invitation, String>("date_invit"));
        tcEtat.setCellValueFactory(new PropertyValueFactory<Invitation, Integer>("etat"));
        DAOFormateur daof = new DAOFormateur();
        listInvit = daof.FindInvitationByNom(lblcinfrm.getText());
        tbvInvit.setItems(listInvit);
        this.fedit = f;
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
        if (!lblNomorg.getText().isEmpty()) {
            daof.AccepterOrganisme(lblNomorg.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Vous etes Formateur maintenant chez " + lblNomorg.getText());
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
        if (!lblNomorg.getText().isEmpty()) {
            daof.RefuserOrganisme(lblNomorg.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Vous avez refuser une invitation de la pard de " + lblNomorg.getText());
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
        Formateur f = new Formateur(lblcinfrm.getText());
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ProfilFormateur.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        ProfilFormateurController pfc = loader.getController();
        pfc.setF(f);
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }

    @FXML
    private void clickAction(MouseEvent event) {
        if (event.getClickCount() > 1) {
            lblNomorg.setText(tcNomExp.getCellData(tbvInvit.getSelectionModel().getSelectedIndex()));
            DAOFormateur da = new DAOFormateur();
            Organisme og = new Organisme();
            og = da.AllInfoOrganisme(lblNomorg.getText());
            lblEmail.setText(og.getEmail());
            lblSiteweb.setText(og.getSiteweb());
            lblAdresse.setText(og.getAdresse());
            lblTelephone.setText(og.getTelephone());
            txtDescription.setText(og.getDescription());
        }
    }

    @FXML
    private void ActualiserAction(ActionEvent event) {
//        tcNomExp.setCellValueFactory(new PropertyValueFactory<Invitation, String>("nom_exp"));
//        tcNomDes.setCellValueFactory(new PropertyValueFactory<Invitation, String>("nom_des"));
//        tcDateInvit.setCellValueFactory(new PropertyValueFactory<Invitation, String>("date_invit"));
//        tcEtat.setCellValueFactory(new PropertyValueFactory<Invitation, Integer>("etat"));
        DAOFormateur d = new DAOFormateur();
        listInvit2 = d.FindInvitationByNom(lblcinfrm.getText());
        tbvInvit.getItems().remove(listInvit);
        tbvInvit.setItems(listInvit2);

    }

}
