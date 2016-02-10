/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.classes;
import java.sql.Connection;
import pidev.dao.interfaces.IDAOAdministrateur ; 
import pidev.techniques.DataSource;

/**
 *
 * @author WiKi
 */
public class DAOAdministrateur implements IDAOAdministrateur{

    public DAOAdministrateur() {
        Connection connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void validerPreinscriOrganisme() {
        
    }
    
}
