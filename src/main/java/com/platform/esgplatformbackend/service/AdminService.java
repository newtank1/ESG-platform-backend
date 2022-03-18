package com.platform.esgplatformbackend.service;

import com.platform.esgplatformbackend.model.vo.*;

import java.util.List;

public interface AdminService {
    ResultVO<CorporationBasicVo> addCorporation(CorporationBasicVo corp);
    ResultVO<CorporationBasicVo> updateCorporationBasic(CorporationBasicVo corp);
    ResultVO<CorporationESGVo> addESG(CorporationESGVo vo);
    ResultVO<CorporationESGVo> updateESG(CorporationESGVo vo);
    ResultVO<CorporationESGHistoryVo> submitESGHistory(CorporationESGHistoryVo vo);
    ResultVO<CorporationESGHistoryVo> addESGHistory(CorporationESGHistoryVo vo);
    ResultVO<CorporationESGScoreVo> submitScore(CorporationESGScoreVo vo);
    ResultVO<CorporationOpinionVo> submitOpinion(CorporationOpinionVo vo);
    ResultVO<CorporationStockVo> submitStock(CorporationStockVo vo);
    ResultVO<List<CorporationESGScoreVo>> getESGScore(Integer corporation_id);
}
