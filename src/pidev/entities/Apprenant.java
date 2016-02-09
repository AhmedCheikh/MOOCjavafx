/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.util.Objects;

/**
 *
 * @author Khoubaib
 */
public class Apprenant {
    private int cin;
    private String nom;
    private String prenom;
    private String email;
//    private String login;
//    private String motDePasse;
    private String avatar;
    

    public Apprenant() {
    }

    public Apprenant(int cin, String nom, String prenom, String email) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
//        this.login = login;
//        this.motDePasse = motDePasse;
    }

    public int getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

//    public String getLogin() {
//        return login;
//    }
//
//    public String getMotDePasse() {
//        return motDePasse;
//    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public void setMotDePasse(String motDePasse) {
//        this.motDePasse = motDePasse;
//    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.cin;
        hash = 59 * hash + Objects.hashCode(this.email);
//        hash = 59 * hash + Objects.hashCode(this.login);
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
        final Apprenant other = (Apprenant) obj;
        if (this.cin != other.cin) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
//        if (!Objects.equals(this.login, other.login)) {
//            return false;
//        }
        return true;
    }

    @Override
    public String toString() {
        return "Apprenant{" + "cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", Email=" + email + ",}";
    }
    
    
}
