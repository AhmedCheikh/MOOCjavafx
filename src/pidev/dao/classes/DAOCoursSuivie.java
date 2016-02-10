
package pidev.dao.classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.dao.interfaces.IDAOCoursSuivie;
public class DAOCoursSuivie implements IDAOCoursSuivie{
    
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    
    @Override
    public void donnerAppreciation() {

    }

    @Override
    public void commenter(String c) {
       try {
            String req="insert into coursuivi (Commentaire) values (?)";
            pst = connection.prepareStatement(req);
            pst.setString(1, c);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCoursSuivie.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
}
