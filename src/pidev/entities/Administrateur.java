/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

/**
 *
 * @author WiKi
 */
public class Administrateur extends Utilisateur {
    
    private int idAdmin ; 
    private int idUser;



    public Administrateur(int idAdmin, int idUser, String login, String password, String role) {
        super(idUser, login, password, role);
        this.idAdmin = idAdmin;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public String toString() {
        return "Administrateur{" + "idAdmin=" + idAdmin + ", idUser=" + idUser + '}';
    }




    
}
