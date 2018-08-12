package com.macolszewski.vod;

import java.sql.SQLOutput;

public class Uzytkownik {
    private String login;
    private String haslo;
    private Rola rola;

    public Uzytkownik() {
        System.out.println("Podaj login: ");
        this.login = Menu.input.nextLine();
        this.rola = Rola.UZYTKOWNIK;
        while(true) {
            System.out.println("Podaj hasło: ");
            String haslo1 = Menu.input.nextLine();
            System.out.println("Powtórz hasło: ");
            String haslo2 = Menu.input.nextLine();
            if (haslo1.equals(haslo2)) {
                this.haslo = haslo1;
                break;
            } else {
                System.out.println("Hasła się nie zgadzają.");
            }
        }

    }

    public
}
