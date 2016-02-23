package pidev.dao.interfaces;

import java.util.List;
import javafx.collections.ObservableList;
import pidev.entities.Cours;
import pidev.entities.Formateur;
import pidev.entities.Invitation;
import pidev.entities.Organisme;
import pidev.entities.Quiz;

/**
 *
 * @author akoubi
 */
public interface IDaoFormateur {

    void inscrire(Formateur f);
    
    boolean Connecter(String cin, String pass);
    
    boolean deconnecter();
    
    Formateur getFormateurByName(String nom);

    Formateur getFormateurByCIN(String cin);
  
    void DemmandeIntegration(Invitation invit);
    
   

    void AccepterOrganisme(String nom);

    void RefuserOrganisme(String nom);
    
    void EditerProfil(Formateur f);
    
    String getEmailByLogin(String login);
     public void setPwd(String login, String pwd);
     void downloadCV(Formateur f);
       void publierCour(Cours c);
    
    Cours getCoursById(int id);
    int nbrInvit(String cin);
    
    ObservableList<Organisme> ListeOrganisme();
    
    Organisme AllInfoOrganisme(String nomexp);
    
    ObservableList<Organisme> FindOrganismeByName(String nom);
    
    ObservableList<Invitation> FindInvitationByNom(String nomdes);
}
