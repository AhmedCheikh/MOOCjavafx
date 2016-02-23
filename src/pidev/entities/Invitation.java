package pidev.entities;

import java.util.Date;

/**
 *
 * @author akoubi
 */
public class Invitation {

   private int id;
   private String nom_exp;
   private String nom_des; 
   private Date date_invit; 
   private Date date_confi; 
   private Date date_vue;
   private int etat;

    public Invitation() {
    }

    public Invitation(String nom_exp, String nom_des, Date date_invit, int etat) {
        this.nom_exp = nom_exp;
        this.nom_des = nom_des;
        this.date_invit = date_invit;
        this.etat = etat;
    }

    public Invitation(String nom_exp, String nom_des, Date date_invit, Date date_confi, Date date_vue, int etat) {
        this.nom_exp = nom_exp;
        this.nom_des = nom_des;
        this.date_invit = date_invit;
        this.date_confi = date_confi;
        this.date_vue = date_vue;
        this.etat = etat;
    }

    public Invitation(int id, String nom_exp, String nom_des, Date date_invit, Date date_confi, Date date_vue, int etat) {
        this.id = id;
        this.nom_exp = nom_exp;
        this.nom_des = nom_des;
        this.date_invit = date_invit;
        this.date_confi = date_confi;
        this.date_vue = date_vue;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_exp() {
        return nom_exp;
    }

    public void setNom_exp(String nom_exp) {
        this.nom_exp = nom_exp;
    }

    public String getNom_des() {
        return nom_des;
    }

    public void setNom_des(String nom_des) {
        this.nom_des = nom_des;
    }

    public Date getDate_invit() {
        return date_invit;
    }

    public void setDate_invit(Date date_invit) {
        this.date_invit = date_invit;
    }

    public Date getDate_confi() {
        return date_confi;
    }

    public void setDate_confi(Date date_confi) {
        this.date_confi = date_confi;
    }

    public Date getDate_vue() {
        return date_vue;
    }

    public void setDate_vue(Date date_vue) {
        this.date_vue = date_vue;
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
        hash = 41 * hash + this.id;
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
        final Invitation other = (Invitation) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Invitation{" + "id=" + id + ", nom_exp=" + nom_exp + ", nom_des=" + nom_des + ", date_invit=" + date_invit + ", date_confi=" + date_confi + ", date_vue=" + date_vue + ", etat=" + etat + '}';
    }
   
   
}
