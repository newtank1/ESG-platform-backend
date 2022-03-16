package com.platform.esgplatformbackend.model.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.platform.esgplatformbackend.model.vo.CorporationESGScoreVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationESGScorePo {
    @JsonProperty(value = "corporation_id")
    private Integer corporation_id;

    @JsonProperty(value = "score_record_id")
    private Integer score_record_id;

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

    @JsonProperty(value = "e_punished")
    private Double e_punished;

    @JsonProperty(value = "e_have_accidents")
    private Double e_have_accidents;

    @JsonProperty(value = "e_monitored")
    private Double e_monitored;

    @JsonProperty(value = "e_publish_idea")
    private Double e_publish_idea;

    @JsonProperty(value = "e_publish_goal")
    private Double e_publish_goal;

    @JsonProperty(value = "e_publish_regulation")
    private Double e_publish_regulation;

    @JsonProperty(value = "e_use_emergency")
    private Double e_use_emergency;

    @JsonProperty(value = "e_three_wastes_measure")
    private Double e_three_wastes_measure;

    @JsonProperty(value = "e_education")
    private Double e_education;

    @JsonProperty(value = "e_investment")
    private Double e_investment;

    @JsonProperty(value = "e_recycle_eco")
    private Double e_recycle_eco;

    @JsonProperty(value = "e_save_resource")
    private Double e_save_resource;

    @JsonProperty(value = "e_green_office")
    private Double e_green_office;

    @JsonProperty(value = "e_invention")
    private Double e_invention;

    @JsonProperty(value = "e_useful_invention")
    private Double e_useful_invention;

    @JsonProperty(value = "e_action")
    private Double e_action;

    @JsonProperty(value = "e_product")
    private Double e_product;

    @JsonProperty(value = "e_certification")
    private Double e_certification;

    @JsonProperty(value = "e_award")
    private Double e_award;

    @JsonProperty(value = "e_pollution")
    private Double e_pollution;

    @JsonProperty(value = "s_poverty_alleviation_amount")
    private Double s_poverty_alleviation_amount;

    @JsonProperty(value = "s_poverty_escape")
    private Double s_poverty_escape;

    @JsonProperty(value = "s_poverty_future_plan")
    private Double s_poverty_future_plan;

    @JsonProperty(value = "s_poverty_activity")
    private Double s_poverty_activity;

    @JsonProperty(value = "s_publish_staff_protection")
    private Double s_publish_staff_protection;

    @JsonProperty(value = "s_publish_supplier_protection")
    private Double s_publish_supplier_protection;

    @JsonProperty(value = "s_publish_responsibility")
    private Double s_publish_responsibility;

    @JsonProperty(value = "s_publish_responsibility_construction")
    private Double s_publish_responsibility_construction;

    @JsonProperty(value = "s_publish_safe_production")
    private Double s_publish_safe_production;

    @JsonProperty(value = "s_product_issue")
    private Double s_product_issue;

    @JsonProperty(value = "s_donation")
    private Double s_donation;

    @JsonProperty(value = "s_support_education")
    private Double s_support_education;

    @JsonProperty(value = "s_support_charity")
    private Double s_support_charity;

    @JsonProperty(value = "s_volunteer")
    private Double s_volunteer;

    @JsonProperty(value = "s_international_assistance")
    private Double s_international_assistance;

    @JsonProperty(value = "s_activate_employment")
    private Double s_activate_employment;

    @JsonProperty(value = "s_promote_economy")
    private Double s_promote_economy;

    @JsonProperty(value = "s_quality_award")
    private Double s_quality_award;

    @JsonProperty(value = "s_patent")
    private Double s_patent;

    @JsonProperty(value = "s_research_pay")
    private Double s_research_pay;

    @JsonProperty(value = "s_researcher_proportion")
    private Double s_researcher_proportion;

    @JsonProperty(value = "s_skill_proportion")
    private Double s_skill_proportion;

    @JsonProperty(value = "s_anti_corruption")
    private Double s_anti_corruption;

    @JsonProperty(value = "s_share_strategy")
    private Double s_share_strategy;

    @JsonProperty(value = "s_operation_integrity")
    private Double s_operation_integrity;

    @JsonProperty(value = "s_employee_safe_issue")
    private Double s_employee_safe_issue;

    @JsonProperty(value = "s_layoff")
    private Double s_layoff;

    @JsonProperty(value = "s_employee_stake")
    private Double s_employee_stake;

    @JsonProperty(value = "s_employee_welfare")
    private Double s_employee_welfare;

    @JsonProperty(value = "s_safe_management")
    private Double s_safe_management;

    @JsonProperty(value = "s_safe_education")
    private Double s_safe_education;

    @JsonProperty(value = "s_employment_safety_certification")
    private Double s_employment_safety_certification;

    @JsonProperty(value = "s_employment_safety_education")
    private Double s_employment_safety_education;

    @JsonProperty(value = "s_employee_communication")
    private Double s_employee_communication;

    @JsonProperty(value = "g_directors")
    private Double g_directors;

    @JsonProperty(value = "g_supervisors")
    private Double g_supervisors;

    @JsonProperty(value = "g_executives")
    private Double g_executives;

    @JsonProperty(value = "g_independent_directors")
    private Double g_independent_directors;

    @JsonProperty(value = "g_primary_stockholder")
    private Double g_primary_stockholder;

    @JsonProperty(value = "g_cash_bonus_proportion")
    private Double g_cash_bonus_proportion;

    @JsonProperty(value = "g_capital_award")
    private Double g_capital_award;

    @JsonProperty(value = "g_interest_guarantee")
    private Double g_interest_guarantee;

    @JsonProperty(value = "g_net_asset_reward")
    private Double g_net_asset_reward;

    @JsonProperty(value = "g_finance_audit")
    private Double g_finance_audit;

    @JsonProperty(value = "g_control_audit")
    private Double g_control_audit;

    @JsonProperty(value = "g_executive_quitting")
    private Double g_executive_quitting;

    @JsonProperty(value = "g_nonrecurring_gains_and_losses")
    private Double g_nonrecurring_gains_and_losses;

    @JsonProperty(value = "g_dishonesty_person")
    private Double g_dishonesty_person;

    @JsonProperty(value = "g_dishonesty_action")
    private Double g_dishonesty_action;

    @JsonProperty(value = "g_dishonesty_punished")
    private Double g_dishonesty_punished;

    @JsonProperty(value = "g_illegal")
    private Double g_illegal;

    @JsonProperty(value = "g_have_extra_finance_form")
    private Double g_have_extra_finance_form;

    @JsonProperty(value = "g_willing_publish")
    private Double g_willing_publish;

    @JsonProperty(value = "g_have_publish")
    private Double g_have_publish;

    @JsonProperty(value = "g_publish_quality")
    private Double g_publish_quality;

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

    public CorporationESGScorePo(CorporationESGScoreVo vo){
        BeanUtils.copyProperties(vo,this);
    }
}
