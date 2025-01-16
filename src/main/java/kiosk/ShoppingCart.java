package kiosk;


import java.util.*;

public class ShoppingCart {

    private final List<CartItem> cart = new ArrayList<>();


    public Boolean isOrder() {
        return cart.size() != 0;
    }

    // 장바구니에 제품 추가
    public void addItem(String name, double price) {
        // 같은 제품이 없는 경우 새로 추가
        if (isExist(name)) {
            CartItem item = find(name);
            item.setQuantity(item.getQuantity() + 1);

        } else {
            cart.add(new CartItem(name, 1, price));
        }
    }

    // 같은 제품이 있는지 확인하고, 수량 추가
    private Boolean isExist(String name) {
        for (CartItem item : cart) {
            if (item.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }


    // 제품명으로 해당 CartItem을 반환하기 위한 find 메서드
    // cart에 저장되는 제품은 오직 하나
    // 여러 개가 담길 경우, 그 CartItem을 찾아 수량을 증가 시켜줌 -> 수량만 증가
    private CartItem find(String name){
        return cart.stream().filter(item -> item.getName().equals(name)).
                toList().get(0);

        // 특정 제품의 CartItem은 하나이기 때문에 해당 List만 뽑으면 무조건 0번째 인덱스
    }


    // 장바구니 품목 조회 -> stream 사용
    public void printCart() {
        System.out.println("[ Orders ]");
        cart.stream().forEach(item -> System.out.println(item.getName() + "\t| " + item.getQuantity() + " 개\t| W " + item.getPrice()));

        System.out.println("\n[ Total ]\nW " + totalPrice());
    }


    // 선택한 품목 삭제
    public void deleteItem(String name) {
        CartItem delete = find(name);

        // 장바구니에 담긴 수량이 2개 이상일 경우, 수량 감소
        if(delete.getQuantity() >= 2){
            delete.setQuantity(delete.getQuantity()-1);
        }
        // 1개만 담겨있으면 제품 삭제
        else{
            cart.remove(delete);
        }
    }


    // 장바구니 품목들의 총 금액 계산
    public double totalPrice() {
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            CartItem item = cart.get(i);
            total += priceCalculation(item);
        }
        return Math.floor(total * 100) / 100.0;
    }

    // 수량 * 금액
    private double priceCalculation(CartItem item) {
        return item.getPrice() * item.getQuantity();
    }

    public void clearAll() {
        cart.clear();
    }


    // 제품 이름: 담은 수량
    public Map<String, Integer> nameToQuantity(){
        Map<String, Integer> productList = new HashMap<>();
        cart.forEach(item -> productList.put(item.getName(), item.getQuantity()));
        return productList;
    }

}
