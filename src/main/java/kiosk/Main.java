package kiosk;

import kiosk.menu.BurgersMenu;
import kiosk.menu.DessertsMenu;
import kiosk.menu.DrinksMenu;
import kiosk.menu.Menu;

public class Main {
    public static void main(String[] args){
        Kiosk kiosk = new Kiosk();

        kiosk.start();
    }
}
