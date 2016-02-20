
package pidev.tests;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.User;
import java.util.logging.Logger;
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
//     Parent root = FXMLLoader.load(getClass().getResource("/pidev/gui/FXMLPageAcceuille.fxml"));
     Parent root = FXMLLoader.load(getClass().getResource("/pidev/gui/AfficherCoursEtChapitreApprenant.fxml"));
     
        Scene scene = new Scene(root);        
        stage.centerOnScreen();
        
       
        stage.getIcons().add(new Image("/pidev/gui/img/icone.png"));
//        root.setStyle("-fx-background-image: url(/pidev/gui/img/moocBack.png ); " +
//           "-fx-background-position: center center; " +
//           "-fx-background-repeat: stretch;");
        stage.setScene(scene);


        stage.setTitle("Welcome !");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        String accesstoken="CAAL8ZCtdpy2QBAP7PgCizW72wekEYaie28i2do1yhphgtdE4G9xVsRZBzMbOizXupksEGD8ifbodV2fBd6D7gAR0fQC3W1ayzrZAZAwYCrLrYZB4m2EABPTLYRus18hyXLaJeTuLZBnBUqLKNMPrEZAzWi2FGNdtZADdSXNry8Kz8hrqZAdAOhpptpbBzZAGCcIkoZD";
        FacebookClient fbClient= new DefaultFacebookClient(accesstoken);
//        User me=fbClient.fetchObject("me", User.class);
//        System.out.println(me.getName());
AccessToken exAccessToken= fbClient.obtainExtendedAccessToken("841121419348836","511eb843c98cee4e53fcb83240b27c13");
        System.out.println(exAccessToken.getAccessToken());
        System.out.println(exAccessToken.getExpires());
        

}
}
