/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.dao.classes.DAOApprenant;
import pidev.entities.Apprenant;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class EditProfilApprenantController implements Initializable {
   
    
    @FXML
    private Label er1;
    @FXML
    private Label er2;
    @FXML
    private Label er5;
    @FXML
    private Label er3;
    @FXML
    private Label er4;
    @FXML
    private Label er6;
    @FXML
    private TextField txtCin;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtLogin;
    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnAnnuller;
    
    private Apprenant apprenant;
    public Apprenant newApprenant;
    @FXML
    private Button btnChoisirImage;
    
    public File file;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DropShadow shadow = new DropShadow();

        btnexit.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        shadow.setColor(Color.RED);
                        btnexit.setEffect(shadow);
                    }
                });

        btnexit.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        
                        btnexit.setEffect(null);
                    }
                });
        btnback.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        shadow.setColor(Color.DODGERBLUE);
                        btnback.setEffect(shadow);
                    }
                });

        btnback.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        
                        btnback.setEffect(null);
                    }
                });
        
    }    

    public void setApprenant(Apprenant apprenant) {
        txtCin.setText(apprenant.getCin());
        txtNom.setText(apprenant.getNom());
        txtPrenom.setText(apprenant.getPrenom());
        txtPassword.setText(apprenant.getPassword());
        txtLogin.setText(apprenant.getLogin());
        this.apprenant = apprenant;
    }

 

    @FXML
    private void btnModifierAction(ActionEvent event) throws IOException {
         
        int test = 0;

        if (txtNom.getText().isEmpty() || (txtNom.getText().matches("[a-zA-Z]+")==false)) {
            er2.setText("Ce champ est obligatoire");
            test -=1;
        } else {
            er2.setText("");
            test +=1;
        }
        if (txtPrenom.getText().isEmpty() || (txtPrenom.getText().matches("[a-zA-Z]+")==false)) {
            er3.setText("Ce champ est obligatoire");
            test -=1;
        } else {
            er3.setText("");
            test +=1;
        }
        
        if (txtLogin.getText().isEmpty()|| (txtLogin.getText().matches("[a-zA-Z0-9]+")==false)) {
            er4.setText("Login non valide");
            test -=1;
        } else {
            er4.setText("");
            test +=1;
        }
        if (txtPassword.getText().isEmpty()) {
            er5.setText("Ce champ est obligatoire");
            test -=1;
        } else {
            er5.setText("");
            test +=1;
        }
              
            System.out.println("1111");
            
        if( test == 4 ){
            DAOApprenant da = new DAOApprenant();
            if(file != null){
                newApprenant = new Apprenant(apprenant.getCin(), txtNom.getText(), txtPrenom.getText(),apprenant.getEmail(), file , txtLogin.getText(), txtPassword.getText());
                da.update(newApprenant , apprenant.getCin());
                apprenant = newApprenant;
            } else {
                newApprenant = new Apprenant(apprenant.getCin(), txtNom.getText(), txtPrenom.getText(),apprenant.getEmail(), txtLogin.getText(), txtPassword.getText());
                da.updateWithoutAvatarChange(newApprenant , apprenant.getCin());
                apprenant = newApprenant;
            }
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("Updated successfully!");
            alert.showAndWait();
    
        }   
        
 }

    @FXML
    private void btnAnnullerAction(ActionEvent event) {

        txtNom.clear();
    
        txtPrenom.clear();
    
        txtLogin.clear();
    
        txtPassword.clear();

    }

    @FXML
    private void btnexitAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
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

    @FXML
    private void btnChoisirImageAction(ActionEvent event) {
        
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = 
                    new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg = 
                    new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG = 
                    new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng = 
                    new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);

        file = fileChooser.showOpenDialog(null);
        if(file != null){
            er6.setText(file.getAbsolutePath());
        }
        
        
 
                
    }
    
    

    
}
