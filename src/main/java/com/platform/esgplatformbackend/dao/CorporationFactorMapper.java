package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationFactorPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CorporationFactorMapper {

    @Select("select * from corporation_factor where corporation_id=#{corporation_id}")
    CorporationFactorPo getByCorporationId(Integer corporation_id);

    @Select("select * from corporation_factor where industry=#{industry}")
    List<CorporationFactorPo> getByIndustry(String industry);
}
