package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationESGPo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CorporationESGMapper {

    @Select("select * from corporation_esg where corporation_id=#{corporation_id}")
    CorporationESGPo getESGByCorporationId(Integer corporation_id);

    @Select("select * from corporation_esg where esg_id=#{esg_id}")
    CorporationESGPo getESGByESGId(Integer esg_id);

    @Select("select * from corporation_esg order by ESG_total_ranking asc limit #{limit}")
    List<CorporationESGPo> getESGByTotalRanking(Integer limit);


    @Insert("insert into corporation_esg(corporation_id,ESG_total_ranking,ESG_industry_ranking,record_id) " +
            "values(#{corporation_id},#{ESG_total_ranking},#{ESG_industry_ranking},#{record_id})")
    @Options(useGeneratedKeys = true,keyProperty = "esg_id")
    int insert(CorporationESGPo po);

    @Update("update corporation_esg set " +
            "ESG_total_ranking=#{ESG_total_ranking}," +
            "ESG_industry_ranking=#{ESG_industry_ranking}," +
            "record_id=#{record_id}" +
            " where corporation_id=#{corporation_id}")
    int update(Integer ESG_total_ranking,Integer ESG_industry_ranking,Integer record_id,Integer corporation_id);

    @Delete("delete from corporation_esg where esg_id=#{esg_id}")
    int delete(Integer esg_id);

    @Select("select * from corporation_esg")
    List<CorporationESGPo> getAllCorporationESG();
}
