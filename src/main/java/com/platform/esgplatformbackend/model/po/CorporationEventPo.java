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
public class CorporationEventPo {
    private int corporation_id;

    private Date time;

    private String event;
}
