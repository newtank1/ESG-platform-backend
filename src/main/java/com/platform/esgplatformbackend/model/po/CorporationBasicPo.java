package com.platform.esgplatformbackend.model.po;

import com.platform.esgplatformbackend.model.vo.CorporationBasicVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationBasicPo {
    private Integer corporation_id;

    private String name;

    private Integer stoke;

    private String industry;

    private String location;

    private String introduction;

    public CorporationBasicPo(CorporationBasicVo vo){
        corporation_id=vo.getCorporation_id();
        name=vo.getName();
        stoke=vo.getStoke();
        industry=vo.getIndustry();
        location=vo.getLocation();
        introduction=vo.getIntroduction();
    }
}
