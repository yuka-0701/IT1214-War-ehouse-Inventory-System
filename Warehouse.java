import java.util.*;

public class Warehouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        int choice;

        do {
            System.out.println("\n=== Warehouse Inventory System ===");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. Search Item");
            System.out.println("5. Display All Items");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input! Enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();

                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    inventory.addItem(new Item(id, name, qty, price));
                    break;

                case 2:
                    System.out.print("Enter ID to remove: ");
                    inventory.removeItem(scanner.nextLine());
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    String updateId = scanner.nextLine();

                    System.out.print("Enter new quantity: ");
                    int newQty = scanner.nextInt();
                    scanner.nextLine();

                    inventory.updateQuantity(updateId, newQty);
                    break;

                case 4:
                    System.out.println("Search by: 1.ID  2.Name");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (searchChoice == 1) {
                        System.out.print("Enter ID: ");
                        Item item = inventory.searchById(scanner.nextLine());
                        System.out.println(item != null ? item : "Item not found.");
                    } else {
                        System.out.print("Enter Name: ");
                        List<Item> results = inventory.searchByName(scanner.nextLine());
                        if (results.isEmpty()) {
                            System.out.println("No items found.");
                        } else {
                            for (Item i : results) {
                                System.out.println(i);
                            }
                        }
                    }
                    break;

                case 5:
                    inventory.displayAll();
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        scanner.close();
    }
}