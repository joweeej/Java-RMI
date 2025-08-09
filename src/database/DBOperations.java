package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {
    
    // Create or Insert
    public String insertOperation(int id, String name, String course){
        
        String output = "";
        
        try{
            // Step 3: Create statement
            String query = " INSERT INTO students (sid, sname, scourse) VALUES (?,?,?)";

            DBConnection dbc = new DBConnection();
            PreparedStatement pst = dbc.con.prepareStatement(query);
            pst.setInt(1,id);
            pst.setString(2,name);
            pst.setString(3, course);
            
            // Step 4: Execute statement
            boolean result = pst.execute();
            
            if(!result){
                output = "Insert successful";
                System.out.println("Insert successful");
            }else{
                output = "insert failed";
                System.out.println("insert failed");
            }
            // Step 5: Process result set

            // Step 6: Close connection
            dbc.con.close();
            
        }catch(SQLException sqle){
            output = "Insert operation failed:\n "+sqle.getMessage();
            System.out.println("Insert operation failed: "+sqle.getMessage());
        }
        return output;
    }
    
    // Read or Select
    public String[] selectOperation(int id){ 
        
        // Array to hold retrieved values - upto 3 values
        String[] output = new String[3];
        
        try{
            // Step 3: Create Statement
            String query = "SELECT * FROM students WHERE sid = ?";

            DBConnection dbc = new DBConnection();
            PreparedStatement pst = dbc.con.prepareStatement(query);
            pst.setInt(1, id);
            
            // Step 4: Execute Statement
            ResultSet rs = pst.executeQuery();
            
            // Step 5: Process ResultSet
            
            while(rs.next()){
                String sid = rs.getString("sid");
                String sname = rs.getString("sname");
                String scourse = rs.getString("scourse");
                
                // attach retrieved values to array
                output[0] = sid;
                output[1] = sname;
                output[2] = scourse;
                
                System.out.println(sid+" "+sname+" "+scourse);
            }
            // Step 6: Close Connection
            dbc.con.close();
            
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
            // return array
        return output;
    }
    
    // Select All
    public ArrayList<String> selectAllOperation(){ 
        
        // Array to hold retrieved values
        ArrayList<String> output = new ArrayList<>();
        
        try{
            // Step 3: Create Statement
            String query = "SELECT * FROM students";

            DBConnection dbc = new DBConnection();
            PreparedStatement pst = dbc.con.prepareStatement(query);
            
            // Step 4: Execute Statement
            ResultSet rs = pst.executeQuery();
            
            // Step 5: Process ResultSet
            
            while(rs.next()){
                String sid = rs.getString("sid");
                String sname = rs.getString("sname");
                String scourse = rs.getString("scourse");
                
                
                // attach retrieved values to array
                String record = "\t"+sid+"\t"+sname+"\t"+scourse;
                output.add(record);
                
                //System.out.println(sid+" "+sname+" "+scourse);
            }
            // Step 6: Close Connection
            dbc.con.close();
            
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
            // return array
        return output;
    }
    
    // Update or Alter
    public String updateOperation(int oldId, int newId, String name, String course){
        
        String output = "";
        
        try{
            // step 3: create statement
            String query = "UPDATE students SET sid = ?, sname = ?, scourse = ? WHERE sid = ?;";
            
            DBConnection dbc = new DBConnection();
            PreparedStatement pst = dbc.con.prepareStatement(query);
            pst.setInt(1, newId);
            pst.setString(2, name);
            pst.setString(3, course);
            pst.setInt(4, oldId);
            
            // step 4: execute statement
            int rows = pst.executeUpdate();
            output = rows+" row(s) updated successfully";
            System.out.println(rows+" row(s) updated successfully");
            // step 5: process resultset
            // step 6: close connection
            dbc.con.close();
        }catch(SQLException sqle){
            output = "Update failed \n: "+sqle.getMessage();
            System.out.println("Update failed: "+sqle.getMessage());
        }
        return output;
    }
    
    // Delete or Drop
    public void deleteOperation(int id){
        
        String output = "";
        
        try{
            // step 3: create statement
            String query = "DELETE FROM students WHERE sid = ?;";
            
            DBConnection dbc = new DBConnection();
            PreparedStatement pst = dbc.con.prepareStatement(query);
            pst.setInt(1,id);
            
            // step 4: execute statement
            int rows = pst.executeUpdate();
            
            output = rows+" row(s) deleted successfully";
            System.out.println(rows+" row(s) deleted successfully");
            
            // step 6: close connection
            dbc.con.close();
        }catch(SQLException sqle){
            output = "Delete Operation Failed:\n "+sqle.getMessage();
            System.out.println("Delete Operation Failed: "+sqle.getMessage());
        }
    }
    
    
    
    
}