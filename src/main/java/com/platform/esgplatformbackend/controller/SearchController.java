package com.platform.esgplatformbackend.controller;

import com.platform.esgplatformbackend.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService){
        this.searchService=searchService;
    }
}
