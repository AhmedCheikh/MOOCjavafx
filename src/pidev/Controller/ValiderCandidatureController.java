/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import pidev.dao.classes.DAOComite;
import pidev.dao.interfaces.IDAOComite;
import pidev.entities.Formateur;
import pidev.techniques.DataSource;

/**
 * FXML Controller class
 *
 * @author WiKi
 */
public class ValiderCandidatureController implements Initializable {
    Connection connection ; 
    private ObservableList<Formateur> data ; 
    @FXML
    private Button btnback;
    @FXML
    private Button btnexit;
    @FXML
    private Button approuver;
    @FXML
    private TableView<Formateur> table ; 
    @FXML
    private TableColumn Nom;
    @FXML
    private TableColumn Prenom;
    @FXML
    private TableColumn Email;
    @FXML
    private TableColumn Adresse;
    @FXML private Label labelNom, labelPrenom, labelEmail, labelAdresse, labelMsg ; 
    
    
    

    /**
     * Initializes the controller class.
     */
     public ValiderCandidatureController() {
        connection =(DataSource.getInstance()).getConnection();
    }
     
     private void showFormateurDetails(Formateur formateur) {
        labelNom.setText(formateur.getNom());
        labelPrenom.setText(formateur.getPrenom());
        labelEmail.setText(formateur.getMail());
//      labelAdresse.setText(formateur.getAdresse());
        
        }
     
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String requete = "select * from formateur where etat=0";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            data = FXCollections.observableArrayList();
             while (rs.next()) {
                data.add(new Formateur(rs.getString("cin"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), null, null, null, null, rs.getInt("etat"))) ; 
            }
        
        Nom.setCellValueFactory(new PropertyValueFactory("nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory("prenom"));
//        Email.setCellValueFactory(new PropertyValueFactory("mail"));
//        Adresse.setCellValueFactory(new PropertyValueFactory("adresse"));
        
        table.setItems(data);
        
        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Formateur>() {

        @Override
        public void changed(ObservableValue<? extends Formateur> observable, Formateur oldValue, Formateur newValue) {
        showFormateurDetails(newValue);
        approuver.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               IDAOComite comiteDAO = new DAOComite();
               comiteDAO.validerCandidature(newValue); 
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Validation");
        alert.setHeaderText(null);
        alert.setContentText("Validation de la candidature effectuée avec succès!");

        alert.showAndWait();
               
            }
        });
                }
            
        }) ;
        
          
        } catch (SQLException ex) {
            Logger.getLogger(ValiderCandidatureController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }    

    @FXML
    private void btnbackAction(ActionEvent event) {
          
    }

    @FXML
    private void btnexitAction(ActionEvent event) {
    }
    
//    @FXML
//    private void approuverAction(ActionEvent event) {
//        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Formateur>() {
//
//        @Override
//        public void changed(ObservableValue<? extends Formateur> observable, Formateur oldValue, Formateur newValue) {
//        IDAOComite comiteDAO = new DAOComite();
//        comiteDAO.validerCandidature(newValue);
//        
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Validation");
//        alert.setHeaderText(null);
//        alert.setContentText("Validation de la candidature effectuée avec succès!");
//
//        alert.showAndWait();
//                }
//        }) ;
//        
//    }
    
    
    
}
