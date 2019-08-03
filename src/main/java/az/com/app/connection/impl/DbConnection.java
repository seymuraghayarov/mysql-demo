package az.com.app.connection.impl;

import az.com.app.connection.IConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection implements IConnection {
    private Connection connection;
    private Statement statement;
    public static final String DB_URL = "jdbc:mysql://localhost:3306";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "123456789";
    public static final String ERR_MESSAGE = "Database connection problem %s";

    public boolean connect() {
        try {
            //DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            return true;
        } catch (SQLException e) {
            System.out.printf(ERR_MESSAGE, e.getMessage());
            return false;
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public void closeConnection() {
        try {
            if (connection != null)
                connection.close();
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
