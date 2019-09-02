package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    private final static String login = "root";
    private final static String password = "password123";
    private final static String url = "jdbc:mysql://localhost:3306/hiperpuntosdb";
    private static DBConnection instance = null;
    private Connection connection = null;

    private DBConnection(){
        if(connection == null){
            try {

                connection = DriverManager.getConnection(url, login, password);
                if(connection != null){
                    System.out.println("Connection OK");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public static DBConnection getInstance(){
        if(instance == null){
            instance = new DBConnection();
        }
        return instance;
    }


    public Connection getConnection() {
        return connection;
    }

    public void closeConnection(){
        instance = null;
    }
}
