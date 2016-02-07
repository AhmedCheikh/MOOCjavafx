
package pidev.entities;

public class Cours {
    private int idCours ;
    private String description;
    private String video ;
    private int idQuiz ;
    private int cinFormateur;
    private String [] chapitres ;

    public Cours(String description, String video, int idQuiz, int cinFormateur, String[] chapitres) {
       
        this.description = description;
        this.video = video;
        this.idQuiz = idQuiz;
        this.cinFormateur=cinFormateur ;
        this.chapitres = chapitres;
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

    public int getCinFormateur() {
        return cinFormateur;
    }

    public String[] getChapitres() {
        return chapitres;
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

     public void setCinFormateur(int cinFormateur) {
        this.cinFormateur = cinFormateur;
    }

    public void setChapitres(String[] chapitres) {
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
        return "Cours{" + "idCours=" + idCours + ", description=" + description + ", video=" + video + ", idQuiz=" + idQuiz + ", formateurs=" + cinFormateur + ", chapitres=" + chapitres + '}';
    }

    
    
    
}
