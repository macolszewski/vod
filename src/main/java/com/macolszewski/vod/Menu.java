package com.macolszewski.vod;

import java.util.Scanner;

public class Menu {
    static int appHandler = 0;
    static Scanner input = new Scanner(System.in);

    /**
     * Metoda, która sprawdza, czy użytkownik jest zalogowany i jakie ma uprawnienia, żeby wiedzieć,
     * które menu ma wyświetlić.
     */
    public static void menuValidator() {

        while (Menu.appHandler != 5) {

            if (Uzytkownik.listaUzytkownikowZalogowanych.contains(Uzytkownik.zalogowany)) {
                if (Uzytkownik.zalogowany.getRola().equals(Rola.ADMINISTRATOR)) {
                    adminMenuNav();
                } else {
                    userMenuNav();
                }
            } else {
                mainMenuNav();
            }
        }
    }

    /**
     * Główne menu, które jest wyświetlane niezalogowanym użytkownikom.
     */
    public static void mainMenu() {
        System.out.println("========================** WYPOŻYCZALNIA FILMÓW - Vintage Heaven **=========================");
        System.out.println("1. Filmy");
        System.out.println("2. Zaloguj");
        System.out.println("3. Utwórz konto");
        System.out.println("4. Wyjdź");
        System.out.println("============================================================================================");
    }

    /**
     * Metoda, która odpowiada za nawigację w menu.
     */
    public static void mainMenuNav() {
        int mainMenuChoice = 0;

        while (mainMenuChoice != 4) {
            mainMenu();
            mainMenuChoice = input.nextInt();
            switch (mainMenuChoice) {
                case 1:
                    filmListMenuNav();
                    break;
                case 2:
                    Uzytkownik.logowanie();
                    mainMenuChoice=4;
                    break;
                case 3:
                    Uzytkownik.addUser();
                    break;
                case 4:
                    System.out.println("Do widzenia. Zapraszamy ponownie.");
                    Menu.appHandler = 5;
//                    System.gc();
//                    System.exit(0);
                    break;
            }
        }
    }

    /**
     * Metoda, która wyświetla menu wyboru listy filmów do wyświetlenia.
     */
    public static void filmListMenu() {
        System.out.println("========================** WYPOŻYCZALNIA FILMÓW - Vintage Heaven **=========================");
        System.out.println("1. Wyświetl wszystkie filmy");
        System.out.println("2. Wyświetl po wybranym gatunku");
        System.out.println("3. Wróć");
        System.out.println("============================================================================================");
    }

    /**
     * Metoda umożliwiająca nawigację w menu wyświetlania filmów.
     */
    public static void filmListMenuNav() {
        int filmListMenuChoice = 0;
        while (filmListMenuChoice != 3) {
            filmListMenu();
            filmListMenuChoice = input.nextInt();

            switch (filmListMenuChoice) {
                case 1:
                    System.out.println("Lista wszystkich filmów: ");
                    Film.showAllFilmList();
                    break;
                case 2:
                    System.out.println("Lista filmów z wybranego gatunku: ");
                    Film.showMoviesGenereList();
                    break;
                case 3:
                    
                    break;
            }
        }
    }

    /**
     * Metoda wyświetla menu użytkownika.
     */
    public static void userMenu() {
        System.out.println("====================================|MENU Użytkownika|======================================");
        System.out.println("1. Filmy");
        System.out.println("2. Znajdź film");
        System.out.println("3. Wypożycz filmy");
        System.out.println("4. Wypożyczone filmy");
        System.out.println("5. Płatności i kary");
        System.out.println("6. Wyloguj");
        System.out.println("============================================================================================");
    }

    /**
     * Metoda umożliwiająca nawigację w menu użytkownika.
     */
    public static void userMenuNav() {
        int userMenuChoice = 0;
        while (userMenuChoice != 6) {
            userMenu();
            userMenuChoice = input.nextInt();

            switch (userMenuChoice) {
                case 1:
                    filmListMenuNav();
                    break;
                case 2:
                    filmSearchNav(); // Metoda wyszukiwania filmów.
                    break;
                case 3:
                    System.out.println("Metoda do wypożyczania filmów.");
                    Film.showavailableFilmList();
                    System.out.println("Podaj ID filmu: ");
                    int id = Menu.input.nextInt();
                    Film.filmList.get(id).rentMovie(Uzytkownik.zalogowany);
                    break;
                case 4:
//                  TODO: Metoda, która będzie wyświetlała wszystkie filmy, które zalogowany użytkownik kiedykolwiek wypożyczył.
//                  TODO: Najlepiej, żeby motoda wyświetlała najpierw wypożyczone aktualnie (nieoddane) filmy, a później filmy wypożyczone i oddane.
                    System.out.println("Tu będzie się pokazywała lista wypożyczonych filmów.");
                    break;
                case 5:
//                  TODO: Metoda, która będzie wyświetlała kwotę do zapłacenia za aktualnie wypożyczone filmy oraz ewentualne kary.
                    System.out.println("Tu będzie się wyświetlała kwota do zapłacenia z podziałem na wypożyczone filmy i kary.");
                    break;
                case 6:
                    Uzytkownik.logoutAnyUser();
                    
                    break;
            }
        }
    }

    /**
     * Metoda pokazująca wybór w menu wyszukiwania filmów.
     */
    public static void filmSearch() {
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
    public static void filmSearchNav() {
        int filmSearchNav = 0;
        while (filmSearchNav != 5) {
            filmListMenuNav();
            filmSearch();
            filmSearchNav = input.nextInt();
            switch (filmSearchNav) {
                case 1:
                    System.out.println("Metoda wyszukiwania po tytule"); // TODO: Stworzyć metodę wyszukiwania filmów po tytule.
                    break;
                case 2:
                    System.out.println("Metoda wyszukiwania po reżyserze"); // TODO: Stworzyć metodę wyszukiwania filmów po reżyserze.
                    break;
                case 3:
                    System.out.println("Metoda wyszukiwania po gatunku"); // TODO: Stworzyć metodę wyszukiwania filmów po gatunku.
                    break;
                case 4:
                    System.out.println("Metoda wyświetlania tylko dostępnych filmów"); //TODO: Stworzyć metodę wyświetlania tylko dostępnych filmów.
                    break;
                case 5:
                    
                    break;
            }
        }
    }

    /**
     * Metoda wyświetlająca menu administratora.
     */
    private static void adminMenu() {
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
    public static void adminMenuNav() {
        int adminMenuChoice = 0;
        while (adminMenuChoice != 6) {
            adminMenu();
            adminMenuChoice = input.nextInt();
            switch (adminMenuChoice) {
                case 1:
                    System.out.println(Uzytkownik.listaUzytkownikow);
                    break;
                case 2:
                    filmListMenuNav();
                    break;
                case 3:
                    addMenuNav();
                    break;
                case 4:
                    arrearsMenuNav();
                    break;
                case 5:
                    System.out.println("Metoda wyświetlająca kwoty przychodów."); // TODO: Stworzyć metodę wyświetlania przychodów.
                    break;
                case 6:
                    Uzytkownik.logoutAnyUser();
                    break;
            }
        }
    }

    /**
     * Metoda wyświetlająca menu wyboru podczas dodawania użytkowników lub filmów.
     */
    private static void addMenu() {
        System.out.println("===================================|MENU Administratora|====================================");
        System.out.println("1. Dodaj użytkownika");
        System.out.println("2. Dodaj film");
        System.out.println("3. Wróć");
        System.out.println("============================================================================================");
    }

    /**
     * Metoda służąca do nawigacji w menu dodawania użytkowników lub filmów.
     */
    private static void addMenuNav() {
        int addMenuChoice = 0;
        while (addMenuChoice != 3) {
            addMenu();
            addMenuChoice = input.nextInt();
            switch (addMenuChoice) {
                case 1:
                    Uzytkownik.adminAddUser();
                    break;
                case 2:
                    System.out.println("Metoda dodawania nowego filmu"); // TODO: Stworzyć metodę dodawania nowego filmu.
                    Film.addFilm();
                    break;
                case 3:
                    
                    break;
            }
        }
    }


    /**
     * Metoda wyświetlająca dłużnikow, lub zalegających z oddaniem filmów.
     */
    private static void arrearsMenu() {
        System.out.println("===================================|MENU Administratora|====================================");
        System.out.println("1. Pokaż dłużników");
        System.out.println("2. Pokaż użytkowników, którzy nie oddali filmu");
        System.out.println("3. Wróć");
        System.out.println("============================================================================================");
    }


    /**
     * Metoda nawigacji w menu dłużników
     */
    private static void arrearsMenuNav() {
        int arrearsMenuChoice = 0;
        while (arrearsMenuChoice != 3) {
            arrearsMenu();
            arrearsMenuChoice = input.nextInt();
            switch (arrearsMenuChoice) {
                case 1:
                    System.out.println("Metoda wyświetlająca dłużników finansowych"); // TODO: Stworzyć metodę wyświetlania dłużników finansowych.
                    break;
                case 2:
                    System.out.println("Metoda wyświetlająca klientów, którzy zalegają ze zwrotem filmów"); // TODO: Stworzyć metodę wyświetlania klientów, którzy nie oddali filmu
                    break;
                case 3:
                    
                    break;
            }
        }
    }
}