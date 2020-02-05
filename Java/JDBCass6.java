/*

6. BLOB Write an example for inserting BLOB into table and reading BLOB from table. 
*/

import java.sql.*;
import java.io.*;
//set classpath=F:\Software\Java\mysql-connector-java-8.0.18\mysql.jar

class QuestionSix{

  private static final String url = "jdbc:mysql://localhost:3306/classicmodels";
  private static final String user = "root";
  private static final String pwd = "";

  public static void main(String[] args) throws  FileNotFoundException{
    String sql = "INSERT INTO Employees(firstName,lastName,email,resume) VALUES(?,?,?,?)";

    InputStream is = new FileInputStream(new File("img/photo.jpg"));
    try(
      Connection conn = DriverManager.getConnection(url,user,pwd);
      Statement stmt = conn.createStatement();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      InputStream in = new FileInputStream(new File("img/photo.jpg"));
      OutputStream os = new FileOutputStream(new File("img/new_photo.jpg"));
    ) {

      //A) Insertion of BLOB in DB Table
      pstmt.setString(1,"Hawk");
      pstmt.setString(2,"Eye");
      pstmt.setString(3,"HawkEye@gmail.com");
      pstmt.setBinaryStream(4,in);
      int count = pstmt.executeUpdate();

      if(count == 1)
        System.out.println("\n\nBLOB Inserted Succesfully");

        //B) Reading of BLOB From DB Table
        sql  = "SELECT resume FROM Employees WHERE firstName='Hawk' AND resume != NULL";
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
               is = rs.getBinaryStream(1);
            }
            byte[] content = new byte[1024];
            int size = 0;
            while((size = is.read(content)) != -1)
                os.write(content,0,size);
          System.out.println("\n\nBLOB is Succesfully Read From DB Table");
          is.close();

    } catch(Exception e) {
        e.printStackTrace();
    }
  }
}
