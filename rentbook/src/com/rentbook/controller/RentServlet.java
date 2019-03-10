package com.rentbook.controller;

import com.rentbook.dao.imp.MyOperateRecords;
import com.rentbook.entity.Record;
import com.rentbook.entity.User;
import com.rentbook.service.MyRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RentServlet",urlPatterns = {"/rent.action"})
public class RentServlet extends HttpServlet {

    private MyRecordService myRecordService=new MyRecordService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Record record=new Record();
        User current = (User) request.getSession().getAttribute("current");
        record.setBookid(request.getParameter("bookid"));
        record.setUserid(current.getUserid());
        myRecordService.rentBook(record);
        response.sendRedirect("/allbooks.action");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
