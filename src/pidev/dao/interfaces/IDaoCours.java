
package pidev.dao.interfaces;

import java.util.List;
import pidev.entities.Cours;

public interface IDaoCours {
    
    void addCours(Cours cours);

    void updateCours(Cours cours);

    void removeCoursByFormateur(String cinFormateur);

    void removeCoursById(int id);

    List<Cours> findAll();

    Cours findCoursById(int id);

    Cours findCoursByFormateur(String cinFormateur);
    
    Cours findCoursByDifficulte (String difficulte) ;
}
