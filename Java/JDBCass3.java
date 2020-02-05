/*
 JDBC Callable Statement 
 a. Write a simple program for CallableStatement statement to execute stored procedure. 
 b. Write a program for CallableStatement statement with stored procedure returns OUT parameters. 
 c. Write a program for CallableStatement statement with batch execution. 
 d. Write a program to execute SQL function using CallableStatement. 
 e. Write a program to execute SQL cursors using CallableStatement. 
 f. How to get column properties from ResultSet using ResultSetMetaData. 
*/


import java.sql.*;
//set classpath=F:\Software\Java\mysql-connector-java-8.0.18\mysql.jar

class JDBCass3{

  private static final String url = "jdbc:mysql://localhost:3306/classicmodels";
  private static final String user = "yogesh";
  private static final String pwd = "yogesh123";

    public static void main(String[] args) {

      Connection conn = null;
      CallableStatement cstmt = null;

      try{

        String sql;
        conn = DriverManager.getConnection(url,user,pwd);

        // A)) Calling Stored Procedure
        sql = "{CALL `Add`(?,?,?)}";
        cstmt = conn.prepareCall(sql);
        cstmt.setString(1,"John");
        cstmt.setString(2,"Doe");
        cstmt.setString(3,"JohnDoe@gmail.com");
        cstmt.executeUpdate();
        System.out.printf("\nSuccessfully Called Stored Procedure");

          // B) Calling Stored Procedure With Return Values
          sql = "{CALL `totalRecords`(?)}";
          cstmt = conn.prepareCall(sql);
          cstmt.registerOutParameter(1,Types.INTEGER);
          cstmt.executeUpdate();
          System.out.println("\n\nTotal Number of Records In Table Is : " + cstmt.getInt(1));

          // C) Callable With Batch Execution
          sql = "{CALL `Add`(?,?,?)}";
          cstmt = conn.prepareCall(sql);
          cstmt.setString(1,"Tony");
          cstmt.setString(2,"Stark");
          cstmt.setString(3,"Ironman@gmail.com");
          cstmt.addBatch();
          cstmt.setString(1,"Bruce");
          cstmt.setString(2,"Banner");
          cstmt.setString(3,"Hulk@gmail.com");
          cstmt.addBatch();
          int i[] = cstmt.executeBatch();
          if(i[0] ==  i[1])
            System.out.println("\n\nBatch Execution Is Successfully");

          // D) Callable With SQL Function
          sql = "{? = CALL `totalNameStartingWith`(?)}";
          cstmt = conn.prepareCall(sql);
          cstmt.registerOutParameter(1,Types.INTEGER);
          cstmt.setString(2,"L%");
          cstmt.executeUpdate();
          System.out.println("\n\nNumber of Employee's Name Starting With L Is : "+cstmt.getInt(1));

          // E)) Callable With SQL Cursor
          sql = "{CALL `curdemo`(?)}";
          cstmt = conn.prepareCall(sql);
          cstmt.setString(1,"");
          cstmt.registerOutParameter(1,Types.VARCHAR);
          int rs =  cstmt.executeUpdate();
              if(rs == 0){
                System.out.println("\n\nCallable With Cursor is Executed Successfully");
              }


          //F)) Getting Column Properties From ResultSetMetaData
          sql = "SELECT * FROM Employees";
          Statement stmt = conn.createStatement();
          ResultSet result = stmt.executeQuery(sql);
          ResultSetMetaData rsmd = result.getMetaData();
          int columnCount = rsmd.getColumnCount();
          System.out.println("\n\nTable Name id : "+rsmd.getTableName(1));
          System.out.println("Total Column are : "+columnCount);
           for(int j=1;j<=columnCount;j++)
               System.out.println(rsmd.getColumnName(j)+" "+rsmd.getColumnTypeName(j));

               stmt.close();
               result.close();
               cstmt.close();
               conn.close();
             } catch(Exception e) {
               e.printStackTrace();
             }
           }
         }


