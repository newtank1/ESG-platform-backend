package com.platform.esgplatformbackend.model.vo;

import com.platform.esgplatformbackend.model.po.PolicyPo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyVo {
    private String location;

    private String time;

    private String content;

    private String industry;

    private Integer attitude;

    private Integer is_supported;

    private Integer is_supported_n;

    public PolicyVo(PolicyPo po){
        BeanUtils.copyProperties(po,this);
    }
}
