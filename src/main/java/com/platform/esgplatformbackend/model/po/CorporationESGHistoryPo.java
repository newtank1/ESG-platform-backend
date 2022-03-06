package com.platform.esgplatformbackend.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporationESGHistoryPo {
    private long corporation_id;

    private long record_id;

    private Date time;

    private double ESG_total_score;

    private double E_score;

    private double S_score;

    private double G_score;

    private long e_punished;

    private long e_have_accidents;

    private long e_monitored;

    private long e_publish_idea;

    private long e_publish_goal;

    private long e_publish_regulation;

    private long e_use_emergency;

    private long e_three_wastes_measure;

    private long e_education;

    private double e_investment;

    private long e_recycle_eco;

    private long e_save_resource;

    private long e_green_office;

    private long e_invention;

    private long e_useful_invention;

    private long e_action;

    private long e_product;

    private long e_certification;

    private long e_award;

    private long e_pollution;

    private double s_poverty_alleviation_amount;

    private long s_poverty_escape;

    private long s_poverty_future_plan;

    private long s_poverty_activity;

    private long s_publish_staff_protection;

    private long s_publish_supplier_protection;

    private long s_publish_responsibility;

    private long s_publish_responsibility_construction;

    private long s_publish_safe_production;

    private long s_product_issue;

    private double s_donation;

    private long s_support_education;

    private long s_support_charity;

    private long s_volunteer;

    private long s_international_assistance;

    private long s_activate_employment;

    private long s_promote_economy;

    private long s_quality_award;

    private long s_patent;

    private double s_research_pay;

    private double s_researcher_proportion;

    private double s_skill_proportion;

    private long s_anti_corruption;

    private long s_share_strategy;

    private long s_operation_integrity;

    private long s_employee_safe_issue;

    private long s_layoff;

    private long s_employee_stake;

    private long s_employee_welfare;

    private long s_safe_management;

    private long s_safe_education;

    private long s_employment_safety_certification;

    private long s_employment_safety_education;

    private long s_employee_communication;

    private double g_directors;

    private double g_supervisors;

    private double g_executives;

    private double g_independent_directors;

    private double g_primary_stockholder;

    private double g_cash_bonus_proportion;

    private double g_capital_award;

    private double g_interest_guarantee;

    private double g_net_asset_reward;

    private long g_finance_audit;

    private long g_control_audit;

    private double g_executive_quitting;

    private double g_nonrecurring_gains_and_losses;

    private long g_dishonesty_person;

    private long g_dishonesty_action;

    private long g_dishonesty_punished;

    private long g_illegal;

    private long g_have_extra_finance_form;

    private long g_willing_publish;

    private long g_have_publish;

    private long g_publish_quality;
}
