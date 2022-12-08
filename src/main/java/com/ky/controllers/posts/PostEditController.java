package com.ky.controllers.posts;

import com.ky.dao.PostDAO;
import com.ky.models.Post;
import com.ky.utils.MediaFile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PostEditController", value = "/post-edit")
public class PostEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Post post = PostDAO.getPost(id);
        String path = getServletContext().getRealPath("/uploads");
        ArrayList<String> files = MediaFile.getFiles(path);
        request.setAttribute("files", files);
        request.setAttribute("post", post);
        request.getRequestDispatcher("posts/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String picture = request.getParameter("pic");
        int userid = 1;

        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        post.setPicture(picture);
        post.setUserId(userid);
        PostDAO.updatePost(post);
        response.sendRedirect(request.getHeader("referer"));
    }
}
