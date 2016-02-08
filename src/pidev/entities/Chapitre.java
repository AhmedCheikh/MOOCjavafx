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
public class Chapitre {

    private int id;
    private String titre;
    private String description;
    private String video;
    private boolean etat;
    private Quiz Quiz;
    private Cours idCours;

    public Chapitre(int id, String titre, String description, String video, boolean etat, Quiz Quiz, Cours idCours) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.video = video;
        this.etat = etat;
        this.Quiz = Quiz;
        this.idCours = idCours;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTb_Quiz(Quiz Quiz) {
        this.Quiz = Quiz;
    }


    public void setVideo(String video) {
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Quiz getQuiz() {
        return Quiz;
    }

    public String getVideo() {
        return video;
    }
    public boolean isEtat() {
        return etat;
    }

    public Cours getIdCours() {
        return idCours;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public void setIdCours(Cours idCours) {
        this.idCours = idCours;
    }
}
