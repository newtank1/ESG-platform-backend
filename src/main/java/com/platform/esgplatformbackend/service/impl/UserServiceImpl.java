package com.platform.esgplatformbackend.service.impl;

import com.platform.esgplatformbackend.dao.CorporationBasicMapper;
import com.platform.esgplatformbackend.dao.UserInterestMapper;
import com.platform.esgplatformbackend.dao.UserMapper;
import com.platform.esgplatformbackend.model.po.CorporationBasicPo;
import com.platform.esgplatformbackend.model.po.UserInterestPo;
import com.platform.esgplatformbackend.model.po.UserPo;
import com.platform.esgplatformbackend.model.vo.CorporationBasicVo;
import com.platform.esgplatformbackend.model.vo.ResultVO;
import com.platform.esgplatformbackend.model.vo.UserInterestVo;
import com.platform.esgplatformbackend.model.vo.UserVo;
import com.platform.esgplatformbackend.service.UserService;
import com.platform.esgplatformbackend.util.Constant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserInterestMapper userInterestMapper;

    @Resource
    CorporationBasicMapper corporationBasicMapper;


    @Override
    public ResultVO<UserVo> login(UserVo useVo) {
        UserPo user = userMapper.getUserByUsername(useVo.getUsername());
        if(user == null || !user.getIs_admin().equals(useVo.getIs_admin())){
            return new ResultVO<>(Constant.REQUEST_FAIL, "用户不存在！");
        }
        if(!user.getPassword().equals(useVo.getPassword())){
            return new ResultVO<>(Constant.REQUEST_FAIL,"密码错误！");
        }

        return new ResultVO<>(Constant.REQUEST_SUCCESS, "登录成功！", new UserVo(user));
    }

    @Override
    public ResultVO<UserInterestVo> addInterest(UserInterestVo userInterestVo) {
        UserInterestPo userInterestPo = userInterestMapper.getUserInterest(new UserInterestPo(userInterestVo));
        if(userInterestPo != null){
            return new ResultVO<>(Constant.REQUEST_FAIL,"已经关注此公司！");
        }
        int insert = userInterestMapper.insert(new UserInterestPo(userInterestVo));
        if(insert != 1){
            return new ResultVO<>(Constant.REQUEST_FAIL,"关注失败！");
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"关注成功！");



    }

    @Override
    public ResultVO<UserInterestVo> removeInterest(UserInterestVo userInterestVo) {
        int remove = userInterestMapper.delete(new UserInterestPo(userInterestVo));
        if(remove != 1){
            return new ResultVO<>(Constant.REQUEST_FAIL,"删除失败！");
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"删除成功！");
    }

    @Override
    public ResultVO<List<CorporationBasicVo>> getallinterests(int uid) {
        List<UserInterestPo> userInterests = userInterestMapper.getUserAllInterests(uid);
        List<CorporationBasicVo> corporationBasicVos = new ArrayList<>();
        for (UserInterestPo userInterest : userInterests) {
            corporationBasicVos.add(new CorporationBasicVo(corporationBasicMapper.getCorporationById(userInterest.getInterest_corporation_id())));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",corporationBasicVos);
    }

    @Override
    public ResultVO<UserVo> register(UserVo userVo) {
        UserPo userPo=userMapper.getUserByUsername(userVo.getUsername());
        if (userPo == null||userPo.getIs_admin().equals("true")) {
            userMapper.addNewUser(userVo.getUsername(),userVo.getPassword());
            return new ResultVO<>(Constant.REQUEST_SUCCESS,"注册成功");
        }
        return new ResultVO<>(Constant.REQUEST_FAIL,"用户名已存在");
    }
}
