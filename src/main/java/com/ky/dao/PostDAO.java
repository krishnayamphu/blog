package com.ky.dao;

import com.ky.database.ConnectDB;
import com.ky.models.Post;
import com.ky.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostDAO {
    public static ArrayList<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM posts ORDER BY id DESC";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setUserId(rs.getInt("user_id"));
                post.setPicture(rs.getString("picture"));
                post.setCreatedAt(rs.getString("created_at"));
                post.setUpdatedAt(rs.getString("updated_at"));
                posts.add(post);
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return posts;
    }

    public static ArrayList<Post> getLatestPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM posts ORDER BY id DESC LIMIT 5";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setUserId(rs.getInt("user_id"));
                post.setPicture(rs.getString("picture"));
                post.setCreatedAt(rs.getString("created_at"));
                post.setUpdatedAt(rs.getString("updated_at"));
                posts.add(post);
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return posts;
    }

    public static Post getPost(int id) {
        Post post = new Post();
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM posts WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setUserId(rs.getInt("user_id"));
                post.setPicture(rs.getString("picture"));
                post.setCreatedAt(rs.getString("created_at"));
                post.setUpdatedAt(rs.getString("updated_at"));
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return post;
    }

    public static void addPost(Post post) {
        String sql = "INSERT INTO posts (title,content,user_id,picture) VALUES(?,?,?,?)";
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getContent());
            ps.setInt(3, post.getUserId());
            ps.setString(4, post.getPicture());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePost(Post post) {
        String sql = "UPDATE posts SET title=?,content=?,user_id=?, picture=? WHERE id=?";
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getContent());
            ps.setInt(3, post.getUserId());
            ps.setString(4,post.getPicture());
            ps.setInt(5, post.getId());
            ps.executeUpdate();
            con.close();
            System.out.println(post.getId());
            System.out.println("post updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean auth(String username, String password) {
        boolean status = false;
        String sql = "SELECT username,password FROM users WHERE username=? AND password=?";
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                status = true;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static void deletePost(int id) {
        String sql = "DELETE FROM posts WHERE id=?";
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
