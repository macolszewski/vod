package com.macolszewski.vod;

import java.util.ArrayList;
import java.util.List;

public class Uzytkownik {
    private String login;
    private String haslo;
    private Rola rola;
    static List<Uzytkownik> listaUzytkownikow = new ArrayList<>();
    static List<Uzytkownik> listaUzytkownikowZalogowanych = new ArrayList<>();
    static Uzytkownik zalogowany;

    public Uzytkownik() {
        System.out.println("Podaj login: ");
        this.login = Menu.input.nextLine();
        this.rola = Rola.UZYTKOWNIK;
        while (true) {
            System.out.println("Podaj hasło: ");
            String haslo1 = Menu.input.nextLine();
            System.out.println("Powtórz hasło: ");
            String haslo2 = Menu.input.nextLine();
            if (haslo1.equals(haslo2)) {
                this.haslo = haslo1;
                listaUzytkownikow.add(this);
                break;
            } else {
                System.out.println("Hasła się nie zgadzają.");
            }
        }
    }

    static void logowanie(String login, String haslo) {
        for (Uzytkownik user : listaUzytkownikow) {
            if (user.getLogin().equals(login)) {
                if (user.getHaslo().equals(haslo)){
                    listaUzytkownikowZalogowanych.add(user);
                    zalogowany=user;
                }
            }
        }

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
