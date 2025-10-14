import java.util.ArrayList;

public class CoffeeMachine {
    int coffeeStock = 100;
    int sugarStock = 100;
    int milkStock = 100;
    int waterStock = 100;
    ArrayList<String> logs = new ArrayList<>();

    public void displayMenu() {
        System.out.println("\nChoose your today's coffee");
        System.out.println("1. Espresso   - Rp10000");
        System.out.println("2. Latte      - Rp12000");
        System.out.println("3. Cappuccino - Rp13000");
        System.out.println("4. Americano  - Rp11000");
    }

    public Coffee chooseCoffee(int choice) {
        if (choice == 1) return new Coffee("Espresso", 10000);
        if (choice == 2) return new Coffee("Latte", 12000);
        if (choice == 3) return new Coffee("Cappuccino", 13000);
        if (choice == 4) return new Coffee("Americano", 11000);
        return null;
    }

    public boolean makeCoffee(Order order) {
        if (coffeeStock < 2 || waterStock < 2) {
            System.out.println("Not enough stock!");
            remindAdmin();
            return false;
        }

        coffeeStock -= 2;
        waterStock -= 2;
        sugarStock -= order.sugar;
        if (order.milk) milkStock--;

        System.out.println("\nPreparing your coffee");
        if (order.sugar != 0) System.out.println("Adding sugar");
        if (order.milk) System.out.println("Adding milk");
        System.out.println("Your " + order.coffee.name + " is ready ^-^");

        String logEntry = order.coffee.name + " (" + order.size + 
                ") | Sugar: " + order.sugar + " | Milk: " + (order.milk ? "Yes" : "No") + 
                " | Total: Rp" + order.totalPrice;
        logs.add(logEntry);
        
        checkLowStock();
        return true;
    }
    
    private void checkLowStock() {
        if (coffeeStock < 10 || sugarStock < 10 || milkStock < 5 || waterStock < 10) {
            remindAdmin();
        }
    }
    
    private void remindAdmin() {
        System.out.println("WARNING: One or more ingredients are low or empty");
        System.out.println("Please refill the stock!\n");
    }
    
    public void showLogs() {
        System.out.println("\nTRANSACTION LOG");
        if (logs.isEmpty()) {
            System.out.println("No transactions yet");
        } else {
            for (String log : logs) {
                System.out.println(log);
            }
        }
    }
}
