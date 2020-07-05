package com.lium.service;

import com.lium.bean.Article;

import java.util.List;

public interface ArticleService {

    List<Article> selectArticles(Integer id);
}
