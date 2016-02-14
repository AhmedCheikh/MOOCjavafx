/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
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
    
   
    @Override
    public void initialize(URL location, ResourceBundle resources) { }


    public void btnValiderAction(ActionEvent event){
    
    
        if (txtTel.getText().isEmpty()) {
        l1.setText("Vous devez Renseigez ce champs");
        }else{
        l1.setText(" ");
        }
        if (txtSite.getText().isEmpty()) {
            l2.setText("Vous devez Renseigez ce champs");
       
        }else{
         l2.setText(" ");
        }
        if (txtDesc.getText().isEmpty()) {
        l3.setText("Vous devez Renseigez ce champs");
        }else{
        l3.setText(" ");
        }
        
            System.out.println(txtTel.getText());
            Organisme o= new Organisme();
                Organisme o1 = new Organisme(0,txtTel.getText(),txtSite.getText(), txtDesc.getText());
                DAOOrganisme d1 = new DAOOrganisme();
                
                
                
                d1.updateOrganismeInscription(o1);
                 

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
     public void btnexitAction(ActionEvent event){
    
    }
    public void btnbackAction(ActionEvent event){
    
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
