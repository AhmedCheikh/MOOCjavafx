
package pidev.dao.interfaces;
import java.util.List;
import pidev.entities.Quiz;


public interface IDAOQuiz {
    void addQuiz(Quiz quiz);
    void removeQuiz(Quiz quiz);
    void updateQuiz(Quiz quiz);
     Quiz findQuizById(int id);
     Quiz findQuizByTitre(String titre);
   List<Quiz> findQuizByType(boolean type);
    
}
