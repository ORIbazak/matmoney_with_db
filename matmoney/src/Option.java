
 class Option {
    private String id;
    private Stock stock;
    private boolean type;
    private int price;
    private Pair<Integer, Integer> expireDate;

    // Constructor with parameters
    public Option(String id, Stock stock, boolean type, int price, Pair<Integer, Integer> expireDate) {
        this.id = id;
        this.stock = stock;
        this.type = type;
        this.price = price;
        this.expireDate = expireDate;
    }
}