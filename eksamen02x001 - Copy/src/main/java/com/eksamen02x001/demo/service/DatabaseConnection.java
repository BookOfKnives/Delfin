package com.eksamen02x001.demo.service;


import java.sql.DriverManager;
import java.sql.SQLException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;

import java.util.Properties;

public class DatabaseConnection {

    private static String url;
    private static String user;
    private static String password;

    private static Connection conn;
private static DatabaseConnection DBConnInstance = null;

    public static DatabaseConnection getInstanceOfDatabaseConnection(){
        if(DBConnInstance == null) DBConnInstance = new DatabaseConnection();
        return DBConnInstance;
    }
    private DatabaseConnection() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/application.properties"));
            user = prop.getProperty("username");
            password = prop.getProperty("password");
            url = prop.getProperty("url");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
}
