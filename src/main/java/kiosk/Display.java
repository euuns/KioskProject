package kiosk;

import kiosk.menu.BurgersMenu;
import kiosk.menu.DessertsMenu;
import kiosk.menu.DrinksMenu;
import kiosk.menu.Menu;

import java.util.*;

public class Display {

    Menu burger = new BurgersMenu();
    Menu drink = new DrinksMenu();
    Menu dessert = new DessertsMenu();

    Menu menu;
    List<String> menus = new ArrayList<>();


    // 화면에 출력될 메뉴 내용 저장
    public Display() {
        menus.add("Burgers");
        menus.add("Drinks");
        menus.add("Desserts");
    }


    // flag를 이용해 인스턴스 되었는지 확인, 만약 인스턴스 되었으면
    public void setMenu(int input) {
        if (input == 1) {
            menu = burger;
        } else if (input == 2){
            menu = drink;
        } else if (input == 3) {
            menu = dessert;
        }
    }

    public Menu getMenu() {
        return menu;
    }

    public int getSize() {
        return menus.size();
    }


    public Map<Integer, String> printMainMenu() {
        Map<Integer, String> input = new HashMap<>();

        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i));
            input.put(i + 1, menus.get(i));
        }
        System.out.println("0. 종료");

        return input;
    }
}
