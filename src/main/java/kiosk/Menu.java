package kiosk;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    // 카테고리 별 메뉴 리스트
    List<MenuItem> burgers = new ArrayList<>();
    List<MenuItem> drinks = new ArrayList<>();
    List<MenuItem> desserts = new ArrayList<>();


    // 객체 생성과 함께 각 카테고리 메뉴 초기화
    public Menu(){
        burgers.add(new MenuItem("ShakeBuger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));

        drinks.add(new MenuItem("Lemonade",4.5,"매장에서 직접 만드는 상큼한 레몬에이드"));
        drinks.add(new MenuItem("IcedTea",3.7,"직접 유기농 홍차를 우려낸 아이스 티"));
        drinks.add(new MenuItem("Sodas  ",2.9,"코카콜라, 코카콜라 제로, 스프라이트, 환타"));
        drinks.add(new MenuItem("RootBeer",5.0,"청량감 있는 독특한 미국식 무알콜 탄산음료"));

        desserts.add(new MenuItem("Fries",4.9,"바삭하고 담백한 크링클 컷 프라이"));
        desserts.add(new MenuItem("Custard",6.8,"쫀득하고 진한 커스터드가 들어간 클래식 쉐이크"));
        desserts.add(new MenuItem("Hotdog",5.1,"참나무 칩으로 훈연한 비프 소시지와 토종효모 포테이토 번"));
    }


    //카테고리 출력
    public void printCategory(){
        System.out.println("[ MAIN MENU ]");
        System.out.println("1. Burgers\n2. Drinks\n3. Desserts");
        System.out.println("0. 종료");
    }


    // 카테고리 메뉴 출력
    private void printMenu(List<MenuItem> category) {
        for (int i = 0; i < category.size(); i++) {
            MenuItem item = category.get(i);
            System.out.println((i+1)+". "+item.getName()+"\t| W "+ item.getPrice()+" | "+item.getExplanation());
        }
        System.out.println("0. 뒤로가기");
    }
    public void printBurgersMenu(){
        System.out.println("[ BURGERS MENU ]");
        printMenu(burgers);
    }
    public void printDrinksMenu(){
        System.out.println("[ DRINKS MENU ]");
        printMenu(drinks);
    }
    public void printDessertsMenu(){
        System.out.println("[ DESSERTS MENU ]");
        printMenu(desserts);
    }


    // 선택한 MenuItem 반환
    public List<MenuItem> getBurgers() {
        return burgers;
    }
    public List<MenuItem> getDesserts() {
        return desserts;
    }
    public List<MenuItem> getDrinks() {
        return drinks;
    }



    public int selectSize(List<MenuItem> select){
        return select.size();
    }
    public MenuItem getSelectMenu(List<MenuItem> select, int idx){
        return select.get(idx);
    }
}
