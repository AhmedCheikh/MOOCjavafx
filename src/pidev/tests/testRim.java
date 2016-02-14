/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author Rimy Jeljeli
 */
public class testRim {
    
    
    public static void main(String[] args) {
      
        DAOOrganisme d1=new DAOOrganisme();
     int a= d1.getEtat("rim");
       
    }
}
