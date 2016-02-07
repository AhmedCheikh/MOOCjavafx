/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;
import pidev.entities.Question;

/**
 *
 * @author Gumus
 */
public interface IDAOQuestion {
    void add(Question question);
    void remove(Question question);
    void update(Question question);
}
