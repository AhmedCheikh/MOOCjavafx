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
public class Administrateur  {
    
    private int id ; 
    private String loginAdmin ; 
    private String passwordAdmin ; 

    public Administrateur(int id, String loginAdmin, String passwordAdmin) {
        this.id = id;
        this.loginAdmin = loginAdmin;
        this.passwordAdmin = passwordAdmin;
    }

    public int getId() {
        return id;
    }

    public String getLoginAdmin() {
        return loginAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLoginAdmin(String loginAdmin) {
        this.loginAdmin = loginAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.id;
        hash = 19 * hash + Objects.hashCode(this.loginAdmin);
        hash = 19 * hash + Objects.hashCode(this.passwordAdmin);
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
        final Administrateur other = (Administrateur) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.loginAdmin, other.loginAdmin)) {
            return false;
        }
        if (!Objects.equals(this.passwordAdmin, other.passwordAdmin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Administrateur{" + "id=" + id + ", loginAdmin=" + loginAdmin + ", passwordAdmin=" + passwordAdmin + '}';
    }
    
    
    
}
