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

    @Test
    void getById(){
        ResultVO<CorporationInfoVo> resultVO=searchService.getById(corporation_id);
        assertEquals(Constant.REQUEST_SUCCESS,resultVO.getCode());
        assertEquals("xya",resultVO.getData().getName());
    }

    @Test
    void getBySearching(){
        boolean pass=false;
        List<CorporationInfoVo> vos=searchService.getBySearching("xy",null,null).getData();
        assertEquals(2,vos.size());
        for (CorporationInfoVo vo : vos) {
            if (vo.getName().equals("xya")) {
                pass = true;
                break;
            }
        }

        vos=searchService.getBySearching(null,"chemistry",null).getData();
        assertEquals(2,vos.size());
        for (CorporationInfoVo vo : vos) {
            if(vo.getName().equals("xy")) {
                pass = true;
                break;
            }
            if(vo.getName().equals("xya")){
                pass=false;
                break;
            }
        }

        vos=searchService.getBySearching(null,"chemistry","nanjing").getData();
        assertEquals(1,vos.size());
        for (CorporationInfoVo vo : vos) {
            if(vo.getName().equals("go")) {
                pass = true;
                break;
            }
            if(vo.getName().contains("xy")){
                pass=false;
                break;
            }
        }

        assertTrue(pass);
    }

    @Test
    void getByTotalRanking(){
        List<CorporationInfoVo> vos=searchService.getByTotalRanking(3).getData();
        assertEquals(3, vos.size());
        int pass1=0;
        for (CorporationInfoVo vo : vos) {
            if(vo.getName().equals("xy")) pass1++;
            if(vo.getName().equals("xya")) pass1++;
            if(vo.getName().equals("go")) pass1++;
        }
        assertEquals(3,pass1);
        vos=searchService.getByTotalRanking(2).getData();
        assertEquals(2, vos.size());
        int pass2=0;
        for (CorporationInfoVo vo : vos) {
            if(vo.getName().equals("xy")) pass2++;
            if(vo.getName().equals("xya")) pass2++;
            if(vo.getName().equals("go")) pass2+=5;
        }
        assertEquals(2,pass2);
    }

    @Test
    void getByIndustry(){
        List<CorporationInfoVo> vos=searchService.getByIndustryRanking("chemistry",2).getData();
        assertEquals(2, vos.size());
        int pass1=0;
        for (CorporationInfoVo vo : vos) {
            if(vo.getName().equals("xy")) pass1++;
            if(vo.getName().equals("xya")) pass1+=5;
            if(vo.getName().equals("go")) pass1++;
        }
        assertEquals(2,pass1);
        vos=searchService.getByIndustryRanking("chemistry",1).getData();
        assertEquals(1, vos.size());
        assertEquals("xy",vos.get(0).getName());
    }
}
