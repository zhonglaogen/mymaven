package com.rentbook.controller;

import com.rentbook.dao.imp.MyOperateRecords;
import com.rentbook.entity.PackingRecord;
import com.rentbook.entity.User;
import com.rentbook.service.MyRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserRecordsServlet",urlPatterns = {"/userrecords.action"})
public class UserRecordsServlet extends HttpServlet {


    private MyRecordService recordService=new MyRecordService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User current = (User) request.getSession().getAttribute("current");
        List<PackingRecord> noReturn = recordService.getRecords(current.getUserid(), false);
        List<PackingRecord> isReturn = recordService.getRecords(current.getUserid(), true);
        request.getSession().setAttribute("noReturn",noReturn);
        request.getSession().setAttribute("isReturn",isReturn);
        response.sendRedirect("records.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
