/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;


/**
 *
 * @author Gumus
 */
public class Reponce {
    private int id;
    private boolean etat;
    private String reponce;
    private  Question idQuestion ;

    public Reponce(int id, boolean etat, String reponce, Question idQuestion) {
        this.id = id;
        this.etat = etat;
        this.reponce = reponce;
        this.idQuestion = idQuestion;
    }

    public String getReponce() {
        return reponce;
    }

    public void setReponce(String reponce) {
        this.reponce = reponce;
    }

    public int getId() {
        return id;
    }

    public boolean isEtat() {
        return etat;
    }

    public Question getIdQuestion() {
        return idQuestion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public void setIdQuestion(Question idQuestion) {
        this.idQuestion = idQuestion;
    }

    
    
}
