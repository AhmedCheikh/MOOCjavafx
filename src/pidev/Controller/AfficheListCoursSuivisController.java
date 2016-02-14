/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pidev.dao.classes.DAOCours;
import pidev.entities.Apprenant;
import pidev.entities.CoursSuivie;
import pidev.techniques.DataSource;

/**
 * FXML Controller class
 *
 * @author Khoubaib
 */
public class AfficheListCoursSuivisController implements Initializable {

    @FXML
    private Button btnExit;
    @FXML
    private Button btnBack;
    @FXML
    private TableView<CoursSuivie> tableCourSuivi;
    @FXML
    private TableColumn<CoursSuivie, Integer> idCour;
    @FXML
    private TableColumn<CoursSuivie, String> dateDebut;
    @FXML
    private TableColumn<CoursSuivie, String> appreciation;
    
    private Apprenant apprenant;
   
    ObservableList<CoursSuivie> data = FXCollections.observableArrayList();
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public AfficheListCoursSuivisController() {
        connection =(DataSource.getInstance()).getConnection();
    }
    

    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String req = "select * from coursuivi";
       
        
        try {
            pst = connection.prepareStatement(req);
            
            rs = pst.executeQuery();
            
            while(rs.next()){
               
                data.add(new CoursSuivie(rs.getInt("idCoursuivi"),rs.getString("date_debut"), rs.getString("appreciation")));
                
            }
        
        
         //data.add(new CoursSuivie(1, "2015", "mauvais"));
        idCour.setCellValueFactory(new PropertyValueFactory<CoursSuivie, Integer>("idCoursuivi"));
        dateDebut.setCellValueFactory(new PropertyValueFactory<CoursSuivie, String>("date_debut"));
        appreciation.setCellValueFactory(new PropertyValueFactory<CoursSuivie, String>("appreciation"));
        tableCourSuivi.setItems(data);
    
            } catch (SQLException ex) {
            Logger.getLogger(DAOCours.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } 

    @FXML
    private void btnExitAction(ActionEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnBackAction(ActionEvent event) throws IOException {      
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ProfilApprenant.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.setTitle("Profil Apprenant");
        ProfilApprenantController pac  = loader.getController();
        pac.setApprenant(apprenant);
        stage.show();
    }

    public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }
    
}
