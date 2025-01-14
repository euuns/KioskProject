package kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItemList = new ArrayList<>();

    public Kiosk(){
        menuItemList.add(new MenuItem("ShakeBuger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItemList.add(new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);

        while(true){

            // 메뉴 출력
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItemList.size(); i++) {
                MenuItem item = menuItemList.get(i);
                System.out.println((i+1)+". "+item.getName()+"\t| W "+ item.getPrice()+" | "+item.getExplanation());
            }
            System.out.println("0. 종료\t| 종료");


            // 유효하지 않은 입력에 대한 오류 메세지
            try{
                // 사용자 입력
                int input = scanner.nextInt();

                if(input == 0){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }else if(input>=1 && input<=4){
                    MenuItem item = menuItemList.get(input-1);
                    System.out.print("선택한 메뉴: ");
                    System.out.println(item.getName()+", W "+item.getPrice()+", "+ item.getExplanation());
                }
                // 0~4 제외 숫자 입력 시 에러 처리
                else{
                    throw new BadInputException();
                }
            } catch (BadInputException be){
                System.out.println(be.getMessage());
            } finally {
                System.out.println();
            }

        }
    }
}
