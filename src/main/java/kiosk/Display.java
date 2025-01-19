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

    // BurgersMenu, DrinksMenu, DessertsMenu 객체가 담겨있는 menus
    List<Menu> menus = new ArrayList<>();

    // 입력 번호와 메뉴 순번을 미리 지정하기 위한 Map
    Map<Integer, String> menuNumber = new HashMap<>();


    // 화면에 출력될 메뉴 내용 저장
    public Display() throws InstantiationException, IllegalAccessException {
        menus.add(burger);
        menus.add(drink);
        menus.add(dessert);
    }


    // 번호 별로 이름이 저장된 menuNumber에서 입력된 값을 비교하여 Menu 지정
    // Map에서 입력된 input을 key로 하여 그 Value 가져오기
    // key로 가져온 value는 메뉴 이름(getCategoryName())
    // menus를 순회하여 안에 있는 Menu를 가져와 value와 비교하고, 이름이 서로 동일하면 해당 Menu 사용
    public void setMenu(int input) {
        for (Menu m:menus) {
            String name = m.getCategoryName();
            if (menuNumber.get(input).equals(name)){
                menu = m;
            }
        }
    }

    public Menu getMenu() {
        return menu;
    }

    public int getSize() {
        return menus.size();
    }



    // 입력 번호와 그 이름을 key, value로 사용하여 반환
    public Map<Integer, String> printMainMenu() {

        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            menuNumber.put(i + 1, menus.get(i).getCategoryName());
            System.out.println((i + 1) + ". " + menuNumber.get(i+1));
        }
        System.out.println("0. 종료");

        return menuNumber;
    }
}
