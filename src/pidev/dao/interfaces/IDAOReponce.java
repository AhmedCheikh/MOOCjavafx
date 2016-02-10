
package pidev.dao.interfaces;
import java.util.List;
import pidev.entities.Reponse;

public interface IDAOReponce {
    void addReponce(Reponse réponce);
    void removeReponce(Reponse réponce);
    void updateReponce(Reponse réponce);
    Reponse findReponceById(int id);
   List<Reponse> findReponceByEtat(boolean etat);
}
