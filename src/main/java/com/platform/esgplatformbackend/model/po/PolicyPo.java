package com.platform.esgplatformbackend.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyPo {
    private String location;

    private String time;

    private String content;

    private String industry;

    private Integer attitude;

    private Integer is_supported;

    private Integer is_supported_n;


}
