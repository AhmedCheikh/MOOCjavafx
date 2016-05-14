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
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.*;


import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pidev.entities.Apprenant;
import pidev.entities.Cours;

import pidev.techniques.DataSource;
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
    private TableColumn Description;
    
   @FXML
    private TableView<Cours> table ; 
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    
private Connection connection ; 
    private String infoApprenant ;
  private Apprenant apprenant;
   public AfficherCoursEtChapitreApprenantController()
   {
    connection = (DataSource.getInstance()).getConnection();
   }

    @FXML
    private void btnexitAction(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
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
        loader.setLocation(getClass().getResource("/pidev/gui/ProfilApprenant.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        stage.setTitle("Profil Apprenant");
        ProfilApprenantController pac  = loader.getController();
        pac.setApprenant(apprenant);
        stage.show();
    }
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
  
        DropShadow shadow = new DropShadow();
//Adding the shadow when the mouse cursor is on
        btnexit.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        shadow.setColor(Color.RED);
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
        
       
    }

   

    void setInfoApprenant(String inf) {
         try {

        String requete = "select c.idQuiz ,c.nom_cours,c.description,f.nom,c.video from cours c,coursuivi cs,apprenant a,formateur f where c.idcours=cs.id_Cours and cs.cinapprenant=a.cin and c.cinformateur=f.cin and cs.cinapprenant="+inf;
        
        PreparedStatement ps;
        
            ps = connection.prepareStatement(requete);
       
        ResultSet rs = ps.executeQuery();
        List<Cours> temp=new ArrayList<>();
        Cours c;
        while (rs.next()) {
            c=new Cours(rs.getString("nom_cours"),rs.getString("description"),rs.getString("nom"),rs.getNString("video"),rs.getInt("idQuiz"));
            //temp.add(rs.getString(1));
            //temp.add(rs.getString(2));
            // temp.add( new SimpleStringProperty(rs.getString(3)));
            
            temp.add(c);
            
        }
        final ObservableList<Cours> list=FXCollections.<Cours>observableList(temp);
        Nom.setCellValueFactory(new PropertyValueFactory("nomCours"));
        Description.setCellValueFactory(new PropertyValueFactory("description"));
        Formateur.setCellValueFactory(new PropertyValueFactory("cinFormateur"));
        table.setItems(list);
        
        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cours>() {
            
            @Override
            public void changed(ObservableValue<? extends Cours> observable, Cours oldValue, Cours newValue) {
                Cours cours=table.getSelectionModel().getSelectedItem();
               
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
                try {
                    pac.setCours(cours);
                } catch (SQLException ex) {
                    Logger.getLogger(AfficherCoursEtChapitreApprenantController.class.getName()).log(Level.SEVERE, null, ex);
                }
                pac.setApprenant(apprenant);
                stage.show();
            }} );
  
  } catch (SQLException ex) {
            Logger.getLogger(AfficherCoursEtChapitreApprenantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.infoApprenant=inf;
        
    }
 public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }
    
}
    
    
