package com.ky.controllers.users;

import com.ky.dao.UserDAO;
import com.ky.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserRegisterController", value = "/register")
public class UserRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("users/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String picture="";
        User user=new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setPicture(picture);
        UserDAO.addUser(user);
        response.sendRedirect("dashboard");

    }
}
