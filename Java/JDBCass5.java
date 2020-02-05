/*
Scrollable Result Set 
a. Write an example for scrollable result set with read only mode. 
b. Write an example for updatable result set. 

*/


import java.sql.*;
//set classpath=F:\Software\Java\mysql-connector-java-8.0.18\mysql.jar

class QuestionFive{

  private static final String url = "jdbc:mysql://localhost:3306/classicmodels";
  private static final String user = "root";
  private static final String pwd  = "";

  public static void main(String[] args) {

    String sql = "SELECT * FROM Employees";
    String sql1 = "SELECT id,firstName,lastName FROM Employees";

    try(
      Connection conn = DriverManager.getConnection(url,user,pwd);
      Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
      Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    ) {

        //A) Scrollable Result Set With Read Only Mode
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("\n\nScrollable ResultSet Output\n ");
        rs.first();
        System.out.print("First Record : ");
        System.out.printf("%-10d %-15s %-15s %s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));

        rs.absolute(5);
        System.out.print("Fifth Record : ");
        System.out.printf("%-10d %-15s %-15s %s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));

        rs.last();
        System.out.print("Last Record : ");
        System.out.printf("%-10d %-15s %-15s %s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));


        //B)) Updatable Result Set
        ResultSet result = st.executeQuery(sql1);

        while(result.next()){
          if(result.getInt(1) == 5){  //Find Record Using PK
            result.updateString(2,"Johnny");
            result.updateString(3,"Cook");
            result.updateRow();
            System.out.println("\n\nResult Set Updated Successfully");
          }
        }

        rs.close();
        result.close();
    } catch(Exception e) {
      e.printStackTrace();
    }

  }
}
