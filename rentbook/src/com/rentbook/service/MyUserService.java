package com.rentbook.service;

import com.rentbook.dao.imp.MyOperateUser;
import com.rentbook.entity.User;
import com.rentbook.util.DatabaseUtil;
import org.apache.commons.codec.binary.Hex;

public class MyUserService {
    private MyOperateUser myOperateUser=new MyOperateUser();

    /**
     * 用户注册
     * @param user
     * @return
     */
    public  boolean registerUser(User user){
        //将字节数组转换成16进制字符串
        user.setPassword(Hex.encodeHexString( DatabaseUtil.getcode(user.getPassword())));
      if(myOperateUser.addUser(user)){
          return true;
      }
        return false;
    }

    /**
     * 验证用户名和密码
     * @param user
     * @return
     */
    public  User isTure(User user){
        user.setPassword(Hex.encodeHexString( DatabaseUtil.getcode(user.getPassword())));
        User user1=myOperateUser.getUser(user.getUserid());
        if(user1!=null){
            if(user.getPassword().equals(user1.getPassword())){
                return user1;
            }
        }

        return null;
    }
}
