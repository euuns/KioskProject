package kiosk;

import kiosk.menu.BurgersMenu;
import kiosk.menu.DessertsMenu;
import kiosk.menu.DrinksMenu;
import kiosk.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class Display {

    List<Menu> menus = new ArrayList<>();

    public Display(){
        menus.add(new BurgersMenu());
        menus.add(new DrinksMenu());
        menus.add(new DessertsMenu());
    }

    public Menu getMenu(int idx){
        return menus.get(idx);
    }

    public void printMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            String temp = menus.get(i).getClass().getSimpleName();
            System.out.println((i + 1) + ". " +temp.substring(0, temp.length()-4));
        }
    }

}
