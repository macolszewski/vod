package com.macolszewski.vod;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.ArrayList;
import java.util.List;

public class Film {
    @JsonView(Views.Normal.class)
    private String title;

    @JsonView(Views.Normal.class)
    private String rezyser;

    @JsonView(Views.Normal.class)
    private int rokWydania;

    @JsonView(Views.Normal.class)
    private GatunekFilmu gatunek;

    @JsonView(Views.Normal.class)
    private int quantity;

    @JsonView(Views.Normal.class)
    private List<Uzytkownik> movieRentiersList = new ArrayList<>();

    @JsonView(Views.Normal.class)
    private boolean isRented;

    @JsonView(Views.Normal.class)
    private boolean availability;

    public List<Uzytkownik> getMovieRentiersList() {
        return movieRentiersList;
    }

    static List<Film> filmList = new ArrayList<>();

    Film(){

    }

     Film(String title, String rezyser, int rok, GatunekFilmu gatunek, int quantity) {
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
            this.availability=false;
            System.out.println("Film niedostępny!");
        }
    }

    public void returnMovie(Uzytkownik user) {
        this.movieRentiersList.remove(user);
        ++this.quantity;
        this.availability=true;
        if (this.movieRentiersList.size() == 0) {
            this.setRented(false);
            this.availability=true;
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

    static void showRentedmovies (Uzytkownik user){
        int counter = 0;
        for (Film film : filmList) {
            if (film.getMovieRentiersList().contains(user)) {
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
                ", movieRentiersList=" + movieRentiersList +
                ", isRented=" + isRented +
                ", availability=" + availability +
                '}';
    }
}

