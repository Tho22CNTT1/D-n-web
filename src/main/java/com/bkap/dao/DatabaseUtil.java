package com.bkap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
   
    private static String username = "root";
    private static String password = "123456"; 
    private static String url = "jdbc:mysql://localhost:3306/FlowerStore?useSSL=false&serverTimezone=UTC";

    public static Connection getConnect() {
        Connection con = null;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
          
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); 
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return con;
    }

}
