package com.platform.esgplatformbackend.controller;

import com.platform.esgplatformbackend.model.vo.CorporationBasicVo;
import com.platform.esgplatformbackend.model.vo.ResultVO;
import com.platform.esgplatformbackend.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService service;

    @PostMapping("/new")
    public ResultVO<CorporationBasicVo> addCorporation(@RequestBody CorporationBasicVo corp){
        return service.addCorporation(corp);
    }
}
