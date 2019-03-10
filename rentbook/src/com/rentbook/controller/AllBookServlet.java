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

@WebServlet(name = "AllBookServlet",urlPatterns = {"/allbooks.action"})
public class AllBookServlet extends HttpServlet {
    MyBookService myBookService=new MyBookService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books= myBookService.getBooks();
        request.getSession().setAttribute("books",books);
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
