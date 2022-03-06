package com.platform.esgplatformbackend.mapper;

import com.platform.esgplatformbackend.dao.CorporationEventMapper;
import com.platform.esgplatformbackend.model.po.CorporationEventPo;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EventTest {
    @Autowired
    CorporationEventMapper corporationEventMapper;

    static String event="eeee";
    static Date time=new Date(System.currentTimeMillis());
    static Integer event_id;
    static Integer corporation_id=1;

    @Test
    @Order(0)
    void insert(){
        CorporationEventPo po=new CorporationEventPo();
        po.setCorporation_id(corporation_id);
        po.setEvent(event);
        po.setTime(time);
        assertEquals(1,corporationEventMapper.insert(po));
        event_id =po.getEvent_id();
        assertEquals(3,corporationEventMapper.getEvents(1).size());
    }

    @Test
    @Order(1)
    void getByCorporationId(){
        List<CorporationEventPo> list=corporationEventMapper.getEvents(corporation_id);
        assertEquals(3,list.size());
        System.out.println(list);
    }

    @Test
    @Order(2)
    void getByTime(){
        List<CorporationEventPo> list=corporationEventMapper.getEventsByTime(corporation_id,7);
        assertEquals(2,list.size());
        list=corporationEventMapper.getEventsByTime(corporation_id,8);
        assertEquals(3,list.size());
    }

    @Test
    @Order(3)
    void getByEventId(){
        CorporationEventPo po=corporationEventMapper.getEventByEventId(event_id);
        assertEquals(event,po.getEvent());
    }

    @Test
    @Order(4)
    void update(){
        assertEquals(1,corporationEventMapper.update("bb",event_id));
        assertEquals("bb",corporationEventMapper.getEventByEventId(event_id).getEvent());
    }

    @Test
    @Order(10)
    void delete(){
        assertEquals(1,corporationEventMapper.delete(event_id));
        assertEquals(2,corporationEventMapper.getEvents(1).size());
    }
}
