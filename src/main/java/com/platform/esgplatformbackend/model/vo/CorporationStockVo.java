package com.platform.esgplatformbackend.model.vo;

import com.platform.esgplatformbackend.model.po.CorporationStockPo;
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
public class CorporationStockVo {
    private int corporation_id;

    private Date time;

    private BigDecimal price;

    public CorporationStockVo(CorporationStockPo po){
        BeanUtils.copyProperties(po,this);
    }
}
