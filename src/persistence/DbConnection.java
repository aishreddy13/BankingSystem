package persistence;


import exceptions.DBConnectionException;
import properties.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
    static Connection connection = null;

    public static ApplicationProperties applicationProperties = new ApplicationProperties() ;

    public DbConnection() throws DBConnectionException {
        connection= getDBConnection();
    }

    public static Connection getConnection() {
        return connection;
    }

    public static Connection getDBConnection() throws DBConnectionException {
        applicationProperties.loadProperties();
        Properties properties = applicationProperties.properties;
        System.out.println("props");
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Establish a connection to the database
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://"+properties.getProperty("db.url")+":3306/Banking", properties.getProperty("db.user"), properties.getProperty("db.password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new DBConnectionException("Exception occured while connecting to db");
        }
        return connection;
    }




}
