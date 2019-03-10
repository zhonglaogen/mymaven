package com.rentbook.dao.imp;

import com.rentbook.dao.MyGetConnection;
import com.rentbook.entity.Evaluate;
import com.rentbook.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyOperateEvaluate {

    private Connection con;
    private PreparedStatement pre;
    private ResultSet rs;
    public boolean addEvaluate(Evaluate evaluate){
        con=MyGetConnection.getConnection();
        try {
             pre = con.prepareStatement("insert into book_evaluate(bookid, userid, evaluate) values (?,?,?)");
            pre.setString(1,evaluate.getBookid());
            pre.setString(2,evaluate.getUserid());
            pre.setString(3,evaluate.getEvaluate());
            pre.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseUtil.close(null,pre,con);
        }
        return false;
    }
}
