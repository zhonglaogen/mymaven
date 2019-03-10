package com.rentbook.dao.imp;

import com.rentbook.dao.MyGetConnection;
import com.rentbook.dao.OperatebookTable;
import com.rentbook.entity.Book;
import com.rentbook.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyOperateBook implements OperatebookTable {

    private Connection con;
    private PreparedStatement pre;
    private ResultSet rs;

    @Override
    public List<Book> getAllBooks() {
        List<Book> books=new ArrayList<>();
        con= MyGetConnection.getConnection();
        System.out.println("**********************************"+con);
        String selectbooks="select * from allbooks ";
        try {
            PreparedStatement pre = con.prepareStatement(selectbooks);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                Book book=new Book(rs.getString("bookid"),
                        rs.getString("bookname"),
                        rs.getString("information"),
                        rs.getInt("counts"),
                        rs.getString("src"));
                books.add(book);

            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseUtil.close(rs,pre,con);
        }

        return null;
    }

    @Override
    public Book findBookById(String bookid) {
        Book book=null;
                con= MyGetConnection.getConnection();
        System.out.println("**********************************"+con);
        String findbook="select * from allbooks where bookid=?";
        try {
            PreparedStatement pre = con.prepareStatement(findbook);
            pre.setString(1,bookid);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                book=new Book();
                book.setBookid(rs.getString("bookid"));
                book.setBookname(rs.getString("bookname"));
                book.setCounts(rs.getInt("counts"));
                book.setInformation(rs.getString("information"));
                book.setSrc(rs.getString("src"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseUtil.close(rs,pre,con);
        }
        return book;
    }

    /**
     * 减少图书剩余量
     * @param bookid
     * @return
     */
    public boolean creaseCounts(String bookid){
        con=MyGetConnection.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement("update allbooks set counts=counts-1 where bookid=?");
            pre.setString(1,bookid);
            pre.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseUtil.close(rs,pre,con);
        }
        return false;
    }

    /**
     * 得到剩余图书
     * @param bookid
     * @return
     */
    public int getAmounts(String bookid){
        con=MyGetConnection.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement("select counts from allbooks where bookid=?");
            pre.setString(1,bookid);
            ResultSet rs = pre.executeQuery();
            int counts=0;
            if(rs.next()){
                 counts=rs.getInt("counts");
            }
            return counts;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseUtil.close(rs,pre,con);
        }
        return 0;
    }

    /**
     * 增加图书数量
     * @param bookid
     * @return
     */
    public boolean increaseCounts(String bookid){
        con=MyGetConnection.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement("update allbooks set counts=counts+1 where bookid=?");
            pre.setString(1,bookid);
            pre.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

}
