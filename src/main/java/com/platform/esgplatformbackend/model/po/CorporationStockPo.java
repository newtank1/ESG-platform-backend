package com.platform.esgplatformbackend.model.po;

import com.platform.esgplatformbackend.model.vo.CorporationStockVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationStockPo {
    private int corporation_id;

    private Date time;

    private BigDecimal price;

    public CorporationStockPo(CorporationStockVo vo){
        BeanUtils.copyProperties(vo,this);
    }
}
