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
    List<CorporationFactorPo> getByCorporationId(Integer corporation_id);

    @Select("select * from corporation_factor where industry=#{industry}")
    List<CorporationFactorPo> getByIndustry(String industry);

    @Select("select * from corporation_factor where corporation_id=#{corporation_id} and score_type=#{score_type}")
    CorporationFactorPo getByCorporationIdAndType(Integer corporation_id,String score_type);

    @Select("select * from corporation_factor where industry=#{industry} and score_type=#{score_type}")
    List<CorporationFactorPo> getByIndustryAndType(String industry,String score_type);
}
