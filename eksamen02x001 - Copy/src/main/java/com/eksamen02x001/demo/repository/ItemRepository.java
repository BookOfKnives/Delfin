package com.eksamen02x001.demo.repository;

import com.eksamen02x001.demo.models.Item;
import com.eksamen02x001.demo.service.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;

public class ItemRepository {
    private Connection conn;
    private DatabaseConnection DatabaseConnection;

    public ItemRepository(){ //konstruktør som init'er dbC og conn
         DatabaseConnection = com.eksamen02x001.demo.service.DatabaseConnection.getInstanceOfDatabaseConnection(); //singleton instance (er der en kortere måde?)
        conn = DatabaseConnection.getConn();
    }

    public ArrayList<Item> getAllItems(){
        ArrayList<Item> allItems = new ArrayList<Item>();
        try {

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM item_table");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Item tmp = new Item(

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


    public void deleteItem(int numberOfItemToDelete){

        String combinedStringForSQLUpdate = "DELETE FROM item_table WHERE iditem_table = " + numberOfItemToDelete;

        try {

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

            PreparedStatement stmt = conn.prepareStatement(ForSQL);
            stmt.executeUpdate();

            System.out.println("Item deleted succesfully");
        }
        catch(SQLException e){
            System.out.println("Something went wrong in add items");
            System.out.println(e.getMessage());
        }

    }

}

