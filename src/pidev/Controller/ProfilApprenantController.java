/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pidev.dao.classes.DAOApprenant;
import pidev.entities.Apprenant;

/**
 * FXML Controller class
 *
 * @author Khoubaib
 */
public class ProfilApprenantController implements Initializable {

    @FXML
    private Label txtCin;
    @FXML
    private Label txtNom;
    @FXML
    private Label txtPrenom;
    @FXML
    private Label txtEmail;
    @FXML
    private Label txtLogin;
    @FXML
    private Button btnListCoursSuivis;
    @FXML
    private Button btnRechCours;
    private String info;
    @FXML
    private Hyperlink btnEditProfil;
    @FXML
    private Button btnDeconnecter;
    Apprenant apprenant;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    @FXML
    private void btnListCoursSuivisAction(ActionEvent event) throws IOException { 
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/AfficheListCoursSuivis.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        AfficheListCoursSuivisController ALCS  = loader.getController();
        ALCS.setApprenant(apprenant);
        stage.setTitle("List Cours Suivis");
        stage.show();
        
    }

    @FXML
    private void btnRechCoursAction(ActionEvent event) throws IOException {       
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/RechercherCour.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        RechercherCourController RCC  = loader.getController();
        RCC.setApprenant(apprenant);
        stage.setTitle("Rechercher Cours");
        stage.show();
    }

    public void setInfo(String info) {
        
        DAOApprenant da = new DAOApprenant();
        apprenant = da.getApprenantByLogin(info);
        txtCin.setText(apprenant.getCin());
        txtNom.setText(apprenant.getNom());
        txtPrenom.setText(apprenant.getPrenom());
        txtEmail.setText(apprenant.getEmail());
        txtLogin.setText(apprenant.getLogin());
        
        this.info = info;
    }

    @FXML
    private void btnEditProfilAction(ActionEvent event) throws IOException {
        
//        ((Node) (event.getSource())).getScene().getWindow().hide();
//        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/EditProfilApprenant.fxml"));
//        Stage stage = new Stage();
//        Scene scene = new Scene(parent);
//        stage.setScene(scene);
//        stage.setTitle("Editer Profil");
//        stage.show();
            
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pidev/gui/EditProfilApprenant.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage =new Stage();
            stage.setScene(new Scene(p));
            EditProfilApprenantController epac  = loader.getController();
            epac.setApprenant(apprenant);
            stage.setTitle("Editer Mon Profil");
            stage.show();
        
    }

    @FXML
    private void btnDeconnecterAction(ActionEvent event) throws IOException {
//        ((Node) (event.getSource())).getScene().getWindow().hide();
//        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/FXMLAuthentification.fxml"));
//        Stage stage = new Stage();
//        Scene scene = new Scene(parent);
//        stage.setScene(scene);
//        stage.setTitle("Authentification");
//        stage.show();
        Stage stage = (Stage) btnDeconnecter.getScene().getWindow();
        stage.close();
        
    }



    public void setApprenant(Apprenant apprenant) {
        txtCin.setText(apprenant.getCin());
        txtNom.setText(apprenant.getNom());
        txtPrenom.setText(apprenant.getPrenom());
        txtEmail.setText(apprenant.getEmail());
        txtLogin.setText(apprenant.getLogin());
        this.apprenant = apprenant;
    }
    
    
    
}
