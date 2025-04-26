import java.util.*;
import java.util.stream.Collectors;

public class ProductSalesAnalysis {

    static class Sale {
        private String productId;
        private int quantity;
        private double price;

        public Sale(String productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId() { return productId; }
        public int getQuantity() { return quantity; }
        public double getPrice() { return price; }
    }

    static class ProductSales {
        private String productId;
        private double totalRevenue;

        public ProductSales(String productId, double totalRevenue) {
            this.productId = productId;
            this.totalRevenue = totalRevenue;
        }

        public String getProductId() { return productId; }
        public double getTotalRevenue() { return totalRevenue; }

        @Override
        public String toString() {
            return productId + " → $" + totalRevenue;
        }
    }

    public static List<ProductSales> analyzeSales(List<Sale> sales, int topN) {
        Map<String, Double> revenueMap = sales.stream()
                .filter(s -> s.getQuantity() > 10)
                .collect(Collectors.groupingBy(
                        Sale::getProductId,
                        Collectors.summingDouble(s -> s.getQuantity() * s.getPrice())
                ));

        List<ProductSales> sortedSales = revenueMap.entrySet().stream()
                .map(entry -> new ProductSales(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed())
                .collect(Collectors.toList());

        return sortedSales.stream().limit(topN).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale("P1", 5, 20.0),
                new Sale("P2", 15, 10.0),
                new Sale("P3", 20, 5.0),
                new Sale("P4", 8, 30.0),
                new Sale("P5", 12, 25.0),
                new Sale("P6", 11, 50.0),
                new Sale("P7", 18, 12.0),
                new Sale("P8", 9, 40.0)
        );

        List<ProductSales> topProducts = analyzeSales(sales, 5);

        System.out.println("Top 5 Products by Total Revenue:");
        topProducts.forEach(System.out::println);
    }
}
