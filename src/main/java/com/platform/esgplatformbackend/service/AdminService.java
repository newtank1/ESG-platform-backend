package com.platform.esgplatformbackend.service;

import com.platform.esgplatformbackend.model.vo.*;

import java.util.List;

public interface AdminService {
    ResultVO<CorporationBasicVo> addCorporation(CorporationBasicVo corp);
    ResultVO<CorporationBasicVo> updateCorporationBasic(CorporationBasicVo corp);
    ResultVO<CorporationESGVo> submitESG(CorporationESGScoreVo vo);
    ResultVO<CorporationOpinionVo> submitOpinion(CorporationOpinionVo vo);
    ResultVO<CorporationEventVo> submitEvent(CorporationEventVo vo);
    ResultVO<CorporationStockVo> submitStock(CorporationStockVo vo);
    List<CorporationESGScoreVo> getESGHistory(Integer corporation_id);
}
