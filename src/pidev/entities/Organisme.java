/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.io.File;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author Rimy Jeljeli
 */
public class Organisme  {

    private int id;
    public String nom;
    private String login;
    private String password;
    private String email;
    private String siteweb;
    private String adresse;
    private String telephone;
    private String description;
    private File document;
    private File logo;
    private int etat;

    public Organisme() {
    }

    public Organisme(int etat) {
        this.etat = etat;
    }

    public Organisme(String nom, String login, String password, String email, String siteweb, String adresse, String telephone, String description, File document, File logo) {
      
        this.nom = nom;
        this.login = login;
        this.password = password;
        this.email = email;
        this.siteweb = siteweb;
        this.adresse = adresse;
        this.telephone = telephone;
        this.description = description;
        this.document = document;
        this.logo = logo;
    }

    public Organisme(String nom) {
        this.nom = nom;
    }

    public Organisme(int id, String siteweb, String telephone, String description) {
        this.id = id;
        this.siteweb = siteweb;
        this.telephone = telephone;
        this.description = description;
      
    }
    
    

    public Organisme(int Id,String nom, String login, String password, String email, String adresse,File document,int etat) {
        this.id=id;
        this.nom = nom;
        this.login = login;
        this.password = password;
        this.email = email;
        this.adresse = adresse;
          this.document=document;
          this.etat=etat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
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
        final Organisme other = (Organisme) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSiteweb() {
        return siteweb;
    }

    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getDocument() {
        return document;
    }

    public void setDocument(File document) {
        this.document = document;
    }

    public File getLogo() {
        return logo;
    }

    public void setLogo(File logo) {
        this.logo = logo;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
 

    
    

    
}