package kiosk.menu;

import kiosk.product.MenuItem;

import java.util.ArrayList;

public class DrinksMenu extends Menu {
    public DrinksMenu() {
        drinks.add(new MenuItem("Lemonade", 4.5, "매장에서 직접 만드는 상큼한 레몬에이드"));
        drinks.add(new MenuItem("IcedTea", 3.7, "직접 유기농 홍차를 우려낸 아이스 티"));
        drinks.add(new MenuItem("Sodas  ", 2.9, "코카콜라, 코카콜라 제로, 스프라이트, 환타"));
        drinks.add(new MenuItem("RootBeer", 5.0, "청량감 있는 독특한 미국식 무알콜 탄산음료"));

        category = new ArrayList<>(drinks);
    }
}
