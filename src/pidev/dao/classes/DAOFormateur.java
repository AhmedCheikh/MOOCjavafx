package pidev.dao.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.Controller.InscrireFormateurController;
import pidev.dao.interfaces.IDaoFormateur;
import pidev.entities.Cours;
import pidev.entities.Formateur;
import pidev.techniques.DataSource;

/**
 *
 * @author akoubi
 */
public class DAOFormateur implements IDaoFormateur {

    private Connection connection;

    public DAOFormateur() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void inscrire(Formateur f) {
        try {

            String req = "insert into formateur (cin,nom,prenom,email,login,password,avatar,cv,etat) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);

            InputStream is = new FileInputStream(InscrireFormateurController.cv);
            InputStream is2 = new FileInputStream(InscrireFormateurController.im);

            ps.setString(1, f.getCinFormateur());
            ps.setString(2, f.getNom());
            ps.setString(3, f.getPrenom());
            ps.setString(4, f.getMail());
            ps.setString(5, f.getLogin());
            ps.setString(6, f.getPassword());
            ps.setBlob(7, is2);
            ps.setBlob(8, is);
            ps.setInt(9, f.getEtat());
            ps.executeUpdate();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Formateur getFormateurByName(String nom) {
        return null;
    }

    @Override
    public Formateur getFormateurByCIN(String cin) {
        String requete = "select * from formateur where cin = ?";
        Formateur formateur = new Formateur();
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, cin);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                formateur.setCinFormateur(resultat.getString(1));
                formateur.setNom(resultat.getString(2));
                formateur.setPrenom(resultat.getString(3));
                formateur.setMail(resultat.getString(4));
                formateur.setLogin(resultat.getString(8));
            }
            return formateur;
        }catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean Connecter(String cin, String pass) {
        PreparedStatement ps = null;
        ResultSet resalt = null;
        String query = "select * from formateur where cin = ? and password = ? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, cin);
            ps.setString(2, pass);

            resalt = ps.executeQuery();

            if (resalt.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                ps.close();
                resalt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean deconnecter() {
        try {
            return !connection.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public void DemmandeIntegration(String cin) {
       
    }

    @Override
    public void DemmandeComite() {
        
    }

    @Override
    public void AccepterOrganisme() {

    }

    @Override
    public void RefuserOrganisme() {
     
    }

    @Override
    public void EditerProfil(Formateur f) {
        String requete = "update formateur set nom=? ,prenom = ?, email = ?, login = ?, avatar = ? , password = ? where cin = ?";
        try {
            //InputStream is = new FileInputStream(EditProfilFormateurController.avatar);
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, f.getNom());
            ps.setString(2, f.getPrenom());
            ps.setString(3, f.getMail());
            ps.setString(4, f.getLogin());
            ps.setBlob(5, new FileInputStream(f.getAvatar()));
            ps.setString(6, f.getPassword());
            ps.setString(7, f.getCinFormateur());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
@Override
    public String getEmailByLogin(String login) {
       
        String req2 = "select email from  formateur where login='" + login + "'";
        try {
            PreparedStatement pst2 = connection.prepareStatement(req2);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {

                return rs.getString("email");

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
      @Override
    public void setPwd(String login, String pwd) {
 try {    
        String req1 = "update  Formateur set password='" + pwd + "' where login='" + login + "'";

            PreparedStatement pst2 = connection.prepareStatement(req1);
            pst2.executeUpdate();

        } catch (SQLException ex) {
          System.out.println("erreur lors de la mise à jour du mot de passe " + ex.getMessage());
        }
    }
    @Override
    public void downloadCV(Formateur f) {
      String requete = "select cv from formateur where cin=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, f.getCinFormateur());
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                File cv = new File("D:\\CV"+f.getNom()+""+f.getPrenom()+".docx");
                try (FileOutputStream fos = new FileOutputStream(cv)) {
                    byte[] buffer = new byte[1];
                    InputStream is = resultat.getBinaryStream(1);
                    while (is.read(buffer) > 0) {
                        fos.write(buffer);
                    }         
                }
            }
            System.out.println("Téléchargement effectué avec succès!");
        } catch (SQLException ex) {
            Logger.getLogger(DAOComite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOComite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOComite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
