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
    private Integer corporation_id;

    private Integer time;

    private Integer post;

    private Integer replies;

    private Integer likes;

    private Integer reposts;

    private Double sentiment_avg;

    private Double sentiment_sum;

    private Integer opinion_id;

    public CorporationOpinionVo(CorporationOpinionPo po){
        BeanUtils.copyProperties(po,this);
    }
}
