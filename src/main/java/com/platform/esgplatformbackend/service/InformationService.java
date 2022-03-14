package com.platform.esgplatformbackend.service;

import com.platform.esgplatformbackend.model.vo.*;

import java.util.List;

public interface InformationService {

    ResultVO<List<CorporationEventVo>> getAllEventsByCorporationId(int corporation_id);

    ResultVO<List<CorporationEventVo>> getRecentEventsByCorporationId(int corporation_id,int day);

    ResultVO<List<CorporationOpinionVo>> getAllOpinionByCorporationId(int corporation_id);

    ResultVO<List<CorporationOpinionVo>> getRecentOpinionByCorporationId(int corporation_id,int day);

    ResultVO<List<CorporationStockVo>> getAllStockByCorporationId(int corporation_id);

    ResultVO<List<CorporationStockVo>> getRecentStockByCorporationId(int corporation_id,int day);

    ResultVO<CorporationInfoVo> getNormalInformationById(int corporation_id);

    ResultVO<CorporationESGScoreVo> getLatestRiskyScore(int corporation_id);

    ResultVO<List<CorporationESGScoreVo>> getRiskyScores(int corporation_id,int day);

    ResultVO<CorporationESGScoreVo> getLatestSteadyScore(int corporation_id);

    ResultVO<List<CorporationESGScoreVo>> getSteadyScores(int corporation_id,int day);

    ResultVO<List<CorporationFactorVo>> getFactors(int corporation_id);

    ResultVO<List<FactorVo>> getTopFactors(int corporation_id,String type,int limit);
}
