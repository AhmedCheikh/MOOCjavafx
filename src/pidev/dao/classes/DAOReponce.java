/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.classes;

import java.util.List;
import pidev.dao.interfaces.IDAOReponce;
import pidev.entities.Reponse;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.dao.interfaces.IDAOChapitre;
import pidev.dao.interfaces.IDAOQuestion;
import pidev.entities.Chapitre;
import pidev.entities.Cours;
import pidev.entities.Question;
import pidev.techniques.DataSource;

/**
 *
 * /**
 *
 * @author Gumus
 */
public class DAOReponce implements IDAOReponce {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public DAOReponce() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void addReponce(Reponse r) {
        try {
            String req = "insert into reponse(id,etat,reponse,idquestion) values (?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1, r.getIdReponse());
            pst.setInt(2, r.getEtat());
            pst.setString(3, r.getReponce());
            pst.setInt(4, r.getIdQuestion());
            pst.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'ajout " + ex.getMessage());
        }
    }

    @Override
    public void removeReponce(Reponse r) {
        String requete = "delete from reponce where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, r.getIdQuestion());
            ps.executeUpdate();
            System.out.println("Reponse supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());

        }
    }

    @Override
    public void updateReponce(Reponse r) {

        String requete = "update reponse set etat=?, reponse=?, idquestion=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            pst.setInt(1, r.getIdReponse());
            pst.setInt(2, r.getEtat());
            pst.setString(3, r.getReponce());
            pst.setInt(4, r.getIdQuestion());

            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public List<Reponse> findReponceById(int id) {
        String req = "select * from reponse where id= '"+id+"'";
        List<Reponse> listReponse = new ArrayList<Reponse>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                Reponse q = new Reponse(rs.getInt("id"), rs.getInt("etat"),rs.getString("reponse"), rs.getInt("idquestion"));

                listReponse.add(q);
            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche " + ex.getMessage());
        }
        return listReponse;
    }

    @Override
    public List<Reponse> findReponceByEtat(int etat) {
               String req = "select * from quiz where etat= '"+etat+"'"; 
        List<Reponse> listReponse = new ArrayList<Reponse>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                    Reponse q = new Reponse(rs.getInt("id"), rs.getInt("etat"),rs.getString("reponse"), rs.getInt("idquestion"));

                listReponse.add(q);
            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche " + ex.getMessage());
        }
        return listReponse;
    }

}
