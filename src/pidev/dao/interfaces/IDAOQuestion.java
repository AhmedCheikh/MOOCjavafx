/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;
import java.util.List;
import pidev.entities.Question;

/**
 *
 * @author Gumus
 */
public interface IDAOQuestion {
    void addQuestion(Question question);
    void removeQuestion(Question question);
    void updateQuestion(Question question);
    Question findQuestionById(int id);
}
