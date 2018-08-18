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
        Uzytkownik user = new Uzytkownik("user1", "user1", Rola.UZYTKOWNIK);
        Uzytkownik user2 = new Uzytkownik("user2", "user2", Rola.UZYTKOWNIK);
        Uzytkownik user3 = new Uzytkownik("user3", "user3", Rola.UZYTKOWNIK);
        Uzytkownik user4 = new Uzytkownik("user4", "user4", Rola.UZYTKOWNIK);
        Uzytkownik user5 = new Uzytkownik("user5", "user5", Rola.UZYTKOWNIK);
        Uzytkownik user6 = new Uzytkownik("user6", "user6", Rola.UZYTKOWNIK);
        Film film1 = new Film("Film","Wajda", 2018, GatunekFilmu.DRAMAT,5);
        Film film2 = new Film("Film","Wajda", 2018, GatunekFilmu.HORROR,5);
        Film film3 = new Film("Film","Wajda", 2018, GatunekFilmu.KOMEDIA,5);
        Film film4 = new Film("Film","Wajda", 2018, GatunekFilmu.DRAMAT,4);
        Film film5 = new Film("Film","Wajda", 2018, GatunekFilmu.KOMEDIA,3);


//        System.out.println(Uzytkownik.listaUzytkownikow);

        Menu menu = new Menu();
        menu.mainMenu();
        menu.mainMenuNav();

//        menu.showLoggedMenu();


    }
}
