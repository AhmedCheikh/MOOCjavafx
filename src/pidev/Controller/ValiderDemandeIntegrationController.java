/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pidev.dao.classes.DAOComite;
import pidev.dao.interfaces.IDAOComite;
import pidev.entities.Comite;
import pidev.entities.Formateur;

/**
 * FXML Controller class
 *
 * @author WiKi
 */
public class ValiderDemandeIntegrationController implements Initializable {
 
    
    Connection connection ; 
    private ObservableList<Formateur> data ; 
    public ObservableList<Formateur> data2;
    @FXML
    private Button btnback;
    @FXML
    private Button btnexit;
    @FXML
    private Button approuver,downloadCV;
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
    private Comite comite ; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IDAOComite comiteDAO = new DAOComite();
        data = FXCollections.observableArrayList();
        List<Formateur> listFormateur = comiteDAO.findFormateurValide() ; 
        
        for (Formateur formateur : listFormateur) {
            data.add(formateur) ; 
        }
        
        Nom.setCellValueFactory(new PropertyValueFactory("nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory("prenom"));

        
        table.setItems(data);
        
        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Formateur>() {

        @Override
        public void changed(ObservableValue<? extends Formateur> observable, Formateur oldValue, Formateur newValue) {
        showFormateurDetails(newValue);
        
        approuver.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        IDAOComite comiteDAO = new DAOComite();
        comiteDAO.validerIntegrationComite(newValue); 
        table.refresh();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Validation");
        alert.setHeaderText(null);
        alert.setContentText("Validation de l'intégration effectuée avec succès!");
        alert.showAndWait();
        
               
                                             }
                               });
        
        downloadCV.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                IDAOComite comiteDAO = new DAOComite();
                comiteDAO.downloadCV(newValue);
                
                
            }
        });
        
        }
            
        }) ;
    
    }  
    public void setComite(Comite comite) {
        this.comite = comite;
    }
    
    private void showFormateurDetails(Formateur formateur) {
        labelNom.setText(formateur.getNom());
        labelPrenom.setText(formateur.getPrenom());
        labelEmail.setText(formateur.getMail());
//      labelAdresse.setText(formateur.getAdresse());
        
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
