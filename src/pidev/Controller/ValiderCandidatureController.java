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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
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
    private TableView table ; 
    @FXML
    private TableColumn Nom;
    @FXML
    private TableColumn Prenom;
    @FXML
    private TableColumn Email;
    @FXML
    private TableColumn Adresse;
    
    

    /**
     * Initializes the controller class.
     */
     public ValiderCandidatureController() {
        connection =(DataSource.getInstance()).getConnection();
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String requete = "select * from formateur";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            data = FXCollections.observableArrayList();
             while (rs.next()) {
                data.add(new Formateur(rs.getInt("cin"), rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("etat"), null,rs.getString("login"),null));
            }
        
        Nom.setCellValueFactory(new PropertyValueFactory("nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory("prenom"));
        Email.setCellValueFactory(new PropertyValueFactory("email"));
        Adresse.setCellValueFactory(new PropertyValueFactory("adresse"));
        
        table.setItems(data);
        
          
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
    
    
    
}
