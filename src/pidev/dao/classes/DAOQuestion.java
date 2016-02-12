/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import pidev.dao.interfaces.IDAOQuestion;
import pidev.entities.Chapitre;
import pidev.entities.Cours;
import pidev.entities.Question;
import pidev.techniques.DataSource;
/**
 *
 * @author Gumus
 */
public class DAOQuestion implements IDAOQuestion{
 Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public DAOQuestion() {
        connection = DataSource.getInstance().getConnection();
    }
    @Override
    public void addQuestion(Question q) {
          try {
            String req = "insert into question(id,question,idQuiz) values (?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1, q.getIdQuestion());
            pst.setString(2, q.getQuestion());
            pst.setInt(3, q.getIdQuiz());
            pst.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'ajout " + ex.getMessage());
        }
    }

    @Override
    public void removeQuestion(Question q) {
             String requete = "delete from question where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, q.getIdQuestion());
            ps.executeUpdate();
            System.out.println("Question supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());

        }
    }

    @Override
    public void updateQuestion(Question q) {
              
                String requete = "update question set question=?, idquiz=?  where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            pst.setInt(1, q.getIdQuestion());
            pst.setString(2, q.getQuestion());
            pst.setInt(3, q.getIdQuiz());
            
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    @Override
    public List<Question> findQuestionById(int id) {
             String req = "select * from question where id= '"+id+"'";
        List<Question> listQuestion = new ArrayList<Question>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                Question q = new Question(rs.getInt("id"), rs.getString("question"), rs.getInt("idquiz"));

                listQuestion.add(q);
            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche " + ex.getMessage());
        }
        return listQuestion;
    }

    
}
