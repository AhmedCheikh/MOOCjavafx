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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pidev.dao.classes.DAOFormateur;
import pidev.entities.Formateur;
import pidev.entities.Invitation;
import pidev.entities.Organisme;

/**
 * FXML Controller class
 *
 * @author akoubi
 */
public class ListeOrganismeController implements Initializable {

    @FXML
    private TableView<Organisme> tbvOrganisme;
    @FXML
    private TableColumn<Organisme, String> tcNomOrg;
    @FXML
    private TableColumn<Organisme, String> tcEmail;
    @FXML
    private TableColumn<Organisme, String> tcAdresse;
    @FXML
    private TableColumn<Organisme, String> tctelephone;

    @FXML
    private TextField txtChercher;
    @FXML
    private Button btnChercher;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    @FXML
    private Label lblcin;
    @FXML
    private Label lblCinFrm;

    private Formateur frm;
    DAOFormateur daof = new DAOFormateur();
    Formateur f2 = new Formateur();
    public String nomFm;
    public String prenomFm;
    public String cin;
    @FXML
    private Label lblNomFrm;

    public void setFrm(Formateur frm) {
        lblCinFrm.setText(frm.getCinFormateur());
        cin = frm.getCinFormateur();
        f2 = daof.getFormateurByCIN(frm.getCinFormateur());
        nomFm = f2.getNom();
        lblNomFrm.setText(nomFm);
        prenomFm = f2.getPrenom();
        this.frm = frm;
    }

    public ObservableList<Organisme> listOrg = FXCollections.observableArrayList();
    public ObservableList<Organisme> listOrg2 = FXCollections.observableArrayList();
    @FXML
    private Button Actualiser;
    @FXML
    private Button btnInviter;
    @FXML
    private TextField txtInviter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Actualiser.setStyle("-fx-background-image: url('/pidev/gui/img/actualiser.png');-fx-background-position: center center; -fx-background-repeat:stretch;-fx-background-size:30 30; -fx-effect: dropshadow(three-pass-box, #AEEE00, 10, 0.5, 0, 0);");
        tcNomOrg.setCellValueFactory(new PropertyValueFactory<Organisme, String>("Nom"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<Organisme, String>("Email"));
        tcAdresse.setCellValueFactory(new PropertyValueFactory<Organisme, String>("Adresse"));
        tctelephone.setCellValueFactory(new PropertyValueFactory<Organisme, String>("telephone"));
        DAOFormateur daof = new DAOFormateur();
        listOrg = daof.ListeOrganisme();
        tbvOrganisme.setItems(listOrg);
    }

    @FXML
    private void btnChercherAction(ActionEvent event) {
        if (!txtChercher.getText().isEmpty()) {
            tcNomOrg.setCellValueFactory(new PropertyValueFactory<Organisme, String>("Nom"));
            tcEmail.setCellValueFactory(new PropertyValueFactory<Organisme, String>("Email"));
            tcAdresse.setCellValueFactory(new PropertyValueFactory<Organisme, String>("Adresse"));
            tctelephone.setCellValueFactory(new PropertyValueFactory<Organisme, String>("telephone"));
            //tctelephone.setText("zied");
            DAOFormateur daof = new DAOFormateur();
            listOrg2 = daof.FindOrganismeByName(txtChercher.getText());
            if (listOrg2 != null) {
                tbvOrganisme.setItems(listOrg2);
                tbvOrganisme.refresh();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText(txtChercher.getText() + " n'existe pas !");
                txtChercher.clear();
                alert.showAndWait();
                tbvOrganisme.refresh();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez taper un nom d'un organisme");
            txtChercher.clear();
            alert.showAndWait();
            tbvOrganisme.refresh();
        }
    }

    @FXML
    private void btnexitAction(ActionEvent event) {
        Stage stage = (Stage) btnexit.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void btnbackAction(ActionEvent event) throws IOException {
        Formateur f = new Formateur(lblCinFrm.getText());
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
    private void ActualiserAction(ActionEvent event) {
        tbvOrganisme.getItems().removeAll(listOrg2);
        tbvOrganisme.setItems(listOrg);
    }

    @FXML
    private void ClickAction(MouseEvent event) {
        if (event.getClickCount() > 1) {
            txtInviter.setText(tcNomOrg.getCellData(tbvOrganisme.getSelectionModel().getSelectedIndex()));
        }
    }

    @FXML
    private void btnInviterAction(ActionEvent event) {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Invitation invit = new Invitation(lblCinFrm.getText(), txtInviter.getText(), sqlDate, null, null, 0);
        daof.DemmandeIntegration(invit);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Demmande Integration");
        alert.setHeaderText(null);
        alert.setContentText("votre invitation a été envoyer a " + txtInviter.getText() + "");
        alert.showAndWait();
    }

}
