package entite;

import java.sql.Timestamp;

public class ReservationEtat {
    Reservation reservation;
    Statut statut;
    TypeSiege typeSiege;
    Integer nombrePlace;
    Timestamp daty;

    //==============================================
    public ReservationEtat(Reservation reservation, Statut statut, TypeSiege typeSiege, Integer nombrePlace,
            Timestamp daty) {
        this.reservation = reservation;
        this.statut = statut;
        this.typeSiege = typeSiege;
        this.nombrePlace = nombrePlace;
        this.daty = daty;
    }
    public ReservationEtat() {
    }
    //==============================================
    public Reservation getReservation() {
        return reservation;
    }
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Statut getStatut() {
        return statut;
    }
    public void setStatut(Statut statut) {
        this.statut = statut;
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

    public Timestamp getDaty() {
        return daty;
    }
    public void setDaty(Timestamp daty) {
        this.daty = daty;
    }
}
