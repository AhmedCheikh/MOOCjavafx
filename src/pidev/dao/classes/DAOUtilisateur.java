
package pidev.dao.classes;
import java.sql.Connection;
import pidev.dao.interfaces.IDaoUtilisateur;
import pidev.techniques.DataSource;
public class DAOUtilisateur implements IDaoUtilisateur{

    public DAOUtilisateur() {
        Connection connection = (DataSource.getInstance()).getConnection();
    }

    @Override
    public void authentification(String login, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
