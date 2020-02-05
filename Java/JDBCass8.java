/*
How to get JDBC Connection object using properties file.
*/

import java.sql.*;
import java.util.Properties;
//set classpath=F:\Software\Java\mysql-connector-java-8.0.18\mysql.jar

class QuestionEight{

  private static final String url = "jdbc:mysql://localhost:3306/";

  public static void main(String[] args){

        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "");
        try(
          Connection con = DriverManager.getConnection(url,prop);
        ){
            System.out.println("\n\nConnection Establish Successfully Using Properties");
        } catch (SQLException e) {
            e.printStackTrace();
        }
  }
}
