package com.ky.dao;

import com.ky.database.ConnectDB;
import com.ky.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static void addUser(User user) {
        String sql = "INSERT INTO users (username,email,password,picture) VALUES(?,?,?,?)";
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4,user.getPicture());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean auth(String username, String password){
        boolean staus=false;
        String sql = "SELECT username,password FROM users WHERE username=? AND password=?";
        try{
            Connection con = ConnectDB.connect();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                staus=true;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staus;
    }
}
