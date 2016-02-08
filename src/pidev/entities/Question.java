
package pidev.entities;


public class Question {
    private  int id;
    private String question;
    private Reponce[] mvReponce;
    private Quiz idquiz;

    public Question(int id, String question, Reponce[] mvReponce, Quiz idquiz) {
        this.id = id;
        this.question = question;
        this.mvReponce = mvReponce;
        this.idquiz = idquiz;
    }
    
    public Quiz getIdquiz() {
        return idquiz;
    }

    public void setIdquiz(Quiz idquiz) {
        this.idquiz = idquiz;
    }
    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public Reponce[] getMvReponce() {
        return mvReponce;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setMvReponce(Reponce[] mvReponce) {
        this.mvReponce = mvReponce;
    }

    
    
    
}
