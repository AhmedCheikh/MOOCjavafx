package pidev.dao.interfaces;

import java.util.List;
import pidev.entities.Cours;
import pidev.entities.Formateur;
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
  
    void DemmandeIntegration(String cin);
    
    void DemmandeComite();

    void AccepterOrganisme();

    void RefuserOrganisme();
    
    void EditerProfil(Formateur f);
    
    String getEmailByLogin(String login);
     public void setPwd(String login, String pwd);
}
