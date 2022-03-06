package com.platform.esgplatformbackend.service;

import com.platform.esgplatformbackend.model.vo.CorporationBasicVo;
import com.platform.esgplatformbackend.model.vo.ResultVO;

public interface AdminService {
    public ResultVO<CorporationBasicVo> addCorporation(CorporationBasicVo corp);
}
