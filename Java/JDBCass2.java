/*
 JDBC Prepared statement. 
 a. Write an example code for JDBC prepared statement using ResultSet. 
 b. How to get primary key value (auto-generated keys) from inserted queries using JDBC? 
*/


import java.sql.*;

class JDBCass2{
  private static final String url = "jdbc:mysql://localhost:3306/classicmodels";
  private static final String user = "yogesh";
  private static final String pwd = "yogesh123";

  public static void main(String[] args) {

    Connection conn = null;
    PreparedStatement pstmt = null;
    try{

      conn = DriverManager.getConnection(url,user,pwd);

      //A)) Prepared Statement with ResultSet
      String sql = "SELECT * FROM Employees WHERE id < ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1,"5");
      ResultSet result = pstmt.executeQuery();
      System.out.printf("%-10s %-15s %-15s %s\n\n","Id","First Name","Last Name","Email");

      while(result.next())
        System.out.printf("%-10d %-15s %-15s %s\n",result.getInt(1),result.getString(2),result.getString(3),result.getString(4));

        //B) Get Auto-Generated Primary Keys Value From JDBC
        sql = "INSERT INTO `Employees`(`firstName`,`lastName`,`email`) VALUES (?,?,?);";
        pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1,"Sonny");
        pstmt.setString(2,"Lee");
        pstmt.setString(3,"lee@gmail.com");
        pstmt.executeUpdate();
        ResultSet rs = pstmt.getGeneratedKeys();
            if(rs != null && rs.next())
                System.out.println("\nGenerated Employee Id: "+rs.getInt(1));

          rs.close();
          pstmt.close();
          conn.close();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
