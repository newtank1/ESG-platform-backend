package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationInfoPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CorporationInfoMapper {

    @Select("select * from corporation_info where corporation_id=#{corporation_id}")
    CorporationInfoPo getCorporationById(Integer corporation_id);

    @Select("select * from corporation_info order by ESG_total_ranking asc limit #{limit}")
    List<CorporationInfoPo> getCorporationByTotalRanking(Integer limit);

    @Select("select * from corporation_info where industry=#{industry} order by ESG_industry_ranking asc limit #{limit}")
    List<CorporationInfoPo> getCorporationByIndustryRanking(String industry,Integer limit);

    @Select("<script>" +
            "select * from corporation_info " +
            "where 1=1 " +
            "<if test='name!=null'> and name like '%${name}%' </if>" +
            "<if test='industry!=null'>and industry = #{industry} </if>" +
            "<if test='location!=null'>and location = #{location} </if>" +
            "</script>")
    List<CorporationInfoPo> getCorporationBySearching(String name,String industry,String location);
}
