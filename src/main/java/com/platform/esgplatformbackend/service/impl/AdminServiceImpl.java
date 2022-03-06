package com.platform.esgplatformbackend.service.impl;

import com.platform.esgplatformbackend.dao.CorporationBasicMapper;
import com.platform.esgplatformbackend.model.po.CorporationBasicPo;
import com.platform.esgplatformbackend.model.vo.CorporationBasicVo;
import com.platform.esgplatformbackend.model.vo.ResultVO;
import com.platform.esgplatformbackend.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private CorporationBasicMapper corporationBasicMapper;

    @Override
    public ResultVO<CorporationBasicVo> addCorporation(CorporationBasicVo corp) {
        CorporationBasicPo po = new CorporationBasicPo(corp);
        return null;
    }
}
