package com.platform.esgplatformbackend.dao;


import com.platform.esgplatformbackend.model.po.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{name}")
    UserPo getUserByUsername(String name);
}
