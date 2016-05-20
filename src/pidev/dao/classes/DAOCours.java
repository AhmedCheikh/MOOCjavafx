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
import pidev.entities.Quiz;

public class DAOCours implements IDaoCours {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public DAOCours() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void addCours(Cours cours) {
        try {
            String req = "insert into cours (nom_cours,description,difficulte,objectif,cinformateur) values (?,?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setString(1, cours.getNomCours());
            pst.setString(2, cours.getDescription());
            pst.setString(3, cours.getDifficulte());
            pst.setString(4, cours.getObjectif());
            pst.setString(5, cours.getCinFormateur());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCours.class.getName()).log(Level.SEVERE, null, ex);
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
        String requete = "delete from cours where cinformateur=?";
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
    public void removeCoursByName(String nomCours) {
        String requete = "delete from cours where nom_cours=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, nomCours);
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

                cours.setDifficulte(resultat.getString(6));
                cours.setObjectif(resultat.getString(7));
                listecours.add(cours);
            }
            return listecours;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Cours findCoursByName(String nomCours) {
        Cours cours = new Cours();
        String requete = "select * from cours where nom_cours=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, nomCours);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                cours.setIdCours(resultat.getInt(1));
                cours.setNomCours(resultat.getString(2));
                cours.setCinFormateur(resultat.getString(3));
                cours.setIdQuiz(resultat.getInt(4));
                cours.setDescription(resultat.getString(5));

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

                cours.setDifficulte(resultat.getString(7));
                cours.setObjectif(resultat.getString(8));

            }
            return cours;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du cours " + ex.getMessage());
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

                cours.setDifficulte(resultat.getString(7));
                cours.setObjectif(resultat.getString(8));

            }
            return cours;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du cours " + ex.getMessage());
            return null;
        }
    }

    public int findIdCoursByTitre(String titre) {
        String req = "select * from cours where nom_cours= '" + titre + "'";
        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;

    }

    @Override
    public int FindIdQuizbycours(String titre
    ) {
        {
            String req = "select * from cours where nom_cours= '" + titre + "'";
            Quiz Quiz = new Quiz();

            try {
                pst = connection.prepareStatement(req);
                rs = pst.executeQuery();

                while (rs.next()) {

                    return rs.getInt("idquiz");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return 0;
        }
    }

    public List<Cours> findCoursByTitle(String title) {
        List<Cours> listecours = new ArrayList<>();
        String requete = "select * from cours where nom_cours like '" + title + "%'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Cours cours = new Cours();
                cours.setIdCours(resultat.getInt(1));
                cours.setNomCours(resultat.getString(2));
                cours.setCinFormateur(resultat.getString(3));

                cours.setDescription(resultat.getString(5));
                cours.setDifficulte(resultat.getString(6));
                cours.setObjectif(resultat.getString(7));
                listecours.add(cours);
            }
            return listecours;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des cours " + ex.getMessage());
            return null;
        }
    }

    public List<Cours> findCoursByApprenant(String cin) {
        List<Cours> listecours = new ArrayList<>();
        String requete = "select * from cours c,coursuivi cs where c.idcours=cs.id_cours and cs.cinapprenant= ?";
        try {
            pst = connection.prepareStatement(requete);
            pst.setString(1, cin);
            rs = pst.executeQuery();
            while (rs.next()) {
                Cours cours = new Cours();
                cours.setIdCours(rs.getInt(1));
                cours.setNomCours(rs.getString(2));
                cours.setCinFormateur(rs.getString(3));
                cours.setDescription(rs.getString(5));
                cours.setDifficulte(rs.getString(6));
                cours.setObjectif(rs.getString(7));
                listecours.add(cours);
            }
            return listecours;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des cours " + ex.getMessage());
            return null;
        }
    }

    @Override
    public String findTitreCoursById(int id) {
        String req = "select * from cours where idcours= '" + id + "'";
        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getString("nom_cours");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";

    }

    @Override
    public int findIdQuizByIdcours(int idcours) {
        String req = "select idquiz from cours where idcours= '" + idcours + "'";
        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt("idquiz");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

     @Override
    public Cours findCoursByID(int id) {
        Cours cours = new Cours();
        String requete = "select * from cours where idcours= '" + id + "'";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                cours.setIdCours(resultat.getInt("idcours"));
                cours.setNomCours(resultat.getString("nom_cours"));
                cours.setCinFormateur(resultat.getString("cinformateur"));
                cours.setIdQuiz(resultat.getInt("idquiz"));
                cours.setDescription(resultat.getString("description"));
                cours.setVideo(resultat.getString("video"));
                cours.setDifficulte(resultat.getString("difficulte"));
                cours.setObjectif(resultat.getString("objectif"));
            }
            return cours;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du cours " + ex.getMessage());
            return null;
        }
    }

}
