package com.macolszewski.vod;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
////        Uzytkownik Jarek = new Uzytkownik();
        Uzytkownik admin = new Uzytkownik("admin", "admin", Rola.ADMINISTRATOR);
        Uzytkownik user = new Uzytkownik("user", "user", Rola.UZYTKOWNIK);
//        System.out.println(Uzytkownik.listaUzytkownikow);
        Menu menu = new Menu();
        menu.mainMenu();
        menu.mainMenuNav();
//        menu.showLoggedMenu();


    }
}
