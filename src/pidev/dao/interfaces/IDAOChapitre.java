package pidev.dao.interfaces;

import java.util.List;
import pidev.entities.Chapitre;

/**
 *
 * @author Gumus
 */
public interface IDAOChapitre {
    
    void addChapitre(Chapitre c);

    void removeChapitre(Chapitre c);

    void updateChapitre(Chapitre c);

    List<Chapitre> findChapitreByEtat(int id);

    List<Chapitre> findChapitreByTitre(String titre);

    List<Chapitre> findChapitreById(int id);
}
