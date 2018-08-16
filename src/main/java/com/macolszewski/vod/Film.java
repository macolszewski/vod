package com.macolszewski.vod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Film {
    private String title;
    private String rezyser;
    private int rokWydania;
    private GatunekFilmu gatunek;
    private boolean dostepnosc = true;

    static List<Film> filmList = new ArrayList<>();

    public Film(String title, String rezyser, int rok, GatunekFilmu gatunek, boolean dostepnosc) {
        this.title = title;
        this.rezyser = rezyser;
        this.rokWydania = rok;
        this.gatunek = gatunek;
        this.dostepnosc = dostepnosc;
    }
    /**
     * Metoda dodająca film do listy filmów.
    */
    static void addFilm() {
        System.out.print("Podaj tytuł filmu: ");
        String title = Menu.input.next();
        System.out.print("Podaj imię i nazwisko reżysera: ");
        String rezyser = Menu.input.next();
        System.out.print("Podaj rok wydania filmu: ");
        int rokWydania = Menu.input.nextInt();
        System.out.println("Podaj gatunek filmu: ");
        System.out.println("1. Dramat");
        System.out.println("2. Komedia");
        System.out.println("3. Horror");
        int addFilmType = 0;

        while (addFilmType != 3) {
            addFilmType = Menu.input.nextInt();
            GatunekFilmu gatunek = null;
            switch (addFilmType) {
                case 1:
                    gatunek = GatunekFilmu.DRAMAT;
                    filmList.add(new Film(title, rezyser, rokWydania, gatunek, true));
                    addNextFilm();
                    break;
                case 2:
                    gatunek = GatunekFilmu.KOMEDIA;
                    filmList.add(new Film(title, rezyser, rokWydania, gatunek, true));
                    addNextFilm();
                    break;
                case 3:
                    gatunek = GatunekFilmu.HORROR;
                    filmList.add(new Film(title, rezyser, rokWydania, gatunek, true));
                    addNextFilm();
                    break;
                default:
                    System.out.println("Podaj ponownie gatunek filmu.");
            }
        }
    }
    /*
    * Metoda pytająca "czy chcesz dodać następny film?"*/
    static void addNextFilm(){
        System.out.println("Chcesz dodać następny film? ");
        System.out.println("1. Tak");
        System.out.println("2. Nie");
        int addNextFilm = 0;
        while (addNextFilm !=2){
            addNextFilm = Menu.input.nextInt();
            switch (addNextFilm){
                case 1:
                    addFilm();
                    break;
                case 2:
                    System.out.println("NIE WIEM JAK DODA METODE Z MENU?=+++++=====+");
                    break;
            }
        }
    }
    /**
     * Metoda do wyświetlenia wszystkich filmów.
     * */
    static void showAllFilmList() {
        System.out.println(filmList);
    }

    /*
    * Metoda do wyświetlenie filmów z gatunku Drama
    * */
    static void showDramaFilmList(){

        }


    /*
     * Metoda do wyświetlenie filmów z gatunku Comedy
     * */
    static void showComedyFilmList(){
        System.out.println(filmList);
    }
    /*
     * Metoda do wyświetlenie filmów z gatunku Horror
     * */
    static void showHorrorFilmList(){
        System.out.println(filmList);
    }

    /*
     * Metoda do wyswietlenia filmów dostępnych do wypożyczenia.
     * */
    static void showavailableFilmList() {
        System.out.println(filmList);
    }

    /*
    * Metoda do wyswietlenia filmów wypożyczonych.
    * */
    static void showRentFilmList() {
        System.out.println(filmList);
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", rezyser='" + rezyser + '\'' +
                ", rokWydania=" + rokWydania +
                ", gatunek=" + gatunek +
                ", dostepnosc=" + dostepnosc +
                '}';
    }
}

