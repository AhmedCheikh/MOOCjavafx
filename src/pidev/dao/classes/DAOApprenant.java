/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.dao.interfaces.IDAOApprenant;
import pidev.entities.Apprenant;
import pidev.entities.CoursSuivie;
import pidev.techniques.DataSource;

/**
 *
 * @author Khoubaib
 */
public class DAOApprenant implements IDAOApprenant<Apprenant>{
//    public static void main(String[] args) {
//        DataSource ds = DataSource.getInstance();
//        File f = new File("C:\\Users\\Khoubaib\\Downloads\\Other\\double.jpg");
//        File f1 = new File("C:\\Users\\Khoubaib\\Downloads\\Other\\saitama.jpg");
//        Apprenant a = new Apprenant("123", "bes", "aziz", "@@", f, "az", "123");
//        DAOApprenant dao = new DAOApprenant();
//        //dao.add(a);
//        a.setAvatar(f);
//        dao.update(a);
//    }
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public DAOApprenant() {
        connection =(DataSource.getInstance()).getConnection();
    }
    

    @Override
    public void add(Apprenant a) {
        try {
            String req="insert into apprenant (cin,nom,prenom,email,login,password) values (?,?,?,?,?,?)";
            pst=connection.prepareStatement(req);

            pst.setString(1, a.getCin());
            pst.setString(2, a.getNom());
            pst.setString(3, a.getPrenom());
            pst.setString(4, a.getEmail());
           // pst.setBlob(5, new FileInputStream(a.getAvatar()));
            pst.setString(5, a.getLogin());
            pst.setString(6, a.getPassword());
                     
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOApprenant.class.getName()).log(Level.SEVERE, null, ex);

        
    }
    }

    
    
    public void update(Apprenant a, String cin ) {
         String requete = "update apprenant set  nom = ?, prenom = ?, login = ? , password = ? , avatar = ? where cin = ?";
        try {
            pst = connection.prepareStatement(requete);
            pst.setString(1, a.getNom());
            pst.setString(2, a.getPrenom());
            pst.setString(3, a.getLogin());
            pst.setString(4, a.getPassword());                                     
            pst.setBlob(5, new FileInputStream(a.getAvatar()));
            pst.setString(6, a.getCin());
            
            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOApprenant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<CoursSuivie> listCoursSuivi(String cin) {
        String req = "select from coursuivi where cin = ? ";
        List<CoursSuivie> listCours=new ArrayList<>();
        
        try {
            pst=connection.prepareStatement(req);
             pst.setString(1, cin);
            rs=pst.executeQuery();
            
            while(rs.next()){
                //CoursSuivie cs =new CoursSuivie(rs.getInt("idCours"), rs.getString("cinApprenant"), rs.getString("Commentaire"), rs.getDouble("note"), rs.getString("dateDebut"), rs.getString("appreciation"));
                
                //listCours.add(cs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCours.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCours;
        }

    @Override
    public boolean authentification(String login, String password) {
        boolean res = false;
        try {
            String req = "select * from apprenant where login = ? and password = ? ";
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
    
    public Apprenant getApprenantByEmail(String email) {
         
            Apprenant a = new Apprenant();
            String req = "select * from apprenant where email = ?";
        try {
            
            pst=connection.prepareStatement(req);
            pst.setString(1, email);
            rs = pst.executeQuery();
            while(rs.next()){
               
                a.setCin(rs.getString(1));
                a.setNom(rs.getString(2));
                a.setPrenom(rs.getString(3));
                a.setEmail(rs.getString(4));
                a.setLogin(rs.getString(6));
                a.setPassword(rs.getString(7));
                
               // a = new Apprenant(rs.getString("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("login"));
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(DAOApprenant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Apprenant getApprenantByLogin(String login) {
         
            Apprenant a = new Apprenant();
            String req = "select * from apprenant where login = ?";
        try {
            
            pst=connection.prepareStatement(req);
            pst.setString(1, login);
            rs = pst.executeQuery();
            while(rs.next()){
               
                a.setCin(rs.getString(1));
                a.setNom(rs.getString(2));
                a.setPrenom(rs.getString(3));
                a.setEmail(rs.getString(4));
                a.setLogin(rs.getString(6));
                a.setPassword(rs.getString(7));
                
               // a = new Apprenant(rs.getString("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("login"));
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(DAOApprenant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(Apprenant t, String cin, File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
  

    
}
