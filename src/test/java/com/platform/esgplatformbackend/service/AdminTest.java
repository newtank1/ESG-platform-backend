package com.platform.esgplatformbackend.service;

import com.platform.esgplatformbackend.dao.CorporationBasicMapper;
import com.platform.esgplatformbackend.dao.CorporationESGHistoryMapper;
import com.platform.esgplatformbackend.dao.CorporationESGMapper;
import com.platform.esgplatformbackend.model.po.CorporationBasicPo;
import com.platform.esgplatformbackend.model.po.CorporationESGHistoryPo;
import com.platform.esgplatformbackend.model.po.CorporationESGPo;
import com.platform.esgplatformbackend.model.po.CorporationOpinionPo;
import com.platform.esgplatformbackend.model.vo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AdminTest {
//    private int corporation_id;
//    private String name;
//    private int stoke;
//    private String industry;
//    private String location;
    @Autowired
    AdminService adminService;
    @Autowired
    CorporationBasicMapper corporationBasicMapper;
    @Autowired
    CorporationESGHistoryMapper corporationESGHistoryMapper;
    @Autowired
    CorporationESGMapper corporationESGMapper;

    static String name="APPLE";
    static Integer stoke=123;
    static String industry="Foxconn";
    static String location="THERE";

    double score = 10;
    long ESG_total_ranking=100;
    long ESG_industry_ranking=100;

    private CorporationBasicVo generateCBVO(){
        CorporationBasicVo vo = new CorporationBasicVo();
        vo.setName(name);
        vo.setStoke(stoke);
        vo.setIndustry(industry);
        vo.setLocation(location);
        return vo;
    }

    private CorporationESGVo generateESGVO(){
        CorporationESGVo vo = new CorporationESGVo();
        vo.setScore(123);
        vo.setESG_total_ranking(10);
        vo.setESG_industry_ranking(1);
        return vo;
    }

    @Test
    @Transactional
    public void addCorporation(){
        CorporationBasicVo vo = generateCBVO();
        ResultVO<CorporationBasicVo> res = adminService.addCorporation(vo);
        CorporationBasicPo po = corporationBasicMapper.getCorporationByName(name);
        Assertions.assertEquals("APPLE",po.getName());
    }
    @Test
    @Transactional
    public void updateCorporationBasic(){
        CorporationBasicVo vo = generateCBVO();
        int line = corporationBasicMapper.insert(new CorporationBasicPo(vo));
        Assertions.assertEquals(1,line);
        CorporationBasicPo po = corporationBasicMapper.getCorporationByName(name);
        vo.setCorporation_id(po.getCorporation_id());
        vo.setLocation("HERE");
        ResultVO<CorporationBasicVo> res = adminService.updateCorporationBasic(vo);
        Assertions.assertEquals("HERE",res.getData().getLocation());
    }

    @Test
    @Transactional
    public void submitESG(){
        CorporationBasicPo po = new CorporationBasicPo();
        po.setIndustry(industry);
        po.setLocation(location);
        po.setStoke(stoke);
        po.setName(name);
        assertEquals(1,corporationBasicMapper.insert(po));
        int corporation_id=po.getCorporation_id();
//      `corporation_id` int(11) not null ,
//                                        `record_id` int(11) not null auto_increment,
//                                        `time` date not null ,
//                                        `ESG_total_score` double not null ,
        CorporationESGHistoryPo po1 = new CorporationESGHistoryPo();
        po1.setCorporation_id(corporation_id);
        po1.setTime(new Date(123));
        po1.setESG_total_score(123);
        assertEquals(1,corporationESGHistoryMapper.insert(po1));
        long record_id = po1.getRecord_id();

        CorporationESGVo vo = new CorporationESGVo();
        vo.setCorporation_id(corporation_id);
        vo.setRecord_id(record_id);
        vo.setScore(score);
        vo.setESG_total_ranking(ESG_total_ranking);
        vo.setESG_industry_ranking(ESG_industry_ranking);
        ResultVO<CorporationESGVo> res = adminService.submitESG(vo);
        Assertions.assertEquals(1,res.getCode());
    }

    @Test
    @Transactional
    public void submitOpinion(){
        // corporation_id
        CorporationBasicPo po = new CorporationBasicPo();
        po.setIndustry(industry);
        po.setLocation(location);
        po.setStoke(stoke);
        po.setName(name);
        assertEquals(1,corporationBasicMapper.insert(po));
        int id=po.getCorporation_id();

        CorporationOpinionVo vo = new CorporationOpinionVo();
        vo.setCorporation_id(id);
        vo.setTime(new Date(123));
        vo.setOpinion_text("......");
        vo.setOpinion_score(12);
        Assertions.assertEquals(1,adminService.submitOpinion(vo).getCode());
    }

    @Test
    @Transactional
    public void submitEvent(){
        CorporationBasicPo po = new CorporationBasicPo();
        po.setIndustry(industry);
        po.setLocation(location);
        po.setStoke(stoke);
        po.setName(name);
        assertEquals(1,corporationBasicMapper.insert(po));
        int id=po.getCorporation_id();

        CorporationEventVo vo = new CorporationEventVo();
        vo.setCorporation_id(id);
        vo.setTime(new Date(123));
        vo.setEvent("......");
        Assertions.assertEquals(1,adminService.submitEvent(vo).getCode());
    }

    @Test
    @Transactional
    public void submitStock(){
        CorporationBasicPo po = new CorporationBasicPo();
        po.setIndustry(industry);
        po.setLocation(location);
        po.setStoke(stoke);
        po.setName(name);
        assertEquals(1,corporationBasicMapper.insert(po));
        int id=po.getCorporation_id();

        CorporationStockVo vo = new CorporationStockVo();
        vo.setCorporation_id(id);
        vo.setTime(new Date(123));
        vo.setPrice(new BigDecimal(123));
        Assertions.assertEquals(1,adminService.submitStock(vo).getCode());
    }

    @Test
    @Transactional
    public void getESGHistory(){
        List<CorporationESGHistoryPo>res = adminService.getESGHistory(1);
        Assertions.assertEquals(0,res.size());
    }
}
