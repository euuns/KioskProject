package kiosk;

public class BurgersMenu extends Menu {

    public BurgersMenu(){
        category.add(new MenuItem("ShakeBuger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        category.add(new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        category.add(new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        category.add(new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    @Override
    public void printCategoryMenu(){
        System.out.println("[ BURGERS MENU ]");
        super.printCategoryMenu();
    }

}
