/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;

/**
 *
 * @author Khoubaib
 */
public interface IDAOApprenant<T> {
    void add(T t);
    void update(T t, int cin);
}
