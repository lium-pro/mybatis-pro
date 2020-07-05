package com.lium;

import com.lium.bean.User;
import com.lium.service.Userservice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

@SpringBootTest
class RedisTransationalApplicationTests {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private Userservice userService;

    @Test
    void contextLoads() {
        User user = new User();
        long id = 37;
        user.setId(id);
        user.setUsername("fdgdsgf");
        user.setEmail("8ddd8888@gg");
        user.setPhone("1");
        try {
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(userService.updateUser(37));
//        try {
//            System.out.println(userService.updateUser(user));
//        } catch (Exception e) {
//            System.out.println("异常了。。。。不得了");
//        }finally {
//            System.out.println(redisTemplate.opsForValue().get("p"));
//            System.out.println(userService.selectUser(37));
//        }
    }

    @Test
    void test2() {
        redisTemplate.opsForValue().set("test", "nihao");
        Object o = redisTemplate.execute(new SessionCallback<Object>() {
            @Override
            public <K, V> Object execute(RedisOperations<K, V> redisOperations) throws DataAccessException {
                redisOperations.multi();
                redisOperations.opsForValue().increment((K) "p",4);
                redisOperations.opsForValue().set((K)"p", (V)"hahaha");
                return redisOperations.exec();
            }
        });

        System.out.println(o.toString());

    }

}
