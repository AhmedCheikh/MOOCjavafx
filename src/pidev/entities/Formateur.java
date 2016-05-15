package pidev.entities;

import java.io.File;
import java.util.Objects;
import javafx.scene.control.TextField;

/**
 *
 * @author akoubi
 */
public class Formateur {

    private String cinFormateur;
    private String nom;
    private String prenom;
    private String mail;
    private String login;
    private String password;
    private String avatar;
    private String cv;
    private int etat;

    public Formateur() {
    }

    public Formateur(String cinFormateur, String nom, String prenom, String mail) {
        this.cinFormateur = cinFormateur;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }

    public Formateur(String nom, String prenom, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }

    public Formateur(String cinFormateur) {
        this.cinFormateur = cinFormateur;
    }

    public Formateur(String cinFormateur, String nom, String prenom, String mail, String login, String password, String avatar, String cv, int etat) {
        this.cinFormateur = cinFormateur;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.login = login;
        this.password = password;
        this.avatar = avatar;
        this.cv = cv;
        this.etat = etat;
    }

    public Formateur(String cinFormateur, String nom, String prenom, String mail, String login, String password, String avatar) {
        this.cinFormateur = cinFormateur;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.login = login;
        this.password = password;
        this.avatar = avatar;
    }

    public Formateur(String cinFormateur, String nom, String prenom, String mail, String login, String password, String avatar, String cv) {
        this.cinFormateur = cinFormateur;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.login = login;
        this.password = password;
        this.avatar = avatar;
        this.cv = cv;
    }

    public String getCinFormateur() {
        return cinFormateur;
    }

    public void setCinFormateur(String cinFormateur) {
        this.cinFormateur = cinFormateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.cinFormateur);
        hash = 59 * hash + Objects.hashCode(this.mail);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Formateur other = (Formateur) obj;
        if (!Objects.equals(this.cinFormateur, other.cinFormateur)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Formateur{" + "cinFormateur=" + cinFormateur + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", login=" + login + '}';
    }

   
  
    
}
