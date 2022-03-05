drop table if exists corporation_esg;
drop table if exists corporation_event;
drop table if exists corporation_opinion;
drop table if exists corporation_esg_history;
drop table if exists corporation_stock;
drop table if exists corporation_basic;

create table corporation_basic(
        `corporation_id` int(11) not null auto_increment,
        `name` varchar(255) not null unique ,
        `stoke` int(11) not null ,
        `industry` varchar(255) not null ,
        `location` varchar(255) not null,
        primary key (`corporation_id`)
)default charset=utf8;

create table corporation_esg(
        `corporation_id` int(11) not null ,
        `ESG_score` double not null ,
        `ESG_total_ranking` int(11) not null ,
        `ESG_industry_ranking` int(11) not null ,
        `time` date not null ,
        `E_score` double,
        `S_score` double,
        `G_score` double,
        `e_punished` int default 0,
        `e_have_accidents` int default 0,
        `e_monitored` int default 0 ,
        `e_publish_idea` int default 0,
        `e_publish_goal` int default 0,
        `e_publish_regulation` int default 0,
        `e_use_emergency` int default 0,
        `e_three_wastes_measure` int default 0,
        `e_education` int default 0,
        `e_investment` decimal(10,2) default 0,
        `e_recycle_eco` int default 0,
        `e_save_resource` int default 0,
        `e_green_office` int default 0,
        `e_invention` int default 0,
        `e_useful_invention` int default 0,
        `e_action` int default 0,
        `e_product` int default 0,
        `e_certification` int default 0,
        `e_award` int default 0,
        `e_pollution` int default 0,
        `s_poverty_alleviation_amount` decimal default 0,
        `s_poverty_escape` int default 0,
        `s_poverty_future_plan` int default 0,
        `s_poverty_activity` int default 0,
        `s_publish_staff_protection` int default 0,
        `s_publish_supplier_protection` int default 0,
        `s_publish_responsibility` int default 0,
        `s_publish_responsibility_construction` int default 0,
        `s_publish_safe_production` int default 0,
        `s_product_issue` int default 0,
        `s_donation` decimal(10,2) default 0,
        `s_support_education` int default 0,
        `s_support_charity` int default 0,
        `s_volunteer` int default 0,
        `s_international_assistance` int default 0,
        `s_activate_employment` int default 0,
        `s_promote_economy` int default 0,
        `s_quality_award` int default 0,
        `s_patent` int default 0,
        `s_research_pay` decimal(10,2) default 0,
        `s_researcher_proportion` double default 0,
        `s_skill_proportion` double default 0,
        `s_anti_corruption` int default 0,
        `s_share_strategy` int,
        `s_operation_integrity` int,
        `s_employee_safe_issue` int,
        `s_layoff` int,
        `s_employee_stake` int,
        `s_employee_welfare` int,
        `s_safe_management` int,
        `s_safe_education` int,
        `s_employment_safety_certification` int,
        `s_employment_safety_education` int,
        `s_employee_communication` int,
        `g_directors` double,
        `g_supervisors` double,
        `g_executives` double,
        `g_independent_directors` double,
        `g_primary_stockholder` double,
        `g_cash_bonus_proportion` double,
        `g_capital_award` double,
        `g_interest_guarantee` double,
        `g_net_asset_reward` double,
        `g_finance_audit` int,
        `g_control_audit` int,
        `g_executive_quitting` double,
        `g_nonrecurring_gains_and_losses` double,
        `g_dishonesty_person` int,
        `g_dishonesty_action` int,
        `g_dishonesty_punished` int,
        `g_illegal` int,
        `g_have_extra_finance_form` int,
        `g_willing_publish` int,
        `g_have_publish` int,
        `g_publish_quality` int,
        foreign key(`corporation_id`) references corporation_basic(`corporation_id`) on delete cascade on update cascade
)default charset=utf8;

create table corporation_event(
        `corporation_id` int(11)not null,
        `time` date not null ,
        `event` text not null ,
        foreign key (`corporation_id`) references corporation_basic(`corporation_id`) on delete cascade on update cascade
)default charset=utf8;

create table corporation_opinion(
        `corporation_id` int(11) not null ,
        `time` date not null ,
        `opinion_text` text not null ,
        `opinion_score` double not null ,
        foreign key (`corporation_id`) references corporation_basic(`corporation_id`) on delete cascade on update cascade
)default charset=utf8;

create table corporation_esg_history(
        `corporation_id` int(11) not null ,
        `time` date not null ,
        `ESG_total_score` double not null ,
        `E_score` double,
        `S_score` double,
        `G_score` double,
        foreign key (`corporation_id`) references corporation_basic(`corporation_id`) on delete cascade on update cascade
)default charset=utf8;

create table corporation_stock(
        `corporation_id` int(11) not null ,
        `time` date not null ,
        `price` decimal not null ,
        foreign key (`corporation_id`) references corporation_basic(`corporation_id`) on delete cascade on update cascade
)default charset=utf8;