package entite;

import java.sql.Timestamp;

public class Vol {
    Integer id;
    Integer avion;
    Timestamp dateDepart;
    Double duree;
    Integer heureReservationAvantVol;
    Integer heureAnnulatioReservationAvantVol;

    //==============================================
    public Vol(Integer id, Integer avion, Timestamp dateDepart, Double duree, Integer heureReservationAvantVol,
            Integer heureAnnulatioReservationAvantVol) {
        this.id = id;
        this.avion = avion;
        this.dateDepart = dateDepart;
        this.duree = duree;
        this.heureReservationAvantVol = heureReservationAvantVol;
        this.heureAnnulatioReservationAvantVol = heureAnnulatioReservationAvantVol;
    }
    public Vol() {
    }
    //==============================================
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvion() {
        return avion;
    }
    public void setAvion(Integer avion) {
        this.avion = avion;
    }

    public Timestamp getDateDepart() {
        return dateDepart;
    }
    public void setDateDepart(Timestamp dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Double getDuree() {
        return duree;
    }
    public void setDuree(Double duree) {
        this.duree = duree;
    }

    public Integer getHeureReservationAvantVol() {
        return heureReservationAvantVol;
    }
    public void setHeureReservationAvantVol(Integer heureReservationAvantVol) {
        this.heureReservationAvantVol = heureReservationAvantVol;
    }

    public Integer getHeureAnnulatioReservationAvantVol() {
        return heureAnnulatioReservationAvantVol;
    }
    public void setHeureAnnulatioReservationAvantVol(Integer heureAnnulatioReservationAvantVol) {
        this.heureAnnulatioReservationAvantVol = heureAnnulatioReservationAvantVol;
    }
}
