package com.macolszewski.vod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Film {
    Scanner input = new Scanner(System.in);
    private String title;
    private String rezyser;
    private int rokWydania;
    private GatunekFilmu gatunek;
    private boolean dostepnosc = true;
    private int wyborGatunku;
    private String dodawanieFilmu;

    List<Film> allFilmList = new ArrayList<>();
    List<Film> dramaFilmList = new ArrayList<>();
    List<Film> comedyFilmList = new ArrayList<>();
    List<Film> horrorFilmList = new ArrayList<>();
    List<Film> availableFilmList = new ArrayList<>();
    List<Film> rentFilmList = new ArrayList<>();

    public Film() {
    }

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
    public void addFilm() {
        System.out.print("Podaj tytuł filmu: ");
        String title = input.next();
        System.out.print("Podaj imię i nazwisko reżysera: ");
        String rezyser = input.next();
        System.out.print("Podaj rok wydania filmu: ");
        int rokWydania = input.nextInt();
        System.out.println("Podaj gatunek filmu: ");
        System.out.println("1. Dramat");
        System.out.println("2. Komedia");
        System.out.println("3. Horror");
        while (true) {
            wyborGatunku = this.input.nextInt();
            GatunekFilmu gatunek = null;
            switch (wyborGatunku) {
                case 1:
                    gatunek = GatunekFilmu.DRAMAT;
                    break;
                case 2:
                    gatunek = GatunekFilmu.KOMEDIA;
                    break;
                case 3:
                    gatunek = GatunekFilmu.HORROR;
                    break;
                default:
                    System.out.println("Podaj ponownie gatunek filmu.");
            }
            System.out.println("Dodać film? [t]/[n]");
            String dodawanieFilmu = input.next();
            if (dodawanieFilmu.equals("t")) {
                allFilmList.add(new Film(title, rezyser, rokWydania, gatunek, true));
                if (wyborGatunku == 1){
                    dramaFilmList.add(new Film(title, rezyser, rokWydania, gatunek, true));
                } else if (wyborGatunku == 2) {
                    comedyFilmList.add(new Film(title, rezyser, rokWydania, gatunek, true));
                } else if (wyborGatunku == 3) {
                    horrorFilmList.add(new Film(title, rezyser, rokWydania, gatunek, true));
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }
    /**
     * Metoda do wyświetlenia wszystkich filmów.
     * */
    public void showAllFilmList() {
        System.out.println(allFilmList);
    }

    /*
    * Metoda do wyświetlenie filmów z gatunku Drama
    * */
    public void showDramaFilmList(){
        System.out.println(dramaFilmList);
    }

    /*
     * Metoda do wyświetlenie filmów z gatunku Comedy
     * */
    public void showComedyFilmList(){
        System.out.println(comedyFilmList);
    }
    /*
     * Metoda do wyświetlenie filmów z gatunku Horror
     * */
    public void showHorrorFilmList(){
        System.out.println(horrorFilmList);
    }

    /*
     * Metoda do wyswietlenia filmów dostępnych do wypożyczenia.
     * */
    public void showavailableFilmList() {
        System.out.println(availableFilmList);
    }

    /*
    * Metoda do wyswietlenia filmów wypożyczonych.
    * */
    public void showRentFilmList() {
        System.out.println(rentFilmList);
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

//    public Film dodajFilm(){
//        TODO: Tu będzie metoda do dodawania filmów,gdz
//        return new Film();
//    }
    }

