
package pidev.entities;


public class Utilisateur {
    protected int idUser;
    protected String login ;
    protected String password ;
    protected String role ;

    public Utilisateur(int idUser, String login, String password, String role) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "idUser=" + idUser + ", login=" + login + ", password=" + password + ", role=" + role + '}';
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

   

   
}
