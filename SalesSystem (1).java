import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.*;

public class SalesSystem {
    // Logger setup
    private static final Logger LOGGER = Logger.getLogger(SalesSystem.class.getName());
    private List<Customer> customers = new ArrayList<>();
    private List<Sale> sales = new ArrayList<>();

    public static void main(String[] args) {  // Fixed typo here
        SalesSystem system = new SalesSystem();
        system.addCustomer("John Doe", "************");
        system.addCustomer("Jane Smith", "************");
        system.recordSale("Laptop", 1, 1000.0);
        system.recordSale("Mouse", 2, 25.5);
        system.displaySales();
        system.displayCustomers();
    }

    public void addCustomer(String name, String contact) {
        customers.add(new Customer(customers.size() + 1, name, contact));
        System.out.println("LOG: New customer added: " + name);
    }

    public void recordSale(String product, int quantity, double price) {
        sales.add(new Sale(product, quantity, price));
        System.out.println("LOG: New sale recorded: " + product);
    }

    public void displaySales() {
        System.out.println("LOG: Displaying all sales");
        for (Sale sale : sales) {
            System.out.println(sale.toString());
        }
    }

    public void displayCustomers() {
        System.out.println("LOG: Displaying all customers");
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }
}

class Customer {
    private int id;
    private String name;
    private String contact;

    public Customer(int id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "', contact='" + contact + "'}";
    }
}

class Sale {
    private String product;
    private int quantity;
    private double price;
    private Date date;

    public Sale(String product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.date = new Date();
    }

    public String getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Sale{product='" + product + "', quantity=" + quantity + ", price=" + price + ", date=" + date + "}";
    }
}