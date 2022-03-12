package com.platform.esgplatformbackend.controller;

import com.platform.esgplatformbackend.model.vo.CorporationInfoVo;
import com.platform.esgplatformbackend.model.vo.ResultVO;
import com.platform.esgplatformbackend.service.SearchService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/search")
public class SearchController {
    @Resource
    private SearchService searchService;

    @GetMapping("/id/{corporation_id}")
    public ResultVO<CorporationInfoVo> getById(@PathVariable Integer corporation_id){
        return searchService.getById(corporation_id);
    }

    @GetMapping("/total")
    public ResultVO<List<CorporationInfoVo>> getByTotalRanking(@RequestParam(name="limit",required = false) Integer limit){
        if (limit == null) {
            limit=50;
        }
        return searchService.getByTotalRanking(limit);
    }

    @GetMapping("/industry/{industry}")
    public ResultVO<List<CorporationInfoVo>> getByIndustryRanking(@PathVariable String industry,@RequestParam(name="limit",required = false) Integer limit){
        if (limit == null) {
            limit=50;
        }
        return searchService.getByIndustryRanking(industry,limit);
    }

    @GetMapping("/")
    public ResultVO<List<CorporationInfoVo>> getBySearching(@RequestParam(name="name",required = false) String name,
                                                            @RequestParam(name="industry",required = false) String industry,
                                                            @RequestParam(name="location",required = false) String location){
        return searchService.getBySearching(name,industry,location);
    }
}
