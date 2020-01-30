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

public class JDBC1
{
            //driver and credentials
    static final String JDBC_driver="com.mysql.jdbc.Driver";
    static final String url="jdbc:mysql://localhost:3306/test2";
    static final String usr="yogesh";
    static final String passwd="yogesh123";
        
    
    public static void main(String args[])
    {
        Connection conn = null;
		Statement stmt = null;
        PreparedStatement pstmt = null;
        CallableStatement cstmt = null;   
        
         String query="select * from branch";
        try{
            Class.forName(JDBC_driver);
            conn=DriverManager.getConnection(url,usr,passwd);
            stmt=conn.createStatement();
            
         
            
            
            
            rs.close();
            stmt.close();
            pstmt.close();
            cstmt.close();
            conn.close();
        }
        catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
        finally
        {
            System.out.print("\nExecuted finally\n");
        }
    }
}