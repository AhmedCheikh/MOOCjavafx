package pidev.entities;

public class Quiz {

    private int idQuiz;
    private String titre;
    private int type;
    private int etat;

    public Quiz(int idQuiz,String titre, int type, int etat) {
        this.idQuiz = idQuiz;
        this.titre = titre;
        this.type = type;
        this.etat = etat;
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

    @Override
    public String toString() {
        return "Quiz{" + "idQuiz=" + idQuiz + ", titre=" + titre + ", type=" + type + ", etat=" + etat + '}';
    }

}
