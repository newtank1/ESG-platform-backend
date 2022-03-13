package com.platform.esgplatformbackend.mapper;

import com.platform.esgplatformbackend.dao.CorporationBasicMapper;
import com.platform.esgplatformbackend.model.po.CorporationBasicPo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.platform.esgplatformbackend.dao.CorporationBasicMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BasicTest {
    @Autowired
    CorporationBasicMapper corporationBasicMapper;

    static Integer id;
    static String name="xyz";
    static Integer stoke=123;
    static String industry="chemistry";
    static String location="nanjing";

    @Test
    @Order(0)
    void insert(){
        CorporationBasicPo po=new CorporationBasicPo();
        po.setIndustry(industry);
        po.setLocation(location);
        po.setStoke(stoke);
        po.setName(name);
        assertEquals(1,corporationBasicMapper.insert(po));
        id=po.getCorporation_id();
    }

    @Test
    @Order(1)
    void findById(){
        CorporationBasicPo po=corporationBasicMapper.getCorporationById(id);
        assertNotNull(po);
        assertEquals(name,po.getName());
        assertEquals(industry,po.getIndustry());
        assertEquals(location,po.getLocation());
        assertEquals(stoke,po.getStoke());
    }

    @Test
    @Order(2)
    void getAll(){
        List<CorporationBasicPo> list=corporationBasicMapper.getAllCorporation();
        assertNotNull(list);
        assertNotEquals(0,list.size());
    }


    @Test
    @Order(6)
    void update(){
        assertEquals(1,corporationBasicMapper.update("xyb",124,industry,location,id,null));
        assertEquals("xyb",corporationBasicMapper.getCorporationById(id).getName());
    }
    @Test
    @Order(10)
    void delete(){
        assertEquals(1,corporationBasicMapper.delete(id));
        assertNull(corporationBasicMapper.getCorporationById(id));
    }
}
