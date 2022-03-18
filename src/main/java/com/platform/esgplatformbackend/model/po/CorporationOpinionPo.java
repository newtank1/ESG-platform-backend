package com.platform.esgplatformbackend.model.po;

import com.platform.esgplatformbackend.model.vo.CorporationOpinionVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationOpinionPo {
    private Integer corporation_id;

    private Integer time;

    private Integer post;

    private Integer replies;

    private Integer likes;

    private Integer reposts;

    private Double sentiment_avg;

    private Double sentiment_sum;

    private Integer opinion_id;

    public CorporationOpinionPo(CorporationOpinionVo vo){
        BeanUtils.copyProperties(vo,this);
    }
}
