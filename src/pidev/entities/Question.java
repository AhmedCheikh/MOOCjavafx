/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Gumus
 */
public class Question {
    private  int id;
    private Set mvReponce = new HashSet(0);

    public Question(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Set getMvReponce() {
        return mvReponce;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMvReponce(Set mvReponce) {
        this.mvReponce = mvReponce;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.mvReponce, other.mvReponce)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", mvReponce=" + mvReponce + '}';
    }
    
    
}
