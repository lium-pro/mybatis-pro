package com.lium.service.impl;

import com.lium.bean.User;
import com.lium.mapper.UserMapper;
import com.lium.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.RedisSystemException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements Userservice {
    private final int ERROR_NUM = 10;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    @Transactional
    public User selectUser(int id) {
        User u = userMapper.selectById(id);
        String name = redisTemplate.opsForValue().get("baba");
        u.setUsername(name);
        return u;
    }

    @Override
    @Transactional
    public int updateUser(User user) throws Exception {
        redisTemplate.multi();
        redisTemplate.opsForValue().set("baba", user.getUsername());
        int num = userMapper.updataUser(user);
        int cNum = Integer.parseInt(user.getPhone());
        cNum = ERROR_NUM / cNum;
        redisTemplate.exec();

        return num;
    }
}
