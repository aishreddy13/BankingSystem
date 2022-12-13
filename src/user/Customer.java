package user;

import account.*;
import currency.Balance;
import currency.Currency;
import exceptions.BalanceInsufficientException;
import exceptions.CurrencyNotFoundException;
import stocks.Stock;
import stocks.StockMarket;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    //Attributes
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Checking checkingAccount;
    private Saving savingAccount;
    private Security securityAccount;
    private List<Loan> loanAccounts;

    //Constructors
    public Customer(String firstName, String lastName, String email, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.loanAccounts = new ArrayList<>();
    }

    //Methods
    public void deposit(Balance balance) throws BalanceInsufficientException, CurrencyNotFoundException {
        this.getCheckingAccount().deposit(balance);
    }

    public void withdraw(Balance balance) throws BalanceInsufficientException, CurrencyNotFoundException {
        this.getCheckingAccount().withdraw(balance);
    }

    public void transferToSecurity(Balance balance) throws BalanceInsufficientException, CurrencyNotFoundException {
        if(this.canTransferToSecurityAccount(balance)){
            this.getSavingAccount().transferMoney(this.getSecurityAccount(), balance);
        }
    }

    public void createCheckingAccount(Balance balance){
        if(this.getCheckingAccount() == null){
            this.setCheckingAccount( Checking.openAccount(balance));
        }
    }

    public void createSavingAccount(Balance balance){
        if(this.getSavingAccount() == null){
            this.setSavingAccount( Saving.openAccount(balance) );
        }
    }

    // Need a transactions class
    public void viewTransactions(){

    }

    public void requestLoan(Balance balance, boolean collateral){
        this.getLoanAccounts().add(Loan.requestLoan(balance, collateral));
    }

    public void openSecurityAccount(Balance balance){
        if(canOpenSecurityAccount() && balance.getWalletValueinUSD() == 1000){
            this.setSecurityAccount( Security.openAccount(balance) );
        }
    }

    public Account viewAccountDetails(int accountNumber){
        if(this.getCheckingAccount().getAccountNumber() == accountNumber){
            return this.getCheckingAccount();
        }else if(this.getSavingAccount().getAccountNumber() == accountNumber){
            return this.getSavingAccount();
        }else if(this.getSecurityAccount().getAccountNumber() == accountNumber){
            return this.getSecurityAccount();
        }else{
            for(Account account : this.getLoanAccounts()){
                if(account.getAccountNumber() == accountNumber){
                    return account;
                }
            }
        }
        return null;
    }

    public boolean closeAccount(Account account) throws BalanceInsufficientException, CurrencyNotFoundException {
        //Check if client has that account and has no other active security or loan accounts
        if(!this.hasActiveSecurityOrLoanAccount() && ( this.getCheckingAccount() == account || this.getSavingAccount() == account ) ){
            //Charging fees
            account.getBalance().substractbalance(new Currency("USD", "USD", Account.FEE_CLOSE_ACCOUNT));
            //Closing the account
            account.setClosed(true);
            return true;
        }else {
            System.out.println("Client has an active Security/Loan account.");
            return false;
        }
    }

    //Need to fix the stock market class
    public List<Stock> availableStocks(){
        return null;
    }

    public List<Stock> viewOwnStocks(){
        return this.getSecurityAccount().getStocksList();
    }

    //Private Methods
    private boolean canOpenSecurityAccount(){
        if(this.getSavingAccount().getBalance().getWalletValueinUSD() >= 5000){
            return true;
        }
        return false;
    }

    private boolean canTransferToSecurityAccount(Balance balance) throws BalanceInsufficientException, CurrencyNotFoundException {
        float accountBalance = this.getSavingAccount().getBalance().getWalletValueinUSD();
        float amountAfterTransaction = accountBalance - balance.getWalletValueinUSD();
        if( amountAfterTransaction >= 2500){
            return true;
        }
        return false;
    }
    private boolean hasActiveSecurityOrLoanAccount(){
        if(this.getLoanAccounts() != null){
            for(Account account : this.getLoanAccounts()){
                if(!account.isClosed()){
                    return true;
                }
            }
        }
        if(this.getSecurityAccount() != null
                && !this.getSecurityAccount().isClosed()){
            return true;
        }
        return false;
    }

    //Getters and Setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Checking getCheckingAccount() {
        return checkingAccount;
    }
    public void setCheckingAccount(Checking checkingAccount) {
        this.checkingAccount = checkingAccount;
    }
    public Saving getSavingAccount() {
        return savingAccount;
    }
    public void setSavingAccount(Saving savingAccount) {
        this.savingAccount = savingAccount;
    }
    public Security getSecurityAccount() {
        return securityAccount;
    }
    public void setSecurityAccount(Security securityAccount) {
        this.securityAccount = securityAccount;
    }
    public List<Loan> getLoanAccounts() {
        return loanAccounts;
    }
    public void setLoanAccounts(List<Loan> loanAccounts) {
        this.loanAccounts = loanAccounts;
    }
}
