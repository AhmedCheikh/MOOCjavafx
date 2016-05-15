
package pidev.dao.interfaces;

import pidev.entities.CoursSuivie;

public interface IDAOCoursSuivie {
    void ajouter(CoursSuivie c);
    void ajouterNote(CoursSuivie c);
    void donnerAppreciation(String appreciation, int idCoursuivi);
    void laisserCommentaire(String commentaire , int idCoursuivi );
    CoursSuivie getCourSuiviByCinApprenantAndCoursId(String cin , int id);
   
}
