
package pidev.entities;
import java.util.Date;


public class CoursSuivie {
    private int idCours ;
    private int cinApprenant ;
    private String Commentaire ;
    private double note ;
    private Date dateDebut ;
    private String appreciation;

    public CoursSuivie(int idCours, int cinApprenant, String Commentaire, double note, Date dateDebut, String appreciation) {
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

    public int getCinApprenant() {
        return cinApprenant;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public double getNote() {
        return note;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public void setCinApprenant(int cinApprenant) {
        this.cinApprenant = cinApprenant;
    }

    public void setCommentaire(String Commentaire) {
        this.Commentaire = Commentaire;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    
}
