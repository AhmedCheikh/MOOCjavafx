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
import java.nio.file.LinkOption;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pidev.dao.classes.DAOFormateur;
import pidev.entities.Formateur;

/**
 * FXML Controller class
 *
 * @author akoubi
 */
public class EditProfilFormateurController implements Initializable {

    @FXML
    private TextField txtCin;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtMail;
    @FXML
    private TextField txtLogin;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtRepaet;
    //declation des labels
    @FXML
    private Label er1;
    @FXML
    private Label er2;
    @FXML
    private Label er3;
    @FXML
    private Label er4;
    @FXML
    private Label er5;
    @FXML
    private Label er6;
    @FXML
    private Label er7;
    @FXML
    private Label er8;

    public static String avatar;

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public static String CheminAv;

    public void setCheminAv(String CheminAv) {
        this.CheminAv = CheminAv;
    }
    
    public static String url;

    public void setUrl(String url) {
        this.url = url;
    }

//    public static String nomAv;
//
//    public void setNomAv(String nomAv) {
//        this.nomAv = nomAv;
//    }

    private Formateur fedit;
    DAOFormateur daof = new DAOFormateur();
    Formateur f2 = new Formateur();

    @FXML
    public void btnChoisirAvatarAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open resource file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.jpg"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            String path = selectedFile.getName();
            er8.setText(selectedFile.getAbsolutePath());
            String ur = selectedFile.getAbsolutePath();
            String nomimg = "C:/Users/akoubi/Documents/NetBeansProjects/MOOC_3A2-master-0325060b914cc6125f9059397e5f87da2754141e/src/pidev/avatar/"+selectedFile.getName();
            setCheminAv(nomimg);
            setUrl(ur);
            setAvatar(path);
        } else {
            er8.setText("File Invalide");
        }
    }

    @FXML
    public void btnModifierAction(ActionEvent event) throws IOException {
        Formateur fr = new Formateur(txtCin.getText(), txtNom.getText(), txtPrenom.getText(), txtMail.getText(), txtLogin.getText(), txtPassword.getText(), avatar);
        daof.EditerProfil(fr);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Path source = Paths.get(url);
        System.out.println(source.toRealPath(LinkOption.NOFOLLOW_LINKS));
        Path destination = Paths.get(CheminAv);
        Files.copy(source, destination);
        alert.setTitle("Mise a jour");
        alert.setHeaderText(null);
        alert.setContentText("Votre Profil a été mise a jour vous devez Reconnecté");
        alert.showAndWait();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/FXMLAuthentification.fxml"));
        Stage st = new Stage();
        Scene sc = new Scene(parent);
        st.setScene(sc);
        st.show();
    }

    @FXML
    public void btnAnullerAction(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setF(Formateur f) {
        txtCin.setText(f.getCinFormateur());
        txtCin.setDisable(true);
        f2 = daof.getFormateurByCIN(f.getCinFormateur());
        txtNom.setText(f2.getNom());
        txtPrenom.setText(f2.getPrenom());
        txtMail.setText(f2.getMail());
        txtLogin.setText(f2.getLogin());
        this.fedit = f;
    }

}
