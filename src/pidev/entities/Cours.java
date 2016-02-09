
package pidev.entities;

public class Cours {
    private int idCours ;
    private String nomCours;
    private String description;
    private String video ;
    private int idQuiz ;
    private String cinFormateur;
    private int [] chapitres ;
    private String difficulte ;
    private String objectif ;

    public Cours(int idCours, String nomCours, String description, String video, int idQuiz, String cinFormateur, int[] chapitres, String difficulte, String objectif) {
        this.idCours = idCours;
        this.nomCours = nomCours;
        this.description = description;
        this.video = video;
        this.idQuiz = idQuiz;
        this.cinFormateur = cinFormateur;
        this.chapitres = chapitres;
        this.difficulte = difficulte;
        this.objectif = objectif;
    }

    public Cours() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }
    
    public int getIdCours() {
        return idCours;
    }

    public String getDescription() {
        return description;
    }

    public String getVideo() {
        return video;
    }

    public int getIdQuiz() {
        return idQuiz;
    }

    public String getCinFormateur() {
        return cinFormateur;
    }

    public int[] getChapitres() {
        return chapitres;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public String getObjectif() {
        return objectif;
    }

   

    public void setDifficulte(String dificulte) {
        this.difficulte = dificulte;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

     public void setCinFormateur(String cinFormateur) {
        this.cinFormateur = cinFormateur;
    }

    public void setChapitres(int[] chapitres) {
        this.chapitres = chapitres;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        return true;
    }

    @Override
    public String toString() {
        return "Cours{" + "idCours=" + idCours + ", description=" + description + ", video=" + video + ", idQuiz=" + idQuiz + ", cinFormateur=" + cinFormateur + ", chapitres=" + chapitres + ", difficulte=" + difficulte + ", objectif=" + objectif +  '}';
    }


    
}
