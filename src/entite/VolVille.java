package entite;

public class VolVille {
    Integer vol;
    Integer villeDesservie;

    //==============================================
    public VolVille(Integer vol, Integer villeDesservie) {
        this.vol = vol;
        this.villeDesservie = villeDesservie;
    }
    public VolVille() {
    }
    //==============================================
    public Integer getVol() {
        return vol;
    }
    public void setVol(Integer vol) {
        this.vol = vol;
    }

    public Integer getVilleDesservie() {
        return villeDesservie;
    }
    public void setVilleDesservie(Integer villeDesservie) {
        this.villeDesservie = villeDesservie;
    }
}
