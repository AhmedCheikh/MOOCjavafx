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
import java.util.Random;
import java.util.ResourceBundle;
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
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnAnuller;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;
    @FXML
    private Button btnChoisirAvatar;
    
    Alert alert = new Alert(Alert.AlertType.WARNING);

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

    public boolean textFieldEmpty(TextField i) {
        boolean r = false;
        if (i.getText() != null && !i.getText().isEmpty()) {
            r = true;
            i.setStyle("-fx-border-color:#84D41D");
        }
        return r;
    }

    public boolean textFieldEmpty(TextField i, Label l, String sValidationText) {
        boolean r = true;
        String c = null;
        if (!textFieldEmpty(i)) {
            r = false;
            c = sValidationText;
            i.setStyle("-fx-border-color:red");

        }
        l.setText(c);
        return r;
    }

    public boolean validationCin(TextField txtf) {
        boolean verif = false;
        Pattern p = Pattern.compile("[0-9]{8}");
        Matcher m = p.matcher(txtCin.getText());
        if (m.find() && m.group().equals(txtf.getText())) {
            verif = true;
            txtf.setStyle("-fx-border-color:#84D41D");
            //paneImg1.setStyle("-fx-background-image: url(pidev/gui/img/vrai.png)");
        }
        return verif;
    }

    public boolean validationCin(TextField ft, Alert alert, String msg) {
        boolean verif = true;
        if (!validationCin(ft)) {
            verif = false;
            alert.setTitle("Validation CIN");
            alert.setHeaderText(null);
            alert.setContentText(msg);
            ft.setText("");
            ft.setStyle("-fx-border-color:red");
            alert.showAndWait();
        }
        return verif;
    }

    public boolean validationEmail(TextField txte) {
        boolean verife = false;
        Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher m = p.matcher(txte.getText());
        if (m.find() && m.group().equals(txte.getText())) {
            verife = true;
            txte.setStyle("-fx-border-color:#84D41D");
            //paneImg2.setStyle("-fx-background-image: url(pidev/gui/img/vrai.png)");
        }
        return verife;
    }

    public boolean validationEmail(TextField txtem, Label el, String sValidationEmail) {
        boolean verife = true;
        String str = null;
        if (!validationEmail(txtem)) {
            str = sValidationEmail;
            txtem.setStyle("-fx-border-color:red");
        }
        el.setText(str);
        return verife;
    }

    private Formateur fedit;
    DAOFormateur daof = new DAOFormateur();
    Formateur f2 = new Formateur();

    @FXML
    public void btnChoisirAvatarAction() throws IOException {
        Random rd = new Random();
        int n = rd.nextInt(100000) + 1;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open resource file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.jpg"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            String path = selectedFile.getName();
            er8.setText(selectedFile.getAbsolutePath());
            String ur = selectedFile.getAbsolutePath();
            Path nomdos = Paths.get("src/pidev/avatar");
//            C:/Users/akoubi/Documents/NetBeansProjects/MOOC_3A2-master-0325060b914cc6125f9059397e5f87da2754141e/src/pidev/avatar/          
            if(!Files.exists(nomdos)){
            Files.createDirectories(nomdos);
            String nomimg = nomdos+"/" +n+selectedFile.getName();
            setCheminAv(nomimg);
            setUrl(ur);
            setAvatar(n+path);
            }else{
            String nomimg = nomdos+"/" +n+selectedFile.getName();
            setCheminAv(nomimg);
            setUrl(ur);
            setAvatar(n+path);
            }
        } else {
            er8.setText("File Invalide");
        }
    }

    @FXML
    public void btnModifierAction(ActionEvent event) throws IOException {
        boolean nom = textFieldEmpty(txtNom, er2, "Ce champs doit etre remplie");
        boolean prenom = textFieldEmpty(txtPrenom, er3, "Ce champs doit etre remplie");
        boolean login = textFieldEmpty(txtLogin, er5, "Ce champs doit etre remplie");
        boolean password = textFieldEmpty(txtPassword, er6, "Ce champs doit etre remplie");
        boolean repeat = textFieldEmpty(txtRepaet, er7, "Ce champs doit etre remplie");
        boolean cin = validationCin(txtCin, alert, "CIN non Valide");
        boolean email = validationEmail(txtMail, er4, "Email Invalide");
        if (cin && nom && prenom && email && login && password && repeat) {
            if (txtPassword.getText().equals(txtRepaet.getText())) {
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

            } else {
                er7.setText("Les 2 mots de passe ne sont pas identiques");
                txtPassword.setStyle("-fx-border-color:red");
                txtRepaet.setStyle("-fx-border-color:red");
            }
        }
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

    @FXML
    private void btnexitAction(ActionEvent event) {
        Stage stage = (Stage) btnexit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnbackAction(ActionEvent event) throws IOException {
        Formateur f = new Formateur(txtCin.getText());
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ProfilFormateur.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        ProfilFormateurController pfc = loader.getController();
        pfc.setF(f);
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();
    }

}
