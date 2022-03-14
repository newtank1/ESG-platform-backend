package com.platform.esgplatformbackend.controller;

import com.platform.esgplatformbackend.model.vo.*;
import com.platform.esgplatformbackend.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
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
    public ResultVO<List<CorporationESGScoreVo>> getESGHistory(@PathVariable Integer corporation_id){
        return service.getESGScore(corporation_id);
    }

    @PostMapping("/esg")
    public ResultVO<CorporationESGVo> addESG(CorporationESGVo vo){
        return service.addESG(vo);
    }

    @PutMapping("/esg")
    public ResultVO<CorporationESGVo> updateESG(CorporationESGVo vo){
        return service.updateESG(vo);
    }

    @PutMapping("/esgHistory")
    public ResultVO<CorporationESGHistoryVo> submitESGHistory(CorporationESGHistoryVo vo){
        return service.submitESGHistory(vo);
    }

    @PostMapping("/esgHistory")
    public ResultVO<CorporationESGHistoryVo> addESGHistory(CorporationESGHistoryVo vo){
        return service.addESGHistory(vo);
    }

    @PostMapping("/score")
    public ResultVO<CorporationESGScoreVo> submitScore(CorporationESGScoreVo vo){
        return service.submitScore(vo);
    }
}
