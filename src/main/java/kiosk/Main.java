package kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println("1. ShakeBuger\t| W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println("2. SmokeShack\t| W 8.9 |  베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            System.out.println("3. Cheeseburger\t| W 6.9 |  포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println("4. Hamburger\t| W 5.4 |  비프패티를 기반으로 야채가 들어간 기본버거");

            System.out.println("0. 종료\t| 종료");

            String input = scanner.nextLine();
            if("0".equals(input)){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
