
package pidev.entities;


public class Question {
    private  int idQuestion;
    private String question;
    private int idQuiz;  

    public Question() {
    }

    public Question(int idQuestion, String question, int idQuiz) {
        this.idQuestion = idQuestion;
        this.question = question;
        this.idQuiz = idQuiz;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public int getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    @Override
    public String toString() {
        return "Question{" + "idQuestion=" + idQuestion + ", question=" + question + ", idQuiz=" + idQuiz + '}';
    }

  
}
