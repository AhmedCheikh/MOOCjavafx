/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pidev.dao.classes.DAOAdministrateur;
import pidev.dao.interfaces.IDAOAdministrateur;
import pidev.entities.Organisme;

/**
 * FXML Controller class
 *
 * @author WiKi
 */
public class ProfilAdministrateurController implements Initializable {
    
    @FXML private Button approuver, telecharger, pieChart, stackedBarChart ; 
    @FXML private TableView<Organisme> table ; 
    @FXML private TableColumn organisme ; 
    @FXML private Label emailLabel, sitewebLabel, adresseLabel, telephoneLabel,descriptionLabel ; 
    @FXML private ObservableList<Organisme> data ;

    /**
     * Initializes the controller class.
     */
    
    public void showOrganismeDetails(Organisme organisme) {
        emailLabel.setText(organisme.getEmail());
        sitewebLabel.setText(organisme.getSiteweb());
        adresseLabel.setText(organisme.getAdresse());
        telephoneLabel.setText(organisme.getTelephone());
        descriptionLabel.setText(organisme.getDescription());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IDAOAdministrateur adminDAO = new DAOAdministrateur();
        List<Organisme> listeorganisme = adminDAO.findAll();
        data = FXCollections.observableArrayList();
        
        for (Organisme organisme : listeorganisme ) {
            data.add(organisme); 
        }
        
        organisme.setCellValueFactory(new PropertyValueFactory("nom"));
        organisme.setStyle("-fx-alignment: CENTER;");
        table.setItems(data);
        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Organisme>() {

        @Override
        public void changed(ObservableValue<? extends Organisme> observable, Organisme oldValue, Organisme newValue) {
                
                showOrganismeDetails(newValue);
                
                approuver.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        IDAOAdministrateur adminDAO = new DAOAdministrateur();
                        adminDAO.validerPreinscriOrganisme(newValue);
                        table.refresh();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Validation");
                        alert.setHeaderText(null);
                        alert.setContentText("Validation de la candidature effectuée avec succès!");
                        alert.showAndWait();
                    }
                });
                
                telecharger.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        IDAOAdministrateur adminDAO = new DAOAdministrateur();
                        adminDAO.downloadDocument(newValue);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Téléchargement");
                        alert.setHeaderText(null);
                        alert.setContentText("Téléchargement effectuée avec succès! (Allez dans D:)");
                        alert.showAndWait();
                    }
                });
            }
        });
    }
    
    @FXML
    private void pieChartAction (ActionEvent event) throws IOException {
        

        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/PieChart.fxml"));
            Stage stage =  new Stage();
            Scene scene = new Scene(parent);
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setScene(scene);
            stage.setTitle("PieChart");
            stage.show();
    }
    
    @FXML
    private void stackedBarChartAction (ActionEvent event) throws IOException {
        

        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/StackedBarChart.fxml"));
            Stage stage =  new Stage();
            Scene scene = new Scene(parent);
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setScene(scene);
            stage.setTitle("StackedBarChart");
            stage.show();
    }
    
    @FXML
    private void lineChartAction (ActionEvent event) throws IOException {
        

        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/lineChart.fxml"));
            Stage stage =  new Stage();
            Scene scene = new Scene(parent);
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setScene(scene);
            stage.setTitle("lineChart");
            stage.show();
    }
    
    
    
}
