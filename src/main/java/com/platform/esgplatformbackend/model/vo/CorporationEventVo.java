package com.platform.esgplatformbackend.model.vo;

import com.platform.esgplatformbackend.model.po.CorporationEventPo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CorporationEventVo {
    private int corporation_id;

    private Date time;

    private String event;

    public CorporationEventVo(CorporationEventPo po){
        BeanUtils.copyProperties(po,this);
    }
}