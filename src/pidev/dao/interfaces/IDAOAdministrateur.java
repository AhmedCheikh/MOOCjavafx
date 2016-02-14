/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.interfaces;
import pidev.entities.Organisme;
/**
 *
 * @author WiKi
 */
public interface IDAOAdministrateur {
    
    void validerPreinscriOrganisme(Organisme o) ; 
    boolean authentification(String login, String password);
    
}
