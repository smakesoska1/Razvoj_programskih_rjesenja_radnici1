package ba.unsa.etf.rpr;

public class Radnik implements Comparable<Radnik> {
private String imePrezime;
private String jmbg;
private double [] plate=new double [1000];
private int brojacPlata=0;
    public Radnik(String imePrezime, String jmbg) {
        this.imePrezime=imePrezime;
        this.jmbg=jmbg;

    }

    public String getImePrezime() {
        return imePrezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime=imePrezime;
    }

    public void setJmbg(String jmbg) {
        this.jmbg=jmbg;
    }

    public void dodajPlatu(double plata){
        if(brojacPlata==1000) throw new IllegalArgumentException("Ne možete registrovati više od 1000 plata za radnika"+imePrezime);
        plate[brojacPlata++]=plata;
    }

    public double prosjecnaPlata() {
        double rezultat=0;
        for(int i=0;i<brojacPlata;i++)
            rezultat+=plate[i];

        if(brojacPlata>0)
            rezultat /= brojacPlata;
return rezultat;

    }
    @Override
    public int compareTo(Radnik r){
        if(prosjecnaPlata()<r.prosjecnaPlata())
            return 1;
            else
                return -1;
    }
}
