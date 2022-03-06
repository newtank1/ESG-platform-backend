package com.platform.esgplatformbackend.mapper;

import com.platform.esgplatformbackend.dao.CorporationESGMapper;
import com.platform.esgplatformbackend.model.po.CorporationESGPo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ESGTest {
    @Autowired
    CorporationESGMapper corporationESGMapper;

    static Integer corporation_id=2;
    static Integer ESG_total_ranking=2;
    static Integer ESG_industry_ranking=1;
    static Integer record_id=2;
    static Integer esg_id;
    @Test
    @Order(0)
    void insert(){
        CorporationESGPo po=new CorporationESGPo();
        po.setCorporation_id(corporation_id);
        po.setESG_industry_ranking(ESG_industry_ranking);
        po.setESG_total_ranking(ESG_total_ranking);
        po.setRecord_id(record_id);
        assertEquals(1,corporationESGMapper.insert(po));
        esg_id=po.getEsg_id();
    }
    @Test
    @Order(1)
    void getByCorporationId(){
        CorporationESGPo po=corporationESGMapper.getESGByCorporationId(corporation_id);
        assertEquals(2,po.getCorporation_id());
        assertEquals(ESG_total_ranking,po.getESG_total_ranking());
    }

    @Test
    @Order(2)
    void getBySort(){
        List<CorporationESGPo> list=corporationESGMapper.getESGByTotalRanking(3);
        System.out.println(list);
        CorporationESGPo po1=corporationESGMapper.getESGByCorporationId(4);
        CorporationESGPo po2=corporationESGMapper.getESGByCorporationId(corporation_id);
        assertTrue(list.contains(po2));
        assertFalse(list.contains(po1));
    }

    @Test
    @Order(3)
    void update(){
        assertEquals(1,corporationESGMapper.update(9,9,record_id,esg_id));
    }

    @Test
    @Order(10)
    void delete(){
        assertEquals(1,corporationESGMapper.delete(esg_id));
        assertNull(corporationESGMapper.getESGByESGId(esg_id));
    }
}
