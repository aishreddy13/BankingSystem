package account;

import currency.Balance;
import currency.Currency;
import exceptions.BalanceInsufficientException;
import exceptions.CurrencyNotFoundException;
import user.Customer;

public class Checking extends Account {

    //Constructors
    public Checking(int accountNumber, boolean closed, Balance balance){
        super(accountNumber, closed, balance);
    }

    //Methods
    public void withdraw(Balance balance) throws BalanceInsufficientException, CurrencyNotFoundException {
        //We remove the fee from the deposit amount
        balance.substractbalance(new Currency("USD", "USD", Account.FEE_TRANSACTION_WITHDRAWAL_DEPOSIT));
        //We subtract the balance to the account.
        this.getBalance().substractbalance(new Currency("USD", "USD", balance.getWalletValueinUSD()));
    }

    public void deposit(Balance balance) throws BalanceInsufficientException, CurrencyNotFoundException {
        //We remove the fee from the deposit amount
        balance.substractbalance(new Currency("USD", "USD", Account.FEE_TRANSACTION_WITHDRAWAL_DEPOSIT));
        //We add the balance to the account.
        this.getBalance().addbalance(new Currency("USD", "USD", balance.getWalletValueinUSD()));
    }

    public void payLoan(Loan loan, Balance balance) throws BalanceInsufficientException, CurrencyNotFoundException {
        //Pay loan
        loan.getBalance().substractbalance(new Currency("USD", "USD", balance.getWalletValueinUSD()));
        //Substract that amount from client's account
        this.getBalance().substractbalance(new Currency("USD", "USD", balance.getWalletValueinUSD()));
    }

    public void transferToSaving(Saving saving, Balance balance) throws BalanceInsufficientException, CurrencyNotFoundException {
        //Charge fees
        balance.substractbalance(new Currency("USD", "USD", Account.FEE_TRANSACTION_WITHDRAWAL_DEPOSIT));

        //Send balance to saving account
        saving.getBalance().addbalance(new Currency("USD", "USD", balance.getWalletValueinUSD()));

        //Substract that amount from client's account
        this.getBalance().substractbalance(new Currency("USD", "USD", balance.getWalletValueinUSD()));
    }

    public static Checking openAccount(Balance balance) {
        //Charging fees
        try {
            balance.substractbalance(new Currency("USD", "USD", Account.FEE_OPEN_ACCOUNT));
        } catch (BalanceInsufficientException e) {
            throw new RuntimeException(e);
        } catch (CurrencyNotFoundException e) {
            throw new RuntimeException(e);
        }

        return new Checking(Account.ACCOUNT_NUMBER++, false, balance);
    }
}
