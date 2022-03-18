package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationSecondFactorPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CorporationSecondFactorMapper {

    @Select("select * from corporation_second_factor where corporation_id=#{corporation_id}")
    List<CorporationSecondFactorPo> getByCorporationId(Integer corporation_id);

    @Select("select * from corporation_second_factor where left(industry,1)=left(#{industry},1)")
    List<CorporationSecondFactorPo> getByIndustry(String industry);

    @Select("select * from corporation_second_factor where corporation_id=#{corporation_id} and score_type=#{score_type}")
    CorporationSecondFactorPo getByCorporationIdAndType(Integer corporation_id, String score_type);

    @Select("select * from corporation_second_factor where left(industry,1)=left(#{industry},1) and score_type=#{score_type}")
    List<CorporationSecondFactorPo> getByIndustryAndType(String industry, String score_type);
}
