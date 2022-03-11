package com.platform.esgplatformbackend.controller;


import com.platform.esgplatformbackend.model.vo.CorporationBasicVo;
import com.platform.esgplatformbackend.model.vo.ResultVO;
import com.platform.esgplatformbackend.model.vo.UserInterestVo;
import com.platform.esgplatformbackend.model.vo.UserVo;
import com.platform.esgplatformbackend.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService userService;


    @PostMapping("/login")
    public ResultVO<UserVo> login(@RequestBody UserVo userVo){

        return userService.login(userVo);

    }
    @PostMapping("/addinterest")
    public ResultVO<UserInterestVo> addInterest(@RequestBody UserInterestVo userInterestVo){

        return userService.addInterest(userInterestVo);

    }
    @PostMapping("/removeinterest")
    public ResultVO<UserInterestVo> removeInterest(@RequestBody UserInterestVo userInterestVo){

        return userService.removeInterest(userInterestVo);

    }

    @GetMapping("/getallinterests")
    public ResultVO<List<CorporationBasicVo>> getallinterests(int uid){
        return userService.getallinterests(uid);

    }

    @PostMapping("/register")
    public ResultVO<UserVo> register(@RequestBody UserVo userVo){
        return userService.register(userVo);
    }




}
