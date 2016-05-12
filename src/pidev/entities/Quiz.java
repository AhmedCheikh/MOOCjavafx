package pidev.entities;

public class Quiz {

    private int idQuiz;
    private String titre;
    private int type;


    public Quiz() {
    }

    public Quiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    public Quiz(String titre) {
        this.titre = titre;
    }

    public Quiz(int idQuiz,String titre, int type) {
        this.idQuiz = idQuiz;
        this.titre = titre;
        this.type = type;
            }

    public Quiz(int idQuiz, String titre) {
        this.idQuiz = idQuiz;
        this.titre = titre;
       
    }

    public Quiz(String titre, int type) {
        this.titre = titre;
        this.type = type;
    
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


    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Quiz{" + "idQuiz=" + idQuiz + ", titre=" + titre + ", type=" + type + '}';
    }


}
