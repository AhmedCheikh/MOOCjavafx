package pidev.dao.interfaces;

import java.util.List;
import pidev.entities.Chapitre;

/**
 *
 * @author Gumus
 */
public interface IDAOChapitre {

    void addChapitre(Chapitre chapitre);

    void removeChapitre(Chapitre chapitre);

    void updateChapitre(Chapitre chapitre);

    Chapitre findQuizByChapitre(int id);

    Chapitre findQuizByTitre(String titre);

    List<Chapitre> findQuizByEtat(boolean etat);
}
