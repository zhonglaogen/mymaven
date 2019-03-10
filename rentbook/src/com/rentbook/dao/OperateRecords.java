package com.rentbook.dao;

import com.rentbook.entity.PackingRecord;
import com.rentbook.entity.Record;

import java.util.List;

public interface OperateRecords {
    public List<PackingRecord> findAllRecordsByuser(String userid,boolean isReturn);
}
