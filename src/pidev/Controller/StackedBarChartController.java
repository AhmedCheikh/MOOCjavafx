/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.util.Duration;
import pidev.dao.classes.DAOAdministrateur;
import pidev.dao.interfaces.IDAOAdministrateur;

/**
 * FXML Controller class
 *
 * @author WiKi
 */

public class StackedBarChartController implements Initializable {

    @FXML private StackedBarChart<String,Number> stackedBarChart ; 
    @FXML private CategoryAxis categoryAxis ; 
    @FXML private NumberAxis numberAxis ; 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stackedBarChart.setTitle("Cours suivis au cours de l'année");
        stackedBarChart.getXAxis().setLabel("Mois");
        categoryAxis.setCategories(FXCollections.<String> observableArrayList(Arrays.asList(
        "Janvier",
        "Fevrier",
        "Mars",
        "Avril",
        "Mai",
        "Juin",
        "Juillet",
        "Aout", 
        "Septembre",
        "Octobre",
        "Novembre",
        "Décembre"
        )));
       numberAxis.setLabel("Nombre de cours");
       
//       XYChart.Series<String,Number> series1 = new XYChart.Series();
//        series1.setName("Android");
//           
//        series1.getData().add(new XYChart.Data("Janvier", 5));
//        series1.getData().add(new XYChart.Data("Février", 13));
//        series1.getData().add(new XYChart.Data("Mars", 17));
//          
//        XYChart.Series<String,Number> series2 = new XYChart.Series();
//        series2.setName("Windows Phone");
//           
//        series2.getData().add(new XYChart.Data("Janvier", 3));
//        series2.getData().add(new XYChart.Data("Février", 7));
//        series2.getData().add(new XYChart.Data("Mars", 12));
//          stackedBarChart.getData().addAll(series1, series2);
       
        IDAOAdministrateur adminDAO = new DAOAdministrateur();
        stackedBarChart.setData(adminDAO.dataChart());
   
    }    
    
}
