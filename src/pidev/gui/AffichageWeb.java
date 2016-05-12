/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gui;

import static pidev.gui.TestRSS.ch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Gumus
 */
public class AffichageWeb extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
      
        Pane p = new Pane();
          final WebView browser = new WebView();
          browser.setMinSize(1000, 600);
        final WebEngine webEngine = browser.getEngine();
         webEngine.load(ch);
         Label lb = new Label("Retour");
         lb.setStyle("-fx-font-size: 15 pt; -fx-text-fill: blue;");
         lb.setAlignment(Pos.TOP_LEFT);
         lb.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
               
                try {
                   primaryStage.hide();
                    String[] args = null;
 
                } catch (Exception ex) {
                    Logger.getLogger(AffichageWeb.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
         
         p.getChildren().add(browser);
         p.getChildren().add(lb);
         Scene scene = new Scene(p, 1000, 600);
         primaryStage.setScene(scene);
         primaryStage.show();
    }
    
}
