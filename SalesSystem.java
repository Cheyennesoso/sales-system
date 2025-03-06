import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.*;

public class SalesSystem {
    // Logger setup
    private static final Logger LOGGER = Logger.getLogger(SalesSystem.class.getName());
    private static FileHandler fileHandler;
    private static CustomFormatter formatter;

    private List<Customer> customers = new ArrayList<>();
    private List<Sale> sales = new ArrayList<>();

    static {
        try {
            // Initialize logging components
            fileHandler = new FileHandler("salesystem.log", true);
            formatter = new CustomFormatter();
            fileHandler.setFormatter(formatter);
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.ALL);
            
            // Configure LogManager
            LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.ALL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
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
        LOGGER.info("New customer added: " + name);
    }

    public void recordSale(String product, int quantity, double price) {
        sales.add(new Sale(product, quantity, price));
        LOGGER.info("New sale recorded: " + product + " - Quantity: " + quantity + " - Price: " + price);
    }

    public void displaySales() {
        LOGGER.info("Displaying all sales");
        for (Sale sale : sales) {
            System.out.println(sale.toString());
        }
    }

    public void displayCustomers() {
        LOGGER.info("Displaying all customers");
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }
}

// Custom Formatter class
class CustomFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder();
        builder.append("[").append(new Date(record.getMillis())).append("] ");
        builder.append("[").append(record.getLevel()).append("] ");
        builder.append(record.getSourceClassName()).append(" - ");
        builder.append(record.getMessage()).append("\n");
        return builder.toString();
    }
}

