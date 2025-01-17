package kiosk;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {

    List<MenuItem> category = new ArrayList<>();

    public void printCategoryMenu() {
        for (int i = 0; i < category.size(); i++) {
            MenuItem item = category.get(i);
            System.out.println((i + 1) + ". " + item.getName() + "\t| W " + item.getPrice() + " | " + item.getExplanation());
        }
        System.out.println("0. 뒤로가기");
    }

    public int menuSize() {
        return category.size();
    }

    public MenuItem getChoice(int idx) {
        return category.get(idx);
    }
}
