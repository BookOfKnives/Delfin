package com.eksamen02x001.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionServiceClass {
    private static String url = "jdbc:mysql://localhost:3306/taskschema";
    private static String user = "root";
    private static String password = "enter";

    private Connection conn;

    public Connection DatabaseConnectionMethod() {


        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
}