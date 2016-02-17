/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pidev.dao.interfaces.IDAOComite ; 
import pidev.entities.Comite;
import pidev.entities.Cours;
import pidev.entities.Formateur;
import pidev.entities.Quiz;
import pidev.techniques.DataSource;

/**
 *
 * @author WiKi
 */
public class DAOComite implements IDAOComite{
    
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    
     public DAOComite() {
        connection =(DataSource.getInstance()).getConnection();
    }

    @Override
    public void validerCandidature(Formateur f) {
       String requete = "update formateur set etat=1 where cin=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1,f.getCinFormateur());
            ps.executeUpdate();
            System.out.println("Validation du formateur effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("Erreur de validation du formateur " + ex.getMessage());
        }
    }

    @Override
    public void validerVideo(Cours c) {
       String requete = "update cours set etat=1 where idcours=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,c.getIdCours() );
            ps.executeUpdate();
            System.out.println("Validation du cours effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("Erreur de validation du cours " + ex.getMessage());
        }        
        
        
    }

    @Override
    public void validerDescription(Cours c) {
       String requete = "update cours set etat=2 where idcours=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,c.getIdCours() );
            ps.executeUpdate();
            System.out.println("Validation du cours effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("Erreur de validation du cours " + ex.getMessage());
        }        
                
    }

    @Override
    public void validerCours(Cours c) {
        
        String requete = "update cours set etat=3 where idcours=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,c.getIdCours() );
            ps.executeUpdate();
            System.out.println("Validation du cours effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("Erreur de validation du cours " + ex.getMessage());
        }
        
    }

    @Override
    public void validerQuiz(Quiz quiz) {
       String requete = "update quiz set etat=1 where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,quiz.getIdQuiz());
            ps.executeUpdate();
            System.out.println("Validation du Quiz effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("Erreur de validation du Quiz " + ex.getMessage());
        }
    }

    @Override
    public void validerIntegrationComite(Formateur formateur) {
        
         String requete = "insert into comite (cin,nom,prenom,email,login,password) values (select cin,nom,prenom,email,login,password from formateur where cin=?) ";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1,formateur.getCinFormateur());
            ps.executeUpdate();
            System.out.println("Intégration à la comité effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("Erreur d'intégration " + ex.getMessage());
        }
        
    }

    @Override
    public List<Comite> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
     public boolean authentification(String login, String password) {
         boolean res = false ; 
        String requete = "select * from comite where login=? and password=?" ; 
        
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet resultat = ps.executeQuery();
            if (resultat.next()) {
                System.out.println("Authentification réussie ! ");
                res = true ; 
            } else {
                System.out.println("Echec !");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
         return res ;  
         
     }
    
}
