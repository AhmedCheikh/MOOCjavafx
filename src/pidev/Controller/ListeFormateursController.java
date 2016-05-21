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
import javafx.scene.control.TextField;
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
public class ListeFormateursController implements Initializable {

    @FXML
    private TableView<Formateur> tbvform;
    @FXML
    private TableColumn<Formateur, String> tcNom;
    @FXML
    private TableColumn<Formateur, String> tcCin;
        @FXML
    private TableColumn<Formateur, String> tcMail;
    
    @FXML
        private TableColumn<Formateur, String> tcPrenom;

    @FXML
    private Label lblNomfor;
    @FXML
    private Label lblprenom;
    @FXML
    private Label lblemail;
    
    @FXML
    private Button btnInviter;
  @FXML
    private Button btnChercher;
  @FXML
  private  TextField  txtChercher;
  @FXML
  private  ImageView  imageV;
    @FXML
    private Button btnexit;
   
    @FXML
    private Label lblNomorg;
 

    private Organisme t;
    DAOOrganisme daoO = new DAOOrganisme();
    Organisme o2 = new Organisme();
    @FXML
    private Button Actualiser;
public ObservableList<Formateur> listform;
    public void setO(Organisme o) {
       listform = FXCollections.observableArrayList();
        o2 = daoO.getOrganisme(o.getLogin());
        lblNomorg.setText(o2.getNom());
        System.out.println("-----"+lblNomorg.getText());
        tcNom.setCellValueFactory(new PropertyValueFactory<Formateur, String>("nom"));
        tcPrenom.setCellValueFactory(new PropertyValueFactory<Formateur, String>("prenom"));
        tcCin.setCellValueFactory(new PropertyValueFactory<Formateur, String>("cin"));
        tcMail.setCellValueFactory(new PropertyValueFactory<Formateur, String>("email"));
        DAOOrganisme daoo = new DAOOrganisme();
        listform = daoo.findFormateurs();
        System.out.println("iiiiiiiiiiiiiiiiiii= "+listform.size());
        tbvform.setItems(listform);
        this.t = o;
    }
    
    public ObservableList<Formateur> listform2 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Actualiser.setStyle("-fx-background-image: url('/pidev/gui/img/actualiser.png');-fx-background-position: center center; -fx-background-repeat:stretch;-fx-background-size:30 30; -fx-effect: dropshadow(three-pass-box, #AEEE00, 10, 0.5, 0, 0);");
       btnInviter.setStyle("-fx-background-image: url('/pidev/gui/img/accept.jpg');-fx-background-position: center center; -fx-background-repeat:stretch;-fx-background-size:47 47; -fx-effect: dropshadow(three-pass-box, #AEEE00, 10, 0.5, 0, 0);");
       
    }

    @FXML
    private void btnInviterAction(ActionEvent event) {
        if (!lblNomfor.getText().isEmpty()) {
           java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Invitation invit = new Invitation(lblNomorg.getText(), lblNomfor.getText(), sqlDate, null, null, 0);
            daoO.envoyerInvitation(invit);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Une invitation a été envoyer à" + lblNomfor.getText());
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Pas de formateur selectionner");
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
    private void btntelechargerAction(ActionEvent event) {
             DAOOrganisme dao = new DAOOrganisme();
     Formateur fr = new Formateur();
            fr = dao.AllInfoFormateur(lblNomfor.getText());
            System.out.println("cv="+fr.getCv());
            System.out.println("cin="+fr.getCinFormateur());
            dao.downloadCV(fr);
    }
    @FXML
    private void btnChercherAction(ActionEvent event) {
        if (!txtChercher.getText().isEmpty()) {
            tcNom.setCellValueFactory(new PropertyValueFactory<Formateur, String>("nom"));
            tcPrenom.setCellValueFactory(new PropertyValueFactory<Formateur, String>("prenom"));
  
            DAOOrganisme daoo = new DAOOrganisme();
            listform2 = daoo.chercherFormateurs(txtChercher.getText());
            if (listform2 != null) {
                tbvform.setItems(listform2);
                tbvform.refresh();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText(txtChercher.getText() + " n'existe pas !");
                txtChercher.clear();
                alert.showAndWait();
                tbvform.refresh();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez taper un nom d'un organisme");
            txtChercher.clear();
            alert.showAndWait();
           tbvform.refresh();
        }
    }

    @FXML
    private void clickAction(MouseEvent event) {
        if (event.getClickCount() > 1) {
            lblNomfor.setText(tcNom.getCellData(tbvform.getSelectionModel().getSelectedIndex()));
            System.out.println("on click "+lblNomfor.getText());
            DAOOrganisme daf = new DAOOrganisme();
            Formateur fr = new Formateur();
            fr = daf.AllInfoFormateur(lblNomfor.getText());
            lblNomfor.setText(fr.getNom());
            lblprenom.setText(fr.getPrenom());
            lblemail.setText(fr.getMail());
            System.out.println("avatar="+fr.getAvatar());
           File file = new File("src/pidev/gui/img/"+fr.getAvatar());
        Image image = new Image(file.toURI().toString());
        imageV.setImage(image);
		
        }
    }

    @FXML
    private void ActualiserAction(ActionEvent event) {

        DAOOrganisme d = new DAOOrganisme();
        listform2 = d.findFormateurs();
       tbvform.getItems().remove(listform);
        tbvform.setItems(listform2);

    }

}

