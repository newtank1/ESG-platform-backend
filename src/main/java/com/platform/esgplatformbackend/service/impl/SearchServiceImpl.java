package com.platform.esgplatformbackend.service.impl;

import com.platform.esgplatformbackend.dao.CorporationBasicMapper;
import com.platform.esgplatformbackend.dao.CorporationInfoMapper;
import com.platform.esgplatformbackend.model.po.CorporationInfoPo;
import com.platform.esgplatformbackend.model.vo.CorporationESGScoreVo;
import com.platform.esgplatformbackend.model.vo.CorporationInfoVo;
import com.platform.esgplatformbackend.model.vo.ResultVO;
import com.platform.esgplatformbackend.service.InformationService;
import com.platform.esgplatformbackend.service.SearchService;
import com.platform.esgplatformbackend.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Resource
    private CorporationInfoMapper corporationInfoMapper;
    @Resource
    private InformationService informationService;

    @Autowired
    public SearchServiceImpl(CorporationInfoMapper corporationInfoMapper) {
        this.corporationInfoMapper = corporationInfoMapper;
    }

    @Override
    public ResultVO<CorporationInfoVo> getById(int corporation_id) {
        CorporationInfoPo corporationInfoPo=corporationInfoMapper.getCorporationById(corporation_id);
        if (corporationInfoPo == null) {
            return new ResultVO<>(Constant.REQUEST_FAIL,"not found");
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",new CorporationInfoVo(corporationInfoPo));
    }

    @Override
    public ResultVO<List<CorporationInfoVo>> getBySearching(String name, String industry, String location,double rate) {
        List<CorporationInfoPo> corporationInfoPos=corporationInfoMapper.getCorporationBySearching(name,industry,location);
        List<CorporationInfoVo> corporationInfoVos=new ArrayList<>();
        for (CorporationInfoPo po : corporationInfoPos) {
            po.setESG_weighted_score(po.getESG_risky_score()*rate+po.getESG_steady_score()*(1-rate));
            corporationInfoVos.add(new CorporationInfoVo(po));
        }
        Collections.sort(corporationInfoVos);
        if(corporationInfoVos.isEmpty()) return new ResultVO<>(Constant.REQUEST_FAIL,"not found");
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",corporationInfoVos);
    }

    @Override
    public ResultVO<List<CorporationESGScoreVo>> getByName(String name) {
        List<CorporationInfoVo> corporationInfoVos=getBySearching(name,null,null,0.5).getData();
        if(corporationInfoVos==null||corporationInfoVos.isEmpty()) return new ResultVO<>(Constant.REQUEST_FAIL,"not found");
        int corporation_id=corporationInfoVos.get(0).getCorporation_id();
        String gotName=corporationInfoVos.get(0).getName();
        for (CorporationInfoVo corporationInfoVo : corporationInfoVos) {
            if(corporationInfoVo.getName().length()<gotName.length()){
                corporation_id=corporationInfoVo.getCorporation_id();
                gotName=corporationInfoVo.getName();
            }
        }
        List<CorporationESGScoreVo> vos=new ArrayList<>();
        vos.add(informationService.getLatestRiskyScore(corporation_id).getData());
        vos.add(informationService.getLatestSteadyScore(corporation_id).getData());
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",vos);
    }

}
