/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection; // Đối tượng connect của JDBC (cơ sở dữ liệu MYsql)
import java.sql.DriverManager; // Driver ảo để kết nối tới csdl
import java.sql.SQLException;
import java.sql.Statement; // Đối tượng dùng để thực hiện truy vấn
import java.sql.ResultSet;
/**
 *
 * @author Admin
 */
public class ConnectDB {
      // localhost (cục bộ) -> máy của mình
    // jdbc -> thư viện để kết nối tới db
    // /quan_Ly_khach_san -> tên cở sở dữ liệu của mình A -> a
    private static String DB_URL = "jdbc:mysql://localhost:3306/quan_Ly_khach_san";
    private static String USER_NAME = "root"; // tên người dùng DB
    private static String PASSWORD = "123456";
    
    
    public static Connection getConnection() {
        String dbURL = DB_URL;
        String userName = USER_NAME;
        String password = PASSWORD;
       Connection conn = null;
       try {
           Class.forName("com.mysql.cj.jdbc.Driver"); // Driver mặc định để connect mysql

           conn = DriverManager.getConnection(dbURL, userName, password);
           System.out.println("connect successfully!");
       } catch (Exception ex) {
           System.out.println("connect failure!");
           ex.printStackTrace();
       }
       return conn;
   }

    Statement createStatement() {
           throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
       public static void main(String[] args) throws SQLException {
           Connection connect =  getConnection();// Test connect
           Statement stmt = connect.createStatement(); // Khởi tạo một phiên làm việc
           String sql = "select id, ho_ten from nhan_vien";// thêm/sửa, xoá...
           ResultSet rs = stmt.executeQuery(sql); // ResultSet thành phần để nhận kết quả từ câu truy vấn
           
           while (rs.next()) {//  next tới bản ghi cuối thì dừng
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Họ tên: " + rs.getString("ho_ten"));
           }
    }
}
