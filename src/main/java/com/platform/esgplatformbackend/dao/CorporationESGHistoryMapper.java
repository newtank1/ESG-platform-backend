package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationESGHistoryPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CorporationESGHistoryMapper {
    @Select("select * from corporation_esg_history where corporation_id=#{corporation_id}")
    List<CorporationESGHistoryPo> getHistoryByCorporationId(Integer corporation_id);
    //      `corporation_id` int(11) not null ,
//      `record_id` int(11) not null auto_increment,
//      `time` date not null ,
//      `ESG_total_score` double not null ,
    // TODO
    @Insert("insert into corporation_esg_history(corporation_id,time,ESG_total_score) values(#{corporation_id},#{time},#{ESG_total_score})")
    @Options(useGeneratedKeys = true,keyProperty = "record_id")
    int insert(CorporationESGHistoryPo po);
}
