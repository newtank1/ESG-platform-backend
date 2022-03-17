package com.platform.esgplatformbackend.service.impl;

import com.platform.esgplatformbackend.dao.*;
import com.platform.esgplatformbackend.model.po.*;
import com.platform.esgplatformbackend.model.vo.*;
import com.platform.esgplatformbackend.service.InformationService;
import com.platform.esgplatformbackend.util.Constant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.*;

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
    private CorporationSecondFactorMapper corporationSecondFactorMapper;

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
    public ResultVO<List<CorporationSecondFactorVo>> getFactors(int corporation_id) {
        List<CorporationSecondFactorPo> pos= corporationSecondFactorMapper.getByCorporationId(corporation_id);
        List<CorporationSecondFactorVo> vos=new ArrayList<>();
        for (CorporationSecondFactorPo po : pos) {
            vos.add(new CorporationSecondFactorVo(po));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",vos);
    }

    @Override
    public ResultVO<List<List<FactorVo>>> getTopFactors(int corporation_id, String type,int limit,String level) {
        CorporationFactorPo corporationFactor=null;
        List<CorporationFactorPo> pos=new ArrayList<>();
        if("second".equals(level)) {
            corporationFactor= corporationSecondFactorMapper.getByCorporationIdAndType(corporation_id, type);
            pos=new ArrayList<>(corporationSecondFactorMapper.getByIndustryAndType(corporationFactor.getIndustry(),type));
        }

        Map<String,FactorRankVo> map=new HashMap<>();

        Class<?> factorClass=corporationFactor.getClass();
        Field[] factors= factorClass.getDeclaredFields();
        for (Field factor : factors) {
            String name=factor.getName();
            if(name.startsWith("s_")||name.startsWith("e_")||name.startsWith("g_")){
                factor.setAccessible(true);
                FactorRankVo rankVo=new FactorRankVo(name,0,0);
                map.put(name,rankVo);
            }
        }

        for (CorporationFactorPo po : pos) {
            for (String factorName : map.keySet()) {
                try {
                    Field factor=factorClass.getDeclaredField(factorName);
                    factor.setAccessible(true);
                    Double poValue=(Double) factor.get(po);
                    map.get(factorName).addSum(poValue);
                    if(poValue.compareTo((Double) factor.get(corporationFactor))>0){
                        map.get(factorName).addRank();
                    }
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }

        List<FactorRankVo> rankVos=new ArrayList<>(map.values());
        rankVos.sort(Comparator.comparing(FactorRankVo::getRank));
        List<List<FactorVo>> result=new ArrayList<>();
        List<FactorVo> topFactors=new ArrayList<>();
        for(int i=0;i<limit&&i<rankVos.size();i++){
            try {
                FactorRankVo vo = rankVos.get(i);
                filterFactors(corporationFactor, pos, factorClass, topFactors, vo);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        result.add(topFactors);
        List<FactorVo> worstFactors=new ArrayList<>();
        for(int i=0;i<limit&&i<rankVos.size();i++){
            try {
                FactorRankVo vo = rankVos.get(rankVos.size()-i-1);
                filterFactors(corporationFactor, pos, factorClass, worstFactors, vo);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        result.add(worstFactors);
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",result);
    }


    @Override
    public ResultVO<String> getRank(int corporation_id, String type) {
        CorporationInfoPo cor=corporationInfoMapper.getCorporationById(corporation_id);
        List<CorporationInfoPo> pos=corporationInfoMapper.getCorporationBySearching(cor.getName(),cor.getIndustry(),null);
        int rank=1;
        for (CorporationInfoPo po : pos) {
            if("risky".equals(type)){
                if(po.getESG_risky_score()>cor.getESG_risky_score()) rank++;
            }
            else if("steady".equals(type)){
                if(po.getESG_steady_score()>cor.getESG_steady_score()) rank++;
            }
        }
        int length=pos.size();
        String res=rank+"/"+length;
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",res);
    }

    private void filterFactors(CorporationFactorPo corporationFactor, List<CorporationFactorPo> pos, Class<?> factorClass, List<FactorVo> factorList, FactorRankVo vo) throws NoSuchFieldException, IllegalAccessException {
        Field factor = factorClass.getDeclaredField(vo.name);
        factor.setAccessible(true);
        Double value = (Double) factor.get(corporationFactor);
        int count=pos.size();
        factorList.add(new FactorVo(vo.name,value,value.compareTo(vo.sum/count)>0,(vo.sum*1.0)/count ));
    }




}
