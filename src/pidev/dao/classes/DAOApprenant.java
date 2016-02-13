/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.classes;

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
    
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    private Object organisme;

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
            pst.setString(5, a.getLogin());
            pst.setString(6, a.getPassword());
           
//            InputStream inputStream = new FileInputStream(a.getAvatar());                                             
//            pst.setBlob(5,inputStream);
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOApprenant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void update(Apprenant a, String cin) {
         String requete = "update apprenant set nom=?, prenom=?, email=? where cin=?";
        try {
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, a.getNom());
            pst.setString(2, a.getPrenom());
            pst.setString(3, a.getEmail());
            pst.setString(4, cin);
            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public List<CoursSuivie> listCoursSuivi(String cin) {
        String req = "select from coursuivi where cin == cin ";
        List<CoursSuivie> listCours=new ArrayList<>();
        
        try {
            pst=connection.prepareStatement(req);
            rs=pst.executeQuery();
            
            while(rs.next()){
                CoursSuivie cs =new CoursSuivie(rs.getInt("idCours"), rs.getString("cinApprenant"), rs.getString("Commentaire"), rs.getDouble("note"), rs.getString("dateDebut"), rs.getString("appreciation"));
                
                listCours.add(cs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCours.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCours;
        }

    @Override
    public boolean authentification(String login, String password) {
            int rowCount = 0;
        try {
            String req = "select from apprenant where login == ? and password=? ";
            pst=connection.prepareStatement(req);
            pst.setString(1, login);
            pst.setString(2, password);
            rs = pst.executeQuery();
            rowCount = rs.getRow();
        } catch (SQLException ex) {
            Logger.getLogger(DAOApprenant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowCount != 0;
    }
    
}
