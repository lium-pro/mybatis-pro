package com.lium.mapper;

import com.lium.bean.Item;
import com.lium.bean.ItemKey;

public interface ItemMapper {
    int deleteByPrimaryKey(ItemKey key);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(ItemKey key);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}