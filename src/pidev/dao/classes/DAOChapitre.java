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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.dao.interfaces.IDAOChapitre;
import pidev.entities.Chapitre;
import pidev.entities.Cours;
import pidev.entities.Quiz;
import pidev.techniques.DataSource;

/**
 *
 * @author Gumus
 */
public class DAOChapitre implements IDAOChapitre {

    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    public DAOChapitre() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void addChapitre(Chapitre c) {


            try {
                String req = "insert into chapitre (idcours,idQuiz,titre,presentation,objectif,video) values (?,?,?,?,?,?)";
                pst = connection.prepareStatement(req);
                pst.setInt(1, c.getIdCours());
                pst.setInt(2, c.getIdQuiz());
                pst.setString(3, c.getTitre());
                pst.setString(4, c.getPresentation());
                pst.setString(5, c.getObjectif());
                pst.setString(6, c.getVideo());

                pst.executeUpdate();
                System.out.println("Ajout effectuée avec succès");

        } catch (SQLException ex) {
            System.out.println("erreur lors de l'ajout " + ex.getMessage());
        }
    }

    @Override
    public void removeChapitre(Chapitre c) {
        String requete = "delete from chapitre where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, c.getIdChapitre());
            ps.executeUpdate();
            System.out.println("Chapitre supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());

        }
    }

    public void updateChapitre(Chapitre c, int id) {

        String requete = "update chapitre set idquiz=?, titre=? ,presentation=? ,objectif=?, video=?  where id= '" + id + "'";

        try {
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(1, c.getIdQuiz());
            pst.setString(2, c.getTitre());
            pst.setString(3, c.getPresentation());
            pst.setString(4, c.getObjectif());
            pst.setString(5, c.getVideo());
            System.out.println(c.getIdQuiz() + "&&&&&" + c.getTitre() + "&&&&&" + id);
            pst.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Chapitre> findChapitre() {
        String req = "select * from chapitre";
        List<Chapitre> listChapitres = new ArrayList<Chapitre>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                Chapitre c = new Chapitre();
                c.setIdCours(rs.getInt(2));
                c.setIdChapitre(rs.getInt(1));
                c.setIdQuiz(rs.getInt(3));
                c.setTitre(rs.getString(4));
                c.setPresentation(rs.getString(7));
                c.setObjectif(rs.getString(6));
                c.setVideo(rs.getString(8));

                listChapitres.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche " + ex.getMessage());
        }
        return listChapitres;
    }

    @Override
    public List<Chapitre> findChapitreById(int id) {
        String req = "select * from chapitre where id= '" + id + "'";
        List<Chapitre> listChapitres = new ArrayList<Chapitre>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                Chapitre c = new Chapitre();
                c.setIdCours(rs.getInt(2));
                c.setIdChapitre(rs.getInt(1));
                c.setIdQuiz(rs.getInt(3));
                c.setTitre(rs.getString(4));
                c.setPresentation(rs.getString(7));
                c.setObjectif(rs.getString(6));
                c.setVideo(rs.getString(8));

                listChapitres.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche " + ex.getMessage());
        }
        return listChapitres;
    }

//    @Override
//    public List<Chapitre> findChapitreById(int id) {
//        String req = "select * from chapitre where id = " + id;
//
//        List<Chapitre> listChapitres = new ArrayList<Chapitre>();
//
//        try {
//            pst = connection.prepareStatement(req);
//            rs = pst.executeQuery();
//
//            while (rs.next()) {
//
//                //Chapitre c = new Chapitre(rs.getInt("idcours"), rs.getInt("idquiz"), rs.getInt("idquiz"), rs.getString("titre"), rs.getBlob("presentation"), rs.getString("objectif"), rs.getBlob("video"));
//                Chapitre c = new Chapitre();
//                listChapitres.add(c);
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("erreur lors de la recherche " + ex.getMessage());
//        }
//        return listChapitres;
//    }
    @Override
    public int FindIdQuizbychapitre(String titre
    ) {
        {
            String req = "select * from chapitre where titre= '" + titre + "'";
            Quiz Quiz = new Quiz();

            try {
                pst = connection.prepareStatement(req);
                rs = pst.executeQuery();

                while (rs.next()) {

                    return rs.getInt(2);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return 0;
        }
    }

    public String FindVideobychapitre(int id) {
        {
            String req = "select * from chapitre where id= '" + id + "'";
            Quiz Quiz = new Quiz();

            try {
                pst = connection.prepareStatement(req);
                rs = pst.executeQuery();

                while (rs.next()) {

                    return rs.getString("video");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return "";
        }
    }

    public void downloadPresentation(Chapitre c) {
        try {
            String requete = "select presentation from chapitre where id=?";

            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, c.getIdChapitre());
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                File pdfFile = new File("src/pidev/gui/pdf/" + c.getPresentation());
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
    public boolean ChercherTitre(String titre) {
        boolean res = false;
        try {
            String req = "select * from chapitre where titre =?";
            pst = connection.prepareStatement(req);
            pst.setString(1, titre);
            rs = pst.executeQuery();
            if (rs.next()) {
                res = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOApprenant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public int FindIdbychapitre(String titre) {
        String req = "select * from chapitre where titre= '" + titre + "'";
        Quiz Quiz = new Quiz();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public void FindPresentationbychapitre(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
