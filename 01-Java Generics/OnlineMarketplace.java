import java.util.ArrayList;
import java.util.List;

// Category Types
interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Gadgets";
    }
}

// Generic Product Class
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            price -= (price * percentage / 100);
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void display() {
        System.out.println(name + " [" + category.getCategoryName() + "] - $" + String.format("%.2f", price));
    }
}

// Catalog class
class ProductCatalog {
    private List<Product<? extends Category>> products = new ArrayList<>();

    public void addProduct(Product<? extends Category> product) {
        products.add(product);
    }

    public void displayCatalog() {
        for (Product<? extends Category> product : products) {
            product.display();
        }
    }
}

// Utility class for generic discount
class DiscountUtils {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
    }
}

// Main class
public class OnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book1 = new Product<>("The Alchemist", 20.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Polo Shirt", 35.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone X", 699.0, new GadgetCategory());

        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(book1);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        System.out.println("=== Catalog Before Discount ===");
        catalog.displayCatalog();

        // Apply some discounts
        DiscountUtils.applyDiscount(book1, 10.0);
        DiscountUtils.applyDiscount(shirt, 20.0);
        DiscountUtils.applyDiscount(phone, 5.0);

        System.out.println("\n=== Catalog After Discount ===");
        catalog.displayCatalog();
    }
}
