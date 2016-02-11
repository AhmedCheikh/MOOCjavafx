
package pidev.dao.classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.dao.interfaces.IDAOCoursSuivie;
import pidev.entities.CoursSuivie;
public class DAOCoursSuivie implements IDAOCoursSuivie{
    
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    
    

    @Override
    public void ajouter(CoursSuivie c) {
        try {
            String req="insert into coursuivi (id_cours,cinapprenant,date_debut) values (?,?,?)";
            pst=connection.prepareStatement(req);
            pst.setInt(1, c.getIdCours());
            pst.setString(2, c.getCinApprenant());
            pst.setString(3, c.getDateDebut());
      
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCours.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ajouterCommentaire(CoursSuivie c) {
       String requete = "update coursuivi set commentaire=? where cinapprenant=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
           pst.setString(1, c.getCommentaire());
            pst.setString(2, c.getCinApprenant());
         
         
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public void ajouterNote(CoursSuivie c) {
       String requete = "update coursuivi set note=? where cinapprenant=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
           
            pst.setDouble(1, c.getNote());
            pst.setString(2, c.getCinApprenant());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public void ajouterAppreciation(CoursSuivie c) {
       String requete = "update coursuivi set appreciation=? where cinapprenant=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
           pst.setString(1, c.getAppreciation());
            pst.setString(2, c.getCinApprenant());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    
}
