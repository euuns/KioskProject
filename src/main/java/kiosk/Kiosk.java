package kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    Menu menu = new Menu();

    public void start(){
        Scanner scanner = new Scanner(System.in);
        int selectMenu = 0;

        while(true){
            List<MenuItem> category = new ArrayList<>();

            // 메뉴 출력
            try{
                menu.printCategory();
                selectMenu = scanner.nextInt();

                if(selectMenu == 0){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }else if(selectMenu>3){
                    throw new BadInputException();
                }

            } catch (BadInputException be){
                System.out.println(be.getMessage());
                continue;
            } finally {
                System.out.println();
            }

            // 소메뉴 출력
            try{
                switch (selectMenu){
                    case 1:
                        category = menu.getBurgers();
                        menu.printBurgersMenu();
                        break;
                    case 2:
                        category = menu.getDrinks();
                        menu.printDrinksMenu();
                        break;
                    case 3:
                        category = menu.getDesserts();
                        menu.printDessertsMenu();
                        break;
                }
                int menuSize = menu.selectSize(category);

                // 입력 예외 설정
                selectMenu = scanner.nextInt();
                if(selectMenu == 0){
                    continue;
                } else if (selectMenu > menuSize) {
                    throw new BadInputException();
                }else{
                    // 선택 결과 출력
                    MenuItem select = menu.getSelectMenu(category, selectMenu-1);
                    System.out.println(select.getName()+" | W "+select.getPrice()+" | "+select.getExplanation());
                }
            } catch (BadInputException be){
                System.out.println(be.getMessage());
            } finally {
                System.out.println();
            }

        }
    }
}
