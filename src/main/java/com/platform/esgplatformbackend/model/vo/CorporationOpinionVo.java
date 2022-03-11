package com.platform.esgplatformbackend.model.vo;

import com.platform.esgplatformbackend.model.po.CorporationOpinionPo;
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
public class CorporationOpinionVo {
    private int corporation_id;

    private Date time;

    private String opinion_text;

    private Double opinion_score;

    private Integer opinion_id;

    public CorporationOpinionVo(CorporationOpinionPo po){
        BeanUtils.copyProperties(po,this);
    }
}
