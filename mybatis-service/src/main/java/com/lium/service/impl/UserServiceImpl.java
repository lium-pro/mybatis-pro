package com.lium.service.impl;

import com.lium.bean.User;
import com.lium.mapper.UserMapper;
import com.lium.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
