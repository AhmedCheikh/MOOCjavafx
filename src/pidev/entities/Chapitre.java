
package pidev.entities;


public class Chapitre {

    private int id;
    private String titre;
    private String presentation;
    private String video;
    private String objectif;
    private boolean etat;
    private Quiz Quiz;
    private Cours idCours;

    public Chapitre(int id, String titre, String presentation, String video, String objectif, boolean etat, Quiz Quiz, Cours idCours) {
        this.id = id;
        this.titre = titre;
        this.presentation = presentation;
        this.video = video;
        this.objectif = objectif;
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

    public String getPresentation() {
        return presentation;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public void setQuiz(Quiz Quiz) {
        this.Quiz = Quiz;
    }

    @Override
    public String toString() {
        return "Chapitre{" + "id=" + id + ", titre=" + titre + ", presentation=" + presentation + ", video=" + video + ", objectif=" + objectif + ", etat=" + etat + ", Quiz=" + Quiz + ", idCours=" + idCours + '}';
    }
    
}
