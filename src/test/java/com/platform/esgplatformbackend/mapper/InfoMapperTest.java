//package com.platform.esgplatformbackend.mapper;
//
//import com.platform.esgplatformbackend.dao.CorporationInfoMapper;
//import com.platform.esgplatformbackend.model.po.CorporationInfoPo;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//public class InfoMapperTest {
//    @Autowired
//    CorporationInfoMapper corporationInfoMapper;
//
//    static Integer id;
//    static String name="xya";
//    static Integer stoke=123;
//    static String industry="chemistry";
//    static String location="nanjing";
//    @Test
//    @Order(3)
//    void getByName(){
//        List<CorporationInfoPo> list=corporationInfoMapper.getCorporationBySearching("x",null,null);
//        assertNotNull(list);
//        assertNotEquals(0,list.size());
//        boolean accept=false;
//        for(CorporationInfoPo po:list){
//            if (name.equals(po.getName())) {
//                accept = true;
//                break;
//            }
//        }
//        assertTrue(accept);
//    }
//
//    @Test
//    @Order(4)
//    void getByIndustry(){
//        List<CorporationInfoPo> list=corporationInfoMapper.getCorporationBySearching(null,industry,null);
//        assertNotNull(list);
//        assertNotEquals(0,list.size());
//        CorporationInfoPo po=list.get(0);
//        System.out.println(po);
//    }
//
//    @Test
//    @Order(5)
//    void getByAll(){
//        List<CorporationInfoPo> list=corporationInfoMapper.getCorporationBySearching("x",industry,null);
//        assertNotNull(list);
//        System.out.println(list);
//        assertEquals(1,list.size());
//    }
//}
