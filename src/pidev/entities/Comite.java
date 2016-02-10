/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.util.Objects;

/**
 *
 * @author WiKi
 */
public class Comite extends Utilisateur {
    
    private String cinComite ; 
    private String nom ; 
    private String prenom ; 
    private String email ; 
    private int idUser;

    public Comite(String cinComite, String nom, String prenom, String email, int idUser, String login, String password, String role) {
        super(idUser, login, password, role);
        this.cinComite = cinComite;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public String getCinComite() {
        return cinComite;
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

    public void setCinComite(String cinComite) {
        this.cinComite = cinComite;
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

    @Override
    public String toString() {
        return "Comite{" + "cinComite=" + cinComite + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", idUser=" + idUser + '}';
    }

    

  
    
}
