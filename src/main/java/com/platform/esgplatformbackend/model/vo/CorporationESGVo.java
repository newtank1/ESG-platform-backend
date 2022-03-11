package com.platform.esgplatformbackend.model.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.platform.esgplatformbackend.model.po.CorporationESGPo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationESGVo {

    private Integer corporation_id;

    @JsonProperty(value = "ESG_total_ranking")
    private Integer ESG_total_ranking;

    @JsonProperty(value = "ESG_industry_ranking")
    private Integer ESG_industry_ranking;

    private Integer record_id;

    private Integer esg_id;

    public CorporationESGVo(CorporationESGPo po){
        BeanUtils.copyProperties(po,this);
    }
}
