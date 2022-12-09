package exceptions;

public class DBConnectionException extends RuntimeException{
    public DBConnectionException(String s) {
        super(s);
    }
}
