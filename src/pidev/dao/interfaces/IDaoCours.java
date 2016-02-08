
package pidev.dao.interfaces;

import java.util.List;
import pidev.entities.Cours;

public interface IDaoCours {
    
    void addCours(Cours cours);

    void updateCours(Cours cours);

    void removeCoursByFormateur(int cinFormateur);

    void removeCoursById(int id);

    List<Cours> findAll();

    Cours findCoursById(int id);

    Cours findCoursByFormateur(int cinFormateur);
    
    Cours findCoursByDifficulte (String difficulte) ;
}
