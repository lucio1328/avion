package entite;

public class Statut {
    Integer id;
    String libelle;

    //==============================================
    public Statut(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    public Statut() {
    }
    //==============================================
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
