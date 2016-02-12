
package pidev.dao.interfaces;
import java.util.List;
import pidev.entities.Question;


public interface IDAOQuestion {
    void addQuestion(Question q);
    void removeQuestion(Question q);
    void updateQuestion(Question q);
    List<Question> findQuestionById(int id);
}
