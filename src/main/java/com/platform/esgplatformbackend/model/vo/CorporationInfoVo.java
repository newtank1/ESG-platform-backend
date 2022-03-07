package com.platform.esgplatformbackend.model.vo;


import com.platform.esgplatformbackend.model.po.CorporationInfoPo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CorporationInfoVo {
    private int corporation_id;

    private String name;

    private int stoke;

    private String industry;

    private String location;

    private int ESG_total_ranking;

    private int ESG_industry_ranking;

    private int record_id;

    private int esg_id;

    private double ESG_total_score;

    public CorporationInfoVo(CorporationInfoPo po){
        BeanUtils.copyProperties(po,this);
    }
}
