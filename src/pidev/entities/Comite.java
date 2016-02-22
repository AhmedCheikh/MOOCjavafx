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
public class Comite  {
    
    private String CIN ; 
    private String nom ; 
    private String prenom ; 
    private String email ; 
    private String loginComite ; 
    private String passwordComite ; 

    public Comite(String CIN, String nom, String prenom, String email, String loginComite, String passwordComite) {
        this.CIN = CIN;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.loginComite = loginComite;
        this.passwordComite = passwordComite;
    }

    public Comite() {
    }

    public String getCIN() {
        return CIN;
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

    public String getLoginComite() {
        return loginComite;
    }

    public String getPasswordComite() {
        return passwordComite;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
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

    public void setLoginComite(String loginComite) {
        this.loginComite = loginComite;
    }

    public void setPasswordComite(String passwordComite) {
        this.passwordComite = passwordComite;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        
        hash = 67 * hash + Objects.hashCode(this.nom);
        hash = 67 * hash + Objects.hashCode(this.prenom);
        hash = 67 * hash + Objects.hashCode(this.email);
        hash = 67 * hash + Objects.hashCode(this.loginComite);
        hash = 67 * hash + Objects.hashCode(this.passwordComite);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comite other = (Comite) obj;
        if (!this.CIN.equals(other.CIN)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.loginComite, other.loginComite)) {
            return false;
        }
        if (!Objects.equals(this.passwordComite, other.passwordComite)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comite{" + "CIN=" + CIN + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", loginComite=" + loginComite + ", passwordComite=" + passwordComite + '}';
    }

    
    
}
