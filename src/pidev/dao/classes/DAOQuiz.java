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
 * @author Gumus
 */
public class DAOQuiz implements IDAOQuiz {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public DAOQuiz() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void addQuiz(Quiz q) {
        try {
            String req = "insert into quiz (id,titre,type,etat) values (?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1, q.getIdQuiz());
            pst.setString(2, q.getTitre());
            pst.setInt(3, q.getType());
            pst.setInt(4, q.getEtat());

            pst.executeUpdate();
            System.out.println("Ajout quiz effectuée avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void removeQuiz(Quiz q) {

        String requete = "delete from quiz where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, q.getIdQuiz());
            ps.executeUpdate();
            System.out.println("Quiz supprimé");
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public void updateQuiz(Quiz q) {

        String requete = "update quiz set titre=?, type=? ,etat=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            pst.setInt(1, q.getIdQuiz());
            pst.setString(2, q.getTitre());
            pst.setInt(3, q.getType());
            pst.setInt(4, q.getEtat());

            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
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

                Quiz q = new Quiz(rs.getInt("id"), rs.getString("titre"), rs.getInt("type"), rs.getInt("etat"));

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

                Quiz q = new Quiz(rs.getInt("id"), rs.getString("titre"), rs.getInt("type"), rs.getInt("etat"));

                listQuiz.add(q);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listQuiz;
    }

    @Override
    public List<Quiz> findQuizByType(boolean type) {
        String req = "select * from quiz where type= '" + type + "'";
        List<Quiz> listQuiz = new ArrayList<Quiz>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                Quiz q = new Quiz(rs.getInt("id"), rs.getString("titre"), rs.getInt("type"), rs.getInt("etat"));

                listQuiz.add(q);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listQuiz;
    }

//        @Override
//    public int findQuizByTitreSelonId(String titre) {
//        int m;
//        try {
//            String requete = "select id from quiz where titre= '" + titre + "'";
//            
//            PreparedStatement ps = connection.prepareStatement(requete);
//            m= ps.executeQuery().getRow();
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOQuiz.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return m;
//        
//        }
    @Override
    public int findQuizByTitreSelonId(String titre) {
//        String req = "select id from quiz where titre= '" + titre + "'";
//        try {
//            pst = connection.prepareStatement(req);
//            rs = pst.executeQuery();
//            
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return rs.getI;
return 0;
  }

    
}
