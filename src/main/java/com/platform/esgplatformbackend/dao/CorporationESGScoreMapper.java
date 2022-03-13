package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationESGScorePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CorporationESGScoreMapper {
    CorporationESGScorePo getByRecordId(Integer score_record_id);

    List<CorporationESGScorePo> getByCorporationId(Integer corporation_id);

    List<CorporationESGScorePo> getByCorporationIdAndType(@Param("corporation_id") Integer corporation_id, @Param("score_type") String score_type);

    int insert(CorporationESGScorePo record);

    int update(CorporationESGScorePo record);

    int delete(Integer record_id);
}
