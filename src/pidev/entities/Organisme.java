/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.util.logging.Logger;

/**
 *
 * @author Rimy Jeljeli
 */
public class Organisme extends Utilisateur{
     private int id;
    private String nom;
    private String email;
     private String siteweb;
     private String adresse;
     private Number telephone;
     private String description;
     private String document;
     private String logo;
    private String [] Formateur ;

    public Organisme(String login, String password, String role) {
        super(login, password, role);
    }

    public Organisme(int id, String nom, String email, String siteweb, String adresse, Number telephone, String description, String document, String logo, String[] Formateur, String login, String password, String role) {
        super(login, password, role);
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.siteweb = siteweb;
        this.adresse = adresse;
        this.telephone = telephone;
        this.description = description;
        this.document = document;
        this.logo = logo;
        this.Formateur = Formateur;
    }
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getSiteweb() {
        return siteweb;
    }

    public String getAdresse() {
        return adresse;
    }

    public Number getTelephone() {
        return telephone;
    }

    public String getDescription() {
        return description;
    }

    public String getDocument() {
        return document;
    }

    public String getLogo() {
        return logo;
    }

    public String[] getFormateur() {
        return Formateur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(Number telephone) {
        this.telephone = telephone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setFormateur(String[] Formateur) {
        this.Formateur = Formateur;
    }

    @Override
    public String toString() {
        return "Organisme{" + "id=" + id + ", nom=" + nom + ", email=" + email + ", siteweb=" + siteweb + ", adresse=" + adresse + ", telephone=" + telephone + ", description=" + description + ", document=" + document + ", logo=" + logo + ", Formateur=" + Formateur + '}';
    }
    
    
   
}