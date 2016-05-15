package pidev.dao.interfaces;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import pidev.entities.Cours;
import pidev.entities.CoursSuivie;
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
    
    int nbrInvit(String cin);
    
    ObservableList<Organisme> ListeOrganisme();
    
    Organisme AllInfoOrganisme(String nomexp);
    
    ObservableList<Organisme> FindOrganismeByName(String nom);
    
    ObservableList<Invitation> FindInvitationByNom(String nomdes);
            
    void publierCour(Cours c);
    
    Cours getCoursById(int id);
    
    ObservableList<Cours> listCoursFormateurbyCin(String cin);
    
    ArrayList<CoursSuivie> listCrSuivieFormateurbyCin();
    
    ObservableList<Invitation> listeMesOrganismesbyCin(String cin);
    
    ArrayList<Quiz> listQuiz();
  
    void setPwd(String login, String pwd);
    String getEmailByLogin(String login);
    
}
