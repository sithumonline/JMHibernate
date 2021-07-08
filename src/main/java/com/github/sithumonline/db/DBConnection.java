package com.github.sithumonline.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private Connection conn;
    private static DBConnection dbConnection;

    private DBConnection() {
        String dbURL = "jdbc:mysql://localhost:3306/javadb?useSSL=false";
        String username = "root";
        String password = "mysespw";

        try {
            conn = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public Statement getCreateStatement() throws SQLException {
        return conn.createStatement();
    }

    public static DBConnection getDBConnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
}