import java.util.ArrayList;
import java.util.List;

public class Broker {
    private String id;
    private String name;
    private String addr; // Use a lowercase variable name
    private int worth;
    private List<Stock> stocks;

    // Constructor
    public Broker(String id, String name, String addr, int worth) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.worth = worth;
        this.stocks = new ArrayList<>(); // Initialize the list
    }
    public void addPersonalStock(Stock s)
    {
        stocks.add(s);
    }

}