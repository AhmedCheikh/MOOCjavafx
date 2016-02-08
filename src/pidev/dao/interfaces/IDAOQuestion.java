
package pidev.dao.interfaces;
import pidev.entities.Question;


public interface IDAOQuestion {
    void addQuestion(Question question);
    void removeQuestion(Question question);
    void updateQuestion(Question question);
    Question findQuestionById(int id);
}
