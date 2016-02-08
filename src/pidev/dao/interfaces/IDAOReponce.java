
package pidev.dao.interfaces;
import java.util.List;
import pidev.entities.Reponce;

public interface IDAOReponce {
    void addReponce(Reponce réponce);
    void removeReponce(Reponce réponce);
    void updateReponce(Reponce réponce);
    Reponce findReponceById(int id);
   List<Reponce> findReponceByEtat(boolean etat);
}
