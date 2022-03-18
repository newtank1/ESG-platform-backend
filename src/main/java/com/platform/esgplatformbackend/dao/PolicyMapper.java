package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.PolicyPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PolicyMapper {
    @Select("select * from policy where location=#{location}")
    List<PolicyPo> getByLocation(String location);
}
