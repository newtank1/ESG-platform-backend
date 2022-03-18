package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationESGHistoryPo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CorporationHistoryMapper {
    @Insert("insert into corporation_esg_history values(#{corporation_id},#{record_id},#{time},#{steady_record_id},#{risky_record_id})")
    @Options(useGeneratedKeys = true,keyProperty = "record_id")
    int insert(CorporationESGHistoryPo po);

    @Update("update corporation_esg_history set time=#{time},steady_record_id=#{steady_record_id},risky_record_id=#{risky_record_id} where record_id=#{record_id}")
    int update(CorporationESGHistoryPo po);

    @Select("select * from corporation_esg_history where record_id=#{record_id}")
    CorporationESGHistoryPo selectByRecordId(Integer record_id);

    @Delete("delete from corporation_esg_history where record_id=#{record_id}")
    int deleteByRecordId(Integer record_id);

    @Select("select * from corporation_esg_history where corporation_id=#{corporation_id}")
    List<CorporationESGHistoryPo> selectByCorporation(Integer corporation_id);
}
