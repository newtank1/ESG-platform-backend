package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationOldIndustryPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CorporationOldIndustryMapper {
    @Select("select * from corporation_old_industry where corporation_id=#{corporation_id}")
    CorporationOldIndustryPo getById(Integer corporation_id);
}
