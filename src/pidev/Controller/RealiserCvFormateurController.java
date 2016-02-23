/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPHeaderCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author akoubi
 */
public class RealiserCvFormateurController implements Initializable {

    @FXML
    private Button btnCrerCv;
    @FXML
    private Button btnAnuller;
    @FXML
    private ImageView imgPhoto;
    @FXML
    private TextField txtLangue;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtnumtel;
    @FXML
    private TextField txtadresse;
    @FXML
    private TextField txtage;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtnom;
    @FXML
    private TextArea txtFormation;
    @FXML
    private TextArea txtExpPro;
    @FXML
    private Pane pnImgPro;
    @FXML
    private Button btnChoisirphoto;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnback;

//    public static String nom;
//    public static String prennom;
//    public static String age;
//    public static String adresse;
//    public static String numTel;
//    public static String email;
//    public static String langue;
//    public static String formation;
//    public static String exppro;
//    
    public static String imgProfil;

    public void setimgProfil(String imgProfil) {
        this.imgProfil = imgProfil;
    }

    @FXML
    private void btnChoisirphotoAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open resource file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.jpg"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            String path = selectedFile.getAbsolutePath();
            setimgProfil(path);
            pnImgPro.setStyle("-fx-background-image:url('/"+path+"');-fx-background-position: center center; -fx-background-repeat:stretch;-fx-background-size: 150 150; -fx-effect: dropshadow(three-pass-box, #FFDA8C, 30, 0.5, 0, 0);");                 
        } else {
            System.out.println("File Invalide");
        }
    }

    public void CreerPdf() throws DocumentException, FileNotFoundException, BadElementException, IOException {

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("Cv" + txtnom.getText() + ".pdf"));
        document.open();
        Image image = Image.getInstance(imgProfil);
        image.scaleAbsolute(50, 50);
        image.setAbsolutePosition(500f, 750f);
        document.add(image);
        document.add(new Paragraph("                                                                            Curriculum Vité"));
        document.add(new Paragraph("Nom: " + txtnom.getText()));
        document.add(new Paragraph("Prenom: " + txtprenom.getText()));
        document.add(new Paragraph("Age: " + txtage.getText()));
        document.add(new Paragraph("Adresse: " + txtadresse.getText()));
        document.add(new Paragraph("Num Tel: " + txtnumtel.getText()));
        document.add(new Paragraph("Email: " + txtemail.getText()));
        document.add(new Paragraph("Langues parlées: " + txtLangue.getText()));
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("---"));
        PdfPTable table = new PdfPTable(2);
        PdfPCell cell1 = new PdfPCell();
        PdfPHeaderCell pdfhcell = new PdfPHeaderCell();
        pdfhcell.addElement(new Paragraph("Ma Formation"));
        cell1.addHeader(pdfhcell);
        cell1.addElement(new Paragraph("Ma Formation: "+txtFormation.getText()));

        PdfPCell cell2 = new PdfPCell();
        PdfPHeaderCell pdfhcell2 = new PdfPHeaderCell();
        pdfhcell.addElement(new Paragraph("Mon Expérience: "));
        cell1.addHeader(pdfhcell2);
        cell2.addElement(new Paragraph("Mon Expérience: "+txtExpPro.getText()));

        table.addCell(cell1);
        table.addCell(cell2);
        document.add(table);
        document.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void btnCrerCvAction(ActionEvent event) throws DocumentException, BadElementException, IOException {
        CreerPdf();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION); 
        alert.setTitle("Création CV");
         alert.setHeaderText(null);
         alert.setContentText("Votre Cv a été créer avec sucès");
         alert.showAndWait();
    }

    @FXML
    private void btnAnullerAction(ActionEvent event) {
        txtnom.clear();
        txtprenom.clear();
        txtage.clear();
        txtadresse.clear();
        txtnumtel.clear();
        txtemail.clear();
        txtLangue.clear();
        txtFormation.clear();
        txtExpPro.clear();
    }

    @FXML
    private void btnexitAction(ActionEvent event) {

    }

    @FXML
    private void btnbackAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/InscrireFormateur.fxml"));
        Stage st = new Stage();
        Scene sc = new Scene(parent);
        st.setScene(sc);
        st.show();
    }

}
