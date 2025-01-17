package kiosk.menu;

import kiosk.product.MenuItem;

import java.util.ArrayList;

public class DessertsMenu extends Menu {
    public DessertsMenu() {
        desserts.add(new MenuItem("Fries", 4.9, "바삭하고 담백한 크링클 컷 프라이"));
        desserts.add(new MenuItem("Custard", 6.8, "쫀득하고 진한 커스터드가 들어간 클래식 쉐이크"));
        desserts.add(new MenuItem("Hotdog", 5.1, "참나무 칩으로 훈연한 비프 소시지와 토종효모 포테이토 번"));

        category = new ArrayList<>(desserts);
    }
}
