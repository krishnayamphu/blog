package com.ky.controllers.users;

import com.ky.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("users/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(UserDAO.auth(username,password)){
            HttpSession session=request.getSession();
            session.setAttribute("user",username);
            response.sendRedirect("dashboard");
        }else{
            String msg="Invalid Username or Password";
            request.setAttribute("err",msg);
            request.getRequestDispatcher("users/login.jsp").include(request,response);
        }
    }
}
