/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;

import java.util.List;
import pidev.entities.Cours;

/**
 *
 * @author Khoubaib
 */
public interface IDAOApprenant<T> {
    void add(T t);
    void update(T t, int cin);
    List<Cours> listCoursSuivi(int cin);
    void commetCours(String c);
    void apprecierCours();
}
