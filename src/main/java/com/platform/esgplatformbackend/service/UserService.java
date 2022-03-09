package com.platform.esgplatformbackend.service;


import com.platform.esgplatformbackend.model.vo.CorporationBasicVo;
import com.platform.esgplatformbackend.model.vo.ResultVO;
import com.platform.esgplatformbackend.model.vo.UserInterestVo;
import com.platform.esgplatformbackend.model.vo.UserVo;

import java.util.List;

public interface UserService {
    ResultVO<UserVo> login(UserVo useVo);
    ResultVO<UserInterestVo> addInterest(UserInterestVo userInterestVo);
    ResultVO<UserInterestVo> removeInterest(UserInterestVo userInterestVo);
    ResultVO<List<CorporationBasicVo>> getallinterests(int uid);

    ResultVO<UserVo> register(UserVo userVo);
}
