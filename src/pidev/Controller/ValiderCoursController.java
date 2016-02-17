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
import java.util.List;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pidev.dao.classes.DAOComite;
import pidev.dao.classes.DAOCours;
import pidev.dao.interfaces.IDAOComite;
import pidev.dao.interfaces.IDaoCours;
import pidev.entities.Cours;
import pidev.entities.Formateur;
import pidev.techniques.DataSource;

/**
 * FXML Controller class
 *
 * @author WiKi
 */
public class ValiderCoursController implements Initializable {
    Connection connection ; 
    @FXML private Button btnback;
    @FXML private Button btnexit;
    @FXML private Button approuver;
    @FXML private TableView<Cours> tableCours ;
    @FXML private TableColumn titre ; 
    @FXML private TableColumn formateur ;
    @FXML private TableColumn description ;
    @FXML private TableColumn difficulte ;
    @FXML private ObservableList<Cours> data ;
    @FXML private Label labelNom, labelPrenom, labelDescription, labelDifficulte, labelObjectif ; 
    
    
    

    /**
     * Initializes the controller class.
     */
    
    private void showCoursDetails(Cours cours) {
        labelDescription.setText(cours.getDescription());
        labelDifficulte.setText(cours.getDifficulte());
        labelObjectif.setText(cours.getObjectif());
        
    }
    
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//      String requete = "select * from cours where etat=2";
//        try {
//            
//            connection =(DataSource.getInstance()).getConnection();
//            PreparedStatement ps = connection.prepareStatement(requete);
//            ResultSet rs = ps.executeQuery();
//            data = FXCollections.observableArrayList();
//            
//             while (rs.next()) {
//               data.add(new Cours(rs.getInt("idCours"),rs.getString("nom_cours"), rs.getString("description"), rs.getString("cinformateur"), rs.getString("difficulte"), rs.getString("objectif"), rs.getInt("idQuiz")));
//             }
//             
//             titre.setCellValueFactory(new PropertyValueFactory("nomCours"));
//
//             
//             tableCours.setItems(data);
//             
//             tableCours.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cours>() {
//
//                @Override
//                public void changed(ObservableValue<? extends Cours> observable, Cours oldValue, Cours newValue) {
//                    showCoursDetails(newValue);
//                    approuver.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//               IDAOComite comiteDAO = new DAOComite();
//               comiteDAO.validerCours(newValue);
//               Alert alert = new Alert(Alert.AlertType.INFORMATION);
//               alert.setTitle("Validation");
//               alert.setHeaderText(null);
//               alert.setContentText("Validation du cours effectuée avec succès!");
//
//               alert.showAndWait();
//               
//            }
//        });
//                    
//                }
//            } );
//        } catch (SQLException ex) {
//            Logger.getLogger(ValiderCoursController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      IDaoCours coursDAO = new DAOCours();
      data = FXCollections.observableArrayList();
      List<Cours> listCours = coursDAO.findAll();
      
        for (Cours cours : listCours) {
            data.add(cours);
        }
             
             titre.setCellValueFactory(new PropertyValueFactory("nomCours"));

             
             tableCours.setItems(data);
             
             tableCours.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cours>() {

                @Override
                public void changed(ObservableValue<? extends Cours> observable, Cours oldValue, Cours newValue) {
                    showCoursDetails(newValue);
                    approuver.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               IDAOComite comiteDAO = new DAOComite();
               comiteDAO.validerCours(newValue);
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Validation");
               alert.setHeaderText(null);
               alert.setContentText("Validation du cours effectuée avec succès!");

               alert.showAndWait();
               
            }
        });
                    
                }
            } );
        } 
        
        
    

    @FXML
    private void btnbackAction(ActionEvent event) {
    }

    @FXML
    private void btnexitAction(ActionEvent event) {
    }
    
}
