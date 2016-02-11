
package pidev.entities;
import java.util.Date;


public class CoursSuivie {
    private int idCours ;
    private String cinApprenant ;
    private String Commentaire ;
    private double note ;
    private String dateDebut ;
    private String appreciation;

    public CoursSuivie(int idCours, String cinApprenant, String Commentaire, double note, String dateDebut, String appreciation) {
        this.idCours = idCours;
        this.cinApprenant = cinApprenant;
        this.Commentaire = Commentaire;
        this.note = note;
        this.dateDebut = dateDebut;
        this.appreciation = appreciation;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    

    public int getIdCours() {
        return idCours;
    }

    

    public String getCommentaire() {
        return Commentaire;
    }

    public double getNote() {
        return note;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public String getCinApprenant() {
        return cinApprenant;
    }

    public void setCinApprenant(String cinApprenant) {
        this.cinApprenant = cinApprenant;
    }

    

    public void setCommentaire(String Commentaire) {
        this.Commentaire = Commentaire;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    
    
}
