package com.rentbook.dao.imp;

import com.rentbook.dao.MyGetConnection;
import com.rentbook.dao.OperateUserTable;
import com.rentbook.entity.User;
import com.rentbook.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyOperateUser implements OperateUserTable {
    private Connection con;
    private PreparedStatement pre;
    private ResultSet rs;

    @Override
    public String selectPassword(String userid) {
        String password=null;
       con= MyGetConnection.getConnection();
        System.out.println("**********************************"+con);
       String selectPassword="select * from user_data where userid=?";

        try {
            pre= con.prepareStatement(selectPassword);
            pre.setString(1,userid);
            rs=pre.executeQuery();
            if(rs.next()){
                password=rs.getString("password");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseUtil.close(rs,pre,con);
        }

        return password;
    }

    @Override
    public boolean addUser(User user) {
        con=MyGetConnection.getConnection();
        System.out.println("**********************************"+con);
        String adduser="insert into user_data(userid,username,password) value(?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(adduser);
            pre.setString(1,user.getUserid());
            pre.setString(2,user.getUsername());
            pre.setString(3,user.getPassword());
            pre.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseUtil.close(rs,pre,con);
        }
        return false;
    }

    @Override
    public boolean alterUser() {
        return false;
    }

    @Override
    public User getUser(String userid) {
        User user=new User();
        con= MyGetConnection.getConnection();
        System.out.println("**********************************"+con);
        String finduser="select * from user_data where userid=?";

        try {
            pre= con.prepareStatement(finduser);
            pre.setString(1,userid);
            rs=pre.executeQuery();
            if(rs.next()){
                user.setUserid(rs.getString("userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseUtil.close(rs,pre,con);
        }


        return null;
    }

}
