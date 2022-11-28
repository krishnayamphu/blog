package com.ky.controllers.posts;

import com.ky.dao.PostDAO;
import com.ky.dao.UserDAO;
import com.ky.models.Post;
import com.ky.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PostCreateController", value = "/post-create")
public class PostCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("posts/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        String picture="";
        int userid=1;

        Post post=new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setPicture(picture);
        post.setUserId(userid);
        PostDAO.addPost(post);
        response.getWriter().print("post register successfully");
    }
}
