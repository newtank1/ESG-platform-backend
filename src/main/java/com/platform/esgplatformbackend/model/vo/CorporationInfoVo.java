package com.platform.esgplatformbackend.model.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.platform.esgplatformbackend.model.po.CorporationInfoPo;
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
public class CorporationInfoVo {
    private Integer corporation_id;

    private String name;

    private Integer stoke;

    private String industry;

    private String location;

    @JsonProperty(value = "ESG_total_ranking")
    private Integer ESG_total_ranking;

    @JsonProperty(value = "ESG_industry_ranking")
    private Integer ESG_industry_ranking;

    private Integer record_id;

    private Integer esg_id;

    @JsonProperty(value = "ESG_total_score")
    private Double ESG_total_score;

    private Date time;

    public CorporationInfoVo(CorporationInfoPo po){
        BeanUtils.copyProperties(po,this);
    }
}
