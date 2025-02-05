package kiosk.product;

public class MenuItem extends Item {
    private String explanation;

    public MenuItem(String name, double price, String explanation) {
        this.name = name;
        this.price = price;
        this.explanation = explanation;
    }

    public String getExplanation() {
        return explanation;
    }
}
