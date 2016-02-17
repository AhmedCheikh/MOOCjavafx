/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.classes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.StringContent;
import pidev.dao.interfaces.IDAOOrganisme;
import pidev.entities.*;
import pidev.techniques.DataSource;
/**
 *
 * @author Rimy Jeljeli
 */
public class DAOOrganisme implements IDAOOrganisme{
  Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    public DAOOrganisme (){
        connection =(DataSource.getInstance()).getConnection();
    }
   
   
  @Override
    public void addOrganisme(Organisme organisme) {
   try {
        InputStream is;
       try {
           is = new FileInputStream(organisme.getDocument());
      

//       String req1="insert into orga (nom) values (?)";
   //     String req1="insert into organisme (id_organisme,nom,login,password,email,adresse) values (?,?,?,?,?,?)";
      String req1="insert into organisme (id_organisme,nom,login,password,email,adresse,document) values (?,?,?,?,?,?,?)";

          pst = connection.prepareStatement(req1);
         pst.setInt(1, organisme.getId());
          pst.setString(2, organisme.getNom());
          pst.setString(3, organisme.getLogin());
          pst.setString(4, organisme.getPassword());
          pst.setString(5, organisme.getEmail());
          pst.setString(6, organisme.getAdresse());
          pst.setBlob(7,is);

           pst.executeUpdate();
           //rs = pst.executeUpdate();

    
        } catch (FileNotFoundException ex) {
           Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
       }
//           System.out.println(rs.getRow());
           } catch (SQLException ex) {
                  Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
      } 
  
     
        }
    
    
    @Override
    public void updateOrganismeInscription(Organisme organisme) {
//        try {
//          String req1="update  organisme set (siteweb,telephone,description) values (?,?,?) where nom=?";
//        //né9ess logo
//          
//          pst = connection.prepareStatement(req1);
//          pst.setString(1, organisme.getSiteweb());
//          pst.setString(2, organisme.getTelephone());
//          pst.setString(3, organisme.getDescription());
////          pst.setString(4, organisme.getLogo());
//         pst.setString(4, organisme.getNom());
//           pst.executeUpdate();
//           } catch (SQLException ex) {
//      } 
//     
        }

    @Override
    public void updateOrganisme(Organisme organisme) {
//      try {
//          String req1="update  organisme set (nom,login,password,email,adresse,siteweb,telephone,description) values (?,?,?,?,?,?,?,?) where nom=?";
//          
//          pst.setString(1, organisme.getNom());
//          pst.setString(2, organisme.getLogin());
//          pst.setString(3, organisme.getPassword());
//          pst.setString(4, organisme.getEmail());
//          pst.setString(5, organisme.getAdresse());
//           pst.setString(6, organisme.getSiteweb());
//          pst.setString(7, organisme.getTelephone());
//          pst.setString(8, organisme.getDescription());
//           pst.setString(9, organisme.getNom());
//      } catch (SQLException ex) {
//          Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
//      }
    }

    @Override
    public void removeOrganismeByName(String nom) {
//  String requete = "delete from Organisme where nom=?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(requete);
//            ps.setString(1,nom);
//            ps.executeUpdate();
//            System.out.println("Organisme supprimé");
//        } catch (SQLException ex) {
//             System.out.println("erreur lors de la suppression " + ex.getMessage());
//    }
//    }
//    @Override
//    public void removeOrganismeById(int id) {
//  String requete = "delete from Organisme where idorganisme=?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(requete);
//            ps.setInt(1,id);
//            ps.executeUpdate();
//            System.out.println("Organisme supprimé");
//        } catch (SQLException ex) {
//             System.out.println("erreur lors de la suppression " + ex.getMessage());
//             
//    }
    }
    @Override
    public void removeFormateurFromOrganisme(int cin) {
//      try {
//          String req1="update  Formateur set (idOrganisme) values (null) where cin=?";
//          PreparedStatement ps = connection.prepareStatement(req1);
//          ps.setInt(1,cin);
//          ps.executeUpdate();
//      } catch (SQLException ex) {
//          Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
//      }

    }

    @Override
    public void envoyerInvitation(String nom1, String nom2) {
//      try {
//          String req1="insert into invitation (nom_exp,nom_des,date_invit,etat) values (?,?,?,?)";
//          
//          PreparedStatement ps = connection.prepareStatement(req1);
//          ps.setString(1,nom1);
//           ps.setString(2,nom2);
//          // ps.setDate(i, 1/22/2012);
//          ps.executeUpdate();
//      } catch (SQLException ex) {
//          Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
//      }
    }

    @Override
    public void accepterInvitation(int idorganisme) {
//      try {
//          String req1="update  invitation set (etat) values (?) where cin=?";
//          PreparedStatement ps = connection.prepareStatement(req1);
//          ps.setString(1,"lu");
//          ps.executeUpdate();
//          try {
//              String req2="update  Formateur set (idOrganisme) values (?) where cin=?";
//              PreparedStatement ps2 = connection.prepareStatement(req2);
//              ps2.setInt(1,idorganisme);
//              ps2.executeUpdate();
//          } catch (SQLException ex) {
//              Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
//          }
//      } catch (SQLException ex) {
//          Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
//      }
//      //ne3lmou el formateur
    }

    @Override
    public void refuserInvitation() {

     
      try {
          String req1="update  invitation set (etat) values (?) where cin=?";
          PreparedStatement ps = connection.prepareStatement(req1);
          ps.setString(1,"lu");
          ps.executeUpdate();
      } catch (SQLException ex) {
          Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
      }
          
         
    }           @Override
          public void findFormateurByOrganisme(String nom) {
//      try {
//          String req1="select * from  formateur where idorganisme=?";
//          PreparedStatement ps = connection.prepareStatement(req1);
//          
//         // ps.setint(1,id);
//          ps.executeUpdate();
//      } catch (SQLException ex) {
//          Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
//      }
          }
        @Override
        public List<Organisme> findAll() {
        return null;
              
          }

    @Override
    public void getIdOrganismeByName(String nom) {
        String req1="select idorgansme from  Organisme where nom=?";
    }

    @Override
    public void removeOrganismeById(int id) {

    }

    @Override
    public boolean authentificationOrganisme(String login, String password) {

      boolean res = false;
        try {
            String req = "select * from organisme where login = ? and password = ? ";
            pst=connection.prepareStatement(req);
            pst.setString(1, login);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next())
            {
                System.out.println("Authentification reussie");
                res = true;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOApprenant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public int getEtat(String login) {
        Organisme o1=new Organisme();
                
        String req2="select * from  Organisme where login='"+login+"'";
      try {
          PreparedStatement  pst2 = connection.prepareStatement(req2);
          ResultSet rs = pst2.executeQuery();
          while (rs.next()) {
                
             return rs.getInt("etat") ;
              
              
          }
      } catch (SQLException ex) {
          Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
      }
return 0;
    }
    
 

   
    }
    
    
    
    

 


  

  