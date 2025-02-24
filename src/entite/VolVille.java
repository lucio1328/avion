package entite;

public class VolVille {
    Vol vol;
    VilleDesservie villeDesservie;

    //==============================================
    public VolVille(Vol vol, VilleDesservie villeDesservie) {
        this.vol = vol;
        this.villeDesservie = villeDesservie;
    }
    public VolVille() {
    }
    //==============================================
    public Vol getVol() {
        return vol;
    }
    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public VilleDesservie getVilleDesservie() {
        return villeDesservie;
    }
    public void setVilleDesservie(VilleDesservie villeDesservie) {
        this.villeDesservie = villeDesservie;
    }
}
