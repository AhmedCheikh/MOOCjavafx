package pidev.dao.classes;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pidev.Controller.InscrireFormateurController;
import pidev.Controller.ProfilFormateurController;
import pidev.dao.interfaces.IDaoFormateur;
import pidev.entities.Cours;
import pidev.entities.Formateur;
import pidev.entities.Quiz;
import pidev.techniques.DataSource;

/**
 *
 * @author akoubi
 */
public class DAOFormateur implements IDaoFormateur{
    private Connection connection;

    public DAOFormateur() {
    connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void inscrire(Formateur f) {
       try {
            
            String req = "insert into formateur (cin,nom,prenom,email,login,password,cv) values (?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
         
            InputStream is = new FileInputStream(InscrireFormateurController.cv);
           
            ps.setString(1, f.getCinFormateur());
            ps.setString(2, f.getNom());
            ps.setString(3, f.getPrenom());
            ps.setString(4, f.getMail());
            ps.setString(5, f.getLogin());
            ps.setString(6, f.getPassword());
            ps.setBlob(7, is);
            ps.executeUpdate();
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Editer_Profil(Formateur f) {
    }

    @Override
    public void getFormateurByName(String nom) {

    }

    @Override
    public void getFormateurByCIN(String cin) {
    String requete = "select * from formateur where cin=?";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, cin);
            ResultSet resultat = ps.executeQuery();
            ProfilFormateurController pfc = new ProfilFormateurController();
            while (resultat.next()) {
//            pfc.lblCin.setText(resultat.getString("cin"));
//            pfc.lblNom.setText(resultat.getString("nom"));
//            pfc.lblNom.setText(resultat.getString("prenom"));
//            pfc.lblNom.setText(resultat.getString("email"));
//            pfc.lblNom.setText(resultat.getString("login"));
            
            InputStream is = resultat.getBinaryStream("avatar");
            OutputStream os = new FileOutputStream(new File("photo.jpg"));
            byte[] content = new byte[1024];
            int size = 0;
            while((size = is.read(content)) !=  -1){
            os.write(content,0,size);
            os.write(content);
            }
            os.close();
            is.close();
//            pfc.image = new Image("file:photo.jpg", 100 ,150,true,true);
//            pfc.imgAvatar.setImage(pfc.image);
            }
 
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cours> ListCoursByNameFormateur(String nom) {
    return null;
    }

    @Override
    public void DemmandeIntegration() {
    
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
    public void PublierCours(Cours c) {

    }

    @Override
    public void EditerCours(Cours c) {

    }

    @Override
    public void AjouterQuiz(Quiz q) {

    }
   
}
