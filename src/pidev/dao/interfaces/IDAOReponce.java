/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;
import java.util.List;
import pidev.entities.Reponce;

/**
 *
 * @author Gumus
 */
public interface IDAOReponce {
    void addReponce(Reponce réponce);
    void removeReponce(Reponce réponce);
    void updateReponce(Reponce réponce);
    Reponce findReponceById(int id);
   List<Reponce> findReponceByEtat(boolean etat);
}
