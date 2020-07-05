package com.lium.service;

import com.lium.bean.User;

public interface Userservice {
    User selectUser(int id);
    int updateUser(User user) throws Exception;
}
