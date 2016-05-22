/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.classes;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import pidev.dao.interfaces.IDAOOrganisme;
import pidev.entities.*;
import pidev.techniques.DataSource;

/**
 *
 * @author Rimy Jeljeli
 */
public class DAOOrganisme implements IDAOOrganisme {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    private Object emailExp;

    public DAOOrganisme() {
        connection = (DataSource.getInstance()).getConnection();
    }

    @Override
    public void addOrganisme(Organisme organisme) {

        try {

//       String req1="insert into orga (nom) values (?)";
            //     String req1="insert into organisme (id_organisme,nom,login,password,email,adresse) values (?,?,?,?,?,?)";
            String req1 = "insert into organisme (nom,login,password,email,adresse,document,complete,etat) values (?,?,?,?,?,?,?,?)";

            pst = connection.prepareStatement(req1);

            pst.setString(1, organisme.getNom());
            pst.setString(2, organisme.getLogin());
            pst.setString(3, organisme.getPassword());
            pst.setString(4, organisme.getEmail());
            pst.setString(5, organisme.getAdresse());
            pst.setString(6, organisme.getDocument());
            pst.setString(7, "0");
            pst.setInt(8, 0);
            pst.executeUpdate();
            //rs = pst.executeUpdate();

        } //           System.out.println(rs.getRow());
        catch (SQLException ex) {
            Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateOrganismeInscription(Organisme organisme, String login) {

        try {

            String req2 = "update  organisme set  siteweb=?, telephone=?, description=? ,logo=? ,complete=?  where login =?";

            PreparedStatement pst2;

            pst2 = connection.prepareStatement(req2);
            pst2.setString(1, organisme.getSiteweb());
            pst2.setString(2, organisme.getTelephone());
            pst2.setString(3, organisme.getDescription());
            pst2.setString(4, organisme.getLogo());
            pst2.setString(5, "1");
            pst2.setString(6, login);
            pst2.executeUpdate();

//           System.out.println(rs.getRow());
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateOrganisme(Organisme organisme, String login) {
        try {
            String req1 = "update  organisme set nom=?,login=?,password=?,email=?,adresse=?,siteweb=?,telephone=?,description=?,logo=?  where login=?";
            PreparedStatement pst3;
            pst3 = connection.prepareStatement(req1);
            pst3.setString(1, organisme.getNom());
            pst3.setString(2, organisme.getLogin());
            pst3.setString(3, organisme.getPassword());
            pst3.setString(4, organisme.getEmail());
            pst3.setString(5, organisme.getAdresse());
            pst3.setString(6, organisme.getSiteweb());
            pst3.setString(7, organisme.getTelephone());
            pst3.setString(8, organisme.getDescription());
            pst3.setString(9, organisme.getLogo());
            pst3.setString(10, login);
            pst3.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
            Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public void removeFormateurFromOrganisme(String cin) {
      try {
          String req1="update  Formateur set organisme_id =? where cin=?";
          PreparedStatement ps = connection.prepareStatement(req1);
          ps.setString(1,null);
           ps.setString(2,cin);
          ps.executeUpdate();
      } catch (SQLException ex) {
          Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
      }

    }

    @Override
    public void envoyerInvitation(Invitation invit) {
        PreparedStatement ps = null;
        try {

            String req = "insert into invitation (id,nom_exp,nom_des,date_invit,date_confi,date_vue,etat) values (?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(req);

            ps.setInt(1, invit.getId());
            ps.setString(2, invit.getNom_exp());
            ps.setString(3, invit.getNom_des());
            ps.setDate(4, (Date) invit.getDate_invit());
            ps.setDate(5, (Date) invit.getDate_confi());
            ps.setDate(6, (Date) invit.getDate_vue());
            ps.setInt(7, invit.getEtat());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void AccepterInvit(String nom,int id) {
      java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        String requete = "update invitation set etat = 1,date_confi=? where nom_exp = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setDate(1, sqlDate);
            ps.setString(2, nom);
            ps.executeUpdate();
            System.out.println("invitation Accepté");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'acceptation " + ex.getMessage());
        }
        
            String requete2 = "update formateur set Organisme_id = ? where cin = ?";
        try {
            PreparedStatement ps2 = connection.prepareStatement(requete2);
            ps2.setInt(1, id);
               ps2.setString(2, nom);
            ps2.executeUpdate();
            System.out.println("invitation Accepté");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'update formateur" + ex.getMessage());
        }
    }

    @Override
    public Formateur AllInfoFormateur(String nomexp) {
        String requete = "select * from formateur where nom = ?";
        Formateur f = new Formateur();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(requete);
            ps.setString(1, nomexp);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                f.setCinFormateur(resultat.getString(1));
                f.setNom(resultat.getString(2));
                f.setPrenom(resultat.getString(3));
                f.setMail(resultat.getString(4));
                 f.setAvatar(resultat.getString(6));
                  f.setCv(resultat.getString(7));

            }
            return f;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void refuserInvitation(String nom) {

        String requete = "delete from invitation where nom_exp = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, nom);
            ps.executeUpdate();
            System.out.println("invitation refusé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public ObservableList<Formateur> findFormateurs() {
        String requete = "SELECT * FROM formateur WHERE Organisme_id is null and etat=?";
        try {
            pst = connection.prepareStatement(requete);
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        ObservableList<Formateur> lst1 = FXCollections.observableArrayList();
        try {
            
            pst = connection.prepareStatement(requete);

            pst.setInt(1, 1);
            ResultSet resultat = pst.executeQuery();
            while (resultat.next()) {
                lst1.add(new Formateur(
                        resultat.getString("cin"),
                        resultat.getString("nom"),
                        resultat.getString("prenom"),
                            resultat.getString("email")
                ));
            }
            return lst1;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public ObservableList<Formateur> findFormateurs1Organisme(int id) {
        String requete = "SELECT * FROM formateur WHERE Organisme_id =? and etat=?";
        PreparedStatement ps = null;
        ObservableList<Formateur> lst1 = FXCollections.observableArrayList();
        try {
            int x = 1;
            ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.setInt(2, x);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                lst1.add(new Formateur(
                        resultat.getString("cin"),
                        resultat.getString("nom"),
                        resultat.getString("prenom"),
                        resultat.getString("email")
                ));
            }
            return lst1;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
public ObservableList<Organisme> ListeOrganisme(int id) {
        String requete = "select * from organisme where etat=1 and idorganisme<> '" + id + "'";
        PreparedStatement ps = null;
        ObservableList<Organisme> lst = FXCollections.observableArrayList();
        try {
            ps = connection.prepareStatement(requete);
//            ps.setInt(2, 1);
//            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                lst.add(new Organisme(
                        resultat.getString("nom"),
                        resultat.getString("email"),
                        resultat.getString("siteweb"),
                        resultat.getString("adresse"),
                        resultat.getString("telephone"),
                        resultat.getString("description")
                ));
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ObservableList<Organisme> chercherOrganisme(String nom) {
        String requete = "select * from organisme where nom like? and etat=?";
        PreparedStatement ps = null;
        ObservableList<Organisme> lst = FXCollections.observableArrayList();
        try {
            ps = connection.prepareStatement(requete);
            ps.setString(1, nom);
            ps.setInt(2, 1);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                lst.add(new Organisme(
                        resultat.getString("nom"),
                        resultat.getString("email"),
                        resultat.getString("siteweb"),
                        resultat.getString("adresse"),
                        resultat.getString("telephone"),
                        resultat.getString("description")
                ));
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ObservableList<Formateur> chercherFormateurs(String nom) {
        String requete = "select * from formateur where nom like? and etat=?";
        PreparedStatement ps = null;
        ObservableList<Formateur> lst = FXCollections.observableArrayList();
        try {
            ps = connection.prepareStatement(requete);
            ps.setString(1, nom);
            ps.setInt(2, 1);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                lst.add(new Formateur(resultat.getString("cin"),
                        resultat.getString("nom"), resultat.getString("prenom"))
                );
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean authentificationOrganisme(String login, String password) {

        boolean res = false;
        try {
            String req = "select * from organisme where login = ? and password = ? ";
            pst = connection.prepareStatement(req);
            pst.setString(1, login);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Authentification reussite");
                res = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOApprenant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public int getEtat(String login) {
        Organisme o1 = new Organisme();

        String req2 = "select * from  Organisme where login='" + login + "'";
        try {
            PreparedStatement pst2 = connection.prepareStatement(req2);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {

                return rs.getInt("etat");

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Organisme getOrganisme(String login) {

        try {
            Organisme o = new Organisme();
            String req = "select * from organisme where login = ? ";
            pst = connection.prepareStatement(req);
            pst.setString(1, login);

            rs = pst.executeQuery();
            while (rs.next()) {
                o.setId(rs.getInt("idorganisme"));
                System.out.println("id mel requette="+o.getId());
                o.setNom(rs.getString("nom"));
                o.setLogin(rs.getString("login"));
                o.setPassword(rs.getString("password"));
                o.setEmail(rs.getString("email"));
                o.setAdresse(rs.getString("adresse"));
                o.setSiteweb(rs.getString("siteweb"));
                o.setTelephone(rs.getString("telephone"));
                o.setDescription(rs.getString("description"));
                 o.setLogo(rs.getString("logo"));

            }
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getComplete(String login) {
        Organisme o2 = new Organisme();
        String s = null;
        String req2 = "select complete from  Organisme where login='" + login + "'";
        try {
            PreparedStatement pst2 = connection.prepareStatement(req2);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {

                return rs.getString("Complete");

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "pas complete";

    }

    @Override
    public void envoyerMsg(String emailExp, String objet, String msg) {
        String username = "mooc123456@gmail.com";
        String password = "moocmail123";

// Etape 1 : Création de la session
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
// Etape 2 : Création de l'objet Message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailExp));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailExp));
            message.setSubject(objet);
            message.setText(msg);
// Etape 3 : Envoyer le message
            Transport.send(message);
            System.out.println("Message_envoye");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getEmailByLogin(String login) {
        Organisme o2 = new Organisme();
        String s = null;
        String req2 = "select email from  Organisme where login='" + login + "'";
        try {
            PreparedStatement pst2 = connection.prepareStatement(req2);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {

                return rs.getString("email");

            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la selection du mail " + ex.getMessage());
        }
        return null;

    }

    @Override
    public void setPwd(String login, String pwd) {
        try {
            String req1 = "update  organisme set password='" + pwd + "' where login='" + login + "'";

            PreparedStatement pst2 = connection.prepareStatement(req1);
            pst2.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour du mot de passe " + ex.getMessage());
        }
    }

    @Override
    public ObservableList<Invitation> FindInvitationByNom(String nomdes) {
        String requete = "SELECT * FROM invitation WHERE nom_des = ? and etat=?";

        ObservableList<Invitation> lst = FXCollections.observableArrayList();
        try {
            pst = connection.prepareStatement(requete);
            pst.setString(1, nomdes);
            pst.setInt(2, 0);
            ResultSet resultat = pst.executeQuery();
            DAOFormateur daof =new DAOFormateur();
            while (resultat.next()) {
                
                lst.add(new Invitation(
                        daof.getFormateurByCIN( resultat.getString("nom_exp")).getNom(),
                        resultat.getString("nom_des"),
                        resultat.getDate("date_invit"),
                        resultat.getInt("etat")
                ));
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        } finally {
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void removeOrganismeById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIdOrganismeByName(String nom) {
           Organisme o2 = new Organisme();
        String s = null;
        String req2 = "select idorganisme from  Organisme where nom=?";
        try {
            PreparedStatement pst2 ;
            pst2 = connection.prepareStatement(req2);
            pst2.setString(1, nom);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {

                return rs.getInt("idorganisme");

            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la selection du idorganisme " + ex.getMessage());
        }
        return 0;

    }

    @Override
    public ObservableList<Formateur> chercherFormateurs1Organisme(String nom,int id) {
 String requete = "select * from formateur where nom like? and etat=? and Organisme_id=?";
        PreparedStatement ps = null;
        ObservableList<Formateur> lst = FXCollections.observableArrayList();
        try {
            ps = connection.prepareStatement(requete);
            ps.setString(1, nom);
            int x=1;
            ps.setInt(2, x);
            ps.setInt(3, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                lst.add(new Formateur(resultat.getString("cin"),
                        resultat.getString("nom"), resultat.getString("prenom"))
                );
            }
            return lst;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

  
}
