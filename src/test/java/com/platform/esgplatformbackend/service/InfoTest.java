package com.platform.esgplatformbackend.service;


import com.platform.esgplatformbackend.dao.CorporationESGMapper;
import com.platform.esgplatformbackend.model.vo.*;
import com.platform.esgplatformbackend.util.Constant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class InfoTest {

    @Autowired
    InformationService informationService;

    @Autowired
    CorporationESGMapper corporationESGMapper;

    static int corporation_id=1;

    @Test
    @Transactional
    void getEvents(){
        ResultVO<List<CorporationEventVo>> allEvents=informationService.getAllEventsByCorporationId(corporation_id);
        assertEquals(Constant.REQUEST_SUCCESS,allEvents.getCode());
        assertEquals(2,allEvents.getData().size());

        ResultVO<List<CorporationEventVo>> recentEvents=informationService.getRecentEventsByCorporationId(corporation_id,7);
        assertEquals(Constant.REQUEST_SUCCESS,recentEvents.getCode());
        assertEquals(1,recentEvents.getData().size());
        assertEquals("a",recentEvents.getData().get(0).getEvent());
    }

    @Test
    @Transactional
    void getOpinions(){
        ResultVO<List<CorporationOpinionVo>> allOpinions=informationService.getAllOpinionByCorporationId(corporation_id);
        assertEquals(Constant.REQUEST_SUCCESS,allOpinions.getCode());
        assertEquals(1,allOpinions.getData().size());
        assertEquals(1,allOpinions.getData().get(0).getOpinion_score());

        ResultVO<List<CorporationOpinionVo>> recentOpinions=informationService.getRecentOpinionByCorporationId(corporation_id,7);
        assertEquals(Constant.REQUEST_SUCCESS,recentOpinions.getCode());
        assertEquals(0,recentOpinions.getData().size());
    }

    @Test
    @Transactional
    void getStock(){
        ResultVO<List<CorporationStockVo>> stocks=informationService.getAllStockByCorporationId(corporation_id);
        assertEquals(Constant.REQUEST_SUCCESS,stocks.getCode());
        CorporationStockVo data=stocks.getData().get(0);
        assertEquals(new BigDecimal(10),data.getPrice());

        assertEquals(0,informationService.getRecentStockByCorporationId(corporation_id,7).getData().size());
    }


    @Test
    void getTopFactors(){
        informationService.getTopFactors(1,"risky",5);
    }
}
