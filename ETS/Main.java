import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine();

        while (true) {
            machine.displayMenu();
            System.out.print("My coffee(0 for exit): ");
            int choice = sc.nextInt();
            
            if (choice == 0) {
                machine.showLogs();
                System.out.println("See uu, fighting!");
                break;
            }

            Coffee coffee = machine.chooseCoffee(choice);
            if (coffee == null) {
                System.out.println("Invalid choice!");
                continue;
            }

            System.out.print("Choose size (S/M/L): ");
            String size = sc.next();

            System.out.print("Add sugar (0-3): ");
            int sugar = sc.nextInt();

            System.out.print("Add milk? (y/n): ");
            boolean milk = sc.next().equalsIgnoreCase("y");

            Order order = new Order(coffee, size, sugar, milk);
            System.out.println("Total price: Rp" + order.totalPrice);

            System.out.print("Insert money (Rp): ");
            double money = sc.nextDouble();
            double change = money - order.totalPrice;

            if (money >= order.totalPrice) {
                System.out.println("Payment accepted");
                if(change != 0) System.out.println("Change: Rp" + change);
                machine.makeCoffee(order);
            } else {
                System.out.println("Not enough money! Transaction cancelled.");
            }
        }

        sc.close();
    }
}
