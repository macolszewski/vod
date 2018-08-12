package com.macolszewski.vod;

import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);

    public void login(){
        System.out.println("Podaj nazwę użytkownika");
        String login = input.nextLine();
        System.out.println("Podaj hasło");
        String pass = input.nextLine();
        //metoda logowanie (login, pass)
        //metoda wyszukuje po loginie, sprawdza hasło i sprawdza poziom uprawnień
    }





    public void showMainMenu() {
        int handler = 1;
        while (handler == 1) {

            System.out.println("MENU");
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

    public void cennik() {

    }

    public void metodaListaFilmow() {
        int handler=1;
        while (handler==1) {
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
                    handler=0;
                    break;


            }
        }
    }

    public void wyswietlFilmy(){
        System.out.println("1. Wyświel wszystkie filmy.");
//        for po enumach


    }

    public void wyswietlHistorie(){

    }

}
