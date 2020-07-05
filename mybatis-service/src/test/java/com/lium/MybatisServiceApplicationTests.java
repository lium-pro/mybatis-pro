package com.lium;

import com.lium.service.ArticleService;
import com.lium.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisServiceApplicationTests {
    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @Test
    void contextLoads() {
      //  System.out.println(userService.selectById(1));
        System.out.println(articleService.selectArticles(1));
    }

}
