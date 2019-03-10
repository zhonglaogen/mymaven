package com.rentbook.controller;
import com.rentbook.entity.Book;
import com.rentbook.entity.User;
import com.rentbook.service.MyBookService;
import com.rentbook.service.MyUserService;

import java.io.IOException;
import java.util.List;

public class AdjustUserServlet extends javax.servlet.http.HttpServlet {

    private MyUserService myUserService=new MyUserService();
    private MyBookService myBookService=new MyBookService();
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
      String  userid=request.getParameter("userid");
      String  password=request.getParameter("password");
      User user=new User();
      user.setUserid(userid);
      user.setPassword(password);

        User user1 = myUserService.isTure(user);

        if(user1!=null){
            request.getSession().setAttribute("current",user1);
            String s1="success";
            response.getWriter().write(s1);
          }else{
            String s2="error";
            response.getWriter().write(s2);
        }

//        request.getRequestDispatcher("index.jsp").forward(request,response);
//      response.sendRedirect(“”);//跳转任意服务器网页

    }
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }

}
