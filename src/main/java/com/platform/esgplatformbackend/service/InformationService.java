package com.platform.esgplatformbackend.service;

import com.platform.esgplatformbackend.model.vo.*;

import java.util.List;

public interface InformationService {


    ResultVO<List<CorporationOpinionVo>> getAllOpinionByCorporationId(int corporation_id);

    ResultVO<List<CorporationStockVo>> getAllStockByCorporationId(int corporation_id);

    ResultVO<List<CorporationStockVo>> getRecentStockByCorporationId(int corporation_id,int day);

    ResultVO<CorporationInfoVo> getNormalInformationById(int corporation_id);

    ResultVO<CorporationESGScoreVo> getLatestRiskyScore(int corporation_id);

    ResultVO<List<CorporationESGScoreVo>> getRiskyScores(int corporation_id);

    ResultVO<CorporationESGScoreVo> getLatestSteadyScore(int corporation_id);

    ResultVO<List<CorporationESGScoreVo>> getSteadyScores(int corporation_id);

    ResultVO<List<CorporationSecondFactorVo>> getFactors(int corporation_id);

    ResultVO<List<List<FactorVo>>> getTopFactors(int corporation_id,String type,int limit,String level);

    ResultVO<String> getRank(int corporation_id,String type);

    ResultVO<List<PolicyVo>> getRelatedPolicy(int corporation_id);

    ResultVO<List<FactorVo>> getScoreRanks(int corporation_id,String type);
}
