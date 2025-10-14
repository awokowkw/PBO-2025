public class Order {
    Coffee coffee;
    String size;
    int sugar;
    boolean milk;
    double totalPrice;

    public Order(Coffee coffee, String size, int sugar, boolean milk) {
        this.coffee = coffee;
        this.size = size;
        this.sugar = sugar;
        this.milk = milk;
        calculateTotal();
    }

    public void calculateTotal() {
        totalPrice = coffee.price;

        if (size.equalsIgnoreCase("M")) totalPrice += 2000;
        else if (size.equalsIgnoreCase("L")) totalPrice += 4000;

        totalPrice += (sugar * 500);
        if (milk) totalPrice += 1000;
    }
}
