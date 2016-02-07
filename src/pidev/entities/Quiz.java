/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Gumus
 */
public class Quiz {
    private int id;
    private String type;
    private Set mvQuestion = new HashSet(0);

    public Quiz(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Set getMvQuestion() {
        return mvQuestion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMvQuestion(Set mvQuestion) {
        this.mvQuestion = mvQuestion;
    }

    @Override
    public String toString() {
        return "Quiz{" + "id=" + id + ", type=" + type + ", mvQuestion=" + mvQuestion + '}';
    }
    
   
    
}
