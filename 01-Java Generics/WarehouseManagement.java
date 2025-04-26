import java.util.ArrayList;
import java.util.List;

// Abstract class
abstract class WarehouseItem {
    private String name;
    private int id;

    public WarehouseItem(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract void displayDetails();
}

// Subclasses
class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, int id, String brand) {
        super(name, id);
        this.brand = brand;
    }

    @Override
    public void displayDetails() {
        System.out.println("Electronics [ID: " + getId() + ", Name: " + getName() + ", Brand: " + brand + "]");
    }
}

class Groceries extends WarehouseItem {
    private String expirationDate;

    public Groceries(String name, int id, String expirationDate) {
        super(name, id);
        this.expirationDate = expirationDate;
    }

    @Override
    public void displayDetails() {
        System.out.println("Groceries [ID: " + getId() + ", Name: " + getName() + ", Expiration Date: " + expirationDate + "]");
    }
}

class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, int id, String material) {
        super(name, id);
        this.material = material;
    }

    @Override
    public void displayDetails() {
        System.out.println("Furniture [ID: " + getId() + ", Name: " + getName() + ", Material: " + material + "]");
    }
}

// Generic Storage Class
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public List<T> getAllItems() {
        return items;
    }
}

// Utility class for display
class StorageUtils {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayDetails();
        }
    }
}

// Main class (now renamed to WarehouseManagement)
public class WarehouseManagement {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("Laptop", 101, "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", 102, "Samsung"));

        groceriesStorage.addItem(new Groceries("Milk", 201, "2025-01-01"));
        groceriesStorage.addItem(new Groceries("Bread", 202, "2024-05-01"));

        furnitureStorage.addItem(new Furniture("Chair", 301, "Wood"));
        furnitureStorage.addItem(new Furniture("Table", 302, "Metal"));

        System.out.println("=== Electronics ===");
        StorageUtils.displayAllItems(electronicsStorage.getAllItems());

        System.out.println("\n=== Groceries ===");
        StorageUtils.displayAllItems(groceriesStorage.getAllItems());

        System.out.println("\n=== Furniture ===");
        StorageUtils.displayAllItems(furnitureStorage.getAllItems());
    }
}
