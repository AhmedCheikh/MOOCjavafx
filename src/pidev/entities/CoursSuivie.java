
package pidev.entities;
import java.util.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class CoursSuivie {
    private int idCoursuivi;    
    private int id_cours ;
    private String cinapprenant ;
    private String commentaire ;
    private double note ;
    private String date_debut ;
    private String appreciation;

    
    

//    public Integer getIdCours() {
//        return idCours.get();
//    }
//
//    public String getCinApprenant() {
//        return cinApprenant;
//    }
//
//    public String getCommentaire() {
//        return Commentaire;
//    }
//
//    public double getNote() {
//        return note;
//    }
//
//    public String getDateDebut() {
//        return dateDebut.get();
//    }
//
//    public String getAppreciation() {
//        return appreciation.get();
//    }
//
//    public void setIdCours(SimpleIntegerProperty idCours) {
//        this.idCours = idCours;
//    }
//
//    public void setCinApprenant(String cinApprenant) {
//        this.cinApprenant = cinApprenant;
//    }
//
//    public void setCommentaire(String Commentaire) {
//        this.Commentaire = Commentaire;
//    }
//
//    public void setNote(double note) {
//        this.note = note;
//    }
//
//    public void setDateDebut(SimpleStringProperty dateDebut) {
//        this.dateDebut = dateDebut;
//    }
//
//    public void setAppreciation(SimpleStringProperty appreciation) {
//        this.appreciation = appreciation;
//    }
//    
//    
//    
//    

    public CoursSuivie() {
    }

    public CoursSuivie(int idCoursuivi, String date_debut, String appreciation) {
        this.idCoursuivi = idCoursuivi;
        this.date_debut = date_debut;
        this.appreciation = appreciation;
    }

    public CoursSuivie(int idCoursuivi, int id_cours, String cinapprenant, String commentaire, double note, String date_debut, String appreciation) {
        this.idCoursuivi = idCoursuivi;
        this.id_cours = id_cours;
        this.cinapprenant = cinapprenant;
        this.commentaire = commentaire;
        this.note = note;
        this.date_debut = date_debut;
        this.appreciation = appreciation;
    }

    public int getIdCoursuivi() {
        return idCoursuivi;
    }

    public int getId_cours() {
        return id_cours;
    }

    public String getCinapprenant() {
        return cinapprenant;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public double getNote() {
        return note;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setIdCoursuivi(int idCoursuivi) {
        this.idCoursuivi = idCoursuivi;
    }

    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    public void setCinapprenant(String cinapprenant) {
        this.cinapprenant = cinapprenant;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }
    
}
