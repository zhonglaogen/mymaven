package com.rentbook.controller;

import com.rentbook.entity.Book;
import com.rentbook.service.MyBookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowBookServlet" ,urlPatterns = {"/showbook.action"})
public class ShowBookServlet extends HttpServlet {
    private MyBookService myBookService=new MyBookService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = myBookService.getBook(request.getParameter("bookid"));
        request.getSession().setAttribute("currentbook",book);
        response.sendRedirect("show.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
