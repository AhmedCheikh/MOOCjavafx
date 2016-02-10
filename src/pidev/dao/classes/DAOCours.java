
package pidev.dao.classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.dao.interfaces.IDaoCours;
import pidev.entities.Cours;
import pidev.techniques.DataSource;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOCours implements IDaoCours{

Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    public DAOCours() {
        Connection connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void addCours(Cours cours) {
       try {
            String req="insert into cours (nom_cours,description,difficulte,objectif) values (?,?,?,?)";
            pst=connection.prepareStatement(req);
            pst.setString(1, cours.getNomCours());
            pst.setString(2, cours.getDescription());
            pst.setString(3, cours.getDifficulte());
            pst.setString(4, cours.getObjectif());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOApprenant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateCours(Cours cours) {
       String requete = "update cours set description=?, difficulte=?, objectif=? where nom_cours=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
           pst.setString(4, cours.getNomCours());
            pst.setString(1, cours.getDescription());
            pst.setString(2, cours.getDifficulte());
            pst.setString(3, cours.getObjectif());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public void removeCoursByFormateur(String cinFormateur) {
        String requete = "delete from cours where id_cours=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, cinFormateur);
            ps.executeUpdate();
            System.out.println("Cours supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public void removeCoursById(int id) {
        String requete = "delete from cours where id_cours=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Cours supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public List<Cours> findAll() {
         List<Cours> listecours = new ArrayList<>();
        String requete = "select * from cours";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Cours cours = new Cours();
                cours.setIdCours(resultat.getInt(1));
                cours.setNomCours(resultat.getString(2));
                cours.setCinFormateur(resultat.getString(3));
                cours.setIdQuiz(resultat.getInt(4));
                cours.setDescription(resultat.getString(5));
                cours.setVideo(resultat.getString(6));
                cours.setDifficulte(resultat.getString(7));
                cours.setObjectif(resultat.getString(8));
                listecours.add(cours);
            }
            return listecours;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Cours findCoursById(int id) {
        Cours cours = new Cours();
        String requete = "select * from cours where id_cours=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                cours.setIdCours(resultat.getInt(1));
                cours.setNomCours(resultat.getString(2));
                cours.setCinFormateur(resultat.getString(3));
                cours.setIdQuiz(resultat.getInt(4));
                cours.setDescription(resultat.getString(5));
                cours.setVideo(resultat.getString(6));
                cours.setDifficulte(resultat.getString(7));
                cours.setObjectif(resultat.getString(8));
                
            }
            return cours;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Cours findCoursByFormateur(String cinFormateur) {
       Cours cours = new Cours();
        String requete = "select * from cours where cinformateur=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, cinFormateur);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                cours.setIdCours(resultat.getInt(1));
                cours.setNomCours(resultat.getString(2));
                cours.setCinFormateur(resultat.getString(3));
                cours.setIdQuiz(resultat.getInt(4));
                cours.setDescription(resultat.getString(5));
                cours.setVideo(resultat.getString(6));
                cours.setDifficulte(resultat.getString(7));
                cours.setObjectif(resultat.getString(8));
                
            }
            return cours;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Cours findCoursByDifficulte(String difficulte) {
        Cours cours = new Cours();
        String requete = "select * from cours where difficulte=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, difficulte);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                cours.setIdCours(resultat.getInt(1));
                cours.setNomCours(resultat.getString(2));
                cours.setCinFormateur(resultat.getString(3));
                cours.setIdQuiz(resultat.getInt(4));
                cours.setDescription(resultat.getString(5));
                cours.setVideo(resultat.getString(6));
                cours.setDifficulte(resultat.getString(7));
                cours.setObjectif(resultat.getString(8));
                
            }
            return cours;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }
    
}
