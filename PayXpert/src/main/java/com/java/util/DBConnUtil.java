package com.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnUtil {
	static Connection connection;

    public static Connection getDBConn() {
        try {
            ResourceBundle rb = ResourceBundle.getBundle("db");
            String driver = rb.getString("driver");
            String user = rb.getString("user");
            String pwd = rb.getString("password");
            Class.forName(driver);
            connection = DriverManager.getConnection(DBPropertyUtil.getConnectionString("db"), user, pwd);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {
    	getDBConn();
       
    }

}
