package ba.unsa.etf.rpr;

import java.util.*;
import java.util.function.Function;

public class Preduzece {
    private int osnovica;
    private ArrayList<RadnoMjesto>radna_mjesta=new ArrayList<RadnoMjesto>();

    public Preduzece(int osnovica) throws NeispravnaOsnovica {
        if(osnovica<=0) throw new NeispravnaOsnovica("Neispravna osnovica"+Integer.toString(osnovica));
        this.osnovica=osnovica;
    }

    public int dajOsnovicu() {
        return osnovica;
    }

    public void novoRadnoMjesto(RadnoMjesto novo) {
        radna_mjesta.add(novo);
    }

    public void obracunajPlatu() {
        for(RadnoMjesto rm:radna_mjesta){
            if(rm.getRadnik()!=null)
            rm.getRadnik().dodajPlatu(osnovica*rm.getKoeficijent());
        }
    }

    public void postaviOsnovicu(int osnovica) throws NeispravnaOsnovica {
        if(osnovica<=0) throw new NeispravnaOsnovica("Neispravna osnovica"+Integer.toString(osnovica));


        this.osnovica=osnovica;
    }

    public void zaposli(Radnik radnik, String nazivRadnog) {
        for(RadnoMjesto rm:radna_mjesta){
            if(rm.getNaziv().equals(nazivRadnog) && rm.getRadnik()==null) {
                rm.setRadnik(radnik);
                return;
            }
        }
        throw new IllegalArgumentException("Nijedno radno mjesto tog tipa nije slobodno");
    }

    public List<Radnik> vecaProsjecnaPlata(double plata) {
        return filterRadnici((Radnik r) -> { return r.prosjecnaPlata() > plata; });
    }

    public Map<RadnoMjesto, Integer> sistematizacija() {
        HashMap<RadnoMjesto,Integer> mapa=new HashMap<>();
        for(RadnoMjesto rm:radna_mjesta){
            Integer broj=mapa.get(rm);
            if(broj==null)
                mapa.put(rm,1);
            else
                mapa.put(rm,broj+1);
        }
        return mapa;
    }

    public Set<Radnik> radnici() {
        TreeSet<Radnik> skup=new TreeSet<>();
        for(RadnoMjesto rm:radna_mjesta){
            if(rm.getRadnik()!=null){
                skup.add(rm.getRadnik());
            }
        }
        return skup;
    }

    public double iznosPlate() {
        double suma=0;
        for(RadnoMjesto rm:radna_mjesta){
            if(rm.getRadnik()!=null){
                suma+=osnovica*rm.getKoeficijent();
            }
        }
        return suma;
    }

    public List<Radnik> filterRadnici(Function<Radnik,Boolean> lol) {
        ArrayList<Radnik> radnici = new ArrayList<Radnik>();
        for(RadnoMjesto rm:radna_mjesta){
            if(rm.getRadnik()!=null && lol.apply(rm.getRadnik()))
            radnici.add(rm.getRadnik());
        }
        return radnici;
    }
}
