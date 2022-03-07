package com.platform.esgplatformbackend.model.po;

import com.platform.esgplatformbackend.model.vo.CorporationEventVo;
import com.platform.esgplatformbackend.model.vo.CorporationOpinionVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationOpinionPo {
    private int corporation_id;

    private Date time;

    private String opinion_text;

    private double opinion_score;
    public CorporationOpinionPo(CorporationOpinionVo vo){
        BeanUtils.copyProperties(vo,this);
    }
}
