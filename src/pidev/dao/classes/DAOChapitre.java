/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao.classes;

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
            InputStream isDoc;
            InputStream isVideo;
            try {
                isDoc = new FileInputStream(c.getPresentation());
                isVideo = new FileInputStream(c.getVideo());
                String req = "insert into chapitre (idcours,idQuiz,titre,presentation,objectif,etat,video) values (?,?,?,?,?,?,?)";
                pst = connection.prepareStatement(req);
                pst.setInt(1, c.getIdCours());
                pst.setInt(2, c.getIdQuiz());
                pst.setString(3, c.getTitre());
                pst.setBlob(4, isDoc);
                pst.setString(5, c.getObjectif());
                pst.setInt(6, c.getEtat());
                pst.setBlob(7, isVideo);

                pst.executeUpdate();
                System.out.println("Ajout effectuée avec succès");

            } catch (FileNotFoundException ex) {
                Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    public void updateChapitre(Chapitre c) {

        String requete = "update chapitre set idcours=?, idquiz=?, titre=? ,presentation=? ,objectif=?, etat=?, video=?  where id=?";
        try {
            InputStream isDoc;
            InputStream isVideo;
            try {
                isDoc = new FileInputStream(c.getPresentation());
                isVideo = new FileInputStream(c.getVideo());
                PreparedStatement ps = connection.prepareStatement(requete);
                pst.setInt(8, c.getIdChapitre());
                pst.setInt(1, c.getIdCours());
                pst.setInt(2, c.getIdQuiz());
                pst.setString(3, c.getTitre());
                pst.setBlob(4, isDoc);
                pst.setString(5, c.getObjectif());
                pst.setInt(6, c.getEtat());
                pst.setBlob(7, isVideo);
                

                ps.executeUpdate();
                System.out.println("Mise à jour effectuée avec succès");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DAOOrganisme.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
    }

    @Override
    public List<Chapitre> findChapitreByEtat(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Chapitre> findChapitreByTitre(String titre) {
        String req = "select * from chapitre where titre= '" + titre + "'";
        List<Chapitre> listChapitres = new ArrayList<Chapitre>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {
                

                Chapitre c = new Chapitre();
                c.setIdChapitre(rs.getInt(1));
                c.setIdQuiz(rs.getInt(3));
                c.setTitre(rs.getString(4));
                String filename = rs.getString(4);
                Blob blob = rs.getBlob(6);
                InputStream is = blob.getBinaryStream();
                FileOutputStream fos = new FileOutputStream("E:\\xampp\\htdocs\\Tests\\MOOC_3A2\\src\\pidev\\gui\\img" + "\\" + filename + ".pdf");
                int b = 0;
                while ((b = is.read()) != -1) {
                    fos.write(b);
                } 
                c.setPresentation(new File ("E:\\xampp\\htdocs\\Tests\\MOOC_3A2\\src\\pidev\\gui\\img" + "\\" + filename + ".pdf"));
                
                
                c.setObjectif(rs.getString(6));
                String filename2 = rs.getString(4);
                Blob blob2 = rs.getBlob(8);
                InputStream is2 = blob2.getBinaryStream();
                FileOutputStream fos2 = new FileOutputStream("E:\\xampp\\htdocs\\Tests\\MOOC_3A2\\src\\pidev\\gui\\img" + "\\" + filename + ".mp4");
                int b1 = 0;
                while ((b1 = is2.read()) != -1) {
                    fos2.write(b1);
                } 
                c.setVideo(new File ("E:\\xampp\\htdocs\\Tests\\MOOC_3A2\\src\\pidev\\gui\\img" + "\\" + filename + ".mp4"));
                

                listChapitres.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOChapitre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOChapitre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listChapitres;
    }

    @Override
    public List<Chapitre> findChapitreById(int id) {
        String req = "select * from chapitre where id = " + id;

        List<Chapitre> listChapitres = new ArrayList<Chapitre>();

        try {
            pst = connection.prepareStatement(req);
            rs = pst.executeQuery();

            while (rs.next()) {

                //Chapitre c = new Chapitre(rs.getInt("idcours"), rs.getInt("idquiz"), rs.getInt("idquiz"), rs.getString("titre"), rs.getBlob("presentation"), rs.getString("objectif"), rs.getInt("etat"), rs.getBlob("video"));
                Chapitre c = new Chapitre();
                listChapitres.add(c);
            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche " + ex.getMessage());
        }
        return listChapitres;
    }
//

//    @Override
//    public List<Chapitre> findChapitreByEtat(int etat) {
//        String req = "select * from chapitre where etat= '"+etat+"'";
//        List<Chapitre> listChapitres = new ArrayList<Chapitre>();
//
//        try {
//            pst = connection.prepareStatement(req);
//            rs = pst.executeQuery();
//
//            while (rs.next()) {
//
//                Chapitre c = new Chapitre(rs.getInt("id"), rs.getInt("idcours"), rs.getInt("idquiz"), rs.getString("titre"), rs.getBlob("presentation"), rs.getString("objectif"), rs.getInt("etat"), rs.getBlob("video"));
//
//                listChapitres.add(c);
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("erreur lors de la recherche " + ex.getMessage());
//        }
//        return listChapitres;
//    }
//
//    public List<Chapitre> findChapitreByCours(int id)
//    {
//       String req = "select * from chapitre where id_cours= '"+id+"'";
//        List<Chapitre> listChapitres = new ArrayList<Chapitre>();
//
//        try {
//            pst = connection.prepareStatement(req);
//            rs = pst.executeQuery();
//
//            while (rs.next()) {
//
//                Chapitre c = new Chapitre(rs.getInt("id"), rs.getInt("idcours"), rs.getInt("idquiz"), rs.getString("titre"), rs.getBlob("presentation"), rs.getString("objectif"), rs.getInt("etat"), rs.getBlob("video"));
//
//                listChapitres.add(c);
//            }
//        } catch (SQLException ex) {
//            System.out.println("erreur lors de la recherche " + ex.getMessage());
//        }
//        return listChapitres;
//    }
    @Override
    public int FindIdQuizbychapitre(int id
    ) {
        {
            String req = "select * from chapitre where etat=1 and id= '" + id + "'";
            Quiz Quiz = new Quiz();

            try {
                pst = connection.prepareStatement(req);
                rs = pst.executeQuery();

                while (rs.next()) {

                    return rs.getInt(3);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return 0;
        }
    }

}
