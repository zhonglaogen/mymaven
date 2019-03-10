package com.rentbook.controller;

import com.rentbook.entity.Record;
import com.rentbook.service.MyRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReturnBookServlet",urlPatterns = {"/returnbook.action"})
public class ReturnBookServlet extends HttpServlet {
    MyRecordService myRecordService=new MyRecordService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int recordid=Integer.parseInt(request.getParameter("recordid")) ;
       String bookid=request.getParameter("bookid");
       request.getSession().getAttribute("");
        Record record=new Record();
        record.setId(recordid);
        record.setBookid(bookid);

        myRecordService.returnRecord(record);
        response.sendRedirect("userrecords.action");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
