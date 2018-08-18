package com.macolszewski.vod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Film {
    private String title;
    private String rezyser;
    private int rokWydania;
    private GatunekFilmu gatunek;
    private int quantity;
    private List<Uzytkownik> movieRentiersList = new ArrayList<>();
    private boolean isRented;

    public List<Uzytkownik> getMovieRentiersList() {
        return movieRentiersList;
    }

    static List<Film> filmList = new ArrayList<>();

    public Film(String title, String rezyser, int rok, GatunekFilmu gatunek, int quantity) {
        this.title = title;
        this.rezyser = rezyser;
        this.rokWydania = rok;
        this.gatunek = gatunek;
        this.quantity = quantity;
        Film.filmList.add(this);

    }

    //    Operator trójkowy:
    public boolean isAvailability() {
        return (this.quantity > 0) ? true : false;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }


    public void rentMovie(Uzytkownik user) {
        if (this.isAvailability()) {
            movieRentiersList.add(user);
            this.setRented(true);
            --this.quantity;
        } else {
            System.out.println("Film niedostępny!");
        }
    }

    public void returnMovie(Uzytkownik user) {
        this.movieRentiersList.remove(user);
        ++this.quantity;
        if (this.movieRentiersList.size() == 0) {
            this.setRented(false);
        }
    }

    /**
     * Metoda dodająca film do listy filmów.
     */
    public static void addFilm() {
        System.out.print("Podaj tytuł filmu: ");
        String title = Menu.input.next();
        System.out.print("Podaj imię i nazwisko reżysera: ");
        String rezyser = Menu.input.next();
        System.out.print("Podaj rok wydania filmu: ");
        int rokWydania = Menu.input.nextInt();
        System.out.print("Podaj liczbę sztuk: ");
        int quantity = Menu.input.nextInt();
        System.out.println("Podaj gatunek filmu: ");
        int addFilmType = 0;

        while (true) {
            System.out.println("Wybierz gatunek filmu:");
            for (int i = 0; i < GatunekFilmu.values().length; i++) {
                System.out.println("\t" + (i + 1) + ". " + GatunekFilmu.values()[i]);
            }
            addFilmType = Menu.input.nextInt();
            GatunekFilmu gatunek = GatunekFilmu.values()[addFilmType - 1];

            Film x = new Film(title, rezyser, rokWydania, gatunek, quantity);
            addNextFilm();
            break;
        }
    }


    /*
     * Metoda pytająca "czy chcesz dodać następny film?"*/
    public static void addNextFilm() {
        System.out.println("Chcesz dodać następny film? ");
        System.out.println("1. Tak");
        System.out.println("2. Nie");
        int addNextFilm = 0;
        while (addNextFilm != 2) {
            addNextFilm = Menu.input.nextInt();
            switch (addNextFilm) {
                case 1:
                    addFilm();
                    break;
            }
        }
    }

    /**
     * Metoda do wyświetlenia wszystkich filmów.
     */
    static void showAllFilmList() {
        int counter = 0;
        for (Film film : filmList) {
            System.out.println("\t" + (++counter) + ". " + film);
        }
    }

    public GatunekFilmu getGatunek() {
        return gatunek;
    }

    /*
     * Metoda do wyświetlenie filmów po wybranym gatunku.
     * */
    static void showMoviesGenereList() {
        System.out.println("Wybierz gatunek filmu:");
        for (int i = 0; i < GatunekFilmu.values().length; i++) {
            System.out.println("\t" + (i + 1) + ". " + GatunekFilmu.values()[i]);
        }
        int genereNumber = Menu.input.nextInt();
        GatunekFilmu gatunek = GatunekFilmu.values()[genereNumber - 1];
        int counter = 0;
        System.out.println("Lista filmów z gatunku - " + gatunek + ":");
        for (Film film : filmList) {
            if (film.getGatunek().equals(gatunek)) {
                System.out.println("\t" + (++counter) + ". " + film);
            }
        }
    }


    /*
     * Metoda do wyswietlenia filmów dostępnych do wypożyczenia.
     * */
    static void showavailableFilmList() {
        int counter = 0;
        for (Film film : filmList) {
            if (film.isAvailability()) {
                System.out.println("\t" + (++counter) + ". " + " ID: " + Film.filmList.indexOf(film) + " ->" + film);
            }
        }
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
                ", quantity=" + quantity +
                ", isRented=" + isRented +
                ", dostępność="+this.isAvailability() +
                '}';
    }
}

