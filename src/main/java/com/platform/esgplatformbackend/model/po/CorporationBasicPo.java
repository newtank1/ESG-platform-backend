package com.platform.esgplatformbackend.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationBasicPo {
    private int corporation_id;

    private String name;

    private int stoke;

    private String industry;

    private String location;
}
