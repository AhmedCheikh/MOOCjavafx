
package pidev.dao.classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.dao.interfaces.IDAOCoursSuivie;
import pidev.dao.interfaces.IDaoCours;
import pidev.entities.CoursSuivie;
import pidev.techniques.DataSource;

public class DAOCoursSuivie implements IDAOCoursSuivie{
    
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    /**
     *
     */
    public DAOCoursSuivie() {
        connection =(DataSource.getInstance()).getConnection();
    }
    
    

    @Override
    public void ajouter(CoursSuivie c) {
        try {
            String req="insert into coursuivi (id_cours,cinapprenant,date_debut) values (?,?,?)";
            pst=connection.prepareStatement(req);
            pst.setInt(1, c.getId_cours());
            pst.setString(2, c.getCinapprenant());
            pst.setString(3, c.getDate_debut());
            
      
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCours.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ajouterNote(CoursSuivie c) {
       String requete = "update coursuivi set note=? where cinapprenant=?";
        try {
             pst = connection.prepareStatement(requete);
           
            pst.setDouble(1, c.getNote());
            pst.setString(2, c.getAppreciation());
            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }


    @Override
    public CoursSuivie getCourSuiviByCinApprenantAndCoursId(String cin , int id){
   
        try {
            String req= "select * from coursuivi where cinapprenant = ? and id_cours = ?";
            pst = connection.prepareStatement(req);
            pst.setString(1, cin);
            pst.setInt(2, id);
            rs = pst.executeQuery();
            CoursSuivie cs;
            while (rs.next()){
                cs = new CoursSuivie();
                cs.setId_cours(rs.getInt(1));
                cs.setCinapprenant(rs.getString(2));
                cs.setCommentaire(rs.getString(3));
                cs.setNote(rs.getFloat(4));
                cs.setDate_debut(rs.getString(5));
                cs.setAppreciation(rs.getString(6));
                cs.setIdCoursuivi(rs.getInt(7));
                return cs;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOCoursSuivie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
 
 
    @Override
        public void donnerAppreciation(String appreciation, int idCoursuivi) {
       String requete = "update coursuivi set appreciation=? where idCoursuivi=?";
        try {
            pst = connection.prepareStatement(requete);
            pst.setString(1, appreciation);
            pst.setInt(2, idCoursuivi);
            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    @Override
         public void laisserCommentaire(String commentaire , int idCoursuivi ) {
       String requete = "update coursuivi set commentaire=? where idCoursuivi=?";
         try {
            pst = connection.prepareStatement(requete);
            pst.setString(1, commentaire);
            pst.setInt(2, idCoursuivi);
            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
 
} 
