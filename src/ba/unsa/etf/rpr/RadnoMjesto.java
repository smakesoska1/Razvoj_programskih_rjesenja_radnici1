package ba.unsa.etf.rpr;

public class RadnoMjesto {
    private String naziv;
    private double koeficijent;
    private Radnik radnik=null;
    public RadnoMjesto(String naziv, int koeficijent, Radnik radnik) {
        this.naziv=naziv;
        this.koeficijent=koeficijent;
        this.radnik=radnik;
    }

    public RadnoMjesto() {

    }

    public void setNaziv(String naziv) {
        this.naziv=naziv;
    }

    public void setKoeficijent(int koeficijent) {
        this.koeficijent=koeficijent;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getKoeficijent() {
        return koeficijent;
    }

    public Object getRadnik() {
    }
}
