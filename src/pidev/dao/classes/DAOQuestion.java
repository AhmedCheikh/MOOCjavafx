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
import pidev.dao.interfaces.IDAOQuestion;
import pidev.entities.Chapitre;
import pidev.entities.Cours;
import pidev.entities.Question;
import pidev.entities.Quiz;
import pidev.techniques.DataSource;

/**
 *
 * @author Gumus
 */
public class DAOQuestion implements IDAOQuestion {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public DAOQuestion() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void addQuestion(Question q) {
        try {
            String req = "insert into question(question,idQuiz) values (?,?)";
            pst = connection.prepareStatement(req);
            pst.setString(1, q.getQuestion());
            pst.setInt(2, q.getIdQuiz());
            pst.executeUpdate();
            System.out.println("Ajout question effectuée avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void removeQuestion(int id) {
        String requete = "delete from question where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Question supprimé");
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public void updateQuestion(int id,String q) {

        String requete = "update question set question=? where id= '" + id + "'";
        try {
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, q);
            System.out.println(pst);
            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Question> findQuestionById(int id) {
        String req = "select * from question where id= '" + id + "'";
        List<Question> listQuestion = new ArrayList<Question>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                Question q = new Question(rs.getInt("id"), rs.getString("ques"), rs.getInt("idquiz"));

                listQuestion.add(q);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listQuestion;
    }

    @Override
    public int findQuestionSelonId(String ques) {
               String req = "select * from question where question= '" + ques + "'";
        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();
               while (rs.next()) {
            return rs.getInt(1);}
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
       

  }
    
        @Override
    public int findQuestionSelonId(Question q) {
               String req = "select * from question where question= '" + q.getQuestion()+ "'";
        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();
               while (rs.next()) {
            return rs.getInt("id");}
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
       

  }
    
    
         @Override
    public List<Question> FindIdQuestionbyQuiz(int q) {
           {
       String req = "select * from question where idquiz= '"+q+"'";
        List<Question> listQuestion = new ArrayList<Question>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                Question e = new Question(rs.getInt("id"),rs.getString("question"),rs.getInt("idquiz"));

                listQuestion.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listQuestion;
    }
    }

}
