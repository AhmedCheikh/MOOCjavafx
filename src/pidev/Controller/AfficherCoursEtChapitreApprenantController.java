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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.MediaView;
import pidev.entities.Cours;
import pidev.entities.Formateur;
import pidev.techniques.DataSource;
import pidev.dao.classes.*;
/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class AfficherCoursEtChapitreApprenantController implements Initializable {
   @FXML
    private TableColumn Nom;
    @FXML
    private TableColumn Formateur;
    @FXML
    private TableColumn Description ;
    
   
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
Connection connection ; 
 private ObservableList<Cours> data ; 
   public AfficherCoursEtChapitreApprenantController()
   {
    Connection connection = (DataSource.getInstance()).getConnection();
   }

    @FXML
    private void btnexitAction(ActionEvent event) {
    }

    @FXML
    private void btnbackAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       String requete = "select * from formateur";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            data = FXCollections.observableArrayList();
             while (rs.next()) {
                data.add(new Cours(rs.getString("nomCours"),rs.getString("description"),rs.getString("cinFormateur"),rs.getString("difficulte"),rs.getString("objectif"),rs.getInt("idQuiz")));
            }
        
        Nom.setCellValueFactory(new PropertyValueFactory("nom"));
        Description.setCellValueFactory(new PropertyValueFactory("description"));
        DAOFormateur form= new DAOFormateur() ;
//        form.getFormateurByCIN(rs.getString("cinFormateur"));
        Formateur.setCellValueFactory(new PropertyValueFactory("email"));
        
        
//        table.setItems(data);
        
          
        } catch (SQLException ex) {
            Logger.getLogger(ValiderCandidatureController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
