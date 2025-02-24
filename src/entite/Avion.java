package entite;

import java.sql.Date;

public class Avion {
    Integer id;
    Modele modele;
    Date dateFabrication;

    //==============================================
    public Avion(Integer id, Modele modele, Date dateFabrication) {
        this.id = id;
        this.modele = modele;
        this.dateFabrication = dateFabrication;
    }
    public Avion() {
    }
    //==============================================
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Modele getModele() {
        return modele;
    }
    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public Date getDateFabrication() {
        return dateFabrication;
    }
    public void setDateFabrication(Date dateFabrication) {
        this.dateFabrication = dateFabrication;
    }
}
