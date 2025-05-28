import java.util.*;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Stock> market = new ArrayList<>();
        HashMap<String, Integer> portfolio = new HashMap<>();

        market.add(new Stock("Apple", 150.0));
        market.add(new Stock("Google", 2800.0));
        market.add(new Stock("Tesla", 720.0));

        OUTER:
        while (true) {
            System.out.println("\n1. View Stocks\n2. Buy Stock\n3. View Portfolio\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Available Stocks:");
                    for (int i = 0; i < market.size(); i++) {
                        Stock s = market.get(i);
                        System.out.println((i + 1) + ". " + s.name + " - $" + s.price);
                    }
                }
                case 2 -> {
                    System.out.print("Enter stock number to buy: ");
                    int stockIndex = sc.nextInt() - 1;
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    String stockName = market.get(stockIndex).name;
                    portfolio.put(stockName, portfolio.getOrDefault(stockName, 0) + quantity);
                    System.out.println("Purchased " + quantity + " shares of " + stockName);
                }
                case 3 -> {
                    System.out.println("Your Portfolio:");
                    for (String stock : portfolio.keySet()) {
                        System.out.println(stock + ": " + portfolio.get(stock) + " shares");
                    }
                }
                default -> {
                    break OUTER;
                }
            }
        }
    }
}
