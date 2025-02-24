package entite;

import java.sql.Timestamp;

public class Reservation {
    Integer id;
    User user;
    Vol vol;
    Timestamp dateReservation;

    //==============================================
    public Reservation(Integer id, User user, Vol vol, Timestamp dateReservation) {
        this.id = id;
        this.user = user;
        this.vol = vol;
        this.dateReservation = dateReservation;
    }
    public Reservation() {
    }
    //==============================================
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Vol getVol() {
        return vol;
    }
    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public Timestamp getDateReservation() {
        return dateReservation;
    }
    public void setDateReservation(Timestamp dateReservation) {
        this.dateReservation = dateReservation;
    }
}
