package currency;

public class Currency{
   private String name;
   private String symbol;
   private float quantity;

    public Currency(String name, String symbol, float quantity) {
        this.name = name;
        this.symbol = symbol;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}


