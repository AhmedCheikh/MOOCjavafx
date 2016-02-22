
package pidev.Controller;

import com.restfb.LegacyFacebookClient;
import com.restfb.types.User;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pidev.tests.test;
import pidev.dao.classes.*;
import pidev.entities.Formateur;

/**
 *
 * @author akoubi
 */
public class ControllerAthentification implements Initializable {

    @FXML
    private Label message;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private Button btnfb;
    public ComboBox roleAuth ;
    
    private String info;
   @FXML
   private void btnfbAction(ActionEvent event)
   {
       
   }
   
    @FXML
    private void btnConnexionAction(ActionEvent event) throws IOException  {
              if(roleAuth.getValue().toString().equals("apprenant"))
       {
           DAOApprenant app= new DAOApprenant();
           info = login.getText();
          if(app.authentification(login.getText(), password.getText()))
          {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/pidev/gui/ProfilApprenant.fxml"));
            loader.load();
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
            stage.setTitle("Profil Apprenant");
            ProfilApprenantController pac  = loader.getController();
            pac.setInfo(info);
            stage.show();
           
          }
          else
          {
               message.setText("mot de passe ou login erroné");
               login.setText("");
               password.setText("");
          }
       }
       else if (roleAuth.getValue().toString().equals("administrateur"))
       {
           DAOAdministrateur admin= new DAOAdministrateur() ;
           
       }
       else if (roleAuth.getValue().toString().equals("formateur"))
       {
          DAOFormateur daof = new DAOFormateur();
            try {
                if (daof.Connecter(login.getText(), password.getText())) {
                Formateur f = new Formateur(login.getText());
                message.setText(" vos identifiant sont correcte ");
                ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/pidev/gui/ProfilFormateur.fxml"));
                loader.load();  
                Parent p = loader.getRoot();
                ProfilFormateurController pfc = loader.getController();
                pfc.setF(f);
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
                } else {
            message.setText(" CIN ou Password Incorrecte ");
        }
            } catch (IOException ex) {
                Logger.getLogger(ControllerAthentification.class.getName()).log(Level.SEVERE, null, ex);
            }
           
       }
       else if (roleAuth.getValue().toString().equals("organisme")) {
            DAOOrganisme org = new DAOOrganisme();
            if (org.authentificationOrganisme(login.getText(), password.getText()) && org.getEtat(login.getText()) == 1) {
                ((Node) (event.getSource())).getScene().getWindow().hide();
                Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/ProfilOrganismeA.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
                stage.setScene(scene);
                stage.setTitle("Profil Organisme");
                stage.show();
            } else {
                message.setText("mot de passe ou login erroné");
                login.setText("");
                password.setText("");
            }
        }
       
        
    }
    public void pwdAction(ActionEvent event) throws IOException {
      
                
         ((Node) (event.getSource())).getScene().getWindow().hide();
                Parent parent = FXMLLoader.load(getClass().getResource("/pidev/gui/RetrouverCompte.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.getIcons().add(new Image("pidev/gui/img/icone.png"));
                stage.setScene(scene);
                stage.setTitle("Retrouver votre compte");
                stage.show();  }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
    }    
//    static ControllerAthentification fbb = new ControllerAthentification();
//
//    public void setgetPermissionsForAppListener(ActionListener l) {
//        btnfb.addActionListener(l);
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                NativeInterface.open();
//                NativeInterface.initialize();
//                fbb.setVisible(true);
//                fbb.setLocationRelativeTo(null);
//            }
//        });
//        fbb.setgetPermissionsForAppListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent e) {
//                final JFrame authFrame = new JFrame();
//                authFrame.setLocation(500, 100);
//                JPanel webBrowserPanel = new JPanel(new BorderLayout());
//                final JWebBrowser webBrowser = new JWebBrowser();
//                webBrowserPanel.setLocation(500, 500);
//                webBrowser.navigate(firstRequest);
//                webBrowser.addWebBrowserListener(new WebBrowserAdapter() {
//                    @Override
//                    public void locationChanged(WebBrowserNavigationEvent e) {
//                        super.locationChanged(e);
//                        if (!firstRequestDone) {
//                            if (e.getNewResourceLocation().contains("access_token")) {
//                                String[] splits = e.getNewResourceLocation().split("=");
//                                GraphReaderExample gr = new GraphReaderExample(splits[1].split("&")[0]);
//                                User rs = gr.fetchObject();
//                                authFrame.dispose();
//                                webBrowser.setVisible(false);
//                                firstRequestDone = true;
//                                String email = rs.getEmail();
//                                ClientDAO clientDAO = new ClientDAO();
//                                Client c;
//                                if (clientDAO.findClientByEmail(email) == null) {
//                                    c = new Client();
//                                    c.setEmailUser(email);
//                                    c.setAdresseUser(rs.getHometownName());
//                                    c.setNomUser(rs.getLastName());
//                                    c.setPrenomUser(rs.getFirstName());
//                                    c.setDateInscription(new Date(new java.util.Date().getTime()));
//                                    c.setCinUser("00000000");
//                                    c.setTelUser(00000000);
//                                    clientDAO.ajouterClient(c);
//                                    c= clientDAO.findClientByEmail(email);
//                                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous "
//                                            + "vos coordonnés dans votre profils ", "Bienvenue", JOptionPane.WARNING_MESSAGE);
//                                } else {
//                                    c = clientDAO.findClientByEmail(email);
//                                }
//                                if (c != null) {
//                                    if(c.getTelUser()==0){
//                                        JOptionPane.showMessageDialog(null, "Veuillez remplir tous "
//                                            + "vos coordonnés dans votre profils ", "Bienvenue", JOptionPane.WARNING_MESSAGE);
//                                        ModificationClient modif = new ModificationClient(c);
//                                        modif.setVisible(true);
//                                        fbb.dispose();
//                                         try {
//                                        fbb.setVisible(false);
//                                    } catch (Throwable ex) {
//                                        Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, ex);
//                                    }
//                                        
//                                    }else{
//                                    AcceuiClientGUI client = new AcceuiClientGUI(c);
//                                    client.setVisible(true);
//                                    try {
//                                        fbb.setVisible(false);
//                                    } catch (Throwable ex) {
//                                        Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, ex);
//                                    } 
//                                    }
//                                }
//                            }
//                        }
//                    }
//                });
//                webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
//                authFrame.add(webBrowserPanel);
//                authFrame.setSize(400, 500);
//                authFrame.setVisible(true);
//
//            }
//        });
//
//    }
//
//    public static String API_KEY = "1585288458352287";
//    public static String SECRET = "b5cbd64fc4b8e7a5c2693b3132d3dfa6";
//
//    public static String firstRequest = "https://www.facebook.com/v2.2/dialog/oauth?response_type=token&display=popup&client_id="
//            + API_KEY
//            + "&redirect_uri=http://localhost/allotaxi/allotaxi.php&scope=user_about_me%2Cuser_birthday%2Cuser_hometown%2Cemail";
//
////            https://graph.facebook.com/oauth/authorize?"
////            + "client_id="
////            + API_KEY
////            + "&redirect_uri=http://www.facebook.com/connect/login_success.html&"
////            + "scope=publish_stream,offline_access,create_event,read_stream,email,user_birthday";
//    public static String secondRequest = "https://graph.facebook.com/oauth/access_token?"
//            + "client_id="
//            + API_KEY
//            + "&redirect_uri=http://www.facebook.com/connect/login_success.html&"
//            + "client_secret=" + SECRET + "&code=";
//
//    public static String access_token = "";
//    public static boolean firstRequestDone = false;
//    public static boolean secondRequestDone = false;
//    
}
