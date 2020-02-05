/*
7. What is DatabaseMetaData? Write an example code. 
*/

import java.sql.*;
//set classpath=F:\Software\Java\mysql-connector-java-8.0.18\mysql.jar

class JDBCass7{

  private static final String url = "jdbc:mysql://localhost:3306/";
  private static final String user = "yogesh";
  private static final String pwd = "yogesh123";

  public static void main(String[] args){

    try(
      Connection conn = DriverManager.getConnection(url,user,pwd);
    ) {
            DatabaseMetaData mdata = conn.getMetaData();

            //A)) Getting Database MetaData From Connection Interface
            System.out.println("\n\nDatabaseMetaData is Given Below\n");
            System.out.println("Driver Version: "+mdata.getDriverVersion());
            System.out.println("Driver Name : "+mdata.getDriverName());
            System.out.println("Product Name :" + mdata.getDatabaseProductName());
            System.out.println("Product Version : "+mdata.getDatabaseProductVersion());
            System.out.println("User Name : " +mdata.getUserName());

    } catch(Exception e) {
        e.printStackTrace();
    }
  }
}
