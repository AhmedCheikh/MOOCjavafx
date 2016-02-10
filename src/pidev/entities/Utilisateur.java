
package pidev.entities;


public class Utilisateur {
    protected String login ;
    protected String password ;
    protected String role ;

    public Utilisateur(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
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

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "login=" + login + ", password=" + password + ", role=" + role + '}';
    }
    
}
