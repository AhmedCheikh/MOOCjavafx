
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

public class test extends Application{

//    @Override
//    public void start(Stage stage) throws Exception {
//     Parent root = FXMLLoader.load(getClass().getResource("/pidev/gui/InscrireFormateur.fxml"));
//        Scene scene = new Scene(root);        
//        stage.setScene(scene);
//        stage.setTitle("Inscrirption Formateur");
//        stage.show();
//    }
    public void start(Stage stage) throws Exception {
     Parent root = FXMLLoader.load(getClass().getResource("/pidev/gui/FXMLAffichageCours.fxml"));
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        stage.setTitle("Authentification");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
        
    
        
    }
}
