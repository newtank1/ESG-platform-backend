package com.platform.esgplatformbackend.model.vo;

import com.platform.esgplatformbackend.model.po.CorporationOldIndustryPo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CorporationOldIndustryVo {
    private Integer corporation_id;
    private String old_industry;

    public CorporationOldIndustryVo(CorporationOldIndustryPo po){
        BeanUtils.copyProperties(po,this);
    }
}
