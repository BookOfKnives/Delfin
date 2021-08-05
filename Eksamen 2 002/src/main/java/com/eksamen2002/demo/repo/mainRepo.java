package com.eksamen2002.demo.repo;

import com.eksamen2002.demo.model.Project;

import java.sql.*;
import java.util.ArrayList;

public class mainRepo {
//OG RETTE DE HER TINGdepartment
    //main repo bruges til at hente til og fra databasen med opgaver
    public ArrayList<Project> getAllDepartments(){
        ArrayList<Project> allDepartments = new ArrayList<Project>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "kodeord");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM dept");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Project tmp = new Project(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                );
                allDepartments.add(tmp); //fix all-dep
            }
        }
        catch(SQLException e){
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
        return allDepartments; //fix all-dpe
    }
}

