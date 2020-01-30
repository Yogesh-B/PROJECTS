/*
User can create a new database and also create new table under that database. Once database has been created then user can perform database operation by calling below functions. 
 a. Connect ......................#Statement
 b. Create Database ................#Statement
 c. Create Table ....................#Statement, PreparedStatement, CallableStatement
 d. Insert Records into respective table..........................#Statement, PreparedStatement, CallableStatement 
 e. Update records of particular table of database .........................#Statement, PreparedStatement, CallableStatement
 f. Delete Records from table .........................................#Statement, PreparedStatement, CallableStatement
 g. Delete table and also database ..................#PreparedStatement
 
Use following Java Statement interface to implement program:  
1. Statement  
2. Prepared Statement 
3. Callable Statement 
*/
import java.sql.*;
import java.util.Scanner;

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
        
         
        try{
            
            Class.forName(JDBC_driver);
            conn=DriverManager.getConnection(url,usr,passwd);
            String sql;
            Scanner sc=new Scanner(System.in);
                    /*(a)create database*/ 
            stmt=conn.createStatement();
            System.out.println("Enter 1 & Press Enter To create database & table using Statement");
            System.out.println("Creating database and table using Statement...");
            sql="CREATE DATABASE demo";
            stmt.executeUpdate(sql);
            stmt.executeUpdate("USE demo");
            
                    /*(b)create table*/
            sql="CREATE TABLE student (Enroll BIGINT(12),Name VARCHAR(30),Department VARCHAR(10),Semester INT)";
            stmt.executeUpdate(sql);
            System.out.println("CREATED DATABASE AND TABLE USING Statement...\nEnter 1 and press enter to continue...");
            int n=sc.nextInt();//for getting EnterKey
                   
                   
                   /*(c)insert records using Statement,PreparedStatement,CallableStatement*/
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
            System.out.println("Data Inserted Using CallableStatement...");
                
                
                    /*(d)update  records using Statement,PreparedStatement,CallableStatement*/
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
            cstmt.setString(2,06); 
            cstmt.executeUpdate();
            System.out.println("Data Updated Using CallableStatement...");
 
            
                    /*(e)delete  records using Statement,PreparedStatement,CallableStatement*/
                //...using Statement
            System.out.println("\n\nDeleting data...");
            stmt.executeUpdate("DELETE FROM Student WHERE Enroll=1702001001");
            System.out.println("Data Deleted Using Statement...");
                //...using PreparedStatement 
            sql = "DELETE FROM Student WHERE Enroll=?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,1702001002);
            pstmt.executeUpdate();
            System.out.println("Data Deleted Using PraparedStatement...");
                //...using CallableStatement
            sql = "call demo.Remove(?)";
            cstmt=conn.prepareCall(sql);
            cstmt.setInt(1,1702001003);
            cstmt.executeUpdate();
            System.out.println("Data Deleted Using CallableStatement...");
            
            
            
            
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