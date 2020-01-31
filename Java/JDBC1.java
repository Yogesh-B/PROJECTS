/*
User can create a new database and also create new table under that database. Once database has been created then user can perform database operation by calling below functions. 
 a. Connect ......................#Statement
 b. Create Database ................#Statement
 c. Create Table ....................#Statement, PreparedStatement, CallableStatement
 d. Insert Records into respective table..........................#Statement, PreparedStatement, CallableStatement 
 e. Update records of particular table of database .........................#Statement, PreparedStatement, CallableStatement
 f. Delete Records from table .........................................#Statement, PreparedStatement, CallableStatement
 g. Delete table and also database ..................#Statement
 
Use following Java Statement interface to implement program:  
1. Statement  
2. Prepared Statement 
3. Callable Statement 
*/
import java.sql.*;

public class JDBC1
{
            //driver and credentials
    static final String JDBC_driver="com.mysql.jdbc.Driver";
    static final String url="jdbc:mysql://localhost:3306/";
    static final String usr="yogesh";
    static final String passwd="yogesh123";
        
    
    public static void main(String args[])
    {
        Connection conn = null;
		Statement stmt = null;
        PreparedStatement pstmt = null;
        CallableStatement cstmt = null;   
        
         
        try
        {
             
            Class.forName(JDBC_driver);
                    /*(a)connect to database*/
            conn=DriverManager.getConnection(url,usr,passwd);
            String sql;
                    
                    /*(b)create database*/ 
            stmt=conn.createStatement();
            System.out.println("Press Enter To create database & table using Statement");
            System.in.read();
            System.in.skip(System.in.available());
            System.out.println("Creating database and table using Statement...");
            sql="CREATE DATABASE demo";
            stmt.executeUpdate(sql);
            stmt.executeUpdate("USE demo");
            
                    /*(c)create table*/
            sql="CREATE TABLE student (Enroll BIGINT(12),Name VARCHAR(30),Department VARCHAR(10),Semester INT)";
            stmt.executeUpdate(sql);
            System.out.println("CREATED DATABASE AND TABLE USING Statement...\nPress enter to INSERT...");
            System.in.read();                   
            System.in.skip(System.in.available());
            
                   /*(d)insert records using Statement,PreparedStatement,CallableStatement*/
                //...using Statement
            System.out.println("\n\nInserting data...");
            stmt.executeUpdate("INSERT INTO student VALUES(1702001001,'Atul','CE',3)");
            System.out.println("Data Inserted Using Statement...");
                //...using PreparedStatement 
            sql = "INSERT INTO student VALUES(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,1702001002);
            pstmt.setString(2,"Bharat");
            pstmt.setString(3,"EC");
            pstmt.setInt(4,2);
            pstmt.executeUpdate();
            System.out.println("Data Inserted Using PraparedStatement...");
                //...using CallableStatement
            sql = "call demo.Add(?,?,?,?)";
            cstmt=conn.prepareCall(sql);
            cstmt.setInt(1,1702001003);
            cstmt.setString(2,"Chaman");
            cstmt.setString(3,"IC");
            cstmt.setInt(4,6);
            cstmt.executeUpdate();
            System.out.println("Data Inserted Using CallableStatement...\nPress enter to UPDATE...");
            System.in.read();
            System.in.skip(System.in.available());
                
                
                    /*(e)update  records using Statement,PreparedStatement,CallableStatement*/
                //...using Statement
            System.out.println("\n\nUpdating data...");
            stmt.executeUpdate("UPDATE student SET Semester=08 WHERE Enroll=1702001001");
            System.out.println("Data Updated Using Statement...");
                //...using PreparedStatement 
            sql = "UPDATE student SET Semester=? WHERE Enroll=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,07);         
            pstmt.setInt(2,1702001002);
            pstmt.executeUpdate();
            System.out.println("Data Updated Using PraparedStatement...");
                //...using CallableStatement
            sql = "call demo.Change(?,?)";
            cstmt=conn.prepareCall(sql);
            cstmt.setInt(1,1702001003);
            cstmt.setInt(2,06); 
            cstmt.executeUpdate();
            System.out.println("Data Updated Using CallableStatement...\nPress enter to DELETE...");
            System.in.read();                   
            System.in.skip(System.in.available());
            
                    /*(f)delete  records using Statement,PreparedStatement,CallableStatement*/
                //...using Statement
            System.out.println("\n\nDeleting data...");
            stmt.executeUpdate("DELETE FROM Student WHERE Enroll=1702001001");
            System.out.println("Data Deleted Using Statement...");
                //...using PreparedStatement 
            sql = "DELETE FROM Student WHERE Enroll=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,1702001002);
            pstmt.executeUpdate();
            System.out.println("Data Deleted Using PraparedStatement...");
                //...using CallableStatement
            sql = "call demo.Remove(?)";
            cstmt=conn.prepareCall(sql);
            cstmt.setInt(1,1702001003);
            cstmt.executeUpdate();
            System.out.println("Data Deleted Using CallableStatement...\nPress enter to DELETE TABLE...");
            System.in.read();                  
            System.in.skip(System.in.available());
            
                    /*(g)delete table and database*/
            stmt.executeUpdate("DROP TABLE student");
            System.out.println("Table Deleted Using Statement...\nPress enter to DELETE DATABASE...");
            System.in.read();             
            System.in.skip(System.in.available());
            stmt.executeUpdate("DROP DATABASE demo");
            System.out.println("Database Deleted Using Statement...");
            System.in.read();                   
            System.in.skip(System.in.available());
            
            
            //closing all objects
            stmt.close();
            pstmt.close();
            cstmt.close();
            conn.close();
        }
        catch(SQLException se)
        {
			se.printStackTrace();
		}
		catch(Exception e)
        {
			e.printStackTrace();
		}
        finally
        {
            System.out.print("\nExecuted finally\n");
        }
    }
}