/*
4. Batch Update
 a. Write an example for batch update using Statement. 
 b. Write an example for batch update using PreparedStatement

*/



import java.sql.*;
//set classpath=F:\Software\Java\mysql-connector-java-8.0.18\mysql.jar


class JDBCass4{

  private static final String url = "jdbc:mysql://localhost:3306/classicmodels";
  private static final String user = "yogesh";
  private static final String pwd = "yogesh123";

  public static void main(String[] args) {

    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;

    try {

      String sql;
      conn = DriverManager.getConnection(url,user,pwd);
      stmt = conn.createStatement();

      //A)) Batch Update Using Statement Interface
      stmt.addBatch("UPDATE Employees SET firstName ='Harsh' WHERE id = 1");
      stmt.addBatch("INSERT INTO Employees(firstName,lastName,email) VALUES('Johnny','Doe','John@gmail.com')");
      int count[] = stmt.executeBatch();

      if(count[0] == count[1])
        System.out.println("\n\nBatch Update Using Statement is Successfull");

        //B) Batch Update Using Prepared Statement
        sql = "UPDATE Employees SET firstName =? WHERE id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,"Tommy");
        pstmt.setInt(2,1);
        pstmt.addBatch();
        pstmt.setString(1,"Gayle");
        pstmt.setInt(2,2);
        pstmt.addBatch();
        int test[] = pstmt.executeBatch();

        if(test[0] == test[1])
                System.out.println("\n\nBatch Update Using Prepared Statement is Successfull");

        pstmt.close();
        stmt.close();
        conn.close();
      } catch(Exception e) {
        e.printStackTrace();
      }

    }
  }
