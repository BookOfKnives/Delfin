package com.eksamen205.demo.repo;

import com.eksamen205.demo.model.Task;
import com.eksamen205.demo.model.User;
import com.eksamen205.demo.service.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class databaseMethods {
    private Connection conn;
    private DatabaseConnection databaseConnection;

    public databaseMethods() {
        databaseConnection = new DatabaseConnection();
        this.conn = databaseConnection.getConn();
    }

    public void createNewTask(String TaskName) {
        String sql = "INSERT INTO TaskTable(TaskDesc) VALUES(?)"; //prøver at fjerne name
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, TaskName);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean checkIfUserExists(String usernameFromLogin) {
        //System.out.println("start of Check");
        Map<String, User> userMap = getUserMap();
        return userMap.containsKey(usernameFromLogin);
    }

    public Map<String, User> getUserMap() {
        System.out.println("start of Usermap");
        Map<String, User> userMap = new HashMap<>();

        try {
            PreparedStatement preparedStatement;
           preparedStatement = conn.prepareStatement("SELECT * FROM UserTable");

            //System.out.println("Start of try");
            ResultSet resultSet = preparedStatement.executeQuery();
            //System.out.println("mid try");
            while (resultSet.next()) {
                int userID = resultSet.getInt(1);
                //System.out.println("this user is " +userID);
                String username = resultSet.getString(2);
                //System.out.println("this user name is " + username);

                User tempUser = new User(userID, username);

                userMap.put(username, tempUser); // bruger "username" som key
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userMap;
    }

    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> taskArrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM TaskTable");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int taskID = resultSet.getInt(1);
                String taskDesc = resultSet.getString(2);

                Task tempTask = new Task(taskID, taskDesc);
                taskArrayList.add(tempTask);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return taskArrayList;
    }
}
