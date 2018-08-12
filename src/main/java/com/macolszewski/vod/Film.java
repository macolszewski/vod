package com.macolszewski.vod;

import java.util.ArrayList;
import java.util.List;

public class Film {
    private String tytul;
    private String rezyser;
    private int rokWydania;
    private GatunekFilmu gatunek;
    private boolean dostepnosc = true;

    List<Film> listaFilmow = new ArrayList<>();

    public Film(String tytul, String rezyser, int rok, GatunekFilmu gatunek, boolean dostepnosc){
        this.tytul = tytul;
        this.rezyser = rezyser;
        this.rokWydania = rok;
        this.gatunek = gatunek;
        this.dostepnosc = dostepnosc;
    }

    public Film dodajFilm(){
//        TODO: Tu będzie metoda do dodawania filmów,gdz
        return new Film();
    }
}
