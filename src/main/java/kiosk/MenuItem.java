package kiosk;

public class MenuItem extends Product {
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
