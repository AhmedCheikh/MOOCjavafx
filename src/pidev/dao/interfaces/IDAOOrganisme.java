/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;

import java.util.List;
import pidev.entities.*;

/**
 *
 * @author Rimy Jeljeli
 */
public interface IDAOOrganisme {
    void addOrganisme(Organisme organisme);
    
    void updateOrganismeInscription(Organisme organisme);
    
    void updateOrganisme(String nom);

    void removeOrganismeByName(String nom);

    void removeOrganismeById(int id);
    
    void removeFormateurFromOrganisme(int idFormateur);
    
    
     void envoyerInvitation(String email1,String email2);
     
     void accepterInvitation();
     
     void refuserInvitation();
     
     void findFormateurByOrganisme(String nom);

    List<Organisme> findAll();

    Organisme findOrganismeById(int id);

    Organisme findOrganismeByAdresse(String adresse);

}
