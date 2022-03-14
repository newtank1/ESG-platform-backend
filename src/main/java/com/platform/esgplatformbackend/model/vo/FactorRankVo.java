package com.platform.esgplatformbackend.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FactorRankVo {
    public String name;
    public int rank;
    public double sum;

    public void addRank(){
        rank++;
    }

    public void addSum(double s){
        sum+=s;
    }

}
