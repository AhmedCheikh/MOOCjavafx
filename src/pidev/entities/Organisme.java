/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.io.File;
import java.util.logging.Logger;

/**
 *
 * @author Rimy Jeljeli
 */
public class Organisme extends Utilisateur {

    private int id;
    private String nom;
    private String email;
    private String siteweb;
    private String adresse;
    private Number telephone;
    private String description;
    private File document;
    private File logo;
    private int cinFormateur;
    private int idUser;

    public Organisme(int id, String nom, String email, String siteweb, String adresse, Number telephone, String description, File document, File logo, int cinFormateur, int idUser, String login, String password, String role) {
        super(idUser, login, password, role);
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.siteweb = siteweb;
        this.adresse = adresse;
        this.telephone = telephone;
        this.description = description;
        this.document = document;
        this.logo = logo;
        this.cinFormateur = cinFormateur;
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

    public File getDocument() {
        return document;
    }

    public File getLogo() {
        return logo;
    }

    public int getCinFormateur() {
        return cinFormateur;
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

    public void setDocument(File document) {
        this.document = document;
    }

    public void setLogo(File logo) {
        this.logo = logo;
    }

    public void setCinFormateur(int cinFormateur) {
        this.cinFormateur = cinFormateur;
    }

    @Override
    public String toString() {
        return "Organisme{" + "id=" + id + ", nom=" + nom + ", email=" + email + ", siteweb=" + siteweb + ", adresse=" + adresse + ", telephone=" + telephone + ", description=" + description + ", document=" + document + ", logo=" + logo + ", cinFormateur=" + cinFormateur + ", idUser=" + idUser + '}';
    }
    

    
}
