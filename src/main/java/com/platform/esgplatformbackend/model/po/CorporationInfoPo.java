package com.platform.esgplatformbackend.model.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CorporationInfoPo {
    @JsonProperty(value = "corporation_id")
    private Integer corporation_id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "introduction")
    private String introduction;

    @JsonProperty(value = "industry")
    private String industry;

    @JsonProperty(value = "location")
    private String location;

    @JsonProperty(value = "stoke")
    private Integer stoke;

    @JsonProperty(value = "ESG_risky_score")
    private Double ESG_risky_score;

    @JsonProperty(value = "ESG_steady_score")
    private Double ESG_steady_score;

    @JsonProperty(value = "ESG_weighted_score")
    private Double ESG_weighted_score;
}
