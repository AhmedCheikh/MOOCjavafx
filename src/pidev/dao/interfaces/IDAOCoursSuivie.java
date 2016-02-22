
package pidev.dao.interfaces;

import pidev.entities.CoursSuivie;

public interface IDAOCoursSuivie {
    void ajouter(CoursSuivie c);
    void ajouterCommentaire(CoursSuivie c);
    void ajouterNote(CoursSuivie c);
    void ajouterAppreciation(CoursSuivie c);
}
