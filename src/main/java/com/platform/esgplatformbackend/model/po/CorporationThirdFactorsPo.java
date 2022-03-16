package com.platform.esgplatformbackend.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationThirdFactorsPo implements CorporationFactorPo{

    private int corporation_id;

    private String industry;

    private int record_id;

    private int score_record_id;

    private String score_type;

    private int e_punished;

    private int e_have_accidents;

    private int e_monitored;

    private int e_publish_idea;

    private int e_publish_goal;

    private int e_publish_regulation;

    private int e_use_emergency;

    private int e_three_wastes_measure;

    private int e_education;

    private double e_investment;

    private int e_recycle_eco;

    private int e_save_resource;

    private int e_green_office;

    private int e_invention;

    private int e_useful_invention;

    private int e_action;

    private int e_product;

    private int e_certification;

    private int e_award;

    private int e_pollution;

    private double s_poverty_alleviation_amount;

    private int s_poverty_escape;

    private int s_poverty_future_plan;

    private int s_poverty_activity;

    private int s_publish_staff_protection;

    private int s_publish_supplier_protection;

    private int s_publish_responsibility;

    private int s_publish_responsibility_construction;

    private int s_publish_safe_production;

    private int s_product_issue;

    private double s_donation;

    private int s_support_education;

    private int s_support_charity;

    private int s_volunteer;

    private int s_international_assistance;

    private int s_activate_employment;

    private int s_promote_economy;

    private int s_quality_award;

    private int s_patent;

    private double s_research_pay;

    private double s_researcher_proportion;

    private double s_skill_proportion;

    private int s_anti_corruption;

    private int s_share_strategy;

    private int s_operation_integrity;

    private int s_employee_safe_issue;

    private int s_layoff;

    private int s_employee_stake;

    private int s_employee_welfare;

    private int s_safe_management;

    private int s_safe_education;

    private int s_employment_safety_certification;

    private int s_employment_safety_education;

    private int s_employee_communication;

    private double g_directors;

    private double g_supervisors;

    private double g_executives;

    private double g_independent_directors;

    private double g_primary_stockholder;

    private double g_cash_bonus_proportion;

    private double g_capital_award;

    private double g_interest_guarantee;

    private double g_net_asset_reward;

    private int g_finance_audit;

    private int g_control_audit;

    private double g_executive_quitting;

    private double g_nonrecurring_gains_and_losses;

    private int g_dishonesty_person;

    private int g_dishonesty_action;

    private int g_dishonesty_punished;

    private int g_illegal;

    private int g_have_extra_finance_form;

    private int g_willing_publish;

    private int g_have_publish;

    private int g_publish_quality;


}
