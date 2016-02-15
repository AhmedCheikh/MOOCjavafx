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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;


import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pidev.entities.Cours;
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
    private TableView table ; 
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
private Connection connection ; 
 private ObservableList<Cours> data ; 
   public AfficherCoursEtChapitreApprenantController()
   {
    connection = (DataSource.getInstance()).getConnection();
   }

    @FXML
    private void btnexitAction(ActionEvent event) {
        Stage stage = (Stage) btnexit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnbackAction(ActionEvent event) throws IOException {
         ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ProfilApprenant.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.setTitle("Profil Apprenant");
     
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//       String requete = "select * from cours";
//        try {
//            PreparedStatement ps = connection.prepareStatement(requete);
//            ResultSet rs = ps.executeQuery();
//            data = FXCollections.observableArrayList();
//             while (rs.next()) {
//                data.add(new Cours(rs.getString("nomCours"),rs.getString("description"),rs.getString("cinFormateur"),rs.getString("difficulte"),rs.getString("objectif"),rs.getInt("idQuiz")));
//            }
//        
//        Nom.setCellValueFactory(new PropertyValueFactory("nom"));
//        Description.setCellValueFactory(new PropertyValueFactory("description"));
//        DAOFormateur form= new DAOFormateur() ;
//        form.getFormateurByCIN(rs.getString("cinFormateur"));
//        Formateur.setCellValueFactory(new PropertyValueFactory("nom"));
//        
//        
//        table.setItems(data);
//        
//          
//        } catch (SQLException ex) {
//            Logger.getLogger(ValiderCandidatureController.class.getName()).log(Level.SEVERE, null, ex);
//        }

Image imageDecline1 = new Image(getClass().getResourceAsStream("/pidev/gui/img/exit.jpg"));
        btnexit.setGraphic(new ImageView(imageDecline1));
 DropShadow shadow = new DropShadow();
//Adding the shadow when the mouse cursor is on
 btnexit.addEventHandler(MouseEvent.MOUSE_ENTERED, 
    new EventHandler<MouseEvent>() {
        @Override public void handle(MouseEvent e) {
            btnexit.setEffect(shadow);
        }
});
//Removing the shadow when the mouse cursor is off
 btnexit.addEventHandler(MouseEvent.MOUSE_EXITED, 
    new EventHandler<MouseEvent>() {
        @Override public void handle(MouseEvent e) {
             btnexit.setEffect(null);
        }
});
        
        
          Image imageDecline = new Image(getClass().getResourceAsStream("/pidev/gui/img/flech.jpg"));
 btnback.setGraphic(new ImageView(imageDecline));
 
//Adding the shadow when the mouse cursor is on
 btnback.addEventHandler(MouseEvent.MOUSE_ENTERED, 
    new EventHandler<MouseEvent>() {
        @Override public void handle(MouseEvent e) {
            btnback.setEffect(shadow);
        }
});
//Removing the shadow when the mouse cursor is off
 btnback.addEventHandler(MouseEvent.MOUSE_EXITED, 
    new EventHandler<MouseEvent>() {
        @Override public void handle(MouseEvent e) {
             btnback.setEffect(null);
        }
});
       
    }
    
    
}
