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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.dao.classes.DAOOrganisme;
import pidev.entities.*;

/**
 *
 * @author Rimy Jeljeli
 */
public class PreInscrireOrganismeController implements Initializable {

    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    private Label l5;
    @FXML
    private Label l6;
    @FXML
    private Label l7;
 @FXML
    private Button btnback;
  @FXML
    private Button btnexit;
    @FXML
    private Image tick1;

    @FXML
    public static String document;
    public void setDoc(String document) {
        this.document = document;
    }

    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtAdresse;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtLogin;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtpassword2;

    
    
      public boolean textFieldEmpty(TextField i, Label l) {
        boolean r = false;
        if (i.getText().isEmpty()) {
            r = true;
            i.setStyle("-fx-border-color:#fc0000");
            l.setText("Vous devez renseigner ce champ!");
        }
        return r;
    }

    public boolean validationEmail(TextField txte) {
        boolean verife = false;
        Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher m = p.matcher(txte.getText());
        if (m.find() && m.group().equals(txte.getText())) {
            verife = true;
            txte.setStyle("-fx-border-color:#84D41D");
            l4.setText("Adresse Email non valide!!");
        }
        return verife;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
public void btnbackAction(ActionEvent event) throws IOException{
                ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/pidev/gui/FXMLAuthentification.fxml"));
                loader.load();                
                Parent p = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
    }
 @FXML
    private void btnexitAction(ActionEvent event) {
        Stage stage = (Stage) btnexit.getScene().getWindow();
        stage.close();
    }
    public void btnValiderAction(ActionEvent event) throws IOException {

//        if (txtNom.getText().isEmpty()) {
//            l1.setText("Vous devez Renseigez ce champs");
//        } else {
//            l1.setText(" ");
//        }
//        if (txtAdresse.getText().isEmpty()) {
//            l2.setText("Vous devez Renseigez ce champs");
//
//        } else {
//            l2.setText(" ");
//        }
//        if (txtEmail.getText().isEmpty()) {
//            l3.setText("Vous devez Renseigez ce champs");
//        } else {
//            l3.setText(" ");
//        }
//        if (txtLogin.getText().isEmpty()) {
//            l4.setText("Vous devez Renseigez ce champs");
//        } else {
//            l4.setText(" ");
//        }
//        if (txtPassword.getText().isEmpty()) {
//            l5.setText("Vous devez Renseigez ce champs");
//        } else {
//            l5.setText(" ");
//        }
//        if (txtpassword2.getText().isEmpty()) {
//            l6.setText("Vous devez Renseigez ce champs");
//        } else {
//            l6.setText(" ");
//        }
//        String p = txtPassword.getText();
//        if (!txtpassword2.getText().equals(p)) {
//            l6.setText("Le Mot de passe n'est pas identique!!");
//        } else {
//            l6.setText(" ");
//        }
//        System.out.println(txtNom.getText());
         Organisme o2=new Organisme();
                 if(!textFieldEmpty(txtNom,l1)&&!textFieldEmpty(txtLogin,l4)&&!textFieldEmpty(txtPassword,l5)&&!textFieldEmpty(txtpassword2,l6)&&!textFieldEmpty(txtEmail,l3)&&!textFieldEmpty(txtAdresse,l2)){

       Organisme o1 = new Organisme(o2.getId(),txtNom.getText(), txtLogin.getText(), txtPassword.getText(), txtEmail.getText(), txtAdresse.getText(),document,0);
      
       DAOOrganisme d1 = new DAOOrganisme();
       d1.addOrganisme(o1);

          ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/validationMsg.fxml"));
        Stage st = new Stage();
        Scene sc = new Scene(parent);
        st.setScene(sc);
        st.setTitle("validationMsg");
        st.show();
                 }
                  else {
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                        alert.setTitle("Erreur");
                                        alert.setHeaderText(null);
                                        alert.setContentText("Un champ est vide");
                                        alert.showAndWait();
                                    }
        
        
         
                
    }

    public void btnAnullerAction(ActionEvent event) {
        txtNom.setText("");
        txtLogin.setText("");
        txtAdresse.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtpassword2.setText("");

    }

  

    public void btnChoisireAction() throws IOException {
        
        FileChooser fileChooser = new FileChooser();

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
 Random r;
                String letters;
                r = new Random();
                letters = "abcdefghijklmnopqrstuvwxyz";
                 StringBuilder nom = new StringBuilder("") ;
                for(int i = 0; i < 5; i++)
                {
                    nom.append(letters.charAt(r.nextInt(letters.length())));
                }
            fileChooser.setTitle("Open resource file");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.pdf"));
            Organisme o = new Organisme();
            if (selectedFile != null) {
                File path = selectedFile.getAbsoluteFile();
                document=nom+selectedFile.getName();
                l7.setText("File selected: " + selectedFile.getName());
               o.setDocument(l7.getText());
               
               
               
               
                  String url = "src/pidev/gui/pdf/"+ selectedFile.getName();
                Path des = Paths.get(url);
                Path source = Paths.get(selectedFile.getAbsolutePath());
                Files.copy(source , des);
            }
            else {

    l7.setText("File selection cancelled.");

}

        }

    }


}
