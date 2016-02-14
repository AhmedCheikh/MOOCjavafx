package pidev.entities;

import java.io.File;
import java.util.Objects;

public class Cours {

    private int idCours;
    private String nomCours;
    private String description;
    private String cinFormateur;
    private String difficulte;
    private String objectif;
    private File video;
    private int idQuiz;
    private int etatVideo;

    public Cours(String nomCours, String description, String cinFormateur, String difficulte, String objectif, int idQuiz) {
        
        this.nomCours = nomCours;
        this.description = description;
        this.cinFormateur = cinFormateur;
        this.difficulte = difficulte;
        this.objectif = objectif;
       
        this.idQuiz = idQuiz;
  
    }

    public Cours() {
       
    }

    public int getIdCours() {
        return idCours;
    }

    public String getNomCours() {
        return nomCours;
    }

    public String getDescription() {
        return description;
    }

    public String getCinFormateur() {
        return cinFormateur;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public String getObjectif() {
        return objectif;
    }

   

    public int getIdQuiz() {
        return idQuiz;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCinFormateur(String cinFormateur) {
        this.cinFormateur = cinFormateur;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

   

    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    public void setVideo(File video) {
        this.video = video;
    }

    public void setEtatVideo(int etatVideo) {
        this.etatVideo = etatVideo;
    }

    public File getVideo() {
        return video;
    }

    public int getEtatVideo() {
        return etatVideo;
    }

    @Override
    public String toString() {
        return "Cours{" + "idCours=" + idCours + ", nomCours=" + nomCours + ", description=" + description + ", cinFormateur=" + cinFormateur + ", difficulte=" + difficulte + ", objectif=" + objectif  + ", idQuiz=" + idQuiz +'}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idCours;
        hash = 29 * hash + Objects.hashCode(this.nomCours);
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
        final Cours other = (Cours) obj;
        if (this.idCours != other.idCours) {
            return false;
        }
        if (!Objects.equals(this.nomCours, other.nomCours)) {
            return false;
        }
        return true;
    }

    
    
    

}
