
package pidev.dao.classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        connection =(DataSource.getInstance()).getConnection();
    }
    
    

    @Override
    public void ajouter(CoursSuivie c) {
        try {
            String req="insert into coursuivi (id_cours,cinapprenant,date_debut) values (?,?,?)";
            pst=connection.prepareStatement(req);
            pst.setInt(1, c.getId_cours());
            pst.setString(2, c.getCinapprenant());
            pst.setDate(3, (Date) c.getDate_debut());
      
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
   
        String req= "select * from coursuivi where cinapprenant = ?";
        pst = connection.prepareStatement(req);
        pst.setString(1, cin);
        rs = pst.executeQuery();
        CoursSuivie cs = new CoursSuivie();
            while (rs.next()){
              //CoursSuivie cs = new CoursSuivie(rs.getInt("idCoursuivi"), rs.getInt("id_cours"), rs.getString("cinapprenant"),rs.getString("commentaire"), rs.getFloat("note"), rs.getString("date_debut"), rs.getString("appreciation"));
                
//                cs.setId_cours(rs.getInt("id_cours"));
//                cs.setCinapprenant(rs.getString("cinapprenant"));
//                cs.setCommentaire(rs.getString("commentaire"));
//                cs.setNote(rs.getFloat("note"));
//                cs.setDate_debut(rs.getString("date_debut"));
//                cs.setAppreciation(rs.getString("appreciation"));
//                cs.setIdCoursuivi(rs.getInt("idCoursuivi"));
                cs.setId_cours(rs.getInt(1));
                cs.setCinapprenant(rs.getString(2));
                cs.setCommentaire(rs.getString(3));
                cs.setNote(rs.getFloat(4));
                cs.setDate_debut(rs.getDate(5));
                cs.setAppreciation(rs.getString(6));
                cs.setIdCoursuivi(rs.getInt(7));
                return cs;
            }
    return null;
    }
 
        public void donnerAppreciation(String appreciation, String cin) {
       String requete = "update coursuivi set appreciation=? where cinapprenant=?";
        try {
            pst = connection.prepareStatement(requete);
            pst.setString(1, appreciation);
            pst.setString(2, cin);
            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    
         public void laisserCommentaire(String c , String cin ) {
       String requete = "update coursuivi set commentaire=? where cinapprenant=?";
         try {
            pst = connection.prepareStatement(requete);
            pst.setString(1, c);
            pst.setString(2, cin);
            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    

        
//       public static void main(String[] args) throws SQLException {
//         DAOCoursSuivie dcs = new DAOCoursSuivie();
//        CoursSuivie cs = new CoursSuivie();
//        
//       cs = dcs.getCourByCinApprenant("11111125");
//        System.out.println(cs.getCommentaire());
            //dcs.donnerAppreciation("Mauvais", "11111125");
            
//        Calendar c = Calendar.getInstance();
//        c.setTime(cs.getDate_debut());
//        c.add(Calendar.DATE, 30);
//        
//            System.out.println(c.getTime());
//            
//            Date d1 = new Date(2016, 01, 01);
//
//            Date d2 = new Date(2016,05,29);
//
//                long diff = d2.getTime() - d1.getTime();
//
//            System.out.println("Difference between  " + d1 + " and "+ d2+" is "
//                + (diff / (1000 * 60 * 60 * 24)) + " days.");
    } 
