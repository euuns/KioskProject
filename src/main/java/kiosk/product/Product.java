package kiosk.product;

public abstract class Product implements Item {
    protected String name;
    protected double price;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
