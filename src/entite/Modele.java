package entite;

public class Modele {
    Integer id;
    String libelle;

    //==============================================
    public Modele(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    public Modele() {
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
