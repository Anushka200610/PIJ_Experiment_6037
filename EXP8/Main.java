import java.util.*;

// Product Interface
interface Product {
    void displayDetails();
}

// LegacyItem Class (Old system)
class LegacyItem {
    private int itemId;
    private String description;

    // Parameterized Constructor
    public LegacyItem(int itemId, String description) {
        this.itemId = itemId;
        this.description = description;
    }

    // Legacy method
    public void print() {
        System.out.println("Legacy Item -> ID: " + itemId + ", Description: " + description);
    }
}

// Adapter Class
class ProductAdapter implements Product {
    private LegacyItem legacyItem;

    public ProductAdapter(LegacyItem legacyItem) {
        this.legacyItem = legacyItem;
    }

    @Override
    public void displayDetails() {
        legacyItem.print(); // adapting old method
    }
}

// New Product Class
class NewProduct implements Product {
    private String name;

    public NewProduct(String name) {
        this.name = name;
    }

    @Override
    public void displayDetails() {
        System.out.println("New Product -> Name: " + name);
    }
}

// Singleton Inventory Manager
class InventoryManager {
    private static InventoryManager instance;
    private List<Product> products;

    // Private Constructor
    private InventoryManager() {
        products = new ArrayList<>();
    }

    // Get Singleton Instance
    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    // Add Product
    public void addProduct(Product product) {
        products.add(product);
    }

    // Return Iterator
    public Iterator<Product> returnInventory() {
        return products.iterator();
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        // Singleton instance
        InventoryManager manager = InventoryManager.getInstance();

        // Adding New Products
        manager.addProduct(new NewProduct("Laptop"));
        manager.addProduct(new NewProduct("Smartphone"));

        // Adding Legacy Products via Adapter
        LegacyItem old1 = new LegacyItem(101, "Old Keyboard");
        LegacyItem old2 = new LegacyItem(102, "Old Mouse");

        manager.addProduct(new ProductAdapter(old1));
        manager.addProduct(new ProductAdapter(old2));

        // Iterating Inventory
        Iterator<Product> iterator = manager.returnInventory();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            product.displayDetails();
        }
    }
}
