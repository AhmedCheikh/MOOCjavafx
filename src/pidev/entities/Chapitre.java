package pidev.entities;

import java.io.File;
import java.sql.Blob;

public class Chapitre {

    private int idChapitre;
    private String titre;
    private File presentation;
    private String objectif;
    private int etat;
    private int idQuiz;
    private int idCours;
    private Blob Video;

    public Chapitre() {
    }

    public Chapitre(int idCours, String titre, String objectif) {
        this.idCours = idCours;
        this.titre = titre;
        this.objectif = objectif;
    }

    public Chapitre(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    public Chapitre(int idChapitre, int idCours, int idQuiz, String titre,File presentation, String objectif, int etat, Blob Video) {
        this.idChapitre = idChapitre;
        this.titre = titre;
        this.presentation = presentation;
        this.objectif = objectif;
        this.etat = etat;
        this.idQuiz = idQuiz;
        this.idCours = idCours;
        this.Video = Video;
    }

    public Chapitre(int idChapitre, int idCours, String titre, String objectif, int etat) {
        this.idChapitre = idChapitre;
        this.titre = titre;
        this.objectif = objectif;
        this.etat = etat;
        this.idCours = idCours;
    }

    public Chapitre(int idChapitre, int idCours, int idQuiz, String titre, String objectif, int etat, Blob Video) {
        this.titre = titre;
        this.objectif = objectif;
        this.etat = etat;
        this.idQuiz = idQuiz;
        this.idCours = idCours;
        this.Video = Video;
    }

    public Chapitre(String titre, String objectif) {
        this.titre = titre;
        this.objectif = objectif;
    }

    @Override
    public String toString() {
        return "Chapitre{" + "idChapitre=" + idChapitre + ", titre=" + titre + ", presentation=" + presentation + ", objectif=" + objectif + ", etat=" + etat + ", idQuiz=" + idQuiz + ", idCours=" + idCours + ", Video=" + Video + '}';
    }

    public void setIdChapitre(int idChapitre) {
        this.idChapitre = idChapitre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public File getPresentation() {
        return presentation;
    }

    public Blob getVideo() {
        return Video;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public int getIdChapitre() {
        return idChapitre;
    }

    public String getTitre() {
        return titre;
    }

    public void setPresentation(File presentation) {
        this.presentation = presentation;
    }

    public void setVideo(Blob Video) {
        this.Video = Video;
    }

    public String getObjectif() {
        return objectif;
    }

    public int getEtat() {
        return etat;
    }

    public int getIdQuiz() {
        return idQuiz;
    }

    public int getIdCours() {
        return idCours;
    }

}
