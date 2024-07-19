package com.gw.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
/**
 * 用户mapper
 * @author xk
 * @version 2024年7月17 下午14:15:11
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    @Select("SELECT * FROM admin_user WHERE username = #{username}")
    UserEntity selectByUsername(String s);
}
