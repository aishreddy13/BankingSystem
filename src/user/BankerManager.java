package user;

import stocks.Stock;
import stocks.StockMarket;

public class BankerManager {

    //Attributes
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    //Constructors
    public BankerManager(String firstName, String lastName, String email, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    //Methods
        //Need database connection
    public void findCustomer(){

    }
        //Need database connection
    public int numbPeopleWithLoans(){
        return 0;
    }
        //Need database connection
    public int numbPeopleWithStocks(){
        return 0;
    }

    public boolean acceptLoan(boolean collateral){
        if(collateral){
            return true;
        }
        return false;
    }
        //Need Transaction class
    public void dailyTransaction(){
        //return null;
    }
        // StockMarket class not yet finished
    public void addStockToMarket(StockMarket stockMarket, Stock stock){

    }

    // StockMarket class not yet finished
    public void removeStockFromMarket(StockMarket stockMarket, Stock stock){

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
}
