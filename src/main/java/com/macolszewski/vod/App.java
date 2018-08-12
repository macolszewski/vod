package com.macolszewski.vod;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Uzytkownik Jarek = new Uzytkownik();
        System.out.println(Uzytkownik.listaUzytkownikow);
        Menu menu = new Menu();

        menu.showMainMenu();
    }
}
