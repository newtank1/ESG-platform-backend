package com.platform.esgplatformbackend.controller;

import com.platform.esgplatformbackend.model.vo.*;
import com.platform.esgplatformbackend.service.InformationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/company")
public class InfoController {
    @Resource
    InformationService informationService;

    @GetMapping("/events/{corporation_id}")
    public ResultVO<List<CorporationEventVo>> getEvents(@PathVariable Integer corporation_id, @RequestParam(name="day",required = false) Integer day){
        if(day==null) return informationService.getAllEventsByCorporationId(corporation_id);
        return informationService.getRecentEventsByCorporationId(corporation_id,day);
    }

    @GetMapping("/opinions/{corporation_id}")
    public ResultVO<List<CorporationOpinionVo>> getOpinions(@PathVariable Integer corporation_id, @RequestParam(name="day",required = false) Integer day){
        if(day==null) return informationService.getAllOpinionByCorporationId(corporation_id);
        return informationService.getRecentOpinionByCorporationId(corporation_id,day);
    }

    @GetMapping("/stocks/{corporation_id}")
    public ResultVO<List<CorporationStockVo>> getStocks(@PathVariable Integer corporation_id, @RequestParam(name="day",required = false) Integer day){
        if(day==null) return informationService.getAllStockByCorporationId(corporation_id);
        return informationService.getRecentStockByCorporationId(corporation_id,day);
    }

    @GetMapping("/history/{corporation_id}")
    public ResultVO<CorporationESGHistoryVo> getLatestHistory(@PathVariable Integer corporation_id){
        return informationService.getLatestHistory(corporation_id);
    }

    @GetMapping("/allHistory/{corporation_id}")
    public ResultVO<List<CorporationESGHistoryVo>> getAllHistory(@PathVariable Integer corporation_id){
        return informationService.getESGHistory(corporation_id);
    }
}
