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
    private Integer corporation_id;

    private String name;

    private Integer stoke;

    private String industry;

    private String location;

    private String introduction;

    public CorporationBasicVo(CorporationBasicPo po){
        BeanUtils.copyProperties(po,this);
    }
}