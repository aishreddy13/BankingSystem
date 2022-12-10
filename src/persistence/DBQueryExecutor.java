package persistence;


import exceptions.DBQueryExecutionException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;


public class DBQueryExecutor {
    static DbConnection dbConnection= new DbConnection();
    Connection connection = dbConnection.getConnection();

    public void executeDBInsertQuery(String query) throws DBQueryExecutionException {
        ResultSet results=null;
        try {
            Statement sqlSt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            results=sqlSt.executeQuery(query);
        } catch (Exception e)
        {
            throw new DBQueryExecutionException("Exception occured while executing the query :"+query);
        }
    }

    public List<String> searchDBWithQuery(String query) throws DBQueryExecutionException {
        ResultSet results=null;
        List<String> response = new ArrayList<>();
        try {

            Statement sqlSt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            results=sqlSt.executeQuery(query);
            while (results.next())
            {
                String rateString = results.getString("currencyConversionRate");
                response.add(rateString);
            }
        } catch (Exception e)
        {
            throw new DBQueryExecutionException("Exception occured while executing the query :"+query);
        }
        return response;
    }
}
