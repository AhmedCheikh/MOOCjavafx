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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.StringContent;
import pidev.dao.interfaces.IDAOOrganisme;
import pidev.entities.*;
import pidev.techniques.DataSource;
/**
 *
 * @author Rimy Jeljeli
 */
public class DAOOrganisme implements IDAOOrganisme{
  Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    public DAOOrganisme (){
        connection =(DataSource.getInstance()).getConnection();
    }
   
   
  @Override
    public void addOrganisme(Organisme organisme) {
   try {
          String req1="insert into organisme (nom,adresse,email) values (?,?,?)";
          pst.setString(1, organisme.getNom());
          pst.setString(2, organisme.getAdresse());
          pst.setString(3, organisme.getEmail());
//          String req2="insert into utilisateur (login,password,role) values (?,?,?)";
//           pst.setString(1, utilisateur.getLogin());
//          pst.setString(2, utilisateur.getPassword());
//          pst.setString(3, utilisateur.getRole());
      } catch (SQLException ex) {
      }    }
    
    
    @Override
    public void updateOrganismeInscription(Organisme organisme) {
        
    }
    
    
    
    @Override
    public void updateOrganisme(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeOrganismeByName(String nom) {
        String requete = "delete from Organisme where nom=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1,nom);
            ps.executeUpdate();
            System.out.println("Organisme supprimé");
        } catch (SQLException ex) {
             System.out.println("erreur lors de la suppression " + ex.getMessage());

        }   
    }

    @Override
    public void removeOrganismeById(int id) {
          String requete = "delete from Organisme where idorganisme=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
           
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Organisme supprimé");
        } catch (SQLException ex) {
             System.out.println("erreur lors de la suppression " + ex.getMessage());

        } 
     }

       @Override
    public void removeFormateurFromOrganisme(int idFormateur) {
        ////////fama idorganisme 3and formateur???!!!
         String requete = "delete idOrganisme from Organisme where idformateur=?";
          try {
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ps.setInt(1,idFormateur);
            ps.executeUpdate();
            System.out.println("Formateur supprimé");
        } catch (SQLException ex) {
             System.out.println("erreur lors de la suppression " + ex.getMessage());

        } 
    }
    
    
    
    @Override
    public void envoyerInvitation(String email1, String email2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void accepterInvitation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void refuserInvitation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void findFormateurByOrganisme(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Organisme> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Organisme findOrganismeById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Organisme findOrganismeByAdresse(String adresse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 


  

    
}
