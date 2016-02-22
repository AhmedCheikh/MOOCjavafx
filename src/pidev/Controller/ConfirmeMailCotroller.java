/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import com.sun.mail.handlers.image_gif;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pidev.dao.classes.DAOApprenant;
import pidev.dao.classes.DAOFormateur;
import pidev.dao.classes.DAOOrganisme;
import pidev.entities.Organisme;

/**
 *
 * @author Rimy Jeljeli
 */
public class ConfirmeMailCotroller implements Initializable{
    
    @FXML
    private ImageView img;
    @FXML
    private TextField codetxt;

    private Organisme org; 
    DAOOrganisme daoo = new DAOOrganisme();
    DAOFormateur daof=new DAOFormateur();
    DAOApprenant daoap=new DAOApprenant();
    Organisme o = new Organisme();
    @FXML
    private Button btnEnvoyer;
    @FXML
    private Button btnValider;
    @FXML
    private Label np;

    
//    public void setOrg(Organisme org) {
//        np.setText(org.getLogin());
//        o2 = daoo.getOrganisme(org.getLogin());
//        this.org = org;
//    }
    
   
    
      float x=1111111+(int) (Math.random() * (999999-111111)) ;
      String s = "" +x;
    @FXML
    public void btnEnvoyerAction(Event event){
      
       String type=RetrouverCompteController.type;
       if(type.equals("organisme")){
            String email= daoo.getEmailByLogin(RetrouverCompteController.log);
               System.out.println(""+email);
              daoo.envoyerMsg(email,"Code de confirmation", s);
       }
       
       else if(type.equals("apprenant")){
            String email= daoap.getEmailByLogin(RetrouverCompteController.log);
               System.out.println(""+email);
              daoo.envoyerMsg(email,"Code de confirmation", s);
       }
        else {
           String email= daof.getEmailByLogin(RetrouverCompteController.log);
               System.out.println(""+email);
              daoo.envoyerMsg(email,"Code de confirmation", s);
       }
      
               
    }
    @FXML
    public void btnValiderAction (Event event) throws IOException{
        if(codetxt.getText().equals(s)){
             ((Node) (event.getSource())).getScene().getWindow().hide();
                Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ModifPwd.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
                stage.setScene(scene);
                stage.setTitle("Modifier password");
                stage.show(); 
        }
        else
        {
             DropShadow shadow = new DropShadow();
               shadow.setColor(Color.RED);
codetxt.setEffect(shadow);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        np.setText(RetrouverCompteController.log);
    }
}
