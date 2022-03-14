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

    @GetMapping("/basic/{corporation_id}")
    public ResultVO<CorporationInfoVo> getNormalInformationById(@PathVariable Integer corporation_id){
        return informationService.getNormalInformationById(corporation_id);
    }

    @GetMapping("/risky/{corporation_id}")
    public ResultVO<CorporationESGScoreVo> getLatestRiskyScore(@PathVariable Integer corporation_id){
        return informationService.getLatestRiskyScore(corporation_id);
    }

    @GetMapping("/allRisky/{corporation_id}")
    public ResultVO<List<CorporationESGScoreVo>> getRiskyScores(@PathVariable Integer corporation_id,@RequestParam(name="day",required = false) Integer day){
        if (day == null) {
            day=365;
        }
        return informationService.getRiskyScores(corporation_id,day);
    }

    @GetMapping("/steady/{corporation_id}")
    public ResultVO<CorporationESGScoreVo> getLatestSteadyScore(@PathVariable Integer corporation_id){
        return informationService.getLatestSteadyScore(corporation_id);
    }

    @GetMapping("/allSteady/{corporation_id}")
    public ResultVO<List<CorporationESGScoreVo>> getSteadyScores(@PathVariable Integer corporation_id,@RequestParam(name="day",required = false) Integer day){
        if (day == null) {
            day=365;
        }
        return informationService.getSteadyScores(corporation_id,day);
    }

    @GetMapping("/factors/{corporation_id}")
    public ResultVO<List<FactorVo>> getTopFactors(@PathVariable Integer corporation_id,
                                                             @RequestParam(name="type") String type,
                                                             @RequestParam(name="limit",required = false) Integer limit){
        if (limit == null) {
            limit=5;
        }
        return  informationService.getTopFactors(corporation_id,type,limit);
    }

    @GetMapping("/allFactors/{corporation_id}")
    public ResultVO<List<CorporationFactorVo>> getFactors(@PathVariable Integer corporation_id){
        return informationService.getFactors(corporation_id);
    }
}
