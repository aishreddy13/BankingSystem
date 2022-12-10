package stocks;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    List<Stock> stocks = new ArrayList<>();

    private Boolean isStockMarketOpen;

    private static StockMarket stockMarket;

    public StockMarket(List<Stock> stocks, Boolean isStockMarketOpen) {
        this.stocks = stocks;
        this.isStockMarketOpen = isStockMarketOpen;
    }
}
