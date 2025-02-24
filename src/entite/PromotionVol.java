package entite;

import java.sql.Timestamp;

public class PromotionVol {
    Vol vol;
    TypeSiege typeSiege;
    Integer nombrePlace;
    Double pourcentage;
    Timestamp datePromotion;

    //==============================================
    public PromotionVol(Vol vol, TypeSiege typeSiege, Integer nombrePlace, Double pourcentage,
            Timestamp datePromotion) {
        this.vol = vol;
        this.typeSiege = typeSiege;
        this.nombrePlace = nombrePlace;
        this.pourcentage = pourcentage;
        this.datePromotion = datePromotion;
    }
    public PromotionVol() {
    }
    //==============================================
    public Vol getVol() {
        return vol;
    }
    public void setVol(Vol vol) {
        this.vol = vol;
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

    public Double getPourcentage() {
        return pourcentage;
    }
    public void setPourcentage(Double pourcentage) {
        this.pourcentage = pourcentage;
    }

    public Timestamp getDatePromotion() {
        return datePromotion;
    }
    public void setDatePromotion(Timestamp datePromotion) {
        this.datePromotion = datePromotion;
    }
}
