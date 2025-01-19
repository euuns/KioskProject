package kiosk;

import java.util.Arrays;

public enum Discount {
    PATRIOTS("국가유공자", 10),
    SOLDIER("군인", 5),
    STUDENT("학생", 3),
    COMMON("일반", 0);

    private final int rate;
    private final String type;

    Discount(String type, int rate) {
        this.type = type;
        this.rate = rate;
    }

    private int getRate() {
        return rate;
    }

    private String getType() {
        return type;
    }

    public double calculateDiscount(double quantity) {
        double discount = (100 - getRate()) * 0.01;
        return Math.floor(discount * quantity * 100) / 100.0;
        // 소수점 둘째짜리 까지 나타내기 위해 100을 곱하고, 100으로 나누기
    }

    public void printDiscountInformation() {
        Discount[] discount = Discount.values();
        for (int i = 0; i < discount.length; i++) {
            System.out.println((i + 1) + ". " + discount[i].getType() + " : " + discount[i].getRate() + "%");
        }
    }


}
