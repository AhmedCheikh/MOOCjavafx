/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;
import pidev.entities.Quiz;

/**
 *
 * @author Gumus
 */
public interface IDAOQuiz {
    void add(Quiz quiz);
    void remove(Quiz quiz);
    void update(Quiz quiz);
    
}
