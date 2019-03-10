package com.rentbook.dao.imp;

import com.rentbook.dao.MyGetConnection;
import com.rentbook.dao.OperateRecords;
import com.rentbook.entity.PackingRecord;
import com.rentbook.entity.Record;
import com.rentbook.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyOperateRecords implements OperateRecords {

    private Connection con;
    private PreparedStatement pre;
    private ResultSet rs;
    //查询未归还
    String findRecords1="select *   from rent_records join  allbooks on rent_records.bookid=allbooks.bookid where userid=? and isreturn=1";
    //查询已归还
    String findRecords0="select *  from rent_records join  allbooks on rent_records.bookid=allbooks.bookid where userid=? and isreturn=0";
    @Override
    public List<PackingRecord> findAllRecordsByuser(String userid,boolean isReturn) {
        List<PackingRecord> records=new ArrayList<>();
        String findRecords=null;
        con=MyGetConnection.getConnection();
        System.out.println("**********************************"+con);
        try {
            if(isReturn){
                findRecords=findRecords0;
            }else {
                findRecords=findRecords1;
            }
            PreparedStatement pre = con.prepareStatement(findRecords);
            pre.setString(1,userid);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                PackingRecord packingRecord=new PackingRecord();
                packingRecord.setBookname(rs.getString("bookname"));
                packingRecord.setRecord(new Record(rs.getInt("recordid"),
                        rs.getString("userid"),
                        rs.getString("bookid"),
                        rs.getString("rentid")
                        ));
                records.add(packingRecord);
            }
            return records;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseUtil.close(rs,pre,con);
        }
        return records;
    }

    /**
     * 将isreturn设置为0
     * @param recordid
     * @return
     */
    public boolean updateReturn(int recordid){
        con=MyGetConnection.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement("update rent_records set isreturn=0 where  recordid=?");
            pre.setInt(1,recordid);
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
     * 添加记录
     * @param record
     * @return
     */
    public boolean addRecord(Record record)  {
            con=MyGetConnection.getConnection();
        PreparedStatement pre = null;
        try {

            pre = con.prepareStatement("insert into rent_records(rentid, bookid, userid,isreturn) values (?,?,?,1)");
            pre.setString(1,record.getRentid());
            pre.setString(2,record.getBookid());
            pre.setString(3,record.getUserid());
            pre.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseUtil.close(rs,pre,con);
        }
        return  false;



    }

    /**
     * 删除某一条记录
     * @param id
     * @return
     */
    public boolean deleteRecord(int id){
        con=MyGetConnection.getConnection();
        try {
            PreparedStatement pre = con.prepareStatement("delete from rent_records where recordid=?");
            pre.setInt(1,id);
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
