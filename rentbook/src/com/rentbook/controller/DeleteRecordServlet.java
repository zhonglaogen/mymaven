package com.rentbook.controller;

import com.rentbook.dao.imp.MyOperateRecords;
import com.rentbook.service.MyRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteRecordServlet",urlPatterns = {"/delete.action"})
public class DeleteRecordServlet extends HttpServlet {
    private MyRecordService myRecordService=new MyRecordService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        myRecordService.deleteRecord(id);
        response.sendRedirect("userrecords.action");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
