package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationOpinionPo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CorporationOpinionMapper {

    @Select("select * from corporation_opinion where corporation_id=#{corporation_id}")
    List<CorporationOpinionPo> getOpinions(Integer corporation_id);

    @Select("select * from corporation_opinion where corporation_id=#{corporation_id} and to_days(now())-to_days(time) <= #{day}")
    List<CorporationOpinionPo> getOpinionsByTime(Integer corporation_id, Integer day);

    @Select("select * from corporation_opinion where opinion_id=#{opinion_id}")
    CorporationOpinionPo getOpinionByOpinionId(Integer opinion_id);

    @Insert("insert into corporation_opinion(corporation_id,time,opinion_text,opinion_score) values(#{corporation_id},#{time},#{opinion_text},#{opinion_score})")
    @Options(useGeneratedKeys = true,keyProperty = "opinion_id")
    int insert(CorporationOpinionPo po);

    @Update("update corporation_opinion set opinion_text=#{opinion_text},opinion_score=#{opinion_score} where opinion_id=#{opinion_id}")
    int update(String opinion_text,Double opinion_score,Integer opinion_id);

    @Delete("delete from corporation_opinion where opinion_id=#{opinion_id}")
    int delete(Integer opinion_id);
}
