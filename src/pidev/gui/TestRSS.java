/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gui;

import pidev.dao.classes.RSSReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import static pidev.dao.classes.RSSReader.readRSS;

/**
 *
 * @author Gumus
 */
public class TestRSS extends Application {

    public static String ch;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Map<String, String> rss = new HashMap<>();
        rss.putAll(RSSReader.readRSS("http://eduscol.education.fr/rid272/les-ressources-du-site.rss"));
        Set<String> key = rss.keySet();
        BorderPane bp = new BorderPane();
        Pane p = new Pane();
        Image image = new Image("file:///C:/Users/Nour/Pictures/rss.jpg");
        ImageView imageV = new ImageView(image);
        imageV.setFitHeight(50);
        imageV.setFitWidth(50);
        imageV.setTranslateX(950);
        imageV.setTranslateY(0);
        imageV.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                int k = 0;
                ContextMenu cm = new ContextMenu();

                for (String title : key) {
                    Hyperlink hl = new Hyperlink(title);

//                        hl.setTranslateX(10);
//                        hl.setTranslateY(10+k);
//                        k+=20;
                    CustomMenuItem mihl = new CustomMenuItem();
                    mihl.setContent(hl);
                    // mihl.set
                    cm.getItems().add(mihl);
                    mihl.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            hl.setStyle("-fx-text-fill: red");
                        }
                    });

                    hl.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            AffichageWeb aWeb = new AffichageWeb();
                            ch = rss.get(title);
                            try {
                                aWeb.start(primaryStage);
                            } catch (Exception ex) {
                                Logger.getLogger(TestRSS.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                    p.getChildren().add(hl);
                        ScrollPane sp =new ScrollPane();
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setContent(cm.getOwnerNode());
                    cm.show(imageV, Side.BOTTOM, imageV.getX() - 650, imageV.getY());
                }

            }
        });

        p.getChildren().add(imageV);

        Scene scene = new Scene(p, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
