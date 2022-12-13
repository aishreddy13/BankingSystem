package account;

import currency.Balance;
import currency.Currency;

public class Loan extends Account {

    //Attributes
    private boolean collateral;

    //Constructors
    public Loan(int accountNumber, boolean closed, Balance balance, boolean collateral){
        super(accountNumber, closed, balance);
        this.collateral = collateral;
    }

    //Methods
    public void chargeInterest() {
        float interestAmount = this.getBalance().getWalletValueinUSD() * Account.CHARGE_INTEREST_ON_LOANS;
        this.getBalance().addbalance(new Currency("USD", "USD", interestAmount));
    }

    public void missedPayements(){
        this.getBalance().addbalance(new Currency("USD", "USD", Account.CHARGE_MISS_LOAN_PAYEMENT));
    }

    public static Loan requestLoan(Balance balance, boolean collateral) {
        return new Loan(Account.ACCOUNT_NUMBER++, false, balance, collateral);
    }
}
