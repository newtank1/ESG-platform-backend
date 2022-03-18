package com.platform.esgplatformbackend.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FactorVo {
    private String name;
    private Double score;
    private Double ratio;
    private String level;
}
