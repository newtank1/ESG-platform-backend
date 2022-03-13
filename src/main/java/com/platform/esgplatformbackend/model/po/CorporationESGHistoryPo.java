package com.platform.esgplatformbackend.model.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.platform.esgplatformbackend.model.vo.CorporationESGHistoryVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationESGHistoryPo {

    @JsonProperty(value = "corporation_id")
    private Integer corporation_id;

    @JsonProperty(value = "record_id")
    private Integer record_id;

    @JsonProperty(value = "time")
    private Date time;

    @JsonProperty(value = "steady_record_id")
    private Integer steady_record_id;

    @JsonProperty(value = "risky_record_id")
    private Integer risky_record_id;

    public CorporationESGHistoryPo(CorporationESGHistoryVo vo){
        BeanUtils.copyProperties(vo,this);
    }
}

