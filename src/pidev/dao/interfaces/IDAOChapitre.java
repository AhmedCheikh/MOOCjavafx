/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;
import pidev.entities.Chapitre;
/**
 *
 * @author Gumus
 */
public interface IDAOChapitre {
    void add(Chapitre chapitre);
    void remove(Chapitre chapitre);
    void update(Chapitre chapitre);
}
