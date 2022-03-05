package com.platform.esgplatformbackend.model.vo;

import com.platform.esgplatformbackend.model.po.CorporationBasicPo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationBasicVo {
    private int corporation_id;

    private String name;

    private int stoke;

    private String industry;

    private String location;

    public CorporationBasicVo(CorporationBasicPo po){
        BeanUtils.copyProperties(po,this);
    }
}