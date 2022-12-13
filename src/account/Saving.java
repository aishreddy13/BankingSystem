package account;

import currency.Balance;
import currency.Currency;
import exceptions.BalanceInsufficientException;
import exceptions.CurrencyNotFoundException;

public class Saving extends Account {

    //Constructors
    public Saving(int accountNumber, boolean closed, Balance balance){
        super(accountNumber, closed, balance);
    }

    //Methods
    public void payInterest() {
        if(this.getBalance().getWalletValueinUSD() > 5000){
            //Value to be subtracted
            float fee = this.getBalance().getWalletValueinUSD() * Account.PAY_INTEREST_TO_SAVING_ACCOUNTS;
            try {
                this.getBalance().substractbalance(new Currency("USD", "USD", fee));
            } catch (BalanceInsufficientException e) {
                throw new RuntimeException(e);
            } catch (CurrencyNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean transferMoney(Account account, Balance balance) throws BalanceInsufficientException, CurrencyNotFoundException {
        //Calculate amount after taking off the fees
        try {
            balance.substractbalance(new Currency("USD", "USD", Account.FEE_TRANSFER_AMOUNT));
        } catch (BalanceInsufficientException e) {
            throw new RuntimeException(e);
        } catch (CurrencyNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(account instanceof Security){
            if(this.getBalance().getWalletValueinUSD() > 5000){
                //Send amount to receiver account
                account.getBalance().addbalance(new Currency("USD", "USD", balance.getWalletValueinUSD()));
                //remove amount from sender account
                this.getBalance().substractbalance(new Currency("USD", "USD", balance.getWalletValueinUSD()));
                //Transaction made successfully
                return true;
            }
        }else {
            //Send amount to receiver account
            account.getBalance().addbalance(new Currency("USD", "USD", balance.getWalletValueinUSD()));
            //remove amount from sender account
            this.getBalance().substractbalance(new Currency("USD", "USD", balance.getWalletValueinUSD()));
            //Transaction made successfully
            return true;
        }
        return false;
    }

    public static Saving openAccount(Balance balance) {
        //Charging fees
        try {
            balance.substractbalance(new Currency("USD", "USD", Account.FEE_OPEN_ACCOUNT));
        } catch (BalanceInsufficientException e) {
            throw new RuntimeException(e);
        } catch (CurrencyNotFoundException e) {
            throw new RuntimeException(e);
        }
        // Return Saving account
        return new Saving(Account.ACCOUNT_NUMBER++, false, balance);
    }



}
