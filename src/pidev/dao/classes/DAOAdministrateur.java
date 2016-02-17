/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.dao.interfaces.IDAOAdministrateur ; 
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
           
}
