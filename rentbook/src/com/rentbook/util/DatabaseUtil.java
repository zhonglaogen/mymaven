package com.rentbook.util;

import com.rentbook.dao.imp.MyOperateBook;
import com.rentbook.dao.imp.MyOperateRecords;
import com.rentbook.dao.imp.MyOperateUser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class DatabaseUtil {
    /**
     * md5为密码编码
     * @param password
     * @return
     */
    public static byte[] getcode(String password) {
        byte[] md5;
        try {
            MessageDigest ms = MessageDigest.getInstance("MD5");
            md5 = ms.digest(password.getBytes());
            return md5;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
