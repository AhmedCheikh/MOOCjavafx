/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;
import java.util.List;
import pidev.entities.* ; 


/**
 *
 * @author WiKi
 */
public interface IDAOComite {
    void validerCandidature(Formateur formateur) ; 
    void validerVideo() ; 
    void validerDescription() ;
    void validerCours(Cours cours) ;
    void validerQuiz(Quiz quiz) ; 
    void validerIntegrationComite(Formateur formateur);
    List<Comite> findAll() ; 
}
