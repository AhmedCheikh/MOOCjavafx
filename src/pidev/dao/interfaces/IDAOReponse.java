/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;
import java.util.List;
import pidev.entities.Question;
import pidev.entities.Reponse;
/**
 *
 * @author Gumus
 */
public interface IDAOReponse {
    void addReponse(Reponse r);
    void removeReponse(int id);
    void updateReponse(int id,Reponse r);
    List<Reponse> findReponseById(int id);
   List<Reponse> findReponseByEtat(int etat);
   List<Reponse> FindIdReponsebyQuestion(int q);
   int findEtatReponse(String r);
}
