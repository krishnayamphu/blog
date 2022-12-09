package com.ky.controllers;

import com.ky.dao.PostDAO;
import com.ky.models.Post;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SingleController", value = "/single")
public class SingleController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Post post= PostDAO.getPost(id);
        ArrayList<Post> latestPosts= PostDAO.getLatestPosts();
        request.setAttribute("latestPosts",latestPosts);
        request.setAttribute("post",post);
        request.getRequestDispatcher("single.jsp").forward(request,response);
    }
}
