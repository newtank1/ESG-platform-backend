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
    private CorporationESGScoreMapper corporationESGScoreMapper;

    @Resource
    private CorporationInfoMapper corporationInfoMapper;

    @Resource
    private CorporationSecondFactorMapper corporationSecondFactorMapper;

    @Resource
    private CorporationESGMapper corporationESGMapper;

    @Resource
    private CorporationHistoryMapper corporationHistoryMapper;

    @Resource
    private CorporationOldIndustryMapper corporationOldIndustryMapper;

    @Resource
    private PolicyMapper policyMapper;

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
            if(isFactor(name)){
                factor.setAccessible(true);
                FactorRankVo rankVo=new FactorRankVo(name,0);
                map.put(name,rankVo);
            }
        }

        for (CorporationFactorPo po : pos) {
            for (String factorName : map.keySet()) {
                try {
                    Field factor=factorClass.getDeclaredField(factorName);
                    factor.setAccessible(true);
                    Double poValue=(Double) factor.get(po);
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
                calculateRankLevel(corporationFactor, pos, factorClass, topFactors, vo);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        result.add(topFactors);
        List<FactorVo> worstFactors=new ArrayList<>();
        for(int i=0;i<limit&&i<rankVos.size();i++){
            try {
                FactorRankVo vo = rankVos.get(rankVos.size()-i-1);
                calculateRankLevel(corporationFactor, pos, factorClass, worstFactors, vo);
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

    @Override
    public ResultVO<List<PolicyVo>> getRelatedPolicy(int corporation_id) {
        String oldIndustry=corporationOldIndustryMapper.getById(corporation_id).getOld_industry();
        String location=corporationInfoMapper.getCorporationById(corporation_id).getLocation();
        List<PolicyPo> pos=policyMapper.getByLocation(location);
        List<PolicyVo> vos=new ArrayList<>();
        for (PolicyPo po : pos) {
            if(po.getIndustry().contains(oldIndustry)) vos.add(new PolicyVo(po));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",vos);
    }

    @Override
    public ResultVO<List<FactorVo>> getScoreRanks(int corporation_id, String type) {
        CorporationSecondFactorPo corporationFactorPo=corporationSecondFactorMapper.getByCorporationIdAndType(corporation_id,type);
        List<CorporationSecondFactorPo> pos=corporationSecondFactorMapper.getByIndustryAndType(corporationFactorPo.getIndustry(),type);
        
        FactorRankVo total=new FactorRankVo("ESG_total_score",0);
        FactorRankVo e=new FactorRankVo("E_score",0);
        FactorRankVo s=new FactorRankVo("S_score",0);
        FactorRankVo g=new FactorRankVo("G_score",0);
        
        for (CorporationSecondFactorPo po : pos) {
            if(po.getESG_total_score()>corporationFactorPo.getESG_total_score()){
                total.addRank();
            }
            if(po.getE_score()>corporationFactorPo.getE_score()){
                e.addRank();
            }
            if(po.getS_score()>corporationFactorPo.getS_score()){
                s.addRank();
            }
            if(po.getG_score()>corporationFactorPo.getG_score()){
                g.addRank();
            }
        }
        
        List<FactorVo> result=new ArrayList<>();
        int length=pos.size();
        double e_ratio=e.getRank()*1.0/length;
        double s_ratio=s.getRank()*1.0/length;
        double g_ratio=g.getRank()*1.0/length;
        double total_ratio=total.getRank()*1.0/length;
        result.add(new FactorVo("ESG_total_score",corporationFactorPo.getESG_total_score(),total_ratio,makeLevel(total_ratio)));
        result.add(new FactorVo("E_score",corporationFactorPo.getE_score(),e_ratio,makeLevel(e_ratio)));
        result.add(new FactorVo("S_score",corporationFactorPo.getS_score(),s_ratio,makeLevel(s_ratio)));
        result.add(new FactorVo("G_score",corporationFactorPo.getG_score(),g_ratio,makeLevel(g_ratio)));
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",result);
    }

    private void calculateRankLevel(CorporationFactorPo corporationFactor, List<CorporationFactorPo> pos, Class<?> factorClass, List<FactorVo> factorList, FactorRankVo vo) throws NoSuchFieldException, IllegalAccessException {
        Field factor = factorClass.getDeclaredField(vo.name);
        factor.setAccessible(true);
        Double value = (Double) factor.get(corporationFactor);
        int count=pos.size();
        double ratio=(vo.rank*1.0)/count;
        factorList.add(new FactorVo(vo.name,value,ratio,makeLevel(ratio) ));
    }


    private boolean isFactor(String name){
        return name.startsWith("s_")||name.startsWith("e_")||name.startsWith("g_");
    }

    private String makeLevel(double ratio){
        if(ratio<0.1) return "A";
        if(ratio<0.2) return "A-";
        if(ratio<0.35) return "B";
        if(ratio<0.6) return "B-";
        if(ratio<0.75) return "C";
        if(ratio<0.9) return "C-";
        if(ratio<0.95) return "D";
        return "D-";
    }
}
