package kiosk;


import java.util.*;

public class ShoppingCart {

    private final List<CartItem> cart = new ArrayList<>();


    public Boolean isOrder(){
        return getCart().size() != 0;
    }

    // 장바구니에 제품 추가
    public void addItem(String name, double price){
        // 같은 제품이 없는 경우 새로 추가
        if(!isExist(name)){
            getCart().add(new CartItem(name, 1 , price));
        }
    }
    // 같은 제품이 있는지 확인하고, 수량 추가
    private Boolean isExist(String name){
        for (CartItem item: getCart()) {

            // 같은 제품이 있으면, 수량을 증가
            if (item.getName().equals(name)){
                existProduct(item);
                return true;
            }
        }
        return false;
    }
    // 장바구니 속 제품의 수량
    private void existProduct(CartItem item){
        item.setQuantity(item.getQuantity()+1);
    }


    // 장바구니 품목 조회
    public void printCart(){
        System.out.println("[ Orders ]");
        for (int i = 0; i < getCart().size(); i++) {
            CartItem item = getCart().get(i);
            System.out.println(item.getName()+"\t| "+item.getQuantity()+" 개\t| W "+item.getPrice());
        }

        System.out.println("\n[ Total ]\nW "+totalPrice());
    }
    // 장바구니 품목들의 총 금액 계산
    public double totalPrice(){
        double total = 0;
        for (int i = 0; i < getCart().size(); i++) {
            CartItem item = getCart().get(i);
            total += priceCalculation(item);
        }
        return Math.floor(total * 100) / 100.0;
    }
    // 수량 * 금액
    private double priceCalculation(CartItem item){
        return item.getPrice() * item.getQuantity();
    }

    public void clearAll(){
        getCart().clear();
    }

    public List<CartItem> getCart() {
        return cart;
    }
}
