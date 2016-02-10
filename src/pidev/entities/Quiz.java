
package pidev.entities;

public class Quiz {
    private int idQuiz;
    private String titre;
    private int type;
    private int etat;
    private int idCours;
    private int idChapitre;

    public Quiz(int idQuiz, String titre, int type, int etat, int idCours, int idChapitre) {
        this.idQuiz = idQuiz;
        this.titre = titre;
        this.type = type;
        this.etat = etat;
        this.idCours = idCours;
        this.idChapitre = idChapitre;
    }

    public int getIdQuiz() {
        return idQuiz;
    }

    public String getTitre() {
        return titre;
    }

    public int getType() {
        return type;
    }

    public int getEtat() {
        return etat;
    }

    public int getIdCours() {
        return idCours;
    }

    public int getIdChapitre() {
        return idChapitre;
    }

    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public void setIdChapitre(int idChapitre) {
        this.idChapitre = idChapitre;
    }

    @Override
    public String toString() {
        return "Quiz{" + "idQuiz=" + idQuiz + ", titre=" + titre + ", type=" + type + ", etat=" + etat + ", idCours=" + idCours + ", idChapitre=" + idChapitre + '}';
    }

   
}
