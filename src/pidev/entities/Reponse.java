package pidev.entities;

public class Reponse {

    private int idReponse;
    private int etat;
    private String reponse;
    private int idQuestion;

    public Reponse() {
    }

    public Reponse(int etat, String reponse, int idQuestion) {
        this.etat = etat;
        this.reponse = reponse;
        this.idQuestion = idQuestion;
    }
    

    public Reponse(int idReponse, int etat, String reponse, int idQuestion) {
        this.idReponse = idReponse;
        this.etat = etat;
        this.reponse = reponse;
        this.idQuestion = idQuestion;
    }

    public int getIdReponse() {
        return idReponse;
    }

    public int getEtat() {
        return etat;
    }

    public String getReponse() {
        return reponse;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdReponse(int idReponse) {
        this.idReponse = idReponse;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }



    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    @Override
    public String toString() {
        return "Reponse{" + "idReponse=" + idReponse + ", etat=" + etat + ", reponse=" + reponse + ", idQuestion=" + idQuestion + '}';
    }

}
