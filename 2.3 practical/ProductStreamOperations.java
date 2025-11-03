import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;

class Product {
    String name;
    double price;
    String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String toString() {
        return name + " | " + category + " | ₹" + price;
    }
}

public class ProductStreamOperations {

    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
            new Product("Laptop", 65000, "Electronics"),
            new Product("Smartphone", 35000, "Electronics"),
            new Product("Shirt", 1500, "Clothing"),
            new Product("Jeans", 2000, "Clothing"),
            new Product("Refrigerator", 45000, "Electronics"),
            new Product("Rice", 60, "Grocery"),
            new Product("Oil", 150, "Grocery")
        );

        // ✅ 1. Group by category
        System.out.println("\n--- Products Grouped by Category ---");
        Map<String, List<Product>> grouped =
            products.stream().collect(Collectors.groupingBy(p -> p.category));

        grouped.forEach((category, list) -> {
            System.out.println(category + ": " + list);
        });

        // ✅ 2. Most expensive product in each category
        System.out.println("\n--- Most Expensive Product in Each Category ---");
        Map<String, Optional<Product>> maxPrice =
            products.stream().collect(
                Collectors.groupingBy(
                    p -> p.category,
                    Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                )
            );

        maxPrice.forEach((cat, prod) -> {
            System.out.println(cat + ": " + prod.get());
        });

        // ✅ 3. Average price of all products
        double avgPrice = products.stream()
                                  .collect(Collectors.averagingDouble(p -> p.price));

        System.out.println("\nAverage Price of All Products: ₹" + avgPrice);
    }
}
