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
import pidev.dao.interfaces.IDAOApprenant;
import pidev.entities.Apprenant;
import pidev.techniques.DataSource;

/**
 *
 * @author Khoubaib
 */
public class DAOApprenant implements IDAOApprenant<Apprenant>{
    
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public DAOApprenant() {
        connection =(DataSource.getInstance()).getConnection();
    }
    

    @Override
    public void add(Apprenant a) {
        try {
            String req="insert into apprenant (cin,nom,prenom,email,login,motDePasse) values (?,?,?,?,?,?)";
            pst=connection.prepareStatement(req);
            pst.setInt(1, a.getCin());
            pst.setString(2, a.getNom());
            pst.setString(3, a.getPrenom());
            pst.setString(4, a.getEmail());
            pst.setString(5, a.getLogin());
            pst.setString(6, a.getMotDePasse());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOApprenant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void update(Apprenant a, int cin) {
         String requete = "update apprenant set nom=?, prenom=?, email=?, login=? where cin=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            pst.setString(1, a.getNom());
            pst.setString(2, a.getPrenom());
            pst.setString(3, a.getEmail());
            pst.setString(4, a.getLogin());
            pst.setInt(5, cin);
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }


    
}
