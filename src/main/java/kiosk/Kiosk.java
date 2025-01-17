package kiosk;

import kiosk.menu.Burgers;
import kiosk.menu.Desserts;
import kiosk.menu.Drinks;
import kiosk.menu.Menu;
import kiosk.product.MenuItem;

import java.util.*;

public class Kiosk {

    ShoppingCart cart = new ShoppingCart();
    Menu menu = new Burgers();

    List<Menu> category = new ArrayList<>();

    public Kiosk(){
        category.add(new Burgers());
        category.add(new Drinks());
        category.add(new Desserts());
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int selectMenu;
        int orderChecked = 3;


        while (true) {
            // 메뉴 출력
            try {
                printMenu();
                if (cart.isOrder()) {
                    printOrder();
                    orderChecked = 5;
                }
                selectMenu = scanner.nextInt();

                if (selectMenu == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (selectMenu > orderChecked) {
                    throw new BadInputException();
                }

            } catch (BadInputException be) {
                System.out.println(be.getMessage());
                continue;
            } finally {
                System.out.println();
            }

            // 소메뉴 출력
            try {
                // 입력한 정보가 3이하면, 일반 메뉴 출력
                if (selectMenu <= 3) {
                    orderMode(selectMenu);

                    // 입력이 4일 경우, 장바구니 내역 출력
                } else if (selectMenu == 4) {
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
                } else {
                    deleteCart();
                    continue;
                }

                // 입력 예외 설정
                selectMenu = scanner.nextInt();

                // 0. 뒤로가기
                if (selectMenu == 0) {
                    continue;
                } else if (selectMenu > menu.menuSize()) {
                    throw new BadInputException();
                } else {
                    // 선택 결과 출력
                    MenuItem select = menu.getChoice(selectMenu - 1);
                    System.out.println(select.getName() + " | W " + select.getPrice() + " | " + select.getExplanation());
                    checkCart();    // 추가하시겠습니까?


                    selectMenu = scanner.nextInt();
                    // 1. 확인 -> 장바구니에 추가
                    if (selectMenu == 1) {
                        cart.addItem(select.getName(), select.getPrice());
                        System.out.println(select.getName() + "이 장바구니에 추가되었습니다.");
                        // 2. 취소
                    } else if (selectMenu == 2) {
                        continue;
                    } else {
                        throw new BadInputException();
                    }
                }
            } catch (BadInputException be) {
                System.out.println(be.getMessage());
            } finally {
                System.out.println();
            }

        }
    }


    private void orderMode(int input) {
        switch (input) {
            case 1 -> menu = new Burgers();
            case 2 -> menu = new Drinks();
            case 3 -> menu = new Desserts();
        }
        menu.printCategoryMenu();
    }

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


    private void printMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < category.size(); i++) {
            System.out.println((i + 1) + ". " + category.get(i).getCategoryName());
        }
        System.out.println("0. 종료");
    }

    private void printOrder() {
        System.out.println("[ ORDER MENU ]");
        System.out.println("4. Orders\n5. Cancel");
    }

    private void checkCart() {
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인\t\t2. 취소");
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
