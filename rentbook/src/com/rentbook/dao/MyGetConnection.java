package com.rentbook.dao;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyGetConnection {
   static {
       try {
           Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");//加载驱动
       } catch (ClassNotFoundException e) {
           System.out.println("加载驱动失败");
           e.printStackTrace();
       }
   }

    public static  Connection getConnection(){

        return init();

    }
    //用连接池
    private static Connection init(){
       Connection connection=null;
        try {
            connection=DriverManager.getConnection("proxool.mysqlsource");//获取连接
            return connection;
        } catch (SQLException e) {
            System.out.println("获取连接失败");
            e.printStackTrace();
        }
        return connection;

    }






//    private static void noInit(){//不用连接池
//        InputStream in=MyGetConnection.class.getClassLoader().getResourceAsStream("mysql.properties");
//        Properties properties=new Properties();
//        try {
//            properties.load(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String driver=properties.getProperty("DRIVER");
//        String url=properties.getProperty("URL");
//        String username=properties.getProperty("USERNAME");
//        String password=properties.getProperty("PASSWORD");
//        try {
//            Class.forName(driver);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            connection=DriverManager.getConnection(url,username,password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}
