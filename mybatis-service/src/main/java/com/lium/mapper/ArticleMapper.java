package com.lium.mapper;

import com.lium.bean.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    @Select(" select a.* from tb_article a " +
            "LEFT JOIN tb_item c on c.article_id = a.id " +
            "WHERE c.amount = #{id} ")
    @Results(value = {@Result(property = "id", column = "id"),
            @Result(property = "orders", column = "id", many = @Many(select = "com.lium.mapper.OrderMapper.selectByItemAmount"))
    })
    List<Article> selectArticlesById(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}