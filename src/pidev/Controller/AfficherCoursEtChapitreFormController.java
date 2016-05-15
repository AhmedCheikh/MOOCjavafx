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
import javafx.scene.control.Label;
import javafx.scene.control.cell.*;


import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pidev.dao.classes.DAOFormateur;
import pidev.entities.Cours;
import pidev.entities.Formateur;

import pidev.techniques.DataSource;
/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class AfficherCoursEtChapitreFormController implements Initializable {
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
    public Formateur formateur;
     Formateur f2 = new Formateur();
 public String cin;
 DAOFormateur daof = new DAOFormateur();
 @FXML
    private Label lblCinFrm;
  public void setFrm(Formateur frm) {
        lblCinFrm.setText(frm.getCinFormateur());
        cin = frm.getCinFormateur();
//        f2 = daof.getFormateurByCIN(frm.getCinFormateur());
    
        try {
        String requete = "select c.nom_cours,c.description,f.nom,c.idcours ,c.idQuiz from cours c,formateur f where c.cinformateur=f.cin and c.cinformateur="+cin;
        
        PreparedStatement ps;
        
            ps = connection.prepareStatement(requete);
       
        ResultSet rs = ps.executeQuery();
        List<Cours> temp=new ArrayList<>();
        Cours c;
        while (rs.next()) {
            c=new Cours(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
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
                loader.setLocation(getClass().getResource("/pidev/gui/FXMLAffichageCoursForm.fxml"));
                try {
                    loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AfficherCoursEtChapitreFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Parent p = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
                stage.setTitle("Affichage Cours");
                AffichageCoursFormController pac  = loader.getController();
                System.out.println("*************************"+cours.getNomCours());
                pac.setInfo(cours);
                stage.show();
            }} );
  
  } catch (SQLException ex) {
            Logger.getLogger(AfficherCoursEtChapitreFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    

        this.formateur = frm;
        
    }
   public AfficherCoursEtChapitreFormController()
   {
    connection = (DataSource.getInstance()).getConnection();
   }

    @FXML
    private void btnexitAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Warning");
alert.setHeaderText("Your are leaving application !");
alert.setContentText("Are you sure to leave?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    Stage stage = (Stage) btnexit.getScene().getWindow();
        stage.close();
} else {
   alert.close();
}
        
    }

    @FXML
    private void btnbackAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ProfilFormateur.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.setTitle("Profil Formateur");
        ProfilFormateurController pac  = loader.getController();
       // pac.setFormateur(formateur);
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
}
    
    
