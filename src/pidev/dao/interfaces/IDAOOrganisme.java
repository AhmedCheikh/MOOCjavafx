/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;

import java.util.List;
import javafx.collections.ObservableList;
import pidev.entities.*;

/**
 *
 * @author Rimy Jeljeli
 */
public interface IDAOOrganisme {

    void addOrganisme(Organisme organisme);

    void updateOrganismeInscription(Organisme organisme, String login);

    Organisme getOrganisme(String login);

    void updateOrganisme(Organisme organisme, String login);

    void removeOrganismeByName(String nom);

    void removeOrganismeById(int id);

    void removeFormateurFromOrganisme(String idFormateur);

    void envoyerInvitation(Invitation i);

    void AccepterInvit(String nom,int cin);

    public void refuserInvitation(String nom);

    public Formateur AllInfoFormateur(String nomexp);

    int getIdOrganismeByName(String nom);

    ObservableList<Formateur> findFormateurs();

    boolean authentificationOrganisme(String login, String password);

    int getEtat(String login);

    String getEmailByLogin(String login);

    public void downloadCV(Formateur f);

    String getComplete(String login);

    ObservableList<Formateur> chercherFormateurs(String nom);

    ObservableList<Formateur> chercherFormateurs1Organisme(String nom, int id);

    ObservableList<Organisme> ListeOrganisme(int id);

    void envoyerMsg(String emailExp, String objet, String msg);

    void setPwd(String login, String pwd);

    public ObservableList<Invitation> FindInvitationByNom(String nomdes);

    public ObservableList<Formateur> findFormateurs1Organisme(int id);
}
