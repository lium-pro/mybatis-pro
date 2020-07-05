package com.lium.mapper;

import com.lium.bean.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    @Select("select * from tb_order where user_id = #{uid}")
    List<Order> selectByUserId(Integer uid);

    @Select(" select b.* from tb_article a " +
            "LEFT JOIN tb_item c on c.article_id = a.id " +
            "LEFT JOIN tb_order b on c.order_id = b.id  " +
            "WHERE c.amount = #{amount};")
    List<Order> selectByItemAmount(int amount);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}