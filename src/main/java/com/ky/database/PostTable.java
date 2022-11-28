package com.ky.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PostTable {
    static Connection cn;
    public static void create(){
        try {
            cn=ConnectDB.connect();
            String sql="CREATE TABLE posts (id int PRIMARY KEY AUTO_INCREMENT, title VARCHAR(256) NOT NULL,content text,user_id int NOT NULL, picture VARCHAR(256), created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, UNIQUE(title))";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Blog table created");
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
            String sql="DROP TABLE posts";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Blog table deleted");
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
