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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.dao.interfaces.IDAOQuiz;
import pidev.entities.Quiz;
import pidev.techniques.DataSource;

/**
 *
 * @author Nour
 */
public class DAOQuiz implements IDAOQuiz{

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public DAOQuiz() {
        connection = DataSource.getInstance().getConnection();
    }

    public void addQuiz(Quiz q) {
        try {
            String req = "insert into quiz (titre,type) values (?,?)";
            pst = connection.prepareStatement(req);

            pst.setString(1, q.getTitre());
            pst.setInt(2, q.getType());

            pst.executeUpdate();
            System.out.println("Ajout quiz effectuée avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void removeQuiz(int id) {

        String requete = "delete from quiz where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Quiz supprimé");
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public void updateQuiz(int id, Quiz q) {

        String requete = "update quiz set titre=?, type=? where id= '" + id + "'";
        try {
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, q.getTitre());
            pst.setInt(2, q.getType());
           
            pst.executeUpdate();
            System.out.println("Mise à jour Quiz effectuée avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Quiz> findQuizById(int id) {

        String req = "select * from quiz where id= '" + id + "'";
        List<Quiz> listQuiz = new ArrayList<Quiz>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                Quiz q = new Quiz(rs.getInt("id"), rs.getString("titre"), rs.getInt("type"));

                listQuiz.add(q);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listQuiz;
    }

    @Override
    public List<Quiz> findQuizByTitre(String titre) {

        String req = "select * from quiz where titre= '" + titre + "'";
        List<Quiz> listQuiz = new ArrayList<Quiz>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                Quiz q = new Quiz(rs.getInt("id"), rs.getString("titre"), rs.getInt("type"));

                listQuiz.add(q);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listQuiz;
    }

    @Override
    public List findQuizByType(int type) {
        String req = "select * from quiz where type= '" + type + "'";
        List<String> l = new ArrayList<>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                String q = rs.getString("titre");

                l.add(q);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return l;
    }

    @Override
    public int findQuizByTitreSelonId(String titre) {
        String req = "select * from quiz where titre= '" + titre + "'";
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
    public int findTypeQuiz(int id) {
        String req = "select * from quiz where id= '" + id + "'";
        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt(3);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;

    }

    @Override
    public String findTitreQuizByTitreSelonId(int id) {
        String req = "select * from quiz where id= '" + id + "'";
        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getString(2);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";

    }

    @Override
    public boolean ChercherTitre(String titre) {
       boolean res = false;
        try {
            String req = "select * from quiz where titre =?";
            pst=connection.prepareStatement(req);
            pst.setString(1, titre);
            rs = pst.executeQuery();
            if(rs.next())
            {
                res = true;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOApprenant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
