package com.macolszewski.vod;

import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);
    Film film = new Film();

    /**
     * Metoda, która sprawdza, czy użytkownik jest zalogowany i jakie ma uprawnienia, żeby wiedzieć,
     * które menu ma wyświetlić.
      */
    public void menuValidator() {
        if (Uzytkownik.listaUzytkownikowZalogowanych.contains(Uzytkownik.zalogowany)) {
            if (Uzytkownik.zalogowany.getRola().equals(Rola.ADMINISTRATOR)) {
                adminMenu();
                adminMenuNav();
            } else {
                userMenu();
                userMenuNav();
            }
        } else {
            mainMenu();
            mainMenuNav();
        }
    }

    /**
     * Główne menu, które jest wyświetlane niezalogowanym użytkownikom.
     */
    public void mainMenu() {
        System.out.println("========================** WYPOŻYCZALNIA FILMÓW - Vintage Heaven **=========================");
        System.out.println("1. Lista filmów");
        System.out.println("2. Zaloguj");
        System.out.println("3. Utwórz konto");
        System.out.println("4. Wyjdź");
        System.out.println("============================================================================================");
    }

    /**
     * Metoda, która odpowiada za nawigację w menu.
     */
    public void mainMenuNav() {
        int mainMenuChoice = 0;

        while (mainMenuChoice != 4) {
            mainMenuChoice = input.nextInt();
            switch (mainMenuChoice) {
                case 1:
                    filmListMenu();
                    filmListMenuNav();
                    break;
                case 2:
                    Uzytkownik.logowanie();
                    menuValidator();
                    break;
                case 3:
                    Uzytkownik.addUser();
                    menuValidator();
                    break;
                case 4:
                    System.out.println("Do widzenia. Zapraszamy ponownie.");
                    break;
            }
        }
    }

    /**
     * Metoda, która wyświetla menu wyboru listy filmów do wyświetlenia.
     */
    public void filmListMenu() {
        System.out.println("========================** WYPOŻYCZALNIA FILMÓW - Vintage Heaven **=========================");
        System.out.println("1. Wyświetl wszystkie filmy");
        System.out.println("2. Wyświetl dramaty");
        System.out.println("3. Wyświetl komedie");
        System.out.println("4. Wyświetl horrory");
        System.out.println("5. Wróć");
        System.out.println("============================================================================================");
    }

    /**
     * Metoda umożliwiająca nawigację w menu wyświetlania filmów.
     */
    public void filmListMenuNav() {
        int filmListMenuChoice = 0;
        while (filmListMenuChoice != 5) {
            filmListMenuChoice = input.nextInt();

            switch (filmListMenuChoice) {
                case 1:
                    System.out.println("Lista wszystkich filmów: ");
                    film.showAllFilmList();
                    break;
                case 2:
                    System.out.println("Lista filmów z gatunku Drama: ");
                    film.showDramaFilmList();
                    break;
                case 3:
                    System.out.println("Lista filmów z gatunku Komedia: ");
                    film.showComedyFilmList();
                    break;
                case 4:
                    System.out.println("Lista filmów z gatunku Horror: ");
                    film.showHorrorFilmList();
                    break;
                case 5:
                    menuValidator();
                    break;
            }
        }
    }

    /**
     * Metoda wyświetla menu użytkownika.
     */
    public void userMenu() {
        System.out.println("====================================|MENU Użytkownika|======================================");
        System.out.println("1. Lista filmów");
        System.out.println("2. Znajdź film");
        System.out.println("3. Wypożyczone filmy");
        System.out.println("4. Płatności i kary");
        System.out.println("5. Wyloguj");
        System.out.println("============================================================================================");
    }

    /**
     * Metoda umożliwiająca nawigację w menu użytkownika.
     */
    public void userMenuNav() {
        int userMenuChoice = 0;
        while (userMenuChoice != 5) {
            userMenuChoice = input.nextInt();

            switch (userMenuChoice) {
                case 1:
                    filmListMenu();
                    filmListMenuNav();
                    break;
                case 2:
                    filmSearch();
                    filmSearchNav();
                    break;
                case 3:
//                  TODO: Metoda, która będzie wyświetlała wszystkie filmy, które zalogowany użytkownik kiedykolwiek wypożyczył.
//                  TODO: Najlepiej, żeby motoda wyświetlała najpierw wypożyczone aktualnie (nieoddane) filmy, a później filmy wypożyczone i oddane.
                    System.out.println("Tu będzie się pokazywała lista wypożyczonych filmów.");
                    userMenu();
                    break;
                case 4:
//                  TODO: Metoda, która będzie wyświetlała kwotę do zapłacenia za aktualnie wypożyczone filmy oraz ewentualne kary.
                    System.out.println("Tu będzie się wyświetlała kwota do zapłacenia z podziałem na wypożyczone filmy i kary.");
                    userMenu();
                    break;
                case 5:
                    Uzytkownik.logoutAnyUser();
                    menuValidator();
                    break;
            }
        }
    }

    /**
     * Metoda pokazująca wybór w menu wyszukiwania filmów.
     */
    public void filmSearch() {
        System.out.println("====================================|MENU Użytkownika|======================================");
        System.out.println("1. Wyszukaj po tytule");
        System.out.println("2. Wyszukaj po reżyserze");
        System.out.println("3. Wyszukaj po gatunku");
        System.out.println("4. Pokaż wszystkie dostępne filmy");
        System.out.println("5. Wróć");
        System.out.println("============================================================================================");
    }

    /**
     * Metoda odpowiadająca za nawigację w wyszukiwarce filmów.
     */
    public void filmSearchNav() {
        int filmSearchNav = 0;
        while (filmSearchNav != 5) {
            filmSearchNav = input.nextInt();
            switch (filmSearchNav) {
                case 1:
                    System.out.println("Metoda wyszukiwania po tytule"); // TODO: Stworzyć metodę wyszukiwania filmów po tytule.
                    filmSearch();
                    break;
                case 2:
                    System.out.println("Metoda wyszukiwania po reżyserze"); // TODO: Stworzyć metodę wyszukiwania filmów po reżyserze.
                    filmSearch();
                    break;
                case 3:
                    System.out.println("Metoda wyszukiwania po gatunku"); // TODO: Stworzyć metodę wyszukiwania filmów po gatunku.
                    filmSearch();
                    break;
                case 4:
                    System.out.println("Metoda wyświetlania tylko dostępnych filmów"); //TODO: Stworzyć metodę wyświetlania tylko dostępnych filmów.
                    filmSearch();
                    break;
                case 5:
                    menuValidator();
                    break;
            }
        }
    }

    /**
     * Metoda wyświetlająca menu administratora.
     */
    private void adminMenu() {
        System.out.println("===================================|MENU Administratora|====================================");
        System.out.println("1. Lista użytkowników");
        System.out.println("2. Lista filmów");
        System.out.println("3. Dodaj...");
        System.out.println("4. Zaległości");
        System.out.println("5. Przychody");
        System.out.println("6. Wyloguj");
        System.out.println("============================================================================================");
    }

    /**
     * Metoda nawigacji w menu administratora.
     */
    public void adminMenuNav() {
        int adminMenuChoice = 0;
        while (adminMenuChoice != 6) {
            adminMenuChoice = input.nextInt();
            switch (adminMenuChoice) {
                case 1:
                    System.out.println(Uzytkownik.listaUzytkownikow);
                    adminMenu();
                    break;
                case 2:
                    filmListMenu();
                    filmListMenuNav();
                    break;
                case 3:
                    addMenu();
                    addMenuNav();
                    break;
                case 4:
                    arrearsMenu();
                    arrearsMenuNav();
                    break;
                case 5:
                    System.out.println("Metoda wyświetlająca kwoty przychodów."); // TODO: Stworzyć metodę wyświetlania przychodów.
                    adminMenu();
                    break;
                case 6:
                    Uzytkownik.logoutAnyUser();
                    menuValidator();
                    break;
            }
        }
    }

    /**
     * Metoda wyświetlająca menu wyboru podczas dodawania użytkowników lub filmów.
     */
    private void addMenu() {
        System.out.println("===================================|MENU Administratora|====================================");
        System.out.println("1. Dodaj użytkownika");
        System.out.println("2. Dodaj film");
        System.out.println("3. Wróć");
        System.out.println("============================================================================================");
    }

    /**
     * Metoda służąca do nawigacji w menu dodawania użytkowników lub filmów.
     */
    private void addMenuNav() {
        int addMenuChoice = 0;
        while (addMenuChoice != 3){
            addMenuChoice = input.nextInt();
            switch (addMenuChoice){
                case 1:
                    Uzytkownik.adminAddUser();
                    break;
                case 2:
                    System.out.println("Metoda dodawania nowego filmu"); // TODO: Stworzyć metodę dodawania nowego filmu.
                    film.addFilm();
                    break;
                case 3:
                    menuValidator();
                    break;
            }
        }
    }


    /**
     * Metoda wyświetlająca dłużnikow, lub zalegających z oddaniem filmów.
     */
    private void arrearsMenu() {
        System.out.println("===================================|MENU Administratora|====================================");
        System.out.println("1. Pokaż dłużników");
        System.out.println("2. Pokaż użytkowników, którzy nie oddali filmu");
        System.out.println("3. Wróć");
        System.out.println("============================================================================================");
    }


    /**
     * Metoda nawigacji w menu dłużników
     */
    private void arrearsMenuNav() {
        int arrearsMenuChoice = 0;
        while (arrearsMenuChoice !=3){
            arrearsMenuChoice = input.nextInt();
            switch (arrearsMenuChoice){
                case 1:
                    System.out.println("Metoda wyświetlająca dłużników finansowych"); // TODO: Stworzyć metodę wyświetlania dłużników finansowych.
                    arrearsMenu();
                    break;
                case 2:
                    System.out.println("Metoda wyświetlająca klientów, którzy zalegają ze zwrotem filmów"); // TODO: Stworzyć metodę wyświetlania klientów, którzy nie oddali filmu
                    arrearsMenu();
                    break;
                case 3:
                    menuValidator();
                    break;
            }
        }
    }
}