/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;

import java.util.List;
import pidev.entities.Cours;

public interface IDaoCours {
    
    void addCours(Cours cours);

    void updateCours(Cours cours);

    void removeCoursByFormateur(int cinFormateur);

    void removeCoursById(int id);

    List<Cours> findAll();

    Cours findCoursById(int id);

    Cours findCoursByFormateur(int cinFormateur);
}
