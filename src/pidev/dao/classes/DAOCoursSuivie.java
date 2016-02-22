
package pidev.dao.classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.dao.interfaces.IDAOCoursSuivie;
import pidev.entities.CoursSuivie;
import pidev.techniques.DataSource;
public class DAOCoursSuivie implements IDAOCoursSuivie{
    
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public DAOCoursSuivie() {
          connection = DataSource.getInstance().getConnection();
    }
    
    

    @Override
    public void ajouter(CoursSuivie c) {
        try {
            String req="insert into coursuivi (id_cours,cinapprenant,date_debut) values (?,?,?)";
            pst=connection.prepareStatement(req);
            pst.setInt(1, c.getId_cours());
            pst.setString(2, c.getCinapprenant());
            pst.setString(3, c.getDate_debut());
      
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCours.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ajouterCommentaire(CoursSuivie c) {
       String requete = "update coursuivi set commentaire=? where cinapprenant=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
           pst.setString(1, c.getCommentaire());
            pst.setString(2, c.getCinapprenant());
         
         
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public void ajouterNote(CoursSuivie c) {
       String requete = "update coursuivi set note=? where cinapprenant=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
           
            pst.setDouble(1, c.getNote());
            pst.setString(2, c.getAppreciation());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public void ajouterAppreciation(CoursSuivie c) {
       String requete = "update coursuivi set appreciation=? where cinapprenant=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            pst.setString(1, c.getAppreciation());
            pst.setString(2, c.getCinapprenant());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    
    public CoursSuivie getCourByCinApprenant(String cin) throws SQLException{
   
        String req= "select from coursuivi where cinapprenant = ?";
        pst = connection.prepareStatement(req);
        pst.setString(1, cin);
        rs = pst.executeQuery();
        CoursSuivie cs = new CoursSuivie();
            while (rs.next()){
              // CoursSuivie cs = new CoursSuivie(rs.getInt("idCoursuivi"), rs.getInt("id_cours"), rs.getString("cinapprenant"),rs.getString("commentaire"), rs.getDouble("note"), rs.getString("date_debut"), rs.getString("appreciation"));
                ;
                cs.setId_cours(rs.getInt("id_cours"));
                cs.setCinapprenant(rs.getString("cinapprenant"));
                cs.setCommentaire(rs.getString("commentaire"));
                cs.setNote(rs.getFloat("note"));
                cs.setDate_debut(rs.getString("date_debut"));
                cs.setAppreciation(rs.getString("appreciation"));
                cs.setIdCoursuivi(rs.getInt("idCoursuivi"));

                return cs;
            }
    return null;
    }
    public static void main(String[] args) throws SQLException {
         DAOCoursSuivie dcs = new DAOCoursSuivie();
        CoursSuivie cs = new CoursSuivie();
        
        cs = dcs.getCourByCinApprenant("0123456");
        System.out.println(cs.getAppreciation());
    }
    
}
