import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class Product {
    String name;
    String category;
    double price;

    Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1000.0),
            new Product("Headphones", "Electronics", 200.0),
            new Product("Apple", "Grocery", 1.5),
            new Product("Banana", "Grocery", 1.2),
            new Product("Desk", "Furniture", 250.0),
            new Product("Chair", "Furniture", 100.0),
            new Product("TV", "Electronics", 1500.0)
        );

        // 1. Group products by category
        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category));

        System.out.println("Grouped by Category:");
        groupedByCategory.forEach((category, prods) -> {
            System.out.println(category + ": " + prods);
        });

        // 2. Most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveInCategory = products.stream()
            .collect(Collectors.groupingBy(
                p -> p.category,
                Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
            ));

        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensiveInCategory.forEach((category, product) -> 
            System.out.println(category + ": " + product.orElse(null))
        );

        // 3. Average price of all products
        double averagePrice = products.stream()
            .collect(Collectors.averagingDouble(p -> p.price));

        System.out.println("\nAverage Price of All Products: $" + averagePrice);
    }
}
