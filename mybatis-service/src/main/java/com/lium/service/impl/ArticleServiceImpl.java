package com.lium.service.impl;

import com.lium.bean.Article;
import com.lium.mapper.ArticleMapper;
import com.lium.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> selectArticles(Integer id) {
        return articleMapper.selectArticlesById(id);
    }
}
