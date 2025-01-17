package kiosk.menu;

import kiosk.product.MenuItem;

import java.util.List;

public abstract class Menu implements Desserts, Burgers, Drinks {

    List<MenuItem> category;
    String categoryName;



    // 상속받은 Category 메서드 구현

    // 제품 출력
    @Override
    public void printCategoryMenu() {
        System.out.println("[ " + getCategoryName() + " ]");

        for (int i = 0; i < category.size(); i++) {
            MenuItem item = category.get(i);
            System.out.println((i + 1) + ". " + item.getName() + "\t| W " + item.getPrice() + " | " + item.getExplanation());
        }
        System.out.println("0. 뒤로가기");
    }


    // 리스트 크기 반환
    @Override
    public int categorySize() {
        return category.size();
    }

    // 제품 선택
    @Override
    public MenuItem getChoice(int idx) {
        return category.get(idx);
    }

    // 카테고리 이름 반환
    @Override
    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public void setCategoryName() {
        String temp = this.getClass().getSimpleName();
        categoryName = temp.substring(0, temp.length() - 4);
    }
}
