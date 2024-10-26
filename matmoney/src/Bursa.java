import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bursa {
    private final List<Stock> stocks = new ArrayList<>();
    private final List<Option> options = new ArrayList<>();
    private final List<Broker> brokers = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    // Default constructor
    public Bursa() {
    }

    // Method to convert string to enum
    public Input stringToEnum(String str) {
        switch (str) {
            case "1": return Input.STOCK;
            case "2": return Input.BROKER;
            case "3": return Input.OPTION;
            case "4": return Input.STATE;
            default: return Input.UNKNOWN;
        }
    }

    // Method to create a stock
    public Stock createStock() {
        System.out.print("Stock ID: ");
        String id = scanner.nextLine();
        System.out.print("Company Name: ");
        String name = scanner.nextLine();
        System.out.print("How much worth? ");
        int value = Integer.parseInt(scanner.nextLine());

        return new Stock(id, name, value);
    }

    // Method to add a stock
    public int addStock(Stock s) {
        stocks.add(s);
        return 0;
    }

    // Main run method
    public int run() {
        boolean run = true;
        while (run) {
            System.out.print("1: Stock, 2: Broker, 3: Option, 4: Print state: ");
            String in = scanner.nextLine();
            Input req = stringToEnum(in);

            switch (req) {
                case STOCK: {
                    Stock stk = createStock();
                    addStock(stk);
                    break;
                }
                case OPTION: {
                    Option p = createOption();
                    addOption(p);
                    break;
                }
                case BROKER: {
                    Broker b = createBroker();
                    addBroker(b);
                    break;
                }
                case STATE: {
                    System.out.println("The Bursa holds " + stocks.size() + " stocks");
                    System.out.println("The Bursa holds " + options.size() + " options");
                    System.out.println("The Bursa has " + brokers.size() + " brokers");
                    break;
                }
                case UNKNOWN: {
                    run = false;
                    break;
                }
            }
        }
        return 0;
    }

    // Method to create an option
    public Option createOption() {
        System.out.print("Option ID: ");
        String id = scanner.nextLine();
        Stock s = createStock();
        System.out.print("Type of option (PUT/CALL): ");
        String typeInput = scanner.nextLine();
        boolean type = typeInput.equalsIgnoreCase("PUT");
        System.out.print("Worth? ");
        int worth = Integer.parseInt(scanner.nextLine());
        System.out.print("Month expire? ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Year expire? ");
        int year = Integer.parseInt(scanner.nextLine());

        Pair<Integer, Integer> date = new Pair<>(month, year);
        return new Option(id, s, type, worth, date);
    }

    // Method to add an option
    public int addOption(Option p) {
        options.add(p);
        return 0;
    }

    // Method to create a broker
    public Broker createBroker() {
        System.out.print("Broker ID: ");
        String id = scanner.nextLine();
        System.out.print("Broker Name: ");
        String name = scanner.nextLine();
        System.out.print("Home Address: ");
        String addr = scanner.nextLine();
        System.out.print("How much money do you have? ");
        int worth = Integer.parseInt(scanner.nextLine());

        Broker b = new Broker(id, name, addr, worth);
        System.out.print("How many stocks? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            Stock s = createStock();
            this.addStock(s);
            b.addPersonalStock(s);
        }
        return b;
    }

    // Method to add a broker
    public int addBroker(Broker b) {
        brokers.add(b);
        return 0;
    }
}
