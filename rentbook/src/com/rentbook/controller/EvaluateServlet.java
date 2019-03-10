package com.rentbook.controller;

import com.rentbook.entity.Book;
import com.rentbook.entity.Evaluate;
import com.rentbook.entity.User;
import com.rentbook.service.MyBookService;
import com.rentbook.service.MyEvaluateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EvaluateServlet",urlPatterns = {"/userevaluate.action"})
public class EvaluateServlet extends HttpServlet {
    MyEvaluateService myEvaluateService=new MyEvaluateService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String evaluation= request.getParameter("evaluate");
        String bookid= request.getParameter("bookid");
            Evaluate evaluate=new Evaluate();
        User user = (User) request.getSession().getAttribute("current");
        evaluate.setBookid(bookid);
        evaluate.setEvaluate(evaluation);
        evaluate.setUserid(user.getUserid());
        if(myEvaluateService.addEvaluate(evaluate)){
            response.sendRedirect("userrecords.action");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
