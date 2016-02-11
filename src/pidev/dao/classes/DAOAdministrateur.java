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
    
}
