package pidev.entities;

import java.sql.Blob;

public class Chapitre {

    private int idChapitre;
    private String titre;
    private Blob presentation;
    private String objectif;
    private int etat;
    private int idQuiz;
    private int idCours;
    private Blob Video;
    
    public Chapitre(int idChapitre, int idCours, int idQuiz,String titre, Blob presentation, String objectif, int etat,Blob Video) {
        this.idChapitre = idChapitre;
        this.titre = titre;
        this.presentation = presentation;
        this.objectif = objectif;
        this.etat = etat;
        this.idQuiz = idQuiz;
        this.idCours = idCours;
        this.Video = Video;
    }

    public Chapitre(int idChapitre,int idCours, String titre, String objectif, int etat) {
        this.idChapitre = idChapitre;
        this.titre = titre;
        this.objectif = objectif;
        this.etat = etat;
        this.idCours = idCours;
    }
    

    public Chapitre(int idChapitre, int idCours, int idQuiz,String titre, String objectif, int etat,Blob Video) {
        this.titre = titre;
        this.objectif = objectif;
        this.etat = etat;
        this.idQuiz = idQuiz;
        this.idCours = idCours;
        this.Video = Video;
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

    public Blob getPresentation() {
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

    public void setPresentation(Blob presentation) {
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
