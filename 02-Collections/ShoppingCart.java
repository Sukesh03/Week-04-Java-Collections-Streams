import java.util.*;

public class ShoppingCart {
    // HashMap to store product prices
    private Map<String, Double> productPrices = new HashMap<>();

    // LinkedHashMap to maintain order of items added to cart
    private Map<String, Double> cart = new LinkedHashMap<>();

    // TreeMap to display products sorted by price
    private Map<String, Double> sortedCart = new TreeMap<>(Comparator.comparing(productPrices::get));

    // Method to add item to cart
    public void addItemToCart(String product, double price) {
        productPrices.put(product, price);
        cart.put(product, price);
        sortedCart.put(product, price);
    }

    // Method to display cart items sorted by price
    public void displayCartSortedByPrice() {
        System.out.println("Cart Items Sorted by Price (TreeMap): ");
        for (Map.Entry<String, Double> entry : sortedCart.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    // Method to display cart items in order of insertion
    public void displayCartInOrder() {
        System.out.println("Cart Items in Insertion Order (LinkedHashMap): ");
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItemToCart("Laptop", 999.99);
        cart.addItemToCart("Phone", 699.99);
        cart.addItemToCart("Headphones", 199.99);

        cart.displayCartInOrder();
        cart.displayCartSortedByPrice();
    }
}
