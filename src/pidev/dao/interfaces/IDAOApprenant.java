/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;

import java.util.List;
import pidev.entities.Apprenant;
import pidev.entities.CoursSuivie;

/**
 *
 * @author Khoubaib
 */
public interface IDAOApprenant<T> {
    void add(T t);
    void update(T t, String cin);
    void updateWithoutAvatarChange(T t, String cin );
    List<CoursSuivie> listCoursSuivi(String cin);
    boolean authentification(String login,String password);
    T getApprenantByEmail(String email);
    T getApprenantByLogin(String login);
    public void setPwd(String login, String pwd);
    public String getEmailByLogin(String login);
    public Apprenant getApprenantByCin(String cin);
}
