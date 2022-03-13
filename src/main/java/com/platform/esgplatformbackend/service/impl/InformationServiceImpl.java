package com.platform.esgplatformbackend.service.impl;

import com.platform.esgplatformbackend.dao.*;
import com.platform.esgplatformbackend.model.po.*;
import com.platform.esgplatformbackend.model.vo.*;
import com.platform.esgplatformbackend.service.InformationService;
import com.platform.esgplatformbackend.util.Constant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    @Resource
    private CorporationOpinionMapper corporationOpinionMapper;

    @Resource
    private CorporationStockMapper corporationStockMapper;

    @Resource
    private CorporationEventMapper corporationEventMapper;

    @Resource
    private CorporationESGScoreMapper corporationESGScoreMapper;

    @Resource
    private CorporationInfoMapper corporationInfoMapper;

    @Resource
    private CorporationFactorMapper corporationFactorMapper;

    @Resource
    private CorporationESGMapper corporationESGMapper;

    @Resource
    private CorporationHistoryMapper corporationHistoryMapper;

    @Override
    public ResultVO<List<CorporationEventVo>> getAllEventsByCorporationId(int corporation_id) {
        List<CorporationEventPo> corporationEventPos=corporationEventMapper.getEvents(corporation_id);
        List<CorporationEventVo> corporationEventVos=new ArrayList<>();
        for(CorporationEventPo po:corporationEventPos){
            corporationEventVos.add(new CorporationEventVo(po));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",corporationEventVos);
    }

    @Override
    public ResultVO<List<CorporationEventVo>> getRecentEventsByCorporationId(int corporation_id, int day) {
        List<CorporationEventPo> corporationEventPos=corporationEventMapper.getEventsByTime(corporation_id,day);
        List<CorporationEventVo> corporationEventVos=new ArrayList<>();
        for(CorporationEventPo po:corporationEventPos){
            corporationEventVos.add(new CorporationEventVo(po));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",corporationEventVos);
    }

    @Override
    public ResultVO<List<CorporationOpinionVo>> getAllOpinionByCorporationId(int corporation_id) {
        List<CorporationOpinionPo> corporationOpinionPos=corporationOpinionMapper.getOpinions(corporation_id);
        List<CorporationOpinionVo> corporationOpinionVos=new ArrayList<>();
        for (CorporationOpinionPo po : corporationOpinionPos) {
            corporationOpinionVos.add(new CorporationOpinionVo(po));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",corporationOpinionVos);
    }

    @Override
    public ResultVO<List<CorporationOpinionVo>> getRecentOpinionByCorporationId(int corporation_id, int day) {
        List<CorporationOpinionPo> corporationOpinionPos=corporationOpinionMapper.getOpinionsByTime(corporation_id,day);
        List<CorporationOpinionVo> corporationOpinionVos=new ArrayList<>();
        for (CorporationOpinionPo po : corporationOpinionPos) {
            corporationOpinionVos.add(new CorporationOpinionVo(po));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",corporationOpinionVos);
    }

    @Override
    public ResultVO<List<CorporationStockVo>> getAllStockByCorporationId(int corporation_id) {
        List<CorporationStockPo> corporationStockPos=corporationStockMapper.getStocks(corporation_id);
        List<CorporationStockVo> corporationStockVos=new ArrayList<>();
        for (CorporationStockPo po : corporationStockPos) {
            corporationStockVos.add(new CorporationStockVo(po));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",corporationStockVos);
    }

    @Override
    public ResultVO<List<CorporationStockVo>> getRecentStockByCorporationId(int corporation_id, int day) {
        List<CorporationStockPo> corporationStockPos=corporationStockMapper.getStocksByTime(corporation_id,day);
        List<CorporationStockVo> corporationStockVos=new ArrayList<>();
        for (CorporationStockPo po : corporationStockPos) {
            corporationStockVos.add(new CorporationStockVo(po));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",corporationStockVos);
    }

    @Override
    public ResultVO<CorporationInfoVo> getNormalInformationById(int corporation_id) {
        CorporationInfoPo corporationInfoPo=corporationInfoMapper.getCorporationById(corporation_id);
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",new CorporationInfoVo(corporationInfoPo));
    }

    @Override
    public ResultVO<CorporationESGScoreVo> getLatestRiskyScore(int corporation_id) {
        int record_id=corporationESGMapper.getESGByCorporationId(corporation_id).getRecord_id();
        CorporationESGHistoryPo corporationESGHistoryPo=corporationHistoryMapper.selectByRecordId(record_id);
        int risky_record_id=corporationESGHistoryPo.getRisky_record_id();
        CorporationESGScorePo po=corporationESGScoreMapper.getByRecordId(risky_record_id);
        if (po == null) {
            return new ResultVO<>(Constant.REQUEST_FAIL,"not found");
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",new CorporationESGScoreVo(po));
    }

    @Override
    public ResultVO<List<CorporationESGScoreVo>> getRiskyScores(int corporation_id, int day) {
        List<CorporationESGHistoryPo> corporationESGHistoryPos=corporationHistoryMapper.selectByCorporationAndTime(corporation_id,day);
        List<CorporationESGScoreVo> vos=new ArrayList<>();
        for (CorporationESGHistoryPo corporationESGHistoryPo : corporationESGHistoryPos) {
            CorporationESGScorePo po=corporationESGScoreMapper.getByRecordId(corporationESGHistoryPo.getRisky_record_id());
            vos.add(new CorporationESGScoreVo(po));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",vos);
    }

    @Override
    public ResultVO<CorporationESGScoreVo> getLatestSteadyScore(int corporation_id) {
        int record_id=corporationESGMapper.getESGByCorporationId(corporation_id).getRecord_id();
        CorporationESGHistoryPo corporationESGHistoryPo=corporationHistoryMapper.selectByRecordId(record_id);
        int steady_record_id=corporationESGHistoryPo.getSteady_record_id();
        CorporationESGScorePo po=corporationESGScoreMapper.getByRecordId(steady_record_id);
        if (po == null) {
            return new ResultVO<>(Constant.REQUEST_FAIL,"not found");
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",new CorporationESGScoreVo(po));
    }

    @Override
    public ResultVO<List<CorporationESGScoreVo>> getSteadyScores(int corporation_id, int day) {
        List<CorporationESGHistoryPo> corporationESGHistoryPos=corporationHistoryMapper.selectByCorporationAndTime(corporation_id,day);
        List<CorporationESGScoreVo> vos=new ArrayList<>();
        for (CorporationESGHistoryPo corporationESGHistoryPo : corporationESGHistoryPos) {
            CorporationESGScorePo po=corporationESGScoreMapper.getByRecordId(corporationESGHistoryPo.getSteady_record_id());
            vos.add(new CorporationESGScoreVo(po));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",vos);
    }

    @Override
    public ResultVO<List<CorporationFactorVo>> getFactors(int corporation_id) {
        List<CorporationFactorPo> pos=corporationFactorMapper.getByCorporationId(corporation_id);
        List<CorporationFactorVo> vos=new ArrayList<>();
        for (CorporationFactorPo po : pos) {
            vos.add(new CorporationFactorVo(po));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",vos);
    }

    @Override
    public ResultVO<List<FactorVo>> getTopFactors(int corporation_id, String type) {
        return null;
    }


}
