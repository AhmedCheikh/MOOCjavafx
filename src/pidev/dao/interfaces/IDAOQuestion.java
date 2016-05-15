
package pidev.dao.interfaces;
import java.util.List;
import pidev.entities.Question;
import pidev.entities.Quiz;


public interface IDAOQuestion {
    void addQuestion(Question q);
    void removeQuestion(int id);
    void updateQuestion(int id,String q);
    int findQuestionSelonId(String ques);
    List<Question> findQuestionById(int id);
    List<Question> FindIdQuestionbyQuiz(int q);
    int findQuestionSelonId(Question q);
}
