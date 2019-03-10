package com.rentbook.service;

import com.rentbook.dao.imp.MyOperateEvaluate;
import com.rentbook.entity.Evaluate;

public class MyEvaluateService {
    private   MyOperateEvaluate myOperateEvaluate=new MyOperateEvaluate();
    public boolean addEvaluate(Evaluate evaluate){
        return myOperateEvaluate.addEvaluate(evaluate);
    }

}
