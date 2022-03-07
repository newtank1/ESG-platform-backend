package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationStockPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CorporationStockMapper {
    @Insert("insert into corporation_stock(corporation_id,time,price) values(#{corporation_id},#{time},#{price})")
    int insert(CorporationStockPo po);
}
