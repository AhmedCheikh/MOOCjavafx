/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pidev.dao.classes.DAOCours;
import pidev.entities.Apprenant;
import pidev.entities.Cours;
import pidev.entities.CoursSuivie;

/**
 * FXML Controller class
 *
 * @author Khoubaib
 */
public class RechercherCourController implements Initializable {

    @FXML
    private TableView<Cours> tableCours;
    @FXML
    private TableColumn<Cours, String> nomCourColumn;
    @FXML
    private TableColumn<Cours, String> descriptionColumn;
    @FXML
    private TableColumn<Cours, String> objectifColumn;
    @FXML
    private TableColumn<Cours, String> difficulteColumn;
    @FXML
    private TextField txtAChercher;
    @FXML
    private Button btnRecherche;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnBack;
    
    private Apprenant apprenant;
    
    ObservableList<Cours> data = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           DropShadow shadow = new DropShadow();

        btnExit.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        shadow.setColor(Color.RED);
                        btnExit.setEffect(shadow);
                    }
                });

        btnExit.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        
                        btnExit.setEffect(null);
                    }
                });
               

        btnBack.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        shadow.setColor(Color.DODGERBLUE);
                        btnBack.setEffect(shadow);
                    }
                });

        btnBack.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        
                        btnBack.setEffect(null);
                    }
                });
         btnRecherche.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        shadow.setColor(Color.BLACK);
                        btnRecherche.setEffect(shadow);
                    }
                });

        btnRecherche.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        
                        btnRecherche.setEffect(null);
                    }
                });
        
                tableCours.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cours>() {
                    
            @Override
            public void changed(ObservableValue<? extends Cours> observable, Cours oldValue, Cours newValue) {
                Cours cours=tableCours.getSelectionModel().getSelectedItem();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/pidev/gui/ConsulterCour.fxml"));
                try {
                    loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AfficherCoursEtChapitreApprenantController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Parent p = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
                stage.setTitle("Affichage Cours");
                ConsulterCoursController pac  = loader.getController();
                pac.setInfo(cours);
                stage.show();
            }} );
        
    }    

    @FXML
    private void btnExitAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning");
        alert.setHeaderText("Your are leaving application !");
            alert.setContentText("Are you sure to leave?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
        } else {
        alert.close();
        }
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

    @FXML
    private void btnRechercheAction(ActionEvent event) {
        data.clear();
        DAOCours dac = new DAOCours();
        List<Cours> listCours = new ArrayList<>();
        listCours = dac.findCoursByTitle(txtAChercher.getText());
        for (Cours cours : listCours) {
            data.add(cours);
        }
        nomCourColumn.setCellValueFactory(new PropertyValueFactory<Cours, String>("nomCours"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Cours, String>("description"));
        objectifColumn.setCellValueFactory(new PropertyValueFactory<Cours, String>("objectif"));
        difficulteColumn.setCellValueFactory(new PropertyValueFactory<Cours, String>("difficulte"));
        tableCours.setItems(data);
        
        
        
    }
    
    
    
}
