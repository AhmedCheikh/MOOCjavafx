/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import pidev.dao.classes.DAOOrganisme;
import pidev.entities.Organisme;

/**
 *
 * @author Rimy Jeljeli
 */
public class InscrireOrganismeController implements Initializable {
 @FXML
    private Label nom;
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    public String logo;

    public void setLogo(String logo) {
        this.logo = logo;
    }
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtTel;
    @FXML
    private TextField txtSite;
    @FXML
    private TextArea txtDesc;
    private File selectedFile;

    private  Organisme o;
    
    DAOOrganisme daoO = new DAOOrganisme();
    Organisme o1 = new Organisme();
    
  
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ControllerAthentification ca=new ControllerAthentification();
  
        o1 = daoO.getOrganisme(ca.log);
        System.out.println("-------"+o1.getLogin());
    }

    public void btnValiderAction(ActionEvent event) throws IOException {

        if (txtTel.getText().isEmpty()) {
            l1.setText("Vous devez Renseigez ce champs");
        } else {
            l1.setText(" ");
        }
        if (txtSite.getText().isEmpty()) {
            l2.setText("Vous devez Renseigez ce champs");

        } else {
            l2.setText(" ");
        }
        if (txtDesc.getText().isEmpty()) {
            l3.setText("Vous devez Renseigez ce champs");
        } else {
            l3.setText(" ");
        }

       

        Organisme o5 = new Organisme( txtSite.getText(), txtTel.getText(), txtDesc.getText(), logo);
        DAOOrganisme d1 = new DAOOrganisme();
        System.out.println(selectedFile.getAbsolutePath());

        d1.updateOrganismeInscription(o5,o1.getLogin());

         ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parent;
     
            parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ProfileOrganismeA.fxml"));
      
            Stage stage =  new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Profil Organisme");
            stage.show();
    }
    
    private Organisme og;
    

    public void btnAnullerAction(ActionEvent event) {
        txtTel.setText("");
        txtSite.setText("");
        txtDesc.setText("");

    }

    public void btnexitAction(ActionEvent event) {

    }

    public void btnbackAction(ActionEvent event) {

    }

    public void btnChoisireImgAction() throws IOException {
        FileChooser fileChooser = new FileChooser();

        selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            fileChooser.setTitle("Open resource file");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.png"));
            Organisme o = new Organisme();
            if (selectedFile != null) {
                File path = selectedFile.getAbsoluteFile();
                logo = selectedFile.getName();
                l4.setText("File selected: " + selectedFile.getName());
                o.setLogo(l4.getText());
                
                
                  String url = "src/pidev/gui/img/"+ selectedFile.getName();
                Path des = Paths.get(url);
                Path source = Paths.get(selectedFile.getAbsolutePath());
                Files.copy(source , des);
            } else {

                l4.setText("File selection cancelled.");

            }

        }

    }

  
    
    
    

}
