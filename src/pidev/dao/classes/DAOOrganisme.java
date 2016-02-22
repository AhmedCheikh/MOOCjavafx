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
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            InputStream is;
            try {
                is = new FileInputStream(organisme.getDocument());

//       String req1="insert into orga (nom) values (?)";
                //     String req1="insert into organisme (id_organisme,nom,login,password,email,adresse) values (?,?,?,?,?,?)";
                String req1 = "insert into organisme (nom,login,password,email,adresse,document,complete,etat) values (?,?,?,?,?,?,?,?)";

                pst = connection.prepareStatement(req1);

                pst.setString(1, organisme.getNom());
                pst.setString(2, organisme.getLogin());
                pst.setString(3, organisme.getPassword());
                pst.setString(4, organisme.getEmail());
                pst.setString(5, organisme.getAdresse());
                pst.setBlob(6, is);
                pst.setString(7, "pas compele");
                pst.setInt(8, 0);
                pst.executeUpdate();
                //rs = pst.executeUpdate();

            } catch (FileNotFoundException ex) {
                System.out.println("erreur lors de l'insertion " + ex.getMessage());
            }
//           System.out.println(rs.getRow());
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateOrganismeInscription(Organisme organisme) {
        try {

            try {

                String req2 = "update  organisme set  siteweb=?, telephone=?, description=? ,logo=? ,complete=?  where login =?";

                PreparedStatement pst2;

                pst2 = connection.prepareStatement(req2);
                pst2.setString(1, organisme.getSiteweb());
                pst2.setString(2, organisme.getTelephone());
                pst2.setString(3, organisme.getDescription());
                pst2.setBlob(4, new FileInputStream(organisme.getLogo()));
                pst2.setString(5, "complete");
                pst2.setString(6, organisme.getLogin());
                pst2.executeUpdate();

//           System.out.println(rs.getRow());
            } catch (FileNotFoundException ex) {
                System.out.println("erreur lors de la mise à jour " + ex.getMessage());
            }
//           System.out.println(rs.getRow());
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateOrganisme(Organisme organisme) {
        try {
            String req1 = "update  organisme set nom=?,login=?,password=?,email=?,adresse=?,siteweb=?,telephone=?,description=?  where nom=?";
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
            pst3.setString(9, organisme.getNom());
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
            String req1 = "update  invitation set (etat) values (?) where cin=?";
            PreparedStatement ps = connection.prepareStatement(req1);
            ps.setString(1, "lu");
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
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
        String req1 = "select idorgansme from  Organisme where nom=?";
    }

    @Override
    public void removeOrganismeById(int id) {

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
                o.setNom(rs.getString(2));
                o.setLogin(rs.getString(3));
                o.setPassword(rs.getString(4));
                o.setEmail(rs.getString(5));
                o.setAdresse(rs.getString(6));
                o.setSiteweb(rs.getString(7));
                o.setTelephone(rs.getString(8));
                o.setDescription(rs.getString(9));

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

}
