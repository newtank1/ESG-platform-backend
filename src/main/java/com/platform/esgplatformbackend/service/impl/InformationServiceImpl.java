package com.platform.esgplatformbackend.service.impl;

import com.platform.esgplatformbackend.dao.*;
import com.platform.esgplatformbackend.model.po.*;
import com.platform.esgplatformbackend.model.vo.*;
import com.platform.esgplatformbackend.service.InformationService;
import com.platform.esgplatformbackend.util.Constant;
import org.springframework.beans.BeanUtils;
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
    private CorporationESGHistoryMapper corporationESGHistoryMapper;

    @Resource
    private CorporationInfoMapper corporationInfoMapper;

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
    public ResultVO<List<CorporationESGHistoryVo>> getESGHistory(int corporation_id) {
        List<CorporationESGHistoryPo> corporationESGHistoryPos=corporationESGHistoryMapper.getByCorporationId(corporation_id);
        List<CorporationESGHistoryVo> corporationESGHistoryVos=new ArrayList<>();
        for (CorporationESGHistoryPo po : corporationESGHistoryPos) {
            corporationESGHistoryVos.add(new CorporationESGHistoryVo(po));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",corporationESGHistoryVos);
    }

    @Override
    public ResultVO<CorporationESGHistoryVo> getLatestHistory(int corporation_id) {
        CorporationESGHistoryPo po=corporationESGHistoryMapper.getByRecordId(corporation_id);
        if (po == null) {
            return new ResultVO<>(Constant.REQUEST_FAIL,"not found");
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",new CorporationESGHistoryVo(po));
    }
}
