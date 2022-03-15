package com.platform.esgplatformbackend.controller;

import com.platform.esgplatformbackend.model.vo.CorporationESGScoreVo;
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



    @GetMapping("/")
    public ResultVO<List<CorporationInfoVo>> getBySearching(@RequestParam(name="name",required = false) String name,
                                                            @RequestParam(name="industry",required = false) String industry,
                                                            @RequestParam(name="location",required = false) String location,
                                                            @RequestParam(name="rate") double rate){
        return searchService.getBySearching(name,industry,location,rate);
    }

    @GetMapping("/name/{name}")
    public ResultVO<List<CorporationESGScoreVo>> getByName(@PathVariable String name){
        return searchService.getByName(name);
    }
}
