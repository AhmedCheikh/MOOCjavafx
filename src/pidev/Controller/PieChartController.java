/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pidev.dao.classes.DAOAdministrateur;
import pidev.dao.interfaces.IDAOAdministrateur;

/**
 * FXML Controller class
 *
 * @author WiKi
 */
public class PieChartController implements Initializable {
    
    @FXML private PieChart pieChart;
    @FXML private ObservableList<PieChart.Data> dataCours;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        ObservableList<PieChart.Data> pieChartData = 
//                FXCollections.observableArrayList(
//                    new PieChart.Data("Android", 10),
//                    new PieChart.Data("iOS", 7),
//                    new PieChart.Data("Windows Phone", 4),
//                    new PieChart.Data("J2ME", 2));
        IDAOAdministrateur administrateurDAO = new DAOAdministrateur();
        dataCours = administrateurDAO.pieChart();
        pieChart.setTitle("Répartition des thématiques");
        pieChart.setData(dataCours);
        
        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");

        pieChart.getData().stream().forEach((data) -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                caption.setTranslateX(e.getSceneX());
                caption.setTranslateY(e.getSceneY());
                caption.setText(String.valueOf(data.getPieValue()) + "%");
            });
        });
        
    }    
    
}
