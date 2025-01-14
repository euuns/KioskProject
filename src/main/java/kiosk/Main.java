package kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> menuItemList = new ArrayList<>();

        menuItemList.add(new MenuItem("ShakeBuger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));


        while(true){

            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItemList.size(); i++) {
                MenuItem item = menuItemList.get(i);
                System.out.println((i+1)+". "+item.getName()+"\t| W "+ item.getPrice()+" | "+item.getExplanation());
            }
            System.out.println("0. 종료\t| 종료");

            int input = scanner.nextInt();
            if(input == 0){
                System.out.println("프로그램을 종료합니다.");
                break;
            }else{
                MenuItem item = menuItemList.get(input-1);
                System.out.print("선택한 메뉴: ");
                System.out.println(item.getName()+", W "+item.getPrice()+", "+ item.getExplanation());
            }
            System.out.println();
        }
    }
}
