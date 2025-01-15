package kiosk;

import java.util.Scanner;

public class Kiosk {

    Menu menu;

    public void start(){
        Scanner scanner = new Scanner(System.in);
        int selectMenu = 0;

        while(true){
            // 메뉴 출력
            try{
                printMenu();
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
                        menu = new BurgersMenu();
                        break;
                    case 2:
                        menu = new DrinksMenu();
                        break;
                    case 3:
                        menu = new DessertsMenu();
                        break;
                }

                menu.printCategoryMenu();

                // 입력 예외 설정
                selectMenu = scanner.nextInt();
                if(selectMenu == 0){
                    continue;
                } else if (selectMenu > menu.menuSize()) {
                    throw new BadInputException();
                }else{
                    // 선택 결과 출력
                    MenuItem select = menu.getChoice(selectMenu-1);
                    System.out.println(select.getName()+" | W "+select.getPrice()+" | "+select.getExplanation());
                }
            } catch (BadInputException be){
                System.out.println(be.getMessage());
            } finally {
                System.out.println();
            }

        }
    }


    public void printMenu(){
        System.out.println("[ MAIN MENU ]");
        System.out.println("1. Burgers\n2. Drinks\n3. Desserts");
        System.out.println("0. 종료");
    }
}
