package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationStockPo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Mapper
public interface CorporationStockMapper {

    @Select("select * from corporation_stock where corporation_id=#{corporation_id}")
    List<CorporationStockPo> getStocks(Integer corporation_id);

    @Select("select * from corporation_stock where corporation_id=#{corporation_id} and to_days(now())-to_days(time) <= #{day}")
    List<CorporationStockPo> getStocksByTime(Integer corporation_id,Integer day);

    @Select("select * from corporation_stock where stock_record_id=#{stock_record_id}")
    CorporationStockPo getStockByStockId(Integer stock_record_id);

    @Insert("insert into corporation_stock(corporation_id,time,price) values(#{corporation_id},#{time},#{price})")
    @Options(useGeneratedKeys = true,keyProperty = "stock_record_id")
    int insert(CorporationStockPo po);

    @Update("update corporation_stock set price=#{price} where stock_record_id=#{stock_record_id}")
    int update(BigDecimal price, Integer stock_record_id);

    @Delete("delete from corporation_stock where stock_record_id=#{stock_record_id}")
    int delete(Integer stock_record_id);
}
