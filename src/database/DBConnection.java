package database;

import java.sql.*;

// Class to establish connection to DB
public class DBConnection {
    // Create variable to hold our connection
    Connection con;
    
    // implement code in constructor so that
    // connectin is established whenever class is instantiated
    public DBConnection(){
        
        // Step 1: Load Driver
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded successfully");
        }catch(ClassNotFoundException cnfe){
            System.out.println("Driver loading failed "+cnfe.getMessage());
        }
        
        // Step 2: Establish Connection
            // api:dbms://server:port/dbname
            // jdbc:postgresql://localhost:5432:/university
        String url = "jdbc:postgresql://localhost:5432/university";
        String user = "postgres";
        String password = "Jeruto";
        
        try{
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully");
        }catch(SQLException sqle){
            System.out.println("Connection Failed: "+sqle.getMessage());
        }
        
        
    }
    
}