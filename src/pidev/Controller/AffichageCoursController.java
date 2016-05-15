/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;

import pidev.dao.classes.*;
import pidev.entities.*;
import pidev.techniques.DataSource;
import pidev.gui.video.*;
import pidev.tests.test;

public class AffichageCoursController implements Initializable {

    @FXML
    private TextArea description;

    @FXML
    private Label labelCours;
    @FXML
    private TableView<Chapitre> table;
    @FXML
    private TableColumn chapitre;
    @FXML
    private TableColumn objectif;
    public String nom;
    public Cours cours;
    public String formateur;
    private Connection connection;
    private Media me;
    @FXML
    private RadioButton radioExcellent;
    @FXML
    private RadioButton radioMoyen;
    @FXML
    private RadioButton radioMauvais;
    @FXML
    private RadioButton radioTresBien;
    @FXML
    private RadioButton radioBien;

    public CoursSuivie cs;
    private ToggleGroup appreciation;
    public Apprenant apprenant;
    @FXML
    private Button btnVideo;
    @FXML
    private Button faireQuiz;
    @FXML
    private Button Formateur1;

    @FXML
    private TextField txtNote;
    @FXML
    private TextArea txtCommentaire;
    @FXML
    private Label txtJour;

    @FXML
    private TextField txtDateDebut;
    @FXML
    private TextField txtDateFin;

    public AffichageCoursController() {
        connection = (DataSource.getInstance()).getConnection();

    }
//   private String MEDIA_URL ="http://download.oracle.com/otndocs/javafx/JavaRap_ProRes_H264_768kbit_Widescreen.mp4";
    public static String pathFile;

    private MediaPlayer mediaPlayer;
    final double mediaWidth = 480;
    final double mediaHeight = 270;
    int idquiz;

    public void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root, 480, 270));
        String path = new File("src/pidev/gui/video/" + pathFile).getAbsolutePath();
        me = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(me);

        mediaPlayer.setAutoPlay(true);
        VideoFXDemo.PlayerPane playerPane = new VideoFXDemo.PlayerPane(mediaPlayer);
        playerPane.setMinSize(mediaWidth, mediaHeight);
        playerPane.setPrefSize(mediaWidth, mediaHeight);
        playerPane.setMaxSize(mediaWidth, mediaHeight);

        root.getChildren().add(playerPane);
    }

    public void play() {
        MediaPlayer.Status status = mediaPlayer.getStatus();
        if (status == MediaPlayer.Status.UNKNOWN || status == MediaPlayer.Status.HALTED) {
            return;
        }
        if (status == MediaPlayer.Status.PAUSED || status == MediaPlayer.Status.STOPPED || status == MediaPlayer.Status.READY) {
            mediaPlayer.play();
        }
    }

//    @Override public void stop() {
//        mediaPlayer.stop();
//    }
    @FXML
    private void btnVideoAction(ActionEvent event) {

        Stage stage = new Stage();
        init(stage);
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        stage.setTitle("VIDEO");
        stage.show();
        play();
    }

    @FXML
    private void faireQuizAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/AfficherQuizChrono.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(AfficherCoursEtChapitreApprenantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        stage.setTitle("Faire Quiz");
        AfficherQuizChronoController pac = loader.getController();
        System.out.println("idddddddquizz" + cours.getIdQuiz());
        pac.setCours(1);
        stage.show();
    }

    @FXML
    private void Formateur1Action(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/ProfilFormateur.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(AfficherCoursEtChapitreApprenantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
        stage.setTitle("Profil Formateur");
        ProfilFormateurController pac = loader.getController();
//            pac.setFormateur(formateur);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        DAOCoursSuivie dcs = new DAOCoursSuivie();
//        cs = new CoursSuivie();
//    try {
//        cs = dcs.getCourByCinApprenant("01478520");
//        txtDateDebut.setText(cs.getDate_debut().toString());
//        
//        txtCommentaire.setText(cs.getCommentaire());
//        txtNote.setText(Float.toString(cs.getNote()));
//        if(cs.getAppreciation().equals("Mauvais")){
//            radioMauvais.setSelected(true);
//        }
//        else if(cs.getAppreciation().equals("Moyen") ){
//            radioMoyen.setSelected(true);
//        }
//        else{
//            radioExcellent.setSelected(true);
//        }
//        
//        
//    } catch (SQLException ex) {
//        Logger.getLogger(AffichageCoursController.class.getName()).log(Level.SEVERE, null, ex);
//    }

    }

    public void setCours(Cours cours) throws SQLException {

        this.cours = cours;
        labelCours.setText(cours.getNomCours());
        description.setText(cours.getDescription());
        formateur = cours.getCinFormateur();
        nom = cours.getNomCours();
        DAOCours dc=new DAOCours();
         idquiz = dc.findIdQuizByIdcours(cours.getIdCours());
        System.out.println("nouuuuuuur" + idquiz);
        pathFile = cours.getVideo();
        String requete = "select titre,objectif from chapitre ch where ch.idcours=(select idcours from cours where nom_cours='" + nom + "')";

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(requete);

            ResultSet rs = ps.executeQuery();

            List<Chapitre> temp = new ArrayList<>();
            Chapitre c;

            while (rs.next()) {

                c = new Chapitre(rs.getString(1), rs.getString(2));
                temp.add(c);

            }
            final ObservableList<Chapitre> list = FXCollections.<Chapitre>observableList(temp);

            chapitre.setCellValueFactory(new PropertyValueFactory("titre"));

            objectif.setCellValueFactory(new PropertyValueFactory("objectif"));
            table.setItems(list);
            table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Chapitre>() {

                @Override
                public void changed(ObservableValue<? extends Chapitre> observable, Chapitre oldValue, Chapitre newValue) {
                    Chapitre ch = table.getSelectionModel().getSelectedItem();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/pidev/gui/AfficherChapitreApprenant.fxml"));
                    try {
                        loader.load();
                    } catch (IOException ex) {
                        Logger.getLogger(AfficherChapitreApprenantController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Parent p = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(p));
                    stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
                    stage.setTitle("Affichage Chapitre");
                    AfficherChapitreApprenantController pac = loader.getController();
                    pac.setCh(ch);
                    stage.show();
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(AffichageCoursController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnCommenterAction(ActionEvent event) {
        DAOCoursSuivie dcs = new DAOCoursSuivie();

        String c = txtCommentaire.getText();
        dcs.laisserCommentaire(c, cs.getIdCoursuivi());
    }

    public void setApprenant(Apprenant apprenant) {
        DAOCoursSuivie dcs = new DAOCoursSuivie();
        CoursSuivie cs = new CoursSuivie();
        cs = dcs.getCourSuiviByCinApprenantAndCoursId(apprenant.getCin(), cours.getIdCours());
        this.cs = cs;
        txtDateDebut.setText(cs.getDate_debut());
        txtCommentaire.setText(cs.getCommentaire());
        txtNote.setText(Double.toString(cs.getNote()));
        if (cs.getAppreciation() == null) {
            //rien a faire
        } else if (cs.getAppreciation().equals("1")) {
            radioMauvais.setSelected(true);
        } else if (cs.getAppreciation().equals("2")) {
            radioMoyen.setSelected(true);
        } else if (cs.getAppreciation().equals("3")) {
            radioBien.setSelected(true);
        } else if (cs.getAppreciation().equals("4")) {
            radioTresBien.setSelected(true);
        } else {
            radioExcellent.setSelected(true);
        }

        this.apprenant = apprenant;
    }

    @FXML
    private void changerAppreciation(MouseEvent event) {
        DAOCoursSuivie dcs = new DAOCoursSuivie();

        radioMauvais.setToggleGroup(appreciation);
        radioMoyen.setToggleGroup(appreciation);
        radioBien.setToggleGroup(appreciation);
        radioTresBien.setToggleGroup(appreciation);
        radioExcellent.setToggleGroup(appreciation);

        appreciation.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {

                RadioButton chk = (RadioButton) t1.getToggleGroup().getSelectedToggle();
                if (chk.getText().equals("Mauvais")) {
                    dcs.donnerAppreciation("1", cs.getIdCoursuivi());
                } else if (chk.getText().equals("Moyen")) {
                    dcs.donnerAppreciation("2", cs.getIdCoursuivi());
                } else if (chk.getText().equals("Bien")) {
                    dcs.donnerAppreciation("3", cs.getIdCoursuivi());
                } else if (chk.getText().equals("TresBien")) {
                    dcs.donnerAppreciation("4", cs.getIdCoursuivi());
                } else {
                    dcs.donnerAppreciation("5", cs.getIdCoursuivi());
                }
            }
        });

    }

}
