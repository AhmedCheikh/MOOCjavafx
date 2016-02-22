/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import pidev.entities.Organisme;
/**
 *
 * @author WiKi
 */
public interface IDAOAdministrateur {
    
    void validerPreinscriOrganisme(Organisme o) ; 
    boolean authentification(String login, String password);
    public ObservableList pieChart();
    public List<Organisme> findAll();
    public void downloadDocument(Organisme o);

  
    public ObservableList<XYChart.Series<String, Number>> dataChart();
    public ObservableList<XYChart.Series<String, Number>> dataChartSecond() ; 
    
}
