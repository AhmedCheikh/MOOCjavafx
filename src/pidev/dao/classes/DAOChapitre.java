/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.classes;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.dao.interfaces.IDAOChapitre;
import pidev.entities.Chapitre;
import pidev.entities.Cours;
import pidev.techniques.DataSource;

/**
 *
 * @author Gumus
 */
public class DAOChapitre implements IDAOChapitre {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public DAOChapitre() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void addChapitre(Chapitre c) {

        try {
            String req = "insert into chapitre (id,idcours,titre,objectif,etat) values (?,?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1, c.getIdChapitre());
            pst.setInt(2, c.getIdCours());
            pst.setInt(3, c.getIdQuiz());
            pst.setString(4, c.getTitre());
            pst.setBlob(5, c.getPresentation());
            pst.setString(6, c.getObjectif());
            pst.setInt(7, c.getEtat());
            pst.setBlob(8, c.getVideo());

            pst.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'ajout " + ex.getMessage());
        }
    }

    @Override
    public void removeChapitre(Chapitre c) {
               String requete = "delete from chapitre where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,c.getIdChapitre());
            ps.executeUpdate();
            System.out.println("Chapitre supprimé");
        } catch (SQLException ex) {
             System.out.println("erreur lors de la suppression " + ex.getMessage());

        }
    }

    public void updateChapitre(Chapitre c) {

        String requete = "update apprenant set idcours=?, idquiz=?, titre=? ,presentation=? ,objectif=?, etat=?, video=?  where c.getId=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            pst.setInt(1, c.getIdCours());
            pst.setInt(2, c.getIdQuiz());
            pst.setString(3, c.getTitre());
            pst.setBlob(4,c.getPresentation());
            pst.setString(5, c.getObjectif());
            pst.setInt(2, c.getEtat());
            pst.setBlob(3, c.getVideo());

            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public List<Chapitre> findChapitreById(int id) {

        String req = "select * from chapitre where id = "+id;
        List<Chapitre> listChapitres = new ArrayList<Chapitre>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                Chapitre c = new Chapitre(rs.getInt("id"), rs.getInt("idcours"), rs.getInt("idquiz"), rs.getString("titre"), rs.getBlob("presentation"), rs.getString("objectif"), rs.getInt("etat"), rs.getBlob("video"));

                listChapitres.add(c);
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche " + ex.getMessage());
        }
        return listChapitres;
    }

    @Override
    public List<Chapitre> findChapitreByEtat(int etat) {
          String req = "select * from chapitre where etat == etat ";
        List<Chapitre> listChapitres = new ArrayList<Chapitre>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                Chapitre c = new Chapitre(rs.getInt("id"), rs.getInt("idcours"), rs.getInt("idquiz"), rs.getString("titre"), rs.getBlob("presentation"), rs.getString("objectif"), rs.getInt("etat"), rs.getBlob("video"));

                listChapitres.add(c);
            }
           
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche " + ex.getMessage());
        }
        return listChapitres;
    }

    @Override
    public List<Chapitre> findChapitreByTitre(String titre) {
        String req = "select * from chapitre where titre == titre ";
        List<Chapitre> listChapitres = new ArrayList<Chapitre>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                Chapitre c = new Chapitre(rs.getInt("id"), rs.getInt("idcours"), rs.getInt("idquiz"), rs.getString("titre"), rs.getBlob("presentation"), rs.getString("objectif"), rs.getInt("etat"), rs.getBlob("video"));

                listChapitres.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche " + ex.getMessage());
        }
        return listChapitres;
    }
}
