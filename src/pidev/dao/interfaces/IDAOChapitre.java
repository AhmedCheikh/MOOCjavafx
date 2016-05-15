package pidev.dao.interfaces;

import java.sql.Blob;
import java.util.List;
import pidev.entities.Chapitre;
import pidev.entities.Quiz;

/**
 *
 * @author Gumus
 */
public interface IDAOChapitre {

    void addChapitre(Chapitre c);

    void removeChapitre(Chapitre c);

    void updateChapitre(Chapitre c, int id);

    List<Chapitre> findChapitre();

    List<Chapitre> findChapitreById(int id);

    int FindIdQuizbychapitre(String titre);

    int FindIdbychapitre(String titre);

    String FindVideobychapitre(int id);

    void FindPresentationbychapitre(int id);

    boolean ChercherTitre(String titre);

    void downloadPresentation(Chapitre c);

}
