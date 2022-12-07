public class BankAccount {
    protected static double balance;
    public BankAccount() {
        balance = 0;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
