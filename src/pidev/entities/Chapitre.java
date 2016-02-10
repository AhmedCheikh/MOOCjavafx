package pidev.entities;

import java.io.File;

public class Chapitre {

    private int idChapitre;
    private String titre;
    private File presentation;
    private String objectif;
    private int etat;
    private Quiz idQuiz;
    private Cours idCours;
    private int idVideo;

    public Chapitre(int idChapitre, String titre, File presentation, String objectif, int etat, Quiz idQuiz, Cours idCours, int idVideo) {
        this.idChapitre = idChapitre;
        this.titre = titre;
        this.presentation = presentation;
        this.objectif = objectif;
        this.etat = etat;
        this.idQuiz = idQuiz;
        this.idCours = idCours;
        this.idVideo = idVideo;
    }

    public int getIdChapitre() {
        return idChapitre;
    }

    public String getTitre() {
        return titre;
    }

    public File getPresentation() {
        return presentation;
    }

    public String getObjectif() {
        return objectif;
    }

    public int getEtat() {
        return etat;
    }

    public Quiz getIdQuiz() {
        return idQuiz;
    }

    public Cours getIdCours() {
        return idCours;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdChapitre(int idChapitre) {
        this.idChapitre = idChapitre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setPresentation(File presentation) {
        this.presentation = presentation;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setIdQuiz(Quiz idQuiz) {
        this.idQuiz = idQuiz;
    }

    public void setIdCours(Cours idCours) {
        this.idCours = idCours;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    @Override
    public String toString() {
        return "Chapitre{" + "idChapitre=" + idChapitre + ", titre=" + titre + ", presentation=" + presentation + ", objectif=" + objectif + ", etat=" + etat + ", idQuiz=" + idQuiz + ", idCours=" + idCours + ", idVideo=" + idVideo + '}';
    }

    
}
