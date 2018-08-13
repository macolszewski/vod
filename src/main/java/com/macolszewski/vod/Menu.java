package com.macolszewski.vod;

import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);

    /**
     * Metoda, która sprawdza, czy użytkownik jest zalogowany i jakie ma uprawnienia, żeby wiedzieć,
     * które menu ma wyświetlić.
      */
    public void menuValidator() {
        if (Uzytkownik.listaUzytkownikowZalogowanych.contains(Uzytkownik.zalogowany)) {
            if (Uzytkownik.zalogowany.getRola().equals(Rola.ADMINISTRATOR)) {
                adminMenu();
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
        System.out.println("============================================================================================");
        System.out.println("** WYPOŻYCZALNIA FILMÓW - Vintage Heaven");
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
                    break;
                case 3:
                    Uzytkownik nowyUzytkownik = new Uzytkownik();
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
        System.out.println("============================================================================================");
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
                    System.out.println("Tu będą wyświetlały się wszystkie filmy.");
                    filmListMenu();
                    break;
                case 2:
                    System.out.println("Tu będą wyświetlały się dramaty.");
                    filmListMenu();
                    break;
                case 3:
                    System.out.println("Tu będą wyświetlały się komedie.");
                    filmListMenu();
                    break;
                case 4:
                    System.out.println("Tu będą wyświetlały się horrory.");
                    filmListMenu();
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
                    break;
                case 4:
//                  TODO: Metoda, która będzie wyświetlała kwotę do zapłacenia za aktualnie wypożyczone filmy oraz ewentualne kary.
                    System.out.println("Tu będzie się wyświetlała kwota do zapłacenia z podziałem na wypożyczone filmy i kary.");
                    break;
                case 5:
//                  TODO: Dodać metodę do wylogowywania.
                    System.out.println("Tu będzie się wylogowywał");
                    menuValidator();
                    break;
            }
        }
    }

    /**
     * Metoda pokazująca wybór w menu wyszukiwania filmów.
     */
    public void filmSearch() {
        System.out.println("============================================================================================");
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
        while (filmSearchNav != 6) {
            filmSearchNav = input.nextInt();
            switch (filmSearchNav) {
                case 1:
                    System.out.println("Metoda wyszukiwania po tytule");
                    break;
                case 3:
                    System.out.println("Metoda wyszukiwania po reżyserze");
                    break;
                case 4:
                    System.out.println("Metoda wyszukiwania po gatunku");
                    break;
                case 5:
                    System.out.println("Metoda wyświetlania tylko dostępnych filmów");
                    break;
                case 6:
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
    public void adminMenuNav(){
        int adminMenuChoice = 0;
        while (adminMenuChoice != 6){
            adminMenuChoice = input.nextInt();
            switch (adminMenuChoice){
                case 1:
                    System.out.println("Wyświetla wszystkich użytkowników");
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
                    incomeMenu();
                    incomeMenuNav();
                    break;
                case 6:
                    menuValidator();
                    break;
            }
        }


        int adminChoice = input.nextInt();

        switch (adminChoice) {
            case 1:
                System.out.println(Uzytkownik.listaUzytkownikow);
                break;
            case 2:
                break;
        }
    }

//
//    public void showLoggedMenu() {
//        if (Uzytkownik.listaUzytkownikowZalogowanych.contains(Uzytkownik.zalogowany)) {
//            if (Uzytkownik.zalogowany.getRola().equals(Rola.ADMINISTRATOR)) {
//                adminMenu();
//            }
//
//            int handler = 1;
//            while (handler == 1) {
//
//                System.out.println("**MENU**");
//                System.out.println("1. Lista filmów");
//                System.out.println("2. Cennik");
//                System.out.println("3. Historia wypożyczeń");
//                System.out.println("4. Wypożycz film");
//                System.out.println("5. Administrator");
//                System.out.println("6. Wyjdź");
//
//                int choice = input.nextInt();
//
//                switch (choice) {
//                    case 1:
////                metodaListaFilmow();
//                        break;
//                    case 2:
//
//                        break;
//                    case 3:
////                    metodaHistoria();
//                        break;
//                    case 4:
////                    metodaWypożyczFilm();
//                        break;
//                    case 5:
//
//                    case 6:
//                        handler = 0;
//                        input.close();
//                        System.out.println("Do widzenia...");
//                        break;
//                }
//            }
//
//        }
//    }
//
//
//    public void cennik() {
//
//    }
//
//    public void metodaListaFilmow() {
//        int handler = 1;
//        while (handler == 1) {
//            System.out.println("1. Wyświetl filmy");
//            System.out.println("2. Wyszukaj film");
//            System.out.println("3. Wyjdź");
//            int choice = input.nextInt();
//
//            switch (choice) {
//                case 1:
////                filmWszysktie():
//                    break;
//                case 2:
//                    System.out.println("Podaj tytuł: ");
//                    String title = input.next();
////                filmWyszukaj(title);
//                    break;
//                case 3:
//                    handler = 0;
//                    break;
//
//
//            }
//        }
//    }
//
//    public void wyswietlFilmy() {
//        System.out.println("1. Wyświel wszystkie filmy.");
////        for po enumach
//
//
//    }
//
//    public void wyswietlHistorie() {
//
//    }

}

