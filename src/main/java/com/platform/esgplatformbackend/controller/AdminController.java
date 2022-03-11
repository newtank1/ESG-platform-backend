package com.platform.esgplatformbackend.controller;

import com.platform.esgplatformbackend.model.vo.*;
import com.platform.esgplatformbackend.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService service;

    @PostMapping("/new")
    public ResultVO<CorporationBasicVo> addCorporation(@RequestBody CorporationBasicVo corp){
        return service.addCorporation(corp);
    }

    @PutMapping("/basic")
    public ResultVO<CorporationBasicVo> updateCorporationBasic(@RequestBody CorporationBasicVo vo){
        return service.updateCorporationBasic(vo);
    }

    @PostMapping("/ESG")
    public ResultVO<CorporationESGVo> submitESG(@RequestBody CorporationESGHistoryVo vo){
        return service.submitESG(vo);
    }

    @PostMapping("/opinion")
    public ResultVO<CorporationOpinionVo> submitOpinion(@RequestBody CorporationOpinionVo vo){
        return service.submitOpinion(vo);
    }

    @PostMapping("/event")
    public ResultVO<CorporationEventVo> submitEvent(@RequestBody CorporationEventVo vo){
        return service.submitEvent(vo);
    }

    @PostMapping("/stock")
    public ResultVO<CorporationStockVo> submitStock(@RequestBody CorporationStockVo vo){
        return service.submitStock(vo);
    }

    @GetMapping("/score/{corporation_id}")
    public List<CorporationESGHistoryVo> getESGHistory(@PathVariable Integer corporation_id){
        return service.getESGHistory(corporation_id);
    }
}
