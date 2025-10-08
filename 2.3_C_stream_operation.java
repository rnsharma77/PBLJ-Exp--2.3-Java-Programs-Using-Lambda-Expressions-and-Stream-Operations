import java.util.*;
import java.util.stream.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return id + " - " + name + " : ₹" + price;
    }
}

public class ProductStreamExample {
    public static void main(String[] args) {

        // Create a list of products
        List<Product> products = Arrays.asList(
            new Product(1, "Laptop", 55000),
            new Product(2, "Mouse", 800),
            new Product(3, "Keyboard", 1500),
            new Product(4, "Monitor", 12000),
            new Product(5, "Phone", 30000)
        );

        // 1️⃣ Filter products whose price > 5000
        System.out.println("Products with price > 5000:");
        products.stream()
                .filter(p -> p.price > 5000)
                .forEach(p -> System.out.println(p));

        // 2️⃣ Sort products by price (ascending)
        System.out.println("\nProducts sorted by price (low to high):");
        products.stream()
                .sorted((p1, p2) -> Double.compare(p1.price, p2.price))
                .forEach(p -> System.out.println(p));

        // 3️⃣ Find the most expensive product
        Product maxProduct = products.stream()
                .max(Comparator.comparingDouble(p -> p.price))
                .get();
        System.out.println("\nMost expensive product: " + maxProduct);

        // 4️⃣ Find the total price of all products
        double totalPrice = products.stream()
                .mapToDouble(p -> p.price)
                .sum();
        System.out.println("\nTotal price of all products: ₹" + totalPrice);

        // 5️⃣ Convert product names to uppercase
        System.out.println("\nProduct names in uppercase:");
        products.stream()
                .map(p -> p.name.toUpperCase())
                .forEach(System.out::println);
    }
}
