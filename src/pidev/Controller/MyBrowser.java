
package pidev.Controller;

import javafx.beans.value.ChangeListener;

import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import netscape.javascript.JSObject;

public class MyBrowser extends Region{
      HBox toolbar;
        VBox toolbox;
    static Stage popup ;
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        public MyBrowser(int i){
            
        }
        public MyBrowser(){
            popup = new Stage();
            webEngine.setCreatePopupHandler((PopupFeatures p) -> {
        WebView wv2 = new WebView();
        popup.setScene(new Scene(wv2,450,250));
        popup.show();
        
        
        return wv2.getEngine();
        });
            //final URL urlHello = getClass().getResource("http://localhost/facebook/");
            webEngine.load("http://localhost/facebook.html");
             
            webEngine.getLoadWorker().stateProperty().addListener((ObservableValue<? extends Worker.State> ov, Worker.State oldState, Worker.State newState) -> {
                if(newState == Worker.State.SUCCEEDED){
                    JSObject window = (JSObject)webEngine.executeScript("window");
                    window.setMember("app", new JavaApplication());
                }
            });
             
             
            JSObject window = (JSObject)webEngine.executeScript("window");
            window.setMember("app", new JavaApplication());
             
            final TextField textField = new TextField ();
            textField.setPromptText("Hello! Who are?");
             
            Button buttonEnter = new Button("Enter");
            buttonEnter.setOnAction(new EventHandler<ActionEvent>(){
                 
                @Override
                public void handle(ActionEvent arg0) {
                    webEngine.executeScript( " updateHello(' " + textField.getText() + " ') " );
                }
            });
             
            Button buttonClear = new Button("Clear");
            buttonClear.setOnAction(new EventHandler<ActionEvent>(){
                 
                @Override
                public void handle(ActionEvent arg0) {
                    webEngine.executeScript( "clearHello()" );
                }
            });
             
            toolbar = new HBox();
            toolbar.setPadding(new Insets(10, 10, 10, 10));
            toolbar.setSpacing(10);
            toolbar.setStyle("-fx-background-color: #336699");
            toolbar.getChildren().addAll(textField, buttonEnter, buttonClear);
             
            toolbox = new VBox();
            
             
            getChildren().add(toolbox);
            getChildren().add(webView);
             
        }
         public void close(){
             popup.hide();
         }
        @Override
        protected void layoutChildren(){
            double w = getWidth();
            double h = getHeight();
            double toolboxHeight = toolbox.prefHeight(w);
            layoutInArea(webView, 0, 0, w, h-toolboxHeight, 0, HPos.CENTER, VPos.CENTER);
            layoutInArea(toolbox, 0, h-toolboxHeight, w, toolboxHeight, 0, HPos.CENTER, VPos.CENTER);
        }
}
