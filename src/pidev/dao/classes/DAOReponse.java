/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.classes;

import java.util.List;
import pidev.dao.interfaces.IDAOReponse;
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
import pidev.dao.interfaces.IDAOReponse;
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
public class DAOReponse implements IDAOReponse{

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public DAOReponse() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void addReponse(Reponse r) {
        try {
            String req = "insert into reponse(id,etat,reponse,idquestion) values (?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1, r.getIdReponse());
            pst.setInt(2, r.getEtat());
            pst.setString(3, r.getReponse());
            pst.setInt(4, r.getIdQuestion());
            System.out.println(pst);
            pst.executeUpdate();
            System.out.println("Ajout reponse effectuée avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

       
    @Override
    public void removeReponse(Reponse r) {
        String requete = "delete from reponse where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, r.getIdQuestion());
            ps.executeUpdate();
            System.out.println("Reponse supprimé");
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public void updateReponse(Reponse r) {

        String requete = "update reponse set etat=?, reponse=?, idquestion=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            pst.setInt(1, r.getIdReponse());
            pst.setInt(2, r.getEtat());
            pst.setString(3, r.getReponse());
            pst.setInt(4, r.getIdQuestion());

            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Reponse> findReponseById(int id) {
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
            ex.printStackTrace();
        }
        return listReponse;
    }

    @Override
    public List<Reponse> findReponseByEtat(int etat) {
               String req = "select * from reponse where etat= '"+etat+"'"; 
        List<Reponse> listReponse = new ArrayList<Reponse>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                    Reponse q = new Reponse(rs.getInt("id"), rs.getInt("etat"),rs.getString("reponse"), rs.getInt("idquestion"));

                listReponse.add(q);
            }

        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return listReponse;
    }

}
