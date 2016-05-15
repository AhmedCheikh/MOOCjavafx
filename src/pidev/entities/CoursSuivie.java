
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

    public CoursSuivie() {
    }

    public CoursSuivie(int id_cours, String appreciation) {
        this.id_cours = id_cours;
        this.appreciation = appreciation;
    }

    public CoursSuivie(int id_cours, String cinapprenant, String date_debut) {
        this.id_cours = id_cours;
        this.cinapprenant = cinapprenant;
        this.date_debut = date_debut;
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
