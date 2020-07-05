package com.lium.mapper;

import com.lium.bean.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    @Select(" select * from tb_user where id = #{id} ")
    User selectById(int id);

    @Update(" UPDATE tb_user set username = {username} , email = #{email}  where id =#{id} ")
    int updataUser(User u);
}
