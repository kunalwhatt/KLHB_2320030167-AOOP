package Chain;

import java.util.*;

class Product {
    String name;
    int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}

class Inventory {
    private Map<String, Product> inventory = new HashMap<>();

    public void addProduct(String name, int quantity) {
        Product product = inventory.get(name);
        if (product != null) {
            product.quantity += quantity;
        } else {
            inventory.put(name, new Product(name, quantity));
        }
    }

    public boolean checkStock(String name, int quantity) {
        Product product = inventory.get(name);
        return product != null && product.quantity >= quantity;
    }

    public void reduceStock(String name, int quantity) {
        Product product = inventory.get(name);
        if (product != null) {
            product.quantity -= quantity;
            if (product.quantity <= 0) {
                inventory.remove(name);
            }
        }
    }

    public void displayInventory() {
        for (Product product : inventory.values()) {
            System.out.println("Product: " + product.name + ", Quantity: " + product.quantity);
        }
    }
}

class Supplier {
    private String name;
    private Inventory inventory;

    public Supplier(String name, Inventory inventory) {
        this.name = name;
        this.inventory = inventory;
    }

    public void supplyProduct(String productName, int quantity) {
        inventory.addProduct(productName, quantity);
        System.out.println(name + " supplied " + quantity + " units of " + productName);
    }
}

class Order {
    String productName;
    int quantity;

    public Order(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }
}

class OrderFulfillment {
    private Inventory inventory;

    public OrderFulfillment(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean fulfillOrder(Order order) {
        if (inventory.checkStock(order.productName, order.quantity)) {
            inventory.reduceStock(order.productName, order.quantity);
            System.out.println("Order fulfilled: " + order.quantity + " units of " + order.productName);
            return true;
        } else {
            System.out.println("Order cannot be fulfilled: Not enough stock for " + order.productName);
            return false;
        }
    }
}

public class SupplyChainManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Supplier supplier = new Supplier("Supplier1", inventory);
        OrderFulfillment orderFulfillment = new OrderFulfillment(inventory);

        // Supplier supplies products
        supplier.supplyProduct("Widget", 100);
        supplier.supplyProduct("Gadget", 50);

        // Display inventory
        System.out.println("Current inventory:");
        inventory.displayInventory();

        // Create and fulfill an order
        Order order = new Order("Widget", 30);
        orderFulfillment.fulfillOrder(order);

        // Display inventory after fulfilling the order
        System.out.println("Inventory after fulfilling the order:");
        inventory.displayInventory();

        // Try to fulfill an order with insufficient stock
        Order anotherOrder = new Order("Gadget", 60);
        orderFulfillment.fulfillOrder(anotherOrder);
    }
}

