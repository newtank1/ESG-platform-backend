//package com.platform.esgplatformbackend.mapper;
//
//import com.platform.esgplatformbackend.dao.CorporationOpinionMapper;
//import com.platform.esgplatformbackend.model.po.CorporationOpinionPo;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.sql.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class OpinionTest {
//    @Autowired
//    CorporationOpinionMapper corporationOpinionMapper;
//
//    static Integer corporation_id=1;
//    static Date time=new Date(System.currentTimeMillis());
//    static String opinion_text="gbf";
//    static Double opinion_score=2.00;
//    static Integer opinion_id;
//
//    @Test
//    @Order(0)
//    void insert(){
//        CorporationOpinionPo po=new CorporationOpinionPo();
//        po.setOpinion_score(opinion_score);
//        po.setOpinion_text(opinion_text);
//        po.setCorporation_id(corporation_id);
//        po.setTime(time);
//        assertEquals(1,corporationOpinionMapper.insert(po));
//        opinion_id=po.getOpinion_id();
//    }
//
//    @Test
//    @Order(1)
//    void getByCorporationId(){
//        List<CorporationOpinionPo> list=corporationOpinionMapper.getOpinions(corporation_id);
//        assertEquals(2,list.size());
//        System.out.println(list);
//    }
//
//    @Test
//    @Order(2)
//    void getByTime(){
//        List<CorporationOpinionPo> list=corporationOpinionMapper.getOpinionsByTime(corporation_id,7);
//        assertEquals(1,list.size());
//        list=corporationOpinionMapper.getOpinionsByTime(corporation_id,30);
//        assertEquals(2,list.size());
//    }
//
//    @Test
//    @Order(3)
//    void getByOpinionId(){
//        CorporationOpinionPo po=corporationOpinionMapper.getOpinionByOpinionId(opinion_id);
//        assertEquals(opinion_text,po.getOpinion_text());
//    }
//
//    @Test
//    @Order(4)
//    void update(){
//        assertEquals(1,corporationOpinionMapper.update("bb",1.05,opinion_id));
//        assertEquals("bb",corporationOpinionMapper.getOpinionByOpinionId(opinion_id).getOpinion_text());
//        assertEquals(1.05,corporationOpinionMapper.getOpinionByOpinionId(opinion_id).getOpinion_score());
//    }
//
//    @Test
//    @Order(10)
//    void delete(){
//        assertEquals(1,corporationOpinionMapper.delete(opinion_id));
//        assertNull(corporationOpinionMapper.getOpinionByOpinionId(opinion_id));
//    }
//}
