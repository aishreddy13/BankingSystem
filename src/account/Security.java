package account;

import currency.Balance;
import currency.Currency;
import exceptions.BalanceInsufficientException;
import exceptions.CurrencyNotFoundException;
import stocks.Stock;

import java.util.ArrayList;
import java.util.List;

public class Security extends Account{

    //Attributes
    private List<Stock> stocksList = new ArrayList<>();

    //Constructors
    public Security(int accountNumber, boolean closed, Balance balance, List<Stock> stocksList){
        super(accountNumber, closed, balance);
        this.stocksList = stocksList;
    }

    //Methods
    public void buyStock(Stock stock) throws BalanceInsufficientException, CurrencyNotFoundException {
        this.getBalance().substractbalance(new Currency("USD", "USD", stock.getPrice()));
        this.stocksList.add(stock);
    }

    public static Security openAccount(Balance balance) {
        return new Security(Account.ACCOUNT_NUMBER++, false, balance, new ArrayList<>());
    }

    //Getters and Setters
    public List<Stock> getStocksList() {
        return stocksList;
    }
    public void setStocksList(List<Stock> stocksList) {
        this.stocksList = stocksList;
    }
}
