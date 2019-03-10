package com.rentbook.controller;

import com.rentbook.entity.User;
import com.rentbook.service.MyUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RejisterServlet")
public class RejisterServlet extends HttpServlet {

    private MyUserService myUserService=new MyUserService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String username = request.getParameter("username");
        String password=request.getParameter("password");
        User user=new User(userid,username,password);
        boolean b = myUserService.registerUser(user);
        if(b){
            response.getWriter().write("success");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
