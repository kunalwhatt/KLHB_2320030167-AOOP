import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Sample products
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1000, "Electronics"),
                new Product("Shirt", 30, "Clothing"),
                new Product("Phone", 700, "Electronics"),
                new Product("Shoes", 50, "Clothing")
        );

        // Product Filter
        ProductFilter filter = new ProductFilter();

        System.out.println("Products between $100 and $800:");
        filter.filterByPrice(products, 100, 800).forEach(System.out::println);

        System.out.println("\nElectronics Products:");
        filter.filterByCategory(products, "Electronics").forEach(System.out::println);
    }
}
