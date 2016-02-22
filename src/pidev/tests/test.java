
package pidev.tests;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class test extends Application
{

    @Override
    public void start(Stage stage) throws Exception {
     Parent root = FXMLLoader.load(getClass().getResource("/pidev/gui/ProfilAdministrateur.fxml"));
//     Parent root = FXMLLoader.load(getClass().getResource("/pidev/gui/AfficherCoursEtChapitreApprenant.fxml"));
     
        Scene scene = new Scene(root);        
        stage.centerOnScreen();
        
       
        stage.getIcons().add(new Image("/pidev/gui/img/icone.png"));
        root.setStyle("-fx-background-image: url(/pidev/gui/img/moocBack.png ); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        stage.setScene(scene);


        stage.setTitle("Welcome !");
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);

        

}
}
