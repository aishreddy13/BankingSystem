package persistence;

import exceptions.ConversionRateNotFoundException;
import exceptions.DBConnectionException;
import exceptions.DBQueryExecutionException;
import netscape.javascript.JSObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class DbCurrencyExchangeRateFetcher {

    static DbConnection dbConnection= new DbConnection();




    Connection connection = dbConnection.getConnection();

    public float fetchExchangeRate(String from, String to) throws DBQueryExecutionException, ConversionRateNotFoundException {
        String query = "select * from currencyexchangerate where currencyName="+from;
        ResultSet results=null;
        try {

            Statement sqlSt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            results=sqlSt.executeQuery(query);
            String rateString = results.getString("currencyConversionRate");
            Map<String, String> collect = Arrays.stream(rateString.split(","))
                    .map(s -> s.split(":", 2))
                    .collect(Collectors.toMap(a -> a[0], a -> a.length > 1 ? a[1] : ""));
            if (collect.containsKey(to))
            {
                return Float.parseFloat( collect.get(to));
            }
            else {
                System.out.println("Cannot be converted");
                throw new ConversionRateNotFoundException("No conversion rate found for "+from + "  " + to);
            }
        }catch (ConversionRateNotFoundException conversionRateNotFoundException)
        {
            throw conversionRateNotFoundException;
        }
        catch (Exception e)
        {
            throw new DBQueryExecutionException("Exception occured while executing the query :"+query);
        }
    }

}
