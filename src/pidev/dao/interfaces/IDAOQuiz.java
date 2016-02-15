
package pidev.dao.interfaces;
import java.util.List;
import pidev.entities.Quiz;


public interface IDAOQuiz {
    void addQuiz(Quiz q);
    void removeQuiz(Quiz q);
    void updateQuiz(Quiz q);
     List<Quiz> findQuizById(int id);
     List<Quiz> findQuizByTitre(String titre);
     int findQuizByTitreSelonId(String titre);
   List<Quiz> findQuizByType(boolean type);
   String findTitreQuizByTitreSelonId(int id);
    
}
