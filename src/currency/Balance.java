package currency;


import exceptions.BalanceInsufficientException;

import java.util.List;

public class Balance{

    private List<Currency> currencyList;
    private float walletValueinUSD;


    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public float getWalletValueinUSD() {
        return walletValueinUSD;
    }

    public void setWalletValueinUSD(float walletValueinUSD) {
        this.walletValueinUSD = walletValueinUSD;
    }

    public void addbalance(Currency currency)
    {
        for (Currency cur : currencyList ) {
            if (cur.getName().equals(currency.getName()))
            {
                cur.setQuantity(cur.getQuantity()+currency.getQuantity());
            }
            else {
                currencyList.add(currency);
            }
        }

    }

    public void removebalance(Currency currency) throws BalanceInsufficientException,Exception
    {
        for (Currency cur : currencyList ) {
            if (cur.getName().equals(currency.getName()))
            {
                if (cur.getQuantity()>currency.getQuantity())
                {
                    cur.setQuantity(cur.getQuantity()-currency.getQuantity());
                }
                else {
                    throw new BalanceInsufficientException("Insufficient Balance. You have only " + cur.getQuantity()+" "+cur.getSymbol()+"in balance");
                }

            }
            else {
                currencyList.add(currency);
            }
        }

    }

}