package pidev.entities;

import java.io.File;

/**
 *
 * @author akoubi
 */
public class Formateur extends Utilisateur{

    private int cinFormateur;
    private String nom;
    private String prenom;
    private String mail;
    private String adresse;
    private int idUser;
    private File avatar;
    private String cv;
    private File etat;

    public Formateur(int cinFormateur, String nom, String prenom, String mail, String adresse, File avatar, String cv, File etat, int idUser, String login, String password, String role) {
        super(idUser, login, password, role);
        this.cinFormateur = cinFormateur;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.adresse = adresse;
        this.avatar = avatar;
        this.cv = cv;
        this.etat = etat;
    }

    public int getCinFormateur() {
        return cinFormateur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public File getAvatar() {
        return avatar;
    }

    public String getCv() {
        return cv;
    }

    public File getEtat() {
        return etat;
    }

    public void setCinFormateur(int cinFormateur) {
        this.cinFormateur = cinFormateur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setAvatar(File avatar) {
        this.avatar = avatar;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public void setEtat(File etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Formateur{" + "cinFormateur=" + cinFormateur + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", adresse=" + adresse + ", idUser=" + idUser + ", avatar=" + avatar + ", cv=" + cv + ", etat=" + etat + '}';
    }

  
    
}
