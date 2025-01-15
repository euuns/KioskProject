package kiosk;

import java.util.Scanner;

public class Kiosk {

    ShoppingCart cart = new ShoppingCart();
    Menu menu = new BurgersMenu();

    public void start(){
        Scanner scanner = new Scanner(System.in);
        int selectMenu = 0;
        int orderChecked = 3;


        while(true){
            // 메뉴 출력
            try{
                printMenu();
                if(cart.isOrder()){
                    printOrder();
                    orderChecked = 5;
                }
                selectMenu = scanner.nextInt();

                if(selectMenu == 0){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }else if(selectMenu>orderChecked){
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
                // 입력한 정보가 3이하면, 일반 메뉴 출력
                if(selectMenu<=3){
                    orderMode(selectMenu);

                    // 입력이 4일 경우, 장바구니 내역 출력
                } else if(selectMenu == 4){
                    selectMenu = cartMode();

                    // 1. 주문 -> 총 금액을 출력하고, 장바구니 초기화
                    if(selectMenu == 1){
                        System.out.println("주문이 완료되었습니다. 금액은 W "+cart.totalPrice()+"입니다.");
                        cart.clearAll();
                        break;

                    // 2. 메뉴판
                    } else if (selectMenu == 2) {
                        System.out.println("메뉴판으로 돌아갑니다.");
                        continue;
                    }

                // 주문 취소 -> 초기화? 그냥 취소?
                } else{
                    System.out.println("진행 중인 주문을 취소 합니다.");
                    continue;
                }

                // 입력 예외 설정
                selectMenu = scanner.nextInt();

                // 0. 뒤로가기
                if(selectMenu == 0){
                    continue;
                } else if (selectMenu > menu.menuSize()) {
                    throw new BadInputException();
                }else{
                    // 선택 결과 출력
                    MenuItem select = menu.getChoice(selectMenu-1);
                    System.out.println(select.getName()+" | W "+select.getPrice()+" | "+select.getExplanation());
                    checkCart();    // 추가하시겠습니까?


                    selectMenu = scanner.nextInt();
                    // 1. 확인 -> 장바구니에 추가
                    if(selectMenu == 1){
                        cart.addItem(select.getName(), select.getPrice());
                        System.out.println(select.getName()+"이 장바구니에 추가되었습니다.");
                    // 2. 취소
                    } else if(selectMenu == 2){
                        continue;
                    } else{
                        throw new BadInputException();
                    }
                }
            } catch (BadInputException be){
                System.out.println(be.getMessage());
            } finally {
                System.out.println();
            }

        }
    }


    private void orderMode(int input){
        switch (input) {
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
    }

    private int cartMode(){
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        cart.printCart();
        System.out.println("1. 주문\t\t2. 메뉴판");

        return new Scanner(System.in).nextInt();
    }


    private void printMenu(){
        System.out.println("[ MAIN MENU ]");
        System.out.println("1. Burgers\n2. Drinks\n3. Desserts");
        System.out.println("0. 종료");
    }

    private void printOrder(){
        System.out.println("[ ORDER MENU ]");
        System.out.println("4. Orders\n5. Cancel");
    }

    private void checkCart(){
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인\t\t2. 취소");
    }
}
