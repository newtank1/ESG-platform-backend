package com.platform.esgplatformbackend.service;

import com.platform.esgplatformbackend.model.vo.CorporationInfoVo;
import com.platform.esgplatformbackend.model.vo.ResultVO;
import com.platform.esgplatformbackend.util.Constant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SearchTest {
    @Autowired
    SearchService searchService;

    static int corporation_id=1;

//    @Test
//    void getById(){
//        ResultVO<CorporationInfoVo> resultVO=searchService.getById(corporation_id);
//        assertEquals(Constant.REQUEST_SUCCESS,resultVO.getCode());
//        assertEquals("xya",resultVO.getData().getName());
//    }


}
