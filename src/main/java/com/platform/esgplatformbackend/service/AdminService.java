package com.platform.esgplatformbackend.service;

import com.platform.esgplatformbackend.model.po.CorporationESGHistoryPo;
import com.platform.esgplatformbackend.model.vo.*;

import java.util.List;

public interface AdminService {
    public ResultVO<CorporationBasicVo> addCorporation(CorporationBasicVo corp);
    public ResultVO<CorporationBasicVo> updateCorporationBasic(CorporationBasicVo corp);
    public ResultVO<CorporationESGVo> submitESG(CorporationESGVo vo);
    public ResultVO<CorporationOpinionVo> submitOpinion(CorporationOpinionVo vo);
    public ResultVO<CorporationEventVo> submitEvent(CorporationEventVo vo);
    public ResultVO<CorporationStockVo> submitStock(CorporationStockVo vo);
    public List<CorporationESGHistoryPo> getESGHistory(Integer corporation_id);
}
