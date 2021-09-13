package com.eksamen02x001.demo.repository;

import com.eksamen02x001.demo.models.ProjectModel;
import com.eksamen02x001.demo.service.DatabaseConnection;


import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProjectRepository {

    private Connection conn;
    private DatabaseConnection DatabaseConnection;

    public ProjectRepository(){ //konstruktør som init'er dbC og conn
        DatabaseConnection = DatabaseConnection.getInstanceOfDatabaseConnection(); //singleton instance (er der en kortere måde?)
        conn = DatabaseConnection.getConn();
    }

    //denne klasse bruges til at give nye projekter et id-tal, som er lig med det højeste id der findes, plus 1.
    public int getHighestNumberOfProjectIdNumberAndAddOne(){
        int temp = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT MAX(idproject_table) FROM project_table;");
            ResultSet rs = stmt.executeQuery();
            rs.next(); //går fra start (null) til den første søjle
         temp = rs.getInt(1); //henter int'en fra den første søjle (der er kun een søjle med een række

        } catch(SQLException e){
            System.out.println("Something went wrong in get new project number max id");
            System.out.println(e.getMessage());
        }
        return ++temp;
    }

    public ArrayList<ProjectModel> getOneProject(int ProjectIDnumber){
        ArrayList<ProjectModel> allProjects = new ArrayList<ProjectModel>();
        try {

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM taskschema.project_table WHERE idproject_table = " + ProjectIDnumber +";");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                ProjectModel tmp = new ProjectModel(
                        rs.getInt(1), //1 henter id)
                        rs.getString(2), //2 henter navn
                        rs.getString(3), //2 henter beskrivelse
                        rs.getString(4), //4 henter projekt ejer navn
                        rs.getInt(5), //5 henter porjekt ejer id
                        rs.getString(6), //henter startdato
                        rs.getString(7), //gdeadline
                        rs.getInt(8));

                allProjects.add(tmp);

            }
        }
        catch(SQLException e){
            System.out.println("Something went wrong in get all projects");
            System.out.println(e.getMessage());
        }
        return allProjects;
    }


    public ArrayList<ProjectModel> GetAllProjects(){
        ArrayList<ProjectModel> allProjects = new ArrayList<ProjectModel>();

        try {

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM project_table");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                ProjectModel tmp = new ProjectModel(
                        rs.getInt(1), //1 henter id)
                        rs.getString(2), //2 henter navn
                        rs.getString(3), //2 henter beskrivelse
                        rs.getString(4), //4 henter projekt ejer navn
                        rs.getInt(5), //5 henter porjekt ejer id
                        rs.getString(6), //henter startdato
                        rs.getString(7), //gdeadline
                        rs.getInt(8));

                allProjects.add(tmp);

            }
        }
        catch(SQLException e){
            System.out.println("Something went wrong in get all projects");
            System.out.println(e.getMessage());
        }
        return allProjects;
    }


    public void deleteProject(int numberOfItemToDelete){

        String combinedStringForSQLUpdate = "DELETE FROM project_table WHERE idproject_table = " + numberOfItemToDelete;

        try {

            PreparedStatement stmt = conn.prepareStatement(combinedStringForSQLUpdate);
            stmt.executeUpdate();

            System.out.println("project deleted succesfully");
        }
        catch(SQLException e){
            System.out.println("Something went wrong in project items");
            System.out.println(e.getMessage());
        }

    }
    public void updateProject(String newName, int IdNumberOfTaskToBeChanged){

        String UpdateForSQL = "UPDATE project_table SET project_name = '" + newName + "' WHERE idproject_table =" + IdNumberOfTaskToBeChanged;
        System.out.println(UpdateForSQL);
        try {

            PreparedStatement stmt = conn.prepareStatement(UpdateForSQL);
            stmt.executeUpdate();

            System.out.println("project updated succesfully");
        }
        catch(SQLException e){
            System.out.println("Something went wrong in update project");
            System.out.println(e.getMessage());
        }
    }

    public void addProjectToDB(ProjectModel pModel)
    {

        String ForSQL = "insert into project_table (project_name, project_description, project_owner, project_ownerID, " +
                "project_startdate, project_deadline, project_iscompleted) " +
                "values ('"+pModel.getProjectName()+"', '" + pModel.getProjectDescription()+"', '" +pModel.getProjectOwner()+
                "', '"+pModel.getProjectOwnerID()+"', '"+pModel.returnProjectStartDate()+"', '"+pModel.returnProjectDeadline()+
                "', '"+pModel.isProjectCompletionStatus()+"')"; //denne er med owner id (som altid er 0, fordi...)

//        String ForSQL = "insert into project_table (project_name, project_description, project_owner, project_ownerID, " +
//                "project_startdate, project_deadline, project_iscompleted) " +
//                "values ('"+pModel.getProjectName()+"', '" + pModel.getProjectDescription()+"', '" +pModel.getProjectOwner()+
//                "', '"+pModel.returnProjectStartDate()+"', '"+pModel.returnProjectDeadline()+
//                "', '"+pModel.isProjectCompletionStatus()+"')"; //denne er uden id


        try {
            PreparedStatement stmt = conn.prepareStatement(ForSQL);
            stmt.executeUpdate();

            System.out.println("project added succesfully");
        }
        catch(SQLException e){
            System.out.println("Something went wrong in addproject to DB");
            System.out.println(e.getMessage());
        }
    }

}

