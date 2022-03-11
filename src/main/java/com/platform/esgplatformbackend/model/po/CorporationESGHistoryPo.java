package com.platform.esgplatformbackend.model.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.platform.esgplatformbackend.model.vo.CorporationESGHistoryVo;
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
public class CorporationESGHistoryPo {
    private Integer corporation_id;

    private Integer record_id;

    private Date time;

    private Double ESG_total_score;

    private Double E_score;

    private Double S_score;

    private Double G_score;

    private Integer e_punished;

    private Integer e_have_accidents;

    private Integer e_monitored;

    private Integer e_publish_idea;

    private Integer e_publish_goal;

    private Integer e_publish_regulation;

    private Integer e_use_emergency;

    private Integer e_three_wastes_measure;

    private Integer e_education;

    private Double e_investment;

    private Integer e_recycle_eco;

    private Integer e_save_resource;

    private Integer e_green_office;

    private Integer e_invention;

    private Integer e_useful_invention;

    private Integer e_action;

    private Integer e_product;

    private Integer e_certification;

    private Integer e_award;

    private Integer e_pollution;

    private Double s_poverty_alleviation_amount;

    private Integer s_poverty_escape;

    private Integer s_poverty_future_plan;

    private Integer s_poverty_activity;

    private Integer s_publish_staff_protection;

    private Integer s_publish_supplier_protection;

    private Integer s_publish_responsibility;

    private Integer s_publish_responsibility_construction;

    private Integer s_publish_safe_production;

    private Integer s_product_issue;

    private Double s_donation;

    private Integer s_support_education;

    private Integer s_support_charity;

    private Integer s_volunteer;

    private Integer s_international_assistance;

    private Integer s_activate_employment;

    private Integer s_promote_economy;

    private Integer s_quality_award;

    private Integer s_patent;

    private Double s_research_pay;

    private Double s_researcher_proportion;

    private Double s_skill_proportion;

    private Integer s_anti_corruption;

    private Integer s_share_strategy;

    private Integer s_operation_integrity;

    private Integer s_employee_safe_issue;

    private Integer s_layoff;

    private Integer s_employee_stake;

    private Integer s_employee_welfare;

    private Integer s_safe_management;

    private Integer s_safe_education;

    private Integer s_employment_safety_certification;

    private Integer s_employment_safety_education;

    private Integer s_employee_communication;

    private Double g_directors;

    private Double g_supervisors;

    private Double g_executives;

    private Double g_independent_directors;

    private Double g_primary_stockholder;

    private Double g_cash_bonus_proportion;

    private Double g_capital_award;

    private Double g_interest_guarantee;

    private Double g_net_asset_reward;

    private Integer g_finance_audit;

    private Integer g_control_audit;

    private Double g_executive_quitting;

    private Double g_nonrecurring_gains_and_losses;

    private Integer g_dishonesty_person;

    private Integer g_dishonesty_action;

    private Integer g_dishonesty_punished;

    private Integer g_illegal;

    private Integer g_have_extra_finance_form;

    private Integer g_willing_publish;

    private Integer g_have_publish;

    private Integer g_publish_quality;

    public CorporationESGHistoryPo(CorporationESGHistoryVo vo){
        BeanUtils.copyProperties(vo,this);
    }
}
