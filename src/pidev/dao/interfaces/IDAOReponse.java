/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;
import java.util.List;
import pidev.entities.Reponse;
/**
 *
 * @author Gumus
 */
public interface IDAOReponse {
    void addReponse(Reponse r);
    void removeReponse(Reponse r);
    void updateReponse(Reponse r);
    List<Reponse> findReponseById(int id);
   List<Reponse> findReponseByEtat(int etat);
}
