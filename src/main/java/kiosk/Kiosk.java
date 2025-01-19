package kiosk;

import kiosk.menu.*;
import kiosk.product.MenuItem;

import java.util.*;

public class Kiosk {

    ShoppingCart cart = new ShoppingCart();
    Display display = new Display();
    int orderChecked = display.getSize();
    Map<Integer, String> menuNumber = new HashMap<>();



    public void start() {
        Scanner scanner = new Scanner(System.in);
        int selectMenu;


        while (true) {
            try{

                // 메뉴 출력
                selectMenu = printMenu();

                if(selectMenu == 0){
                    System.out.println("프로그램을 종료합니다.");
                    break;

                  // 입력한 번호가 지정한 카테고리 개수에 벗어나지 않는 지 확인
                } else if (selectMenu <= display.getSize()){
                    // 선택한 카테고리 세팅
                    display.setMenu(selectMenu);
                    // 해당 카테고리의 제품들 출력
                    display.getMenu().printCategoryMenu();

                    selectMenu = scanner.nextInt();

                    // 0. 뒤로가기
                    if (selectMenu == 0) {
                        continue;

                      // 입력 값이 메뉴 크기를 초과하면 예외 처리
                    } else if (selectMenu > display.getMenu().categorySize() ) {
                        throw new BadInputException();

                      // 제품을 선택했을 경우, 주문 모드로 진입
                    } else {

                        // 주문모드에서 '취소' 선택 시 false 반환
                        if(!orderMode(selectMenu))
                            continue;
                    }

                  // 카테고리 출력 바로 다음 번호가 장바구니 메뉴
                  // 장바구니 내역을 출력하고, 그 안에서 소메뉴 입력값을 받아옴
                } else if (selectMenu == display.getSize()+1) {
                    selectMenu = cartMode();

                    // 1. 주문 -> 총 금액을 출력하고, 장바구니 초기화
                    if (selectMenu == 1) {

                        // 할인 정보
                        Discount discount = applyDiscount();

                        System.out.println("주문이 완료되었습니다. 금액은 W " + discount.calculateDiscount(cart.totalPrice()) + "입니다.");
                        cart.clearAll();
                        break;


                        // 2. 메뉴판
                    } else if (selectMenu == 2) {
                        System.out.println("메뉴판으로 돌아갑니다.");
                        continue;
                    }

                  // 주문 취소
                } else if (selectMenu == display.getSize()+2) {
                    deleteCart();
                    continue;
                }


            } catch (BadInputException be){
                System.out.println(be.getMessage());
                continue;
            } finally {
                System.out.println();
            }

        }
    }


    // 전체 메뉴 출력 후 선택 정보 반환
    private int printMenu() throws BadInputException {
        menuNumber = display.printMainMenu();

        // 장바구니에 주문 내역이 있으면
        if (cart.isOrder()) {
            System.out.println("[ ORDER MENU ]");
            System.out.println((display.getSize()+1) + ". Orders\n" + (display.getSize()+2) + ". Cancel");

            orderChecked = display.getSize()+2;
        }

        // 메뉴를 선택하고 잘못된 번호는 예외 처리
        int input = new Scanner(System.in).nextInt();
        if (input > orderChecked){
            throw new BadInputException();
        }

        // 선택한 번호 반환
        return input;
    }


    // 제품 목록에서 메뉴 선택 시 진입하게 될 주문 모드
    private boolean orderMode(int input) throws BadInputException {
        // 선택 결과 출력
        MenuItem select = display.getMenu().getChoice(input - 1);
        System.out.println(select.getName() + " | W " + select.getPrice() + " | " + select.getExplanation());

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인\t\t2. 취소");

        input = new Scanner(System.in).nextInt();

        // 1. 확인 -> 장바구니에 추가
        if (input == 1) {
            cart.addItem(select.getName(), select.getPrice());
            System.out.println(select.getName() + "이 장바구니에 추가되었습니다.");

            return true;

          // 2. 취소
        } else if (input == 2) {
            return false;

        } else {
            throw new BadInputException();
        }
    }


    // 장바구니를 선택했을 때 보이는 장바구니 모드
    private int cartMode() throws BadInputException {
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        cart.printCart();
        System.out.println("1. 주문\t\t2. 메뉴판");

        int input = new Scanner(System.in).nextInt();
        if (input > 2 || input == 0) {
            throw new BadInputException();
        }

        return input;
    }


    // 장바구니에서 특정 제품을 삭제하는 메서드
    private void deleteCart() throws BadInputException {
        System.out.println("삭제할 제품을 선택해주세요.");

        // (이름:수량)으로 된 Map을 받아옴 -> product
        Map<String, Integer> product = cart.nameToQuantity();

        // (입력 번호:이름) 으로 된 삭제를 위한 Map 생성
        Map<Integer, String> delete = new HashMap<>();

        // product를 반복하며 이름과 개수 출력
        int i = 1;
        for (String name : product.keySet()) {
            // 입력받을 번호와 함께 제품명을 Map에 저장
            delete.put(i, name);
            System.out.println(i + ". " + name + " | " + product.get(name) + "개");
            i += 1;
        }

        int input = new Scanner(System.in).nextInt();
        if (input > product.size() || input == 0) {
            throw new BadInputException();
        } else {
            // 선택한 번호에 맞는 제품 이름을 받아 deleteItem 호출 -> 삭제
            String item = delete.get(input);
            cart.deleteItem(item);
        }

        System.out.println("제품을 삭제하였습니다.");
    }


    // 할인 정보 출력
    private int printDiscount() throws BadInputException {
        System.out.println("할인 정보를 입력해주세요.");
        Discount discount = Discount.COMMON;
        discount.printDiscountInformation();

        int input = new Scanner(System.in).nextInt();
        if (input > Discount.values().length) {
            throw new BadInputException();
        }

        return input;
    }


    // 할인율 계산
    private Discount applyDiscount() throws BadInputException {
        int input = printDiscount();
        switch (input) {
            case 1:
                return Discount.PATRIOTS;
            case 2:
                return Discount.SOLDIER;
            case 3:
                return Discount.STUDENT;
            default:
                return Discount.COMMON;
        }
    }


}
