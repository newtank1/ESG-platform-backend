package com.platform.esgplatformbackend.model.po;


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

  private long corporation_id;

  private double score;

  private long ESG_total_ranking;

  private long ESG_industry_ranking;

  private long record_id;

  public CorporationESGPo(CorporationESGVo vo){
    BeanUtils.copyProperties(vo,this);
  }
}
