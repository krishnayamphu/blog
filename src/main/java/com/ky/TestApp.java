package com.ky;

import com.ky.dao.PostDAO;
import com.ky.models.Post;

import java.util.ArrayList;

public class TestApp {
    public static void main(String[] args) {
        ArrayList<Post> posts= PostDAO.getLatestPosts();
        for(Post post:posts){
            System.out.println(post.getTitle());
        }
    }
}
