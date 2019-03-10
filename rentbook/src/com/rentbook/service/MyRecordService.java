package com.rentbook.service;

import com.rentbook.dao.imp.MyOperateBook;
import com.rentbook.dao.imp.MyOperateRecords;
import com.rentbook.entity.PackingRecord;
import com.rentbook.entity.Record;

import java.util.List;

public class MyRecordService {

    private MyOperateRecords myOperateRecords=new MyOperateRecords();
    private MyOperateBook myOperateBook=new MyOperateBook();

    /**
     * 查找租借记录
     * @param userid
     * @param isreturn
     * @return
     */
    public List<PackingRecord> getRecords(String userid,boolean isreturn){
        return  myOperateRecords.findAllRecordsByuser(userid,isreturn);

    }

    /**
     * 归还图书
     * @param Record
     */
    public boolean returnRecord(Record record){
        myOperateBook.increaseCounts(record.getBookid());
        myOperateRecords.updateReturn(record.getId());
        return true;
    }

    /**
     * 租借图书
     * @param record
     * @return
     */
    public boolean rentBook(Record record){
        int total=  myOperateBook.getAmounts(record.getBookid());
        if(total<=0){
            return false;
        }

        myOperateBook.creaseCounts(record.getBookid());
        myOperateRecords.addRecord(record);

        return true;


    }

    /**
     * 删除记录
     * @param id
     * @return
     */
    public boolean deleteRecord(int id){
        return myOperateRecords.deleteRecord(id);
    }
}
