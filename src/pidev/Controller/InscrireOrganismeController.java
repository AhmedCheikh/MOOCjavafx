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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
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
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
  
  
 
        
    @FXML
    private TextField txtTel;
    @FXML
    private TextField txtSite;
   
  @FXML
  private TextArea txtDesc;
  @FXML
  private Button btnDeconnecter;
   
    @Override
    public void initialize(URL location, ResourceBundle resources) { }


    public void btnValiderAction(ActionEvent event){
    
    
        if (txtTel.getText().isEmpty()) {
        l1.setText("Vous devez Renseigez ce champs");
         DropShadow shadow = new DropShadow();
               shadow.setColor(Color.RED);
txtTel.setEffect(shadow);
        }else if (txtSite.getText().isEmpty()) {
            l2.setText("Vous devez Renseigez ce champs");
      DropShadow shadow = new DropShadow();
               shadow.setColor(Color.RED);
txtSite.setEffect(shadow);
       
        }else if (txtDesc.getText().isEmpty()) {
        l3.setText("Vous devez Renseigez ce champs");
         DropShadow shadow = new DropShadow();
               shadow.setColor(Color.RED);
txtDesc.setEffect(shadow);
        }else{
      
            Organisme o= new Organisme();
                Organisme o1 = new Organisme(0,txtTel.getText(),txtSite.getText(), txtDesc.getText());
                DAOOrganisme d1 = new DAOOrganisme();
                
                
                
                d1.updateOrganismeInscription(o1);
        }
        
            
                 

//         ((Node) (event.getSource())).getScene().getWindow().hide();
//            Parent parent;
//     
//            parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ProfileOrganismeA.fxml"));
//      
//            Stage stage =  new Stage();
//            Scene scene = new Scene(parent);
//            stage.setScene(scene);
//            stage.setTitle("Profil Organisme");
//            stage.show();
   }

  public void btnAnullerAction(ActionEvent event){
    txtTel.setText("");
    txtSite.setText("");
    txtDesc.setText("");
     
   
    }
     @FXML
    private void btnDeconnecterAction(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Warning");
alert.setHeaderText("Your are leaving application !");
alert.setContentText("Are you sure to leave?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    
       Stage stage = (Stage) btnDeconnecter.getScene().getWindow();
    
    stage.close();
    
} else {
   alert.close();
}
        
    }

    @FXML
    private void btnbackAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/pidev/gui/FXMLPageAcceuille.fxml"));
        loader.load();
        Parent p = loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.getIcons().add(new javafx.scene.image.Image("pidev/gui/img/icone.png"));
        stage.setTitle("Page Acceuille");
        
        stage.show();
    }
    public void  btnChoisireImgAction(){
        FileChooser fileChooser = new FileChooser();

File selectedFile = fileChooser.showOpenDialog(null);

 

if (selectedFile != null) {

 

    l4.setText("File selected: " + selectedFile.getName());

}

else {

    l4.setText("File selection cancelled.");

}

    }
   
}
