package com.macolszewski.vod;

import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);


    public void showMainMenu() {
        int handler = 1;
        while (handler == 1) {


            System.out.println("** WYPOŻYCZALNIA FILMÓW - Jeah ZUS");
            System.out.println("1. Lista filmów");
            System.out.println("2. Zaloguj");
            System.out.println("3. Utwórz konto");
            System.out.println("4. Wyjdź");
            int choice = Menu.input.nextInt();

            switch (choice) {
                case 1:
                    break;
                case 2:
                    Uzytkownik.logowanie();
                    handler=0;
                    break;
                case 3:
                    Uzytkownik nowyUzytkownik = new Uzytkownik();
                    break;
                case 4:
                    handler=0;
                    break;
            }
        }
    }

    public void menuAdministratora(){
        System.out.println("MENU Administratora");
        System.out.println("1. Lista użytkowników");
        System.out.println("2. ...");
        int adminChoice = input.nextInt();

        switch (adminChoice){
            case 1:
                System.out.println(Uzytkownik.listaUzytkownikow);
                break;
            case 2:
                break;
        }
    }

//    public void login() {
//        System.out.println("** LOGOWANIE **");
//        System.out.print("Podaj nazwę użytkownika: ");
//        String login = input.nextLine();
//        System.out.print("Podaj hasło: ");
//        String pass = input.nextLine();
//        Uzytkownik.logowanie(login, pass);
//        //metoda wyszukuje po loginie, sprawdza hasło i sprawdza poziom uprawnień
//    }


    public void showLoggedMenu() {
        if (Uzytkownik.listaUzytkownikowZalogowanych.contains(Uzytkownik.zalogowany)) {
            if (Uzytkownik.zalogowany.getRola().equals(Rola.ADMINISTRATOR)){
                menuAdministratora();
            }

            int handler = 1;
            while (handler == 1) {

                System.out.println("**MENU**");
                System.out.println("1. Lista filmów");
                System.out.println("2. Cennik");
                System.out.println("3. Historia wypożyczeń");
                System.out.println("4. Wypożycz film");
                System.out.println("5. Administrator");
                System.out.println("6. Wyjdź");

                int choice = input.nextInt();

                switch (choice) {
                    case 1:
//                metodaListaFilmow();
                        break;
                    case 2:
                        cennik();
                        break;
                    case 3:
//                    metodaHistoria();
                        break;
                    case 4:
//                    metodaWypożyczFilm();
                        break;
                    case 5:

                    case 6:
                        handler = 0;
                        input.close();
                        System.out.println("Do widzenia...");
                        break;
                }
            }

        }
    }

    public void cennik() {

    }

    public void metodaListaFilmow() {
        int handler = 1;
        while (handler == 1) {
            System.out.println("1. Wyświetl filmy");
            System.out.println("2. Wyszukaj film");
            System.out.println("3. Wyjdź");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
//                filmWszysktie():
                    break;
                case 2:
                    System.out.println("Podaj tytuł: ");
                    String title = input.next();
//                filmWyszukaj(title);
                    break;
                case 3:
                    handler = 0;
                    break;


            }
        }
    }

    public void wyswietlFilmy() {
        System.out.println("1. Wyświel wszystkie filmy.");
//        for po enumach


    }

    public void wyswietlHistorie() {

    }

}
