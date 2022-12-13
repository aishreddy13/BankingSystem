package account;

import currency.Balance;
import transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    //Attributes
    private int accountNumber;
    private boolean closed;
    private Balance balance;
    private List<Transaction> transactions;

    //Static Attributes
    protected static int ACCOUNT_NUMBER = 0;
    public static float FEE_OPEN_ACCOUNT = 20;
    public static float FEE_CLOSE_ACCOUNT = 20;
    public static float FEE_TRANSFER_AMOUNT = 20;
    public static float PAY_INTEREST_TO_SAVING_ACCOUNTS = 0.5f;
    public static float FEE_TRANSACTION_WITHDRAWAL_DEPOSIT = 2;
    public static float CHARGE_INTEREST_ON_LOANS = 0.2f;
    public static float CHARGE_MISS_LOAN_PAYEMENT = 40f;

    //Constructors
    public Account(int accountNumber, boolean closed, Balance balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.closed = closed;
        this.transactions = new ArrayList<>();
    }

    //Methods



    //Getters and Setters
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public Balance getBalance() {
        return balance;
    }
    public void setBalance(Balance balance) {
        this.balance = balance;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    public boolean isClosed() {
        return closed;
    }
    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}