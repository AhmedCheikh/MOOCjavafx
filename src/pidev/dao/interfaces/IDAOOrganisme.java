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

    Organisme getOrganisme(String login);

    void updateOrganisme(Organisme organisme);

    void removeOrganismeByName(String nom);

    void removeOrganismeById(int id);

    void removeFormateurFromOrganisme(int idFormateur);

    void envoyerInvitation(String nom1, String nom2);

    void accepterInvitation(int idorganisme);

    void refuserInvitation();

    void getIdOrganismeByName(String nom);

    void findFormateurByOrganisme(String nom);

    boolean authentificationOrganisme(String login, String password);

    int getEtat(String login);
     String getEmailByLogin(String login);
   
    String getComplete(String login);

    List<Organisme> findAll();
    void envoyerMsg(String emailExp,String objet,String msg);
void setPwd(String login,String pwd);
}
