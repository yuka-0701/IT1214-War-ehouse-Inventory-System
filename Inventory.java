import java.util.*;

public class Inventory {
    private HashMap<String, Item> items;

    public Inventory() {
        items = new HashMap<>();
    }

    // Add item
    public void addItem(Item item) {
        if (items.containsKey(item.getItemId())) {
            System.out.println("Item already exists!");
        } else {
            items.put(item.getItemId(), item);
            System.out.println("Item added successfully.");
        }
    }

    // Remove item
    public void removeItem(String itemId) {
        if (items.remove(itemId) != null) {
            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    // Update quantity
    public void updateQuantity(String itemId, int quantity) {
        Item item = items.get(itemId);
        if (item != null) {
            item.setQuantity(quantity);
            System.out.println("Quantity updated.");
        } else {
            System.out.println("Item not found.");
        }
    }

    // Search by ID
    public Item searchById(String itemId) {
        return items.get(itemId);
    }

    // Search by Name
    public List<Item> searchByName(String name) {
        List<Item> results = new ArrayList<>();
        for (Item item : items.values()) {
            if (item.getItemName().toLowerCase().contains(name.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }

    // Display all items
    public void displayAll() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Item item : items.values()) {
                System.out.println(item);
            }
        }
    }
}