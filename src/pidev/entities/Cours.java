package pidev.entities;

public class Cours {

    private int idCours;
    private String nomCours;
    private String description;
    private String cinFormateur;
    private String difficulte;
    private String objectif;
    private int idVideo;
    private int idQuiz;

    public Cours(int idCours, String nomCours, String description, String cinFormateur, String difficulte, String objectif, int idVideo, int idQuiz) {
        this.idCours = idCours;
        this.nomCours = nomCours;
        this.description = description;
        this.cinFormateur = cinFormateur;
        this.difficulte = difficulte;
        this.objectif = objectif;
        this.idVideo = idVideo;
        this.idQuiz = idQuiz;
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

    public int getIdVideo() {
        return idVideo;
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

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    @Override
    public String toString() {
        return "Cours{" + "idCours=" + idCours + ", nomCours=" + nomCours + ", description=" + description + ", cinFormateur=" + cinFormateur + ", difficulte=" + difficulte + ", objectif=" + objectif + ", idVideo=" + idVideo + ", idQuiz=" + idQuiz + '}';
    }
    
    

}
