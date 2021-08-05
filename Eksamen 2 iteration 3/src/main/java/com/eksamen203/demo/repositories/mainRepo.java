package com.eksamen203.demo.repositories;

import com.eksamen203.demo.model.Task;
import com.eksamen203.demo.services.DatabaseConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mainRepo {
 private Connection Conn;

    public mainRepo(){
        DatabaseConnection databaseConnection = new DatabaseConnection();
     this.Conn = databaseConnection.getConn();
 }

 public void createNewTask(String TaskName){
        String sql = "INSERT INTO Task(Taskdesc) VALUES(?)"; //prøver at fjerne name
     try {
         PreparedStatement preparedStatement = Conn.prepareStatement(sql);
         preparedStatement.setString(1, TaskName);
         preparedStatement.executeUpdate();

     } catch (SQLException throwables) {
         throwables.printStackTrace();
     }
 }
 public void createNewTask2(String TaskDescription){ //test af denne funktion
        String sql = "INSERT INTO Task(TaskDescription) VALUES(?)";
     try {
         PreparedStatement preparedStatement = Conn.prepareStatement(sql);
         preparedStatement.setString(1, TaskDescription);
         preparedStatement.executeUpdate();

     } catch (SQLException throwables) {
         throwables.printStackTrace();
     }
 } public void checkTables(){
             String sql = "Show fields from Task;";
     try {
         PreparedStatement preparedStatement = Conn.prepareStatement(sql);
         //preparedStatement.setString(1, TaskDescription);
          ResultSet rs = preparedStatement.executeQuery();
          while (rs.next()){
              System.out.println(rs.getString(2));
          }


     } catch (SQLException throwables) {
         throwables.printStackTrace();
     }
 }

 }


