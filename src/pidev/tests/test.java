
package pidev.tests;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pidev.entities.*;
import pidev.dao.classes.*;
import pidev.techniques.DataSource;

public class test extends Application
{

    @Override
    public void start(Stage stage) throws Exception {
     Parent root = FXMLLoader.load(getClass().getResource("/pidev/gui/PreInscrireOrganisme.fxml"));
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        stage.setTitle("Inscrirption organisme");
        stage.show();
    }
//    public void start(Stage stage) {
////            throws Exception {
////     Parent root = FXMLLoader.load(getClass().getResource("/pidev/gui/PreInscrireOrganisme.fxml"));
////        Scene scene = new Scene(root);        
////        stage.setScene(scene);
////        stage.setTitle("Pre-Inscription Organisme");
////        stage.show();
//    }
    
    public static void main(String[] args) {
        launch(args);
//        launch();
        
//    try {
//        DAOOrganisme d = new DAOOrganisme();
//        Organisme o = new Organisme(3,"zzzz","sdsd","String password","String email","String siteweb","String adresse","String telephone","String description",null,null,8);
//        d.addOrganisme(o); 
//          
//        } catch (Exception e) {
//            System.out.println("lerreur est "+e.getMessage());
//        }
//        
//    }
}
}