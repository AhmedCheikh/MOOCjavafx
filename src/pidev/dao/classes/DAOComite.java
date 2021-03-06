/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.classes;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.dao.interfaces.IDAOComite ; 
import pidev.entities.Apprenant;
import pidev.entities.Comite;
import pidev.entities.Cours;
import pidev.entities.Formateur;
import pidev.entities.Quiz;
import pidev.techniques.DataSource;
import pidev.entities.Comite;

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
    public void update( Comite c, String cin ) {
         String requete = "update comite set  nom = ?, prenom = ?, email=?, login = ? , password = ? where cin = ?";
        try {
            pst = connection.prepareStatement(requete);
            pst.setString(1, c.getNom());
            pst.setString(2, c.getPrenom());
            pst.setString(3, c.getEmail());
            pst.setString(4, c.getLoginComite());
            pst.setString(5, c.getPasswordComite());
            pst.setString(6, c.getCIN());
            
            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        } 
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
        
         String requete = "insert into comite (cin,nom,prenom,email,login,password) select cin,nom,prenom,email,login,password from formateur where cin=? ";
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
    public List<Formateur> findAllFormateur() {
        List<Formateur> listeformateur = new ArrayList<>();
        String requete = "select * from formateur where etat=0";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Formateur formateur = new Formateur();
                formateur.setCinFormateur(resultat.getString(1));
                formateur.setNom(resultat.getString(2));
                formateur.setPrenom(resultat.getString(3));
                formateur.setMail(resultat.getString(4));
                formateur.setEtat(resultat.getInt(5));
                formateur.setAvatar(null);
                formateur.setCv(resultat.getString(7));
                formateur.setLogin(null);
                formateur.setPassword(null);
                listeformateur.add(formateur);
            }
            return listeformateur;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Formateur> findFormateurValide() {
        List<Formateur> listeformateur = new ArrayList<>();
        String requete = "select * from formateur where etat=1";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Formateur formateur = new Formateur();
                formateur.setCinFormateur(resultat.getString(1));
                formateur.setNom(resultat.getString(2));
                formateur.setPrenom(resultat.getString(3));
                formateur.setMail(resultat.getString(4));
                formateur.setEtat(resultat.getInt(5));
                formateur.setAvatar(null);
                formateur.setCv(resultat.getString(7));
                formateur.setLogin(null);
                formateur.setPassword(null);
                listeformateur.add(formateur);
            }
            return listeformateur;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
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



    @Override
    public void downloadCV(Formateur f) {
      try {
            String requete = "select cv from formateur where cin=?";
            
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, f.getCinFormateur());
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
               File pdfFile = new File("src/pidev/gui/pdf/"+f.getCv());
                System.out.println(pdfFile.getAbsolutePath());
                pdfFile.getAbsolutePath();
               if (pdfFile.exists()) {

			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().open(pdfFile);
			} else {
				System.out.println("Awt Desktop is not supported!");
			}

		} else {
			System.out.println("File is not exists!");
		}

		System.out.println("Done");

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOComite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOComite.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    @Override
    public Comite getComiteByLogin(String login) {
         
            Comite a = new Comite();
            String req = "select * from comite where login = ?";
        try {
            
            pst=connection.prepareStatement(req);
            pst.setString(1, login);
            rs = pst.executeQuery();
            while(rs.next()){
               
                a.setCIN(rs.getString(1));
                a.setNom(rs.getString(2));
                a.setPrenom(rs.getString(3));
                a.setEmail(rs.getString(4));
                a.setLoginComite(rs.getString(5));
                a.setPasswordComite(rs.getString(6));  
                

            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(DAOApprenant.class.getName()).log(Level.SEVERE, null, ex);

        return null;
    }
    }
    
}
