package com.eksamen02x001.demo.repository;

import com.eksamen02x001.demo.models.TaskModel;
import com.eksamen02x001.demo.service.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskRepository {
    private Connection conn;
    private DatabaseConnection DatabaseConnection;

    public TaskRepository(){ //konstruktør som init'er dbC og conn
        DatabaseConnection = DatabaseConnection.getInstanceOfDatabaseConnection(); //singleton instance
        conn = DatabaseConnection.getConn();
    }


    public ArrayList<TaskModel> GetAllTasks(){
        ArrayList<TaskModel> allTasks = new ArrayList<TaskModel>();

        try {

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Task_table");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                rs.getInt(1);
                TaskModel tmp = new TaskModel(
                        //rs.getInt(2), //1 henter id, bruges ikke af task-modellen
                        rs.getString(2), //2 henter navn
                        rs.getString(3), //2 henter beskrivelse
                        rs.getInt(4), //4 henter taskens project-forældre ID
                        rs.getInt(5), //5 henter estimat af antal dage indtil færdig
                        rs.getInt(6) //henter om den er færdig eller ej
                );
                allTasks.add(tmp);

            }
        }
        catch(SQLException e){
            System.out.println("Something went wrong in get all Tasks");
            System.out.println(e.getMessage());
        }
        return allTasks;
    }


    public void deleteTask(int numberOfItemToDelete){

        String combinedStringForSQLUpdate = "DELETE FROM Task_table WHERE idTask_table = " + numberOfItemToDelete;

        try {

            PreparedStatement stmt = conn.prepareStatement(combinedStringForSQLUpdate);
            stmt.executeUpdate();

            System.out.println("Task deleted succesfully");
        }
        catch(SQLException e){
            System.out.println("Something went wrong in Task items");
            System.out.println(e.getMessage());
        }

    }
    public void updateTask(String newName, int IdNumberOfTaskToBeChanged){

        String UpdateForSQL = "UPDATE Task_table SET Task_name = '" + newName + "' WHERE idTask_table =" + IdNumberOfTaskToBeChanged;
        System.out.println(UpdateForSQL);
        try {

            PreparedStatement stmt = conn.prepareStatement(UpdateForSQL);
            stmt.executeUpdate();

            System.out.println("Task updated succesfully");
        }
        catch(SQLException e){
            System.out.println("Something went wrong in update Task");
            System.out.println(e.getMessage());
        }
    }

    public void addTaskToDB(TaskModel TaskModel)
    {

        String ForSQL = "insert into Task_table (Task_name, " +
                "Task_description, " +
                "Task_parentProjectID, " +
                "Task_NumberOfDaysToCompletionEstimate, " +
                "Task_iscompleted) " +
                "values ('"+TaskModel.getTaskName()+"', '"
                + TaskModel.getTaskDescription()+"', '"
                +TaskModel.getTaskProjectParentID()+"', '"
                +TaskModel.getNumberOfDaysToCompletionEstimate()+"', '"
                +TaskModel.isTaskCompletionStatus()+"')";

        try {
            PreparedStatement stmt = conn.prepareStatement(ForSQL);
            stmt.executeUpdate();

            System.out.println("Task added succesfully");
        }
        catch(SQLException e){
            System.out.println("Something went wrong in addTask to DB");
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<TaskModel> getAllTasksAssociatedWithProject(int projectNumber) {

        ArrayList<TaskModel> allTasks = new ArrayList<TaskModel>();

        try {

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM taskschema.task_table WHERE task_parentprojectid = " +projectNumber+";");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                rs.getInt(1);
                TaskModel tmp = new TaskModel(
                        //rs.getInt(2), //1 henter id, bruges ikke af task-modellen
                        rs.getString(2), //2 henter navn
                        rs.getString(3), //2 henter beskrivelse
                        rs.getInt(4), //4 henter taskens project-forældre ID
                        rs.getInt(5), //5 henter estimat af antal dage indtil færdig
                        rs.getInt(6) //henter om den er færdig eller ej
                );
                allTasks.add(tmp);
                System.out.println("getAllTasksAssociatedWithProject completed OK");
            }
        }
        catch(SQLException e){
            System.out.println("Something went wrong in getAllTasksAssociatedWithProject");
            System.out.println(e.getMessage());
        }
        return allTasks;
    }
}


