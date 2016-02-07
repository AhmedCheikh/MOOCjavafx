/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;
import pidev.entities.Reponce;

/**
 *
 * @author Gumus
 */
public interface IDAOReponce {
    void add(Reponce réponce);
    void remove(Reponce réponce);
    void update(Reponce réponce);
    
}
