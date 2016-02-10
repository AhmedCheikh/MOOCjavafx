/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;

import java.util.List;
import pidev.entities.Organisme;

/**
 *
 * @author Rimy Jeljeli
 */
public interface IDAOOrganisme {
    void addOrganisme(Organisme organisme);

    void updateOrganisme(Organisme organisme);

    void removeOrganismeByName(String adresse);

    void removeOrganismeById(int id);
    
     void envoyerInvitation(String email1,String email2);
     
     void accepterInvitation();
     
     void refuserInvitation();
     
     void findFormateurByOrganisme(String nom);

    List<Organisme> findAll();

    Organisme findOrganismeById(int id);

    Organisme findOrganismeByAdresse(String adresse);

}
