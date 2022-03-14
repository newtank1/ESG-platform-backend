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
        po.setRecord_id(record_id);
        assertEquals(1,corporationESGMapper.insert(po));
        esg_id=po.getEsg_id();
    }
    @Test
    @Order(1)
    void getByCorporationId(){
        CorporationESGPo po=corporationESGMapper.getESGByCorporationId(corporation_id);
        assertEquals(2,po.getCorporation_id());
    }

    @Test
    @Order(3)
    void update(){
        assertEquals(1,corporationESGMapper.update(9,9));
    }

    @Test
    @Order(10)
    void delete(){
        assertEquals(1,corporationESGMapper.delete(esg_id));
        assertNull(corporationESGMapper.getESGByESGId(esg_id));
    }
}
