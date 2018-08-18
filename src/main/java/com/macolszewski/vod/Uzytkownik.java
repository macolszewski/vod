package com.macolszewski.vod;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.ArrayList;
import java.util.List;

public class Uzytkownik {
    @JsonView(Views.Normal.class)
    private String login;

    @JsonView(Views.Normal.class)
    private String haslo;

    @JsonView(Views.Normal.class)
    private Rola rola;

    static List<Uzytkownik> listaUzytkownikow = new ArrayList<>();

    static List<Uzytkownik> listaUzytkownikowZalogowanych = new ArrayList<>();

    static Uzytkownik zalogowany;

    Uzytkownik(){

    }

    /*public Uzytkownik() {
        System.out.println("Podaj login: ");
        this.login = Menu.input.nextLine();
        this.rola = Rola.UZYTKOWNIK;
        while (true) {
            System.out.println("Podaj hasło: ");
            String haslo1 = Menu.input.next();
            System.out.println("Powtórz hasło: ");
            String haslo2 = Menu.input.next();
            if (haslo1.equals(haslo2)) {
                this.haslo = haslo1;
                listaUzytkownikow.add(this);
                break;
            } else {
                System.out.println("Hasła się nie zgadzają.");
            }
        }
    }*/

    static void addUser () {
        System.out.println("Podaj login: ");
            String login = Menu.input.next();
            Rola rola = Rola.UZYTKOWNIK;
            for (Uzytkownik user : listaUzytkownikow) {
                if (user.getLogin().equals(login)) {
                    System.out.println("Login zajęty. Spróbuj z innym.");
                    addUser();
                    return;
                }
            }
            while (true) {
            System.out.println("Podaj hasło: ");
            String haslo1 = Menu.input.next();
            System.out.println("Powtórz hasło: ");
            String haslo2 = Menu.input.next();
            if (haslo1.equals(haslo2)) {
                String haslo = haslo1;
                new Uzytkownik(login, haslo, rola);
                System.out.println("==* Gratulacje! Utworzyłeś nowe konto w Vintage Heaven *==");
                break;
            }
            else {
                System.out.println("Hasła się nie zgadzają.");
            }
        }
    }

    static void adminAddUser () {
        System.out.println("Podaj login: ");
        String login = Menu.input.next();
        for (Uzytkownik user : listaUzytkownikow) {
            if (user.getLogin().equals(login)) {
                System.out.println("Login zajęty. Spróbuj z innym.");
                adminAddUser();
                return;
            }
        }
        while (true) {
            System.out.println("Podaj hasło: ");
            String haslo1 = Menu.input.next();
            System.out.println("Powtórz hasło: ");
            String haslo2 = Menu.input.next();
            if (haslo1.equals(haslo2)) {
                String haslo = haslo1;
                System.out.println("Podaj rolę: ");
                Rola rola = Rola.valueOf(Menu.input.next());
                new Uzytkownik(login, haslo, rola);
                System.out.println("Utworzyłeś nowego " + rola+"A");
                System.out.println(listaUzytkownikow);
                break;
            }
            else {
                System.out.println("Hasła się nie zgadzają.");
            }
        }
    }

    public Uzytkownik(String login, String haslo, Rola rola) {
        this.login = login;
        this.rola = rola;
        this.haslo = haslo;
        listaUzytkownikow.add(this);
    }

    public Rola getRola() {
        return rola;
    }

    static void logowanie() {
        System.out.println("** LOGOWANIE **");

        System.out.print("Podaj nazwę użytkownika: ");
        String login = Menu.input.next();
        System.out.print("Podaj hasło: ");
        String haslo = Menu.input.next();
        for (Uzytkownik user : listaUzytkownikow) {
            if (user.getLogin().equals(login)) {
                if (user.getHaslo().equals(haslo)) {
                    Uzytkownik.listaUzytkownikowZalogowanych.add(user);
                    Uzytkownik.zalogowany = user;
                    System.out.println(listaUzytkownikowZalogowanych);
                }
            }
        }
    }

    static void logoutAnyUser() {
        Uzytkownik.listaUzytkownikowZalogowanych.remove(Uzytkownik.zalogowany);
        System.out.println("Zostałeś wylogowany");
    }

    public String getLogin() {
        return login;
    }

    private String getHaslo() {
        return haslo;
    }

    @Override
    public String toString() {
        return "Uzytkownik{" +
                "login='" + login + '\'' +
                ", rola=" + rola +
                '}';
    }

}