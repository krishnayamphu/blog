package com.ky.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserTable {
    static Connection cn;
    public static void create(){
        try {
            cn=ConnectDB.connect();
            String sql="CREATE TABLE users (id int PRIMARY KEY AUTO_INCREMENT, username VARCHAR(30) NOT NULL,email VARCHAR(256) NOT NULL,password VARCHAR(256) NOT NULL, picture VARCHAR(256), created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, UNIQUE(username),UNIQUE(email))";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("User table created");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void drop(){
        try {
            cn=ConnectDB.connect();
            String sql="DROP TABLE users";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("User table deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
