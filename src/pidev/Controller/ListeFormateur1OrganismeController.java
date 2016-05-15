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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import pidev.dao.classes.DAOComite;
import pidev.dao.classes.DAOFormateur;
import pidev.dao.interfaces.IDAOComite;
import pidev.entities.Formateur;
import pidev.entities.Organisme;
import pidev.techniques.DataSource;

/**
 *
 * @author Rimy Jeljeli
 */
public class ListeFormateur1OrganismeController implements Initializable{
   
      private ObservableList<Formateur> data ; 
    @FXML
    private Button btnback,telechargerCv ; 
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
   
    @FXML private Label labelNom, labelPrenom, labelEmail, labelAdresse, labelMsg, login ; 
ControllerAthentification ca=new ControllerAthentification();
String log=ca.log;
    Connection connection ; 

    public ListeFormateur1OrganismeController() {
    
    
    
    
        connection =(DataSource.getInstance()).getConnection();
    }
     
     private void showFormateurDetails(Formateur formateur) {
        labelNom.setText(formateur.getNom());
        labelPrenom.setText(formateur.getPrenom());
        labelEmail.setText(formateur.getMail());
       
        
        }
    
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String requete = "select * from formateur where organisme='"+log+"'";
        try {
            connection =(DataSource.getInstance()).getConnection();
            PreparedStatement ps = connection.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            data = FXCollections.observableArrayList();
             while (rs.next()) {
                data.add(new Formateur( rs.getString("nom"),rs.getString("prenom"),rs.getString("email")));
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
                    telechargerCv.setOnAction(new EventHandler<ActionEvent>() {
                        
                        @Override
                        public void handle(ActionEvent event) {
                            DAOComite formDAO = new DAOComite();
                            formDAO.downloadCV(newValue);
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
////        Alert alert = new Alert(Alert.AlertType.INFORMATION);
////        alert.setTitle("Validation");
////        alert.setHeaderText(null);
////        alert.setContentText("Validation de la candidature effectuÃ©e avec succÃ¨s!");
////
////        alert.showAndWait();
//                }
   
 
        
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Validation");
//        alert.setHeaderText(null);
//        alert.setContentText("Validation de la candidature effectuÃ©e avec succÃ¨s!");
//
//        alert.showAndWait();
      
 
        
   
    Organisme og=new Organisme();
       public void setOg(Organisme og) {
        login.setText(og.getLogin());
        this.og = og;
       
    }
    


    
}
