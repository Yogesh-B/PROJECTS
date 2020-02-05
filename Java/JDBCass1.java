/*
JDBC Statement 
a. To create JDBC Connection only (MySql). 
b. Write a  program to execute and read select queries using JDBC. 
c. Write a program to update a record and give count of updated records in JDBC. 
*/


import  java.sql.*;
import  java.util.Scanner;

class JDBCass1{

  private static final String url = "jdbc:mysql://localhost:3306/classicmodels";
  private static final String user = "yogesh";
  private static final String pwd = "yogesh123";
  private static int counter;

  public static void main(String[] args) {

    System.out.println("\nCreating MYSQL JDBC Connection...\n");
    Scanner input = new Scanner(System.in);

    try(
      //A) Create JDBC Connection
      Connection conn = DriverManager.getConnection(url,user,pwd);
      Statement stmt = conn.createStatement();
    ){

      String sql;

      //B) Execute And Read Select Query
      sql = "SELECT * FROM Employees LIMIT 5;";
      ResultSet result = stmt.executeQuery(sql);
      System.out.printf("%-10s %-15s %-15s %s\n\n","Id","First Name","Last Name","Email");

      while(result.next())
        System.out.printf("%-10d %-15s %-15s %s\n",result.getInt(1),result.getString(2),result.getString(3),result.getString(4));

      //C) Update Records and Give Total Count
      while(true){
        System.out.print("\nPress 0 to Exit Otherwise Enter SQL Query : ");
        sql = input.nextLine();

        if(sql.equals("0"))
            break;
        stmt.executeUpdate(sql);
        counter++;
      }
      System.out.println("\nNumber to Records Updated is : "+counter);
      result.close();
      input.close();
  }
catch(SQLException se){
    se.printStackTrace();
  }
  catch(Exception e){
    e.printStackTrace();
  }
 }
}
