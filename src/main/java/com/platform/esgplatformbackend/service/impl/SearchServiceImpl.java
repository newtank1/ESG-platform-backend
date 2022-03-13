package com.platform.esgplatformbackend.service.impl;

import com.platform.esgplatformbackend.dao.CorporationInfoMapper;
import com.platform.esgplatformbackend.model.po.CorporationInfoPo;
import com.platform.esgplatformbackend.model.vo.CorporationInfoVo;
import com.platform.esgplatformbackend.model.vo.ResultVO;
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
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",corporationInfoVos);
    }

}
