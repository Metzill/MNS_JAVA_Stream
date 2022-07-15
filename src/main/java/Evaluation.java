public class Evaluation {

    private Personne personne;

    private Integer note;

    public Evaluation(Personne personne, Integer note) {
        this.personne = personne;
        this.note = note;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }
}
