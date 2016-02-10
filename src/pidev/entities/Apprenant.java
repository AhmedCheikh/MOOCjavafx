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
public class Apprenant extends Utilisateur{

    private String cinApprenant;
    private String nom;
    private String prenom;
    private String email;
    private String avatar;
    private int idUser;

    public Apprenant(String cinApprenant, String nom, String prenom, String email, String avatar, int idUser, String login, String password, String role) {
        super(idUser, login, password, role);
        this.cinApprenant = cinApprenant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.avatar = avatar;
    }

    public String getCinApprenant() {
        return cinApprenant;
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

    public String getAvatar() {
        return avatar;
    }

    public void setCinApprenant(String cinApprenant) {
        this.cinApprenant = cinApprenant;
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

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

   
}
