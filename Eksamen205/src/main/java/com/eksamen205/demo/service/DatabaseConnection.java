package com.eksamen205.demo.service;

import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

        private static String url;
        private static String user;
        private static int password;

        private Connection conn;

    public DatabaseConnection() {
                Properties prop = new Properties();
                try {
                    prop.load(new FileInputStream("src/main/resources/application.properties"));
//                    user = prop.getProperty("user");
//                    password = prop.getProperty("password");
//                    url = prop.getProperty("url");
                    String userN = "remote";
                    user = userN;
                    int passN = 1234;
                    password = passN;
                    String urln= "jdbc:mariadb://3.122.180.186:3306/Tasks";
                    url = urln;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    int passN = 1234;
                    conn = DriverManager.getConnection(url, user, String.valueOf(passN));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            try {
                int passN = 1234;
                conn = DriverManager.getConnection(url, user, String.valueOf(passN));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        public Connection getConn() {
            return conn;
        }
    }
