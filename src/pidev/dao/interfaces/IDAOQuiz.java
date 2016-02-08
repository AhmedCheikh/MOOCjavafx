/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;
import java.util.List;
import pidev.entities.Quiz;

/**
 *
 * @author Gumus
 */
public interface IDAOQuiz {
    void addQuiz(Quiz quiz);
    void removeQuiz(Quiz quiz);
    void updateQuiz(Quiz quiz);
     Quiz findQuizById(int id);
     Quiz findQuizByTitre(String titre);
   List<Quiz> findQuizByType(boolean type);
    
}
