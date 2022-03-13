package com.platform.esgplatformbackend.model.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.platform.esgplatformbackend.model.po.CorporationFactorPo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationFactorVo {

@JsonProperty(value = "corporation_id")
  private Integer corporation_id;

@JsonProperty(value = "industry")
  private String industry;

@JsonProperty(value = "score_type")
  private String score_type;

@JsonProperty(value = "e_accident")
  private Double e_accident;

@JsonProperty(value = "e_publish")
  private Double e_publish;

@JsonProperty(value = "e_pollution_deal")
  private Double e_pollution_deal;

@JsonProperty(value = "e_benefit")
  private Double e_benefit;

@JsonProperty(value = "e_others")
  private Double e_others;

@JsonProperty(value = "s_poverty")
  private Double s_poverty;

@JsonProperty(value = "s_publish")
  private Double s_publish;

@JsonProperty(value = "s_issue")
  private Double s_issue;

@JsonProperty(value = "s_charity")
  private Double s_charity;

@JsonProperty(value = "s_product")
  private Double s_product;

@JsonProperty(value = "s_employee")
  private Double s_employee;

@JsonProperty(value = "g_structure")
  private Double g_structure;

@JsonProperty(value = "g_result")
  private Double g_result;

@JsonProperty(value = "g_audit")
  private Double g_audit;

@JsonProperty(value = "g_exception")
  private Double g_exception;

@JsonProperty(value = "g_visibility")
  private Double g_visibility;

  public CorporationFactorVo(CorporationFactorPo po){
    BeanUtils.copyProperties(po,this);
  }
}
