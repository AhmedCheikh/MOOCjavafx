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
     public List<Formateur> findFormateurValide() ; 
    void validerCandidature(Formateur formateur) ; 
    void validerVideo(Cours cours) ; 
    void validerDescription(Cours cours) ;
    void validerCours(Cours cours) ;
    void validerQuiz(Quiz quiz) ; 
    void validerIntegrationComite(Formateur formateur);
    public List<Formateur> findAllFormateur() ;  
    boolean authentification(String login, String password);
    void downloadCV(Formateur f);
    Comite getComiteByLogin(String login);
    public void update( Comite c, String cin );
}
