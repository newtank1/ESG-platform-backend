package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationEventPo;
import com.platform.esgplatformbackend.model.po.CorporationOpinionPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CorporationOpinionMapper {
    @Insert("insert into corporation_opinion(corporation_id,time,opinion_text,opinion_score) values(#{corporation_id},#{time},#{opinion_text},#{opinion_score})")
    int insert(CorporationOpinionPo po);
}
