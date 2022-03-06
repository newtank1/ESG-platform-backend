package com.platform.esgplatformbackend.mapper;

import com.platform.esgplatformbackend.dao.CorporationStockMapper;
import com.platform.esgplatformbackend.model.po.CorporationStockPo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StockTest {
    @Autowired
    CorporationStockMapper corporationStockMapper;

    static BigDecimal price=new BigDecimal("11.00");
    static Date time=new Date(System.currentTimeMillis());
    static Integer stock_record_id;
    static Integer corporation_id=1;

    @Test
    @Order(0)
    void insert(){
        CorporationStockPo po=new CorporationStockPo();
        po.setCorporation_id(corporation_id);
        po.setPrice(price);
        po.setTime(time);
        assertEquals(1,corporationStockMapper.insert(po));
        stock_record_id =po.getStock_record_id();
        assertEquals(2,corporationStockMapper.getStocks(1).size());
    }

    @Test
    @Order(1)
    void getByCorporationId(){
        List<CorporationStockPo> list=corporationStockMapper.getStocks(corporation_id);
        assertEquals(2,list.size());
        System.out.println(list);
    }

    @Test
    @Order(2)
    void getByTime(){
        List<CorporationStockPo> list=corporationStockMapper.getStocksByTime(corporation_id,7);
        assertEquals(1,list.size());
        list=corporationStockMapper.getStocksByTime(corporation_id,30);
        assertEquals(2,list.size());
    }

    @Test
    @Order(3)
    void getByStockId(){
        CorporationStockPo po=corporationStockMapper.getStockByStockId(stock_record_id);
        assertEquals(price.stripTrailingZeros(),po.getPrice());
    }

    @Test
    @Order(4)
    void update(){
        assertEquals(1,corporationStockMapper.update(new BigDecimal("12.00"),stock_record_id));
        assertEquals(new BigDecimal("12.00").stripTrailingZeros(),corporationStockMapper.getStockByStockId(stock_record_id).getPrice());
    }

    @Test
    @Order(10)
    void delete(){
        assertEquals(1,corporationStockMapper.delete(stock_record_id));
        assertEquals(1,corporationStockMapper.getStocks(1).size());
    }
}
