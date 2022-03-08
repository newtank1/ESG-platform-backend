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
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",new CorporationInfoVo(corporationInfoPo));
    }

    @Override
    public ResultVO<List<CorporationInfoVo>> getBySearching(String name, String industry, String location) {
        List<CorporationInfoPo> corporationInfoPos=corporationInfoMapper.getCorporationBySearching(name,industry,location);
        List<CorporationInfoVo> corporationInfoVos=new ArrayList<>();
        for (CorporationInfoPo po : corporationInfoPos) {
            corporationInfoVos.add(new CorporationInfoVo(po));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",corporationInfoVos);
    }

    @Override
    public ResultVO<List<CorporationInfoVo>> getByTotalRanking(int limit) {
        List<CorporationInfoPo> corporationInfoPos=corporationInfoMapper.getCorporationByTotalRanking(limit);
        List<CorporationInfoVo> corporationInfoVos=new ArrayList<>();
        for (CorporationInfoPo po : corporationInfoPos) {
            corporationInfoVos.add(new CorporationInfoVo(po));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",corporationInfoVos);
    }

    @Override
    public ResultVO<List<CorporationInfoVo>> getByIndustryRanking(String industry, int limit) {
        List<CorporationInfoPo> corporationInfoPos=corporationInfoMapper.getCorporationByIndustryRanking(industry,limit);
        List<CorporationInfoVo> corporationInfoVos=new ArrayList<>();
        for (CorporationInfoPo po : corporationInfoPos) {
            corporationInfoVos.add(new CorporationInfoVo(po));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",corporationInfoVos);
    }
}
