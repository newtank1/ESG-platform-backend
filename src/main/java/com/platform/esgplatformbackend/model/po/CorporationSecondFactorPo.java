package com.platform.esgplatformbackend.model.po;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationSecondFactorPo implements CorporationFactorPo{

@JsonProperty(value = "corporation_id")
  private Integer corporation_id;

@JsonProperty(value = "industry")
  private String industry;

@JsonProperty(value = "score_type")
  private String score_type;

  @JsonProperty(value = "ESG_total_score")
  private Double ESG_total_score;

  @JsonProperty(value = "E_score")
  private Double E_score;

  @JsonProperty(value = "S_score")
  private Double S_score;

  @JsonProperty(value = "G_score")
  private Double G_score;

  @JsonProperty(value = "e_accident")
  private Double e_accident;

  @JsonProperty(value = "e_advantage")
  private Double e_advantage;

  @JsonProperty(value = "e_idea")
  private Double e_idea;

  @JsonProperty(value = "e_pollution")
  private Double e_pollution;

  @JsonProperty(value = "s_charity")
  private Double s_charity;

  @JsonProperty(value = "s_publish")
  private Double s_publish;

  @JsonProperty(value = "s_responsibility")
  private Double s_responsibility;

  @JsonProperty(value = "s_employee_variety")
  private Double s_employee_variety;

  @JsonProperty(value = "s_employee_guarantee")
  private Double s_employee_guarantee;

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


}
