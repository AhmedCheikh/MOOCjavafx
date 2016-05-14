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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import static pidev.Controller.ConsulterCoursController.pathFile;
import pidev.dao.classes.DAOComite;
import pidev.dao.interfaces.IDAOComite;
import pidev.entities.Comite;
import pidev.entities.Cours;
import pidev.gui.video.VideoFXDemo;
import pidev.techniques.DataSource;

/**
 * FXML Controller class
 *
 * @author WiKi
 */
public class ValiderVideoController implements Initializable {
    private Comite comite ; 
    private Cours c ; 
    private Connection connection ; 
    @FXML
    private TableColumn cours;
    @FXML
    private TableColumn formateur;
    @FXML
    private TableView<Cours> table ;
    @FXML private Button approuver,refresh ; 
    @FXML private Button video ;
    @FXML private Label labelNom, labelPrenom, labelDescription, labelDifficulte, labelObjectif ; 
    public static String pathFile ;
    private MediaPlayer mediaPlayer;
    final double mediaWidth = 480;  
    final double mediaHeight = 270;
    

    public void setComite(Comite comite) {
        this.comite = comite;
    }
    
    public void setInfo(Cours c) {
        this.c=c;
        pathFile=c.getVideo();
    }
    
    
    
    private void showCoursDetails(Cours cours) {
        labelDescription.setText(cours.getDescription());
        labelDifficulte.setText(cours.getDifficulte());
        labelObjectif.setText(cours.getObjectif());
        
    }
    
    public ValiderVideoController()
   {
    connection = (DataSource.getInstance()).getConnection();
   }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

        String requete = "select c.idcours, c.nom_cours,c.description,c.difficulte,c.objectif, f.nom,c.video from cours c,formateur f where c.cinformateur=f.cin and c.etat=0 ";
        PreparedStatement ps;
        ps = connection.prepareStatement(requete);
        ResultSet rs = ps.executeQuery();
        List<Cours> temp=new ArrayList<>();
        Cours c;
        while (rs.next()) {

            c=new Cours(rs.getInt("idcours"),rs.getString("nom_cours"),rs.getString("description"),rs.getString("difficulte"),rs.getString("objectif") ,rs.getString("nom"),rs.getNString("video"));
            System.out.println(c.getIdCours()+"--"+c.getNomCours()+"--"+c.getDescription()+"--"+c.getCinFormateur()+"--"+c.getVideo());
            temp.add(c);
            
        }
        
        final ObservableList<Cours> list=FXCollections.<Cours>observableList(temp);
        cours.setCellValueFactory(new PropertyValueFactory("nomCours"));
        formateur.setCellValueFactory(new PropertyValueFactory("cinFormateur"));
        table.setItems(list);
        table.getColumns().get(0).setVisible(false);
        table.getColumns().get(0).setVisible(true);
        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Cours>() {
            
            @Override
            public void changed(ObservableValue<? extends Cours> observable, Cours oldValue, Cours newValue) {
                showCoursDetails(newValue);
                approuver.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               IDAOComite comiteDAO = new DAOComite();
               comiteDAO.validerVideo(newValue);
               
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Validation");
               alert.setHeaderText(null);
               alert.setContentText("Validation du cours effectuée avec succès!");
               alert.showAndWait();
               table.getColumns().get(0).setVisible(false);
               table.getColumns().get(0).setVisible(true);
               
            }
        });
               video.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/pidev/gui/FXMLAffichageCours2.fxml"));
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
                FXMLAffichageCours2Controller pac  = loader.getController();
                pac.setInfo(newValue);
//                pac.setApprenant(apprenant);
                stage.show();                    }
                });
//                FXMLLoader loader = new FXMLLoader();
//                loader.setLocation(getClass().getResource("/pidev/gui/FXMLAffichageCours2.fxml"));
//                try {
//                    loader.load();
//                } catch (IOException ex) {
//                    Logger.getLogger(AfficherCoursEtChapitreApprenantController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                Parent p = loader.getRoot();
//                Stage stage = new Stage();
//                stage.setScene(new Scene(p));
//                stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
//                stage.setTitle("Affichage Cours");
//                FXMLAffichageCours2Controller pac  = loader.getController();
//                pac.setInfo(cours);
////                pac.setApprenant(apprenant);
//                stage.show();
            }} );
        
  
  } catch (SQLException ex) {
            Logger.getLogger(AfficherCoursEtChapitreApprenantController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
