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
import javafx.stage.Stage;
import pidev.dao.classes.DAOFormateur;
import pidev.dao.classes.DAOOrganisme;
import pidev.entities.Organisme;

/**
 *
 * @author Rimy Jeljeli
 */
public class ListeConcurrentsController implements Initializable {

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
    private Label lblNomOrg;

       Organisme t;
    DAOOrganisme daoO = new DAOOrganisme();
   public Organisme o2 = new Organisme();


        public void setO(Organisme o) {
        this.t = o;
        //o2 = daoO.getOrganisme(o.getLogin());
            System.out.println("******"+o.getNom());
            System.out.println("******"+o.getLogin());
        lblNomOrg.setText(o.getNom());
        o.toString();
        System.out.println("-----"+lblNomOrg.getText());
         DAOOrganisme daoo = new DAOOrganisme();
         //DAOOrganisme daoo = new DAOOrganisme();
     
        System.out.println("id="+o.getId());
         listOrg = daoo.ListeOrganisme(o.getId());
        Actualiser.setStyle("-fx-background-image: url('/pidev/gui/img/actualiser.png');-fx-background-position: center center; -fx-background-repeat:stretch;-fx-background-size:30 30; -fx-effect: dropshadow(three-pass-box, #AEEE00, 10, 0.5, 0, 0);");
        tcNomOrg.setCellValueFactory(new PropertyValueFactory<Organisme, String>("nom"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<Organisme, String>("email"));
        tcAdresse.setCellValueFactory(new PropertyValueFactory<Organisme, String>("adresse"));
        tctelephone.setCellValueFactory(new PropertyValueFactory<Organisme, String>("telephone"));
      
       
       
        tbvOrganisme.setItems(listOrg);
        
        
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
          
    }

    @FXML
    private void btnChercherAction(ActionEvent event) {
        if (!txtChercher.getText().isEmpty()) {
            tcNomOrg.setCellValueFactory(new PropertyValueFactory<Organisme, String>("nom"));
            tcEmail.setCellValueFactory(new PropertyValueFactory<Organisme, String>("email"));
            tcAdresse.setCellValueFactory(new PropertyValueFactory<Organisme, String>("adresse"));
            tctelephone.setCellValueFactory(new PropertyValueFactory<Organisme, String>("telephone"));
            DAOOrganisme daoo = new DAOOrganisme();
            listOrg2 = daoo.chercherOrganisme(txtChercher.getText());
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
        Organisme o = new Organisme(lblNomOrg.getText());
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
    private void ActualiserAction(ActionEvent event) {
        tbvOrganisme.getItems().removeAll(listOrg2);
        tbvOrganisme.setItems(listOrg);
    }

    

    
}
