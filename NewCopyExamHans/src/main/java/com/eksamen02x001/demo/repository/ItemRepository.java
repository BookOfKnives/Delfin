package com.eksamen02x001.demo.repository;

import com.eksamen02x001.demo.models.Item;
import com.eksamen02x001.demo.service.DatabaseConnection;
import com.eksamen02x001.demo.service.DatabaseConnectionServiceClass;

import java.sql.*;
import java.util.ArrayList;

public class ItemRepository {
    private Connection conn;
    private DatabaseConnection DatabaseConnection;
    public ArrayList<Item> getAllItems(){
        ArrayList<Item> allItems = new ArrayList<Item>();
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskschema", "root", "enter");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM item_table");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Item tmp = new Item(
                       // rs.getInt(1),
                        rs.getInt(1), //1 henter ID
                        rs.getString(2), //2 henter navn
                        rs.getString(3) //2 henter beskrivelse
                );
                allItems.add(tmp);

            }
        }
        catch(SQLException e){
            System.out.println("Something went wrong in getallitems");
            System.out.println(e.getMessage());
        }
        return allItems;
    }
//public ArrayList<Item> getAllItems(){
//        ArrayList<Item> allItems = new ArrayList<Item>();
//        try {
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskschema", "root", "enter");
//            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM item_table");
//            ResultSet rs = stmt.executeQuery();
//            while(rs.next()){
//                Item tmp = new Item(
//                       // rs.getInt(1),
//                        rs.getString(1), //1 henter ID
//                        rs.getString(2) //2 henter beskrivelse
//                );
//                allItems.add(tmp);
//            }
//        }
//        catch(SQLException e){
//            System.out.println("Something went wrong in getallitems");
//            System.out.println(e.getMessage());
//        }
//        return allItems;
//    }

    public void deleteItem(int numberOfItemToDelete){

        String combinedStringForSQLUpdate = "DELETE FROM item_table WHERE iditem_table = " + numberOfItemToDelete;

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskschema", "root", "enter");
            PreparedStatement stmt = conn.prepareStatement(combinedStringForSQLUpdate);
            stmt.executeUpdate();

            System.out.println("Item deleted succesfully");
        }
        catch(SQLException e){
            System.out.println("Something went wrong in delete items");
            System.out.println(e.getMessage());
        }

    }
    public void updateItem(String newName, int IdNumberOfTaskToBeChanged){

        String UpdateForSQL = "UPDATE item_table SET item_name = '" + newName + "' WHERE iditem_table =" + IdNumberOfTaskToBeChanged;
        System.out.println(UpdateForSQL);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskschema", "root", "enter");
            PreparedStatement stmt = conn.prepareStatement(UpdateForSQL);
            stmt.executeUpdate();

            System.out.println("Item updated succesfully");
        }
        catch(SQLException e){
            System.out.println("Something went wrong in update items");
            System.out.println(e.getMessage());
        }
    }

    public void addItem(String newItemName, String newItemDescription)
    {


        String ForSQL = "insert into item_table (item_name, item_description) values ('"+newItemName+"', '" + newItemDescription + "')";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskschema", "root", "enter");
            PreparedStatement stmt = conn.prepareStatement(ForSQL);
            stmt.executeUpdate();

            System.out.println("Item deleted succesfully");
        }
        catch(SQLException e){
            System.out.println("Something went wrong in add items");
            System.out.println(e.getMessage());
        }

    }

    public int doesUserExist(String username) {
        int[] resultSetInarray = new int[1];
        //String ForSQL = "SELECT count(*) FROM item_table WHERE item_name ='" + username + "';";
        String ForSQL = "SELECT count(*) FROM item_table WHERE item_name ='hahshshs'";
        int UserIDCheck = 0;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskschema", "root", "enter");
            PreparedStatement stmt = conn.prepareStatement(ForSQL);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            System.out.println("username chcekd ok"+ resultSet.getInt(1));
            //System.out.println("print from doesUserExist: value of resultset first int:" + resultSet.getInt(1));
            System.out.println("username chcekd ok");
        }
        catch(SQLException e){
            System.out.println("Something went wrong inusername chcekd ok");
            System.out.println(e.getMessage());
        }
        if (resultSetInarray[0] == 0) return -1; //hvis der ikke er nogen hits på tælleren, så returner -1 (som negativ)
    return resultSetInarray[0]; //ellers, return det ene hit, der vil være i arrayet.
    }
}

