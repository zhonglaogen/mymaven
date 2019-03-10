package com.rentbook.dao;

import com.rentbook.entity.User;

public interface OperateUserTable {
    public String selectPassword(String userid);
    public boolean addUser(User user);
    public boolean alterUser();
    public User getUser(String userid);

}
