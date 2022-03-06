package com.platform.esgplatformbackend.model.vo;


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

    private int corporation_id;

    private int ESG_total_ranking;

    private int ESG_industry_ranking;

    private int record_id;

    private int esg_id;

    public CorporationESGVo(CorporationESGPo po){
        BeanUtils.copyProperties(po,this);
    }
}
