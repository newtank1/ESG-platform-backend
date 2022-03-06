package com.platform.esgplatformbackend.service.impl;

import com.platform.esgplatformbackend.dao.CorporationBasicMapper;
import com.platform.esgplatformbackend.dao.CorporationESGMapper;
import com.platform.esgplatformbackend.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {

    private CorporationBasicMapper corporationBasicMapper;

    private CorporationESGMapper corporationESGMapper;

    @Autowired
    public SearchServiceImpl(CorporationESGMapper corporationESGMapper,CorporationBasicMapper corporationBasicMapper){
        this.corporationBasicMapper=corporationBasicMapper;
        this.corporationESGMapper=corporationESGMapper;
    }

}
