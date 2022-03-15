package com.platform.esgplatformbackend.service;

import com.platform.esgplatformbackend.model.vo.CorporationESGScoreVo;
import com.platform.esgplatformbackend.model.vo.CorporationInfoVo;
import com.platform.esgplatformbackend.model.vo.ResultVO;

import java.util.List;

public interface SearchService {
    ResultVO<CorporationInfoVo> getById(int corporation_id);

    ResultVO<List<CorporationInfoVo>> getBySearching(String name,String industry,String location,double rate);

    ResultVO<List<CorporationESGScoreVo>> getByName(String name);
}
