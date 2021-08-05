package com.eksamen204.demo.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseMethods {
    private Connection Conn;

    public DatabaseMethods() {
        DatabaseConnection dbConn = new DatabaseConnection();
        this.Conn = dbConn.getConn();
    }
    public void createNewTask(String taskname){
    String sql = "INSERT INTO Task(Taskdesc) VALUES(?)";
    try  {
        PreparedStatement preparedStatement = Conn.prepareStatement(sql);
        preparedStatement.setString(1, taskname);
        preparedStatement.executeUpdate();

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    }
    public void deleteTask(){

    }
    public void updateTask(){

    }
    public void getAllTasks(){

    }
    public void getAllTasksForUser(){}

    public void markTaskAsStakeholder(){}

}
