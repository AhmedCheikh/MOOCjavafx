
package pidev.entities;


public class Reponse {
    private int idReponse;
    private int etat;
    private String reponce;
    private int  idQuestion ;

    public Reponse(int idReponse, int etat, String reponce, int idQuestion) {
        this.idReponse = idReponse;
        this.etat = etat;
        this.reponce = reponce;
        this.idQuestion = idQuestion;
    }

    public int getIdReponse() {
        return idReponse;
    }

    public int getEtat() {
        return etat;
    }

    public String getReponce() {
        return reponce;
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

    public void setReponce(String reponce) {
        this.reponce = reponce;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    @Override
    public String toString() {
        return "Reponse{" + "idReponse=" + idReponse + ", etat=" + etat + ", reponce=" + reponce + ", idQuestion=" + idQuestion + '}';
    }

   
}
