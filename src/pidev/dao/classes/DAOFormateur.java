package pidev.dao.classes;


import static com.sun.org.apache.xerces.internal.util.FeatureState.is;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.Controller.InscrireFormateurController;
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

//    @Override
//    public void inscrire(Formateur f) {
//       try {
//            
//            String req = "insert into formateur (cin,nom,prenom,email,login,password) values (?,?,?,?,?,?)";
//            PreparedStatement ps = connection.prepareStatement(req);
//         
//             
//           
//            ps.setString(1, f.getCinFormateur());
//            ps.setString(2, f.getNom());
//            ps.setString(3, f.getPrenom());
//            ps.setString(4, f.getMail());
//            ps.setString(5, f.getLogin());
//            ps.setString(6, f.getPassword());
//
//            ps.executeUpdate();
//        } catch (SQLException | FileNotFoundException ex) {
//            Logger.getLogger(DAOFormateur.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    @Override
    public void Editer_Profil(Formateur f) {
    }

    @Override
    public void getFormateurByName(String nom) {

    }

    @Override
    public void getFormateurByCIN(int cin) {

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

    @Override
    public void inscrire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
