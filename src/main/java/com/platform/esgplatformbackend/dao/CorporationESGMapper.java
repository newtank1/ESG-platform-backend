package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationESGPo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CorporationESGMapper {
    @Select("select * from corporation_esg")
    List<CorporationESGPo> getAllCorporationESG();

    @Insert("insert into corporation_esg(corporation_id, score, ESG_total_ranking, ESG_industry_ranking, record_id) values(#{corporation_id}, #{score}, #{ESG_total_ranking}, #{ESG_industry_ranking}, #{record_id})")
    int insert(CorporationESGPo po);

    @Select("select * from corporation_esg"+"where corporation_id=#{corporation_id")
    CorporationESGPo getCorporationESGByCorporationId(long corporation_id);
}
