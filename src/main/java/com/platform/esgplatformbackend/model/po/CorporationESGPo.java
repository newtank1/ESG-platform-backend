package com.platform.esgplatformbackend.model.po;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationESGPo {

  private long corporation_id;

  private long ESG_total_ranking;

  private long ESG_industry_ranking;

  private long record_id;


}
