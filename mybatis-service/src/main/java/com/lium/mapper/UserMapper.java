package com.lium.mapper;

import com.lium.bean.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);


    /**
     * property = “cars”, 表示要将返回的查询结果赋值给user的cars属性
     * column = “id” 是指将user表中的用户主键id作为com.kimzing.data.repository.CarRepository.findCarsByUserId的查询参数
     * many 表示这是一个一对多的查询
     *  @Many(select = "方法全路径") 表示我们调用的方法, 方法参数userId就是上面column指定的列值
     * @param id
     * @return
     */
    @Select(" select * from tb_user where id = #{id} ")
    @Results(value = {
            @Result(property = "orderList", column = "id", many = @Many(select = "com.lium.mapper.OrderMapper.selectByUserId")),
            @Result(property = "id",column = "id")
    })
    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}