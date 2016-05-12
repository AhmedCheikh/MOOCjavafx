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
import java.util.List;
import java.util.Optional;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pidev.dao.classes.DAOComite;
import pidev.dao.classes.DAOCours;
import pidev.dao.interfaces.IDAOComite;
import pidev.dao.interfaces.IDaoCours;
import pidev.entities.Comite;
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
    private Comite comite; 
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
    
    public void setComite(Comite comite) {
        this.comite = comite;
    }

    
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
    private void btnexitAction(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("Your are leaving application !");
alert.setContentText("Are you sure to leave?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    
      ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/FXMLAuthentification.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        stage.setTitle("Authentification");
        
        stage.show();
    
} else {
   alert.close();
}
        
    }

    @FXML
    private void btnbackAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ProfilComite.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        stage.setTitle("Profil Comite");
        ProfilComiteController pcc = loader.getController();
        pcc.setComite(comite);

        stage.show();
    }
    
}
