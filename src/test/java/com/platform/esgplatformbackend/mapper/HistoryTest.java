package com.platform.esgplatformbackend.mapper;

import com.platform.esgplatformbackend.dao.CorporationESGHistoryMapper;
import com.platform.esgplatformbackend.model.po.CorporationESGHistoryPo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HistoryTest {
    @Autowired
    CorporationESGHistoryMapper corporationESGHistoryMapper;

    static int corporation_id=1;
    static int record_id;
    static Date time=new Date(System.currentTimeMillis());
    static double ESG_total_score=5;
    static double E_score=1;
    static double S_score=2;
    static double G_score=3;
    @Test
    @Order(0)
    void insert(){
        CorporationESGHistoryPo po=new CorporationESGHistoryPo();
        po.setCorporation_id(corporation_id);
        po.setESG_total_score(ESG_total_score);
        po.setE_score(E_score);
        po.setS_score(S_score);
        po.setG_score(G_score);
        po.setTime(time);
        assertEquals(1,corporationESGHistoryMapper.insert(po));
        record_id=po.getRecord_id();
        assertEquals(po.getESG_total_score(),corporationESGHistoryMapper.getByRecordId(record_id).getESG_total_score());
    }

    @Test
    @Order(1)
    void getByCorporationId(){
        List<CorporationESGHistoryPo> list=corporationESGHistoryMapper.getByCorporationId(corporation_id);
        assertEquals(2,list.size());
    }

    @Test
    @Order(2)
    void update(){
        CorporationESGHistoryPo po=corporationESGHistoryMapper.getByRecordId(record_id);
        po.setESG_total_score(10.0);
        assertEquals(1,corporationESGHistoryMapper.update(po));
        assertEquals(10,corporationESGHistoryMapper.getByRecordId(record_id).getESG_total_score());
    }
    @Test
    @Order(10)
    void delete(){
        assertEquals(1,corporationESGHistoryMapper.delete(record_id));
        assertNull(corporationESGHistoryMapper.getByRecordId(record_id));
    }
}
