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

    void Editer_Profil(Formateur f);

    void getFormateurByName(String nom);

    void getFormateurByCIN(String cin);
    
    List<Cours> ListCoursByNameFormateur(String nom);
  
    void DemmandeIntegration();
    
    void DemmandeComite();

    void AccepterOrganisme();

    void RefuserOrganisme();
    
    void PublierCours(Cours c);
    
    void EditerCours(Cours c);
    
    void AjouterQuiz(Quiz q);
}
