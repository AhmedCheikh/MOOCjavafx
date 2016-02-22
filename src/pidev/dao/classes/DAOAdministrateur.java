/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import pidev.dao.interfaces.IDAOAdministrateur ; 
import pidev.entities.Cours;
import pidev.entities.Formateur;
import pidev.entities.Organisme;
import pidev.techniques.DataSource;

/**
 *
 * @author WiKi
 */
public class DAOAdministrateur implements IDAOAdministrateur{

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    
        public DAOAdministrateur() {
        connection =(DataSource.getInstance()).getConnection();
    }
    
    
    @Override
    public void validerPreinscriOrganisme(Organisme o) {
        
        String requete = "update organisme set etat=1 where idorganisme=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            System.out.println("Validation effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("Erreur de validation " + ex.getMessage());
        }     
    }
    
    @Override
      public boolean authentification(String login, String password) {
        boolean res = false ; 
        String requete = "select * from admin where login=? and password=?" ; 
        
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet resultat = ps.executeQuery();
            if (resultat.next()) {
                System.out.println("Authentification réussie ! ");
                res = true ; 
            } else {
                System.out.println("Echec !");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
         return res ;  
    
      }
      
    @Override
      public ObservableList pieChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        String requete = "select (nom_cours), COUNT(*) from cours group by nom_cours ;  "; 
        
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                pieChartData.add(new PieChart.Data(resultat.getString(1),resultat.getInt(2)));
            }
            return pieChartData;
        } catch (SQLException ex) {
            Logger.getLogger(DAOAdministrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
          
      }
      
      @Override
      public ObservableList<XYChart.Series<String, Number>> dataChart() {
          ObservableList<XYChart.Series<String, Number>> answer = FXCollections.observableArrayList();
          XYChart.Series<String, Number> serie1 = new XYChart.Series<String, Number>();
          XYChart.Series<String, Number> serie2 = new XYChart.Series<String, Number>();
          XYChart.Series<String, Number> serie3 = new XYChart.Series<String, Number>();
          XYChart.Series<String, Number> serie4 = new XYChart.Series<String, Number>();
          
          serie1.setName("Android");
          serie2.setName("Windows Phone");
          serie3.setName("iOS");
          serie4.setName("J2ME");
          
          String requete = "SELECT CASE month(date_debut) when \"01\" then \"Janvier\" when \"02\" then \"Fevrier\" when \"03\" then \"Mars\" when \"04\" then \"Avril\" when \"05\" then \"Mai\" when \"06\" then \"Juin\" when \"07\" then \"Juillet\" when \"08\" then \"Aout\" when \"09\" then \"Septembre\" when \"10\" then \"Octobre\" when \"11\" then \"Novembre\" when \"12\" then \"Decembre\" END , COUNT(c.nom_cours), c.nom_cours FROM coursuivi cs, cours c where cs.id_cours=c.idcours GROUP BY month(cs.date_debut), c.nom_cours ; " ; 
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ResultSet rs = ps.executeQuery() ; 
            while (rs.next()) {
                System.out.println(rs.getString(3)+" "+rs.getString(2)+" "+rs.getString(1));
                switch (rs.getString(3)) {
                    case "Android":
                        serie1.getData().add(new XYChart.Data(rs.getString(1), rs.getInt(2)));
                        break;
                    case "Windows Phone":
                        serie2.getData().add(new XYChart.Data(rs.getString(1), rs.getInt(2)));
                        break;
                    case "iOS":
                        serie3.getData().add(new XYChart.Data(rs.getString(1), rs.getInt(2)));
                        break;
                    case "J2ME":
                        serie4.getData().add(new XYChart.Data(rs.getString(1), rs.getInt(2)));
                        break;
                }
                
            
            }
            answer.addAll(serie1,serie2,serie3,serie4) ; 
            return answer ; 
        } catch (SQLException ex) {
            Logger.getLogger(DAOAdministrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null ; 
      }
      
      @Override
      public ObservableList<XYChart.Series<String, Number>> dataChartSecond() {
          ObservableList<XYChart.Series<String, Number>> answer = FXCollections.observableArrayList();
          XYChart.Series<String, Number> serie1 = new XYChart.Series<String, Number>();
          XYChart.Series<String, Number> serie2 = new XYChart.Series<String, Number>();
          XYChart.Series<String, Number> serie3 = new XYChart.Series<String, Number>();
          XYChart.Series<String, Number> serie4 = new XYChart.Series<String, Number>();
          int x = 0 ; 
          int y = 0 ;
          int z = 0 ;
          int w = 0 ;
          
          serie1.setName("Android");
          serie2.setName("Windows Phone");
          serie3.setName("iOS");
          serie4.setName("J2ME");
          
          String requete = "SELECT CASE month(date_debut) when \"01\" then \"Janvier\" when \"02\" then \"Fevrier\" when \"03\" then \"Mars\" when \"04\" then \"Avril\" when \"05\" then \"Mai\" when \"06\" then \"Juin\" when \"07\" then \"Juillet\" when \"08\" then \"Aout\" when \"09\" then \"Septembre\" when \"10\" then \"Octobre\" when \"11\" then \"Novembre\" when \"12\" then \"Decembre\" END , COUNT(c.nom_cours), c.nom_cours FROM coursuivi cs, cours c where cs.id_cours=c.idcours GROUP BY month(cs.date_debut), c.nom_cours ; " ; 
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ResultSet rs = ps.executeQuery() ; 
            while (rs.next()) {
                
                
                System.out.println(rs.getString(3)+" "+rs.getString(2)+" "+rs.getString(1));
                switch (rs.getString(3)) {
                    case "Android":
                        x= x + rs.getInt(2);
                        serie1.getData().add(new XYChart.Data(rs.getString(1), x));
                        break;
                    case "Windows Phone":
                        y= y + rs.getInt(2);
                        serie2.getData().add(new XYChart.Data(rs.getString(1), y));
                        break;
                    case "iOS":
                        z= z + rs.getInt(2);
                        serie3.getData().add(new XYChart.Data(rs.getString(1), z));
                        break;
                    case "J2ME":
                        w= w + rs.getInt(2);
                        serie4.getData().add(new XYChart.Data(rs.getString(1), w));
                        break;
                }
            }
            answer.addAll(serie1,serie2,serie3,serie4) ; 
            return answer ; 
        } catch (SQLException ex) {
            Logger.getLogger(DAOAdministrateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null ; 
      }
      

    @Override
    public List<Organisme> findAll() {
        List<Organisme> listeorganisme = new ArrayList<>();
        String requete = "select * from organisme";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Organisme organisme = new Organisme();
                organisme.setId(resultat.getInt(1));
                organisme.setNom(resultat.getString(2));
                organisme.setEmail(resultat.getString(3));
                organisme.setSiteweb(resultat.getString(4));
                organisme.setAdresse(resultat.getString(5));
                organisme.setTelephone(resultat.getString(6));
                organisme.setDescription(resultat.getString(7));
                listeorganisme.add(organisme);
            }
            return listeorganisme;
        } catch (SQLException ex) {
            System.out.println("erreur " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public void downloadDocument(Organisme o) {
      String requete = "select document from organisme where idorganisme=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, o.getId());
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                File doc = new File("D:\\Document"+o.getNom()+".docx");
                try (FileOutputStream fos = new FileOutputStream(doc)) {
                    byte[] buffer = new byte[1];
                    InputStream is = resultat.getBinaryStream(1);
                    while (is.read(buffer) > 0) {
                        fos.write(buffer);
                    }         
                }
            }
            System.out.println("Téléchargement effectué avec succès!");
        } catch (SQLException ex) {
            Logger.getLogger(DAOComite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOComite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOComite.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
           
}
