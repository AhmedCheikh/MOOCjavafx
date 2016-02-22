
package pidev.Controller;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import pidev.dao.classes.DAOAdministrateur;
import pidev.dao.interfaces.IDAOAdministrateur;

/**
 * FXML Controller class
 *
 * @author WiKi
 */
public class LineChartController implements Initializable {
    @FXML LineChart lineChart ; 
    @FXML private CategoryAxis categoryAxis ; 
    @FXML private NumberAxis numberAxis ; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lineChart.setTitle("Croissance des cours suivis");
        categoryAxis.setLabel("Mois");
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
        IDAOAdministrateur adminDAO = new DAOAdministrateur();
        lineChart.setData(adminDAO.dataChartSecond());
        
    }    
    
}
