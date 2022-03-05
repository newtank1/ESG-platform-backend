package com.platform.esgplatformbackend.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationOpinionPo {
    private int corporation_id;

    private Date time;

    private String opinion_text;

    private double opinion_score;
}
