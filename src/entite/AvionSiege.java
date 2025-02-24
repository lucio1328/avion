package entite;

import java.sql.Date;

public class AvionSiege {
    Avion avion;
    TypeSiege typeSiege;
    Integer nombrePlace;
    Double prix;
    Date dateModification;

    //==============================================
    public AvionSiege(Avion avion, TypeSiege typeSiege, Integer nombrePlace, Double prix, Date dateModification) {
        this.avion = avion;
        this.typeSiege = typeSiege;
        this.nombrePlace = nombrePlace;
        this.prix = prix;
        this.dateModification = dateModification;
    }
    public AvionSiege() {
    }
    //==============================================
    public Avion getAvion() {
        return avion;
    }
    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public TypeSiege getTypeSiege() {
        return typeSiege;
    }
    public void setTypeSiege(TypeSiege typeSiege) {
        this.typeSiege = typeSiege;
    }

    public Integer getNombrePlace() {
        return nombrePlace;
    }
    public void setNombrePlace(Integer nombrePlace) {
        this.nombrePlace = nombrePlace;
    }

    public Double getPrix() {
        return prix;
    }
    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Date getDateModification() {
        return dateModification;
    }
    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }
}
