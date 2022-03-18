package com.platform.esgplatformbackend.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FactorRankVo {
    public String name;
    public int rank;

    public void addRank(){
        rank++;
    }


}
