
package pidev.dao.interfaces;

import java.util.List;
import pidev.entities.Cours;

public interface IDaoCours {
    
    void addCours(Cours cours);

    void updateCours(Cours cours);

    void removeCoursByFormateur(String cinFormateur);

    void removeCoursByName(String nomCours);

    List<Cours> findAll();

    Cours findCoursByName(String nomCours);

    Cours findCoursByFormateur(String cinFormateur);
    
    Cours findCoursByDifficulte (String difficulte) ;
}
