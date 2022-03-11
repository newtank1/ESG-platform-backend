package com.platform.esgplatformbackend.model.po;

import com.platform.esgplatformbackend.model.vo.CorporationEventVo;
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
public class CorporationEventPo {
    private Integer corporation_id;

    private Date time;

    private String event;

    private Integer event_id;
    public CorporationEventPo(CorporationEventVo vo){
        BeanUtils.copyProperties(vo,this);
    }
}
