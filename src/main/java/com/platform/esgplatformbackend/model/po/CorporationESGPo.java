package com.platform.esgplatformbackend.model.po;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.platform.esgplatformbackend.model.vo.CorporationESGVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationESGPo {

  private int corporation_id;

  private int ESG_total_ranking;

  private int ESG_industry_ranking;

  private int record_id;

  private int esg_id;

  public CorporationESGPo(CorporationESGVo vo){
    BeanUtils.copyProperties(vo,this);
  }
}
