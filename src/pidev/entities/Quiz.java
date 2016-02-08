
package pidev.entities;

public class Quiz {
    private int id;
    private String titre;
    private String type;
    private Question[] Questions;
    private Cours idcours;
    private Chapitre idchapitre;

    public Quiz(int id, String titre, String type, Question[] Questions, Cours idcours, Chapitre idchapitre) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.Questions = Questions;
        this.idcours = idcours;
        this.idchapitre = idchapitre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuestions(Question[] Questions) {
        this.Questions = Questions;
    }

    public void setIdcours(Cours idcours) {
        this.idcours = idcours;
    }

    public void setIdchapitre(Chapitre idchapitre) {
        this.idchapitre = idchapitre;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getType() {
        return type;
    }

    public Question[] getQuestions() {
        return Questions;
    }

    public Cours getIdcours() {
        return idcours;
    }

    public Chapitre getIdchapitre() {
        return idchapitre;
    }
    
    
}
