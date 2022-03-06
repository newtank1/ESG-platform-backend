package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationESGHistoryPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CorporationESGHistoryMapper {
    CorporationESGHistoryPo getByRecordId(Integer record_id);

    List<CorporationESGHistoryPo> getByCorporationId(Integer corporation_id);

    int insert(CorporationESGHistoryPo record);

    int update(CorporationESGHistoryPo record);

    int delete(Integer record_id);
}
