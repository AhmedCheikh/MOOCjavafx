/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pidev.dao.classes.DAOCours;
import pidev.entities.Apprenant;
import pidev.entities.Cours;


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
    private TableView<Cours> tableCourSuivi;
    @FXML
    private TableColumn nomCour;
    @FXML
    private TableColumn difficulteCours;
    @FXML
    private TableColumn objectifCours;
    
    private Apprenant apprenant;
  



    public AfficheListCoursSuivisController() {

    }
 
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

        DAOCours dc = new DAOCours();
        List<Cours> temp=new ArrayList<>();
        temp = dc.findCoursByApprenant(apprenant.getCin());

        final ObservableList<Cours> list=FXCollections.<Cours>observableList(temp);
        nomCour.setCellValueFactory(new PropertyValueFactory("nomCours"));
        difficulteCours.setCellValueFactory(new PropertyValueFactory("difficulte"));
        objectifCours.setCellValueFactory(new PropertyValueFactory("objectif"));
        tableCourSuivi.setItems(list);
        
        tableCourSuivi.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cours>() {
            
            @Override
            public void changed(ObservableValue<? extends Cours> observable, Cours oldValue, Cours newValue) {
                try {
                    Cours cours=tableCourSuivi.getSelectionModel().getSelectedItem();
                    
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/pidev/gui/FXMLAffichageCours.fxml"));
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
                    AffichageCoursController pac  = loader.getController();
                    pac.setCours(cours);
                    pac.setApprenant(apprenant);
                    stage.show();
                } catch (SQLException ex) {
                    Logger.getLogger(AfficheListCoursSuivisController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }} );
  
        
        this.apprenant = apprenant;
    }
    
}
