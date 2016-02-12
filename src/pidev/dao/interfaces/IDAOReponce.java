
package pidev.dao.interfaces;
import java.util.List;
import pidev.entities.Reponse;

public interface IDAOReponce {
    void addReponce(Reponse r);
    void removeReponce(Reponse r);
    void updateReponce(Reponse r);
    List<Reponse> findReponceById(int id);
   List<Reponse> findReponceByEtat(int etat);
}
