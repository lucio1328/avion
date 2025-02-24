package entite;

public class TypeSiege {
    Integer id;
    String libelle;

    //==============================================
    public TypeSiege(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    public TypeSiege() {
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
