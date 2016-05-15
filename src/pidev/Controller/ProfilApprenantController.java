/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
    
    @FXML
    private Button btnEditProfil;
    @FXML
    private Button btnDeconnecter;
    
    public static Apprenant apprenant;
     
    private String info;
    
    @FXML
    private Button btnEnvoyerMail;
    
    @FXML
    private ImageView imageView;

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
        //loader.setLocation(getClass().getResource("/pidev/gui/AfficherCoursSuiviApprenant.fxml")); 
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        
        AfficheListCoursSuivisController ALCS = loader.getController();
        ALCS.setApprenant(apprenant);
//        AfficherCoursEtChapitreApprenantController ACCA  = loader.getController();
//        ACCA.setInfoApprenant(inf);
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

    public void setInfo(String info) throws IOException {
        
        DAOApprenant da = new DAOApprenant();
       
        apprenant = da.getApprenantByLogin(info);

        File file = new File("src/pidev/gui/img/"+apprenant.getAvatar());
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);

        txtCin.setText(apprenant.getCin());
        
        txtNom.setText(apprenant.getNom());
        txtPrenom.setText(apprenant.getPrenom());
        txtEmail.setText(apprenant.getEmail());
        txtLogin.setText(apprenant.getLogin());
        
        this.info = info;
    }

    @FXML
    private void btnEditProfilAction(ActionEvent event) throws IOException {
           
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
        Stage stage = (Stage) btnDeconnecter.getScene().getWindow();
        stage.close();
        
    }



    public void setApprenant(Apprenant apprenant) {
        txtCin.setText(apprenant.getCin());
        txtNom.setText(apprenant.getNom());
        txtPrenom.setText(apprenant.getPrenom());
        txtEmail.setText(apprenant.getEmail());
        txtLogin.setText(apprenant.getLogin());
        File file = new File("src/pidev/gui/img/"+apprenant.getAvatar());
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
       
        this.apprenant = apprenant;
    }

    @FXML
    private void btnEnvoyerMailAction(ActionEvent event) throws IOException {
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/SendMailApprenant.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.setTitle("Envoyer Mail");
        stage.show();   
        
    }

}
