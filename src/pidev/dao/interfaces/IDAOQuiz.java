package pidev.dao.interfaces;

import java.util.List;
import pidev.entities.Quiz;

public interface IDAOQuiz {

    void addQuiz(Quiz q);

    void removeQuiz(int id);

    void updateQuiz(int id, Quiz q);

    List<Quiz> findQuizById(int id);

    List<Quiz> findQuizByTitre(String titre);

    int findQuizByTitreSelonId(String titre);

    List<Quiz> findQuizByType(int type);

    String findTitreQuizByTitreSelonId(int id);

    int findTypeQuiz(int id);

    boolean ChercherTitre(String titre);

}
