/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.tests;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pidev.dao.classes.DAOOrganisme;
import pidev.entities.Organisme;

/**
 *
 * @author Rimy Jeljeli
 */
public class TestRimMeymisha7ad {
//extends Application{
//    
//       @Override
//   public void start(Stage stage) throws Exception {
//     Parent root = FXMLLoader.load(getClass().getResource("./gui/PreinscrIreOrganisme.fxml"));
//        Scene scene = new Scene(root);        
//        stage.setScene(scene);
//        stage.setTitle("Inscrirption Formateur");
//        stage.show();
    
    public static void main(String[] args) {
        
//        launch();
       DAOOrganisme d = new DAOOrganisme();
     Organisme o = new Organisme(3,"aaa","sdsd","String password","String email","String siteweb","String adresse","String telephone","String description",null,null,8);
       d.addOrganisme(o); 
//          
      
        
    }

 
}
