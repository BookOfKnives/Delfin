package com.sqltest01.demo.repo;

import com.sqltest01.demo.models.Department;

import java.sql.*;
import java.util.ArrayList;

public class Repo {


    public ArrayList<Department> getAllDepartments(){
        ArrayList<Department> allDepartments = new ArrayList<Department>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "kodeord");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM dept");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Department tmp = new Department(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                );
                allDepartments.add(tmp);
            }
        }
        catch(SQLException e){
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
        return allDepartments;
    }
}

