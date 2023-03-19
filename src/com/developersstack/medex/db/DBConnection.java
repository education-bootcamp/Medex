package com.developersstack.medex.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // 1 private static reference var
    private static DBConnection dbConnection;
    private Connection connection;
    // constructor private
    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/medex",
                "root",
                "1234" );
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        /*if (dbConnection==null){
            dbConnection= new DBConnection();
        }
        return dbConnection;*/
        return dbConnection==null?(dbConnection= new DBConnection()):dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }

}
