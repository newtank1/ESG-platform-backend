package com.platform.esgplatformbackend.model.po;

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
    private Integer corporation_id;

    private String name;

    private Integer stoke;

    private String industry;

    private String location;

    private Integer ESG_total_ranking;

    private Integer ESG_industry_ranking;

    private Integer record_id;

    private Integer esg_id;

    private double ESG_total_score;

    private Date time;

}
