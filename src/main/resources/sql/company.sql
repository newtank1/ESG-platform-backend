drop database  if exists  `esg_database`;
create  database `esg_database`;
use `esg_database`;
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

create table corporation_esg_history(
                                        `corporation_id` int(11) not null ,
                                        `record_id` int(11) not null auto_increment,
                                        `time` date not null ,
                                        `ESG_total_score` double not null ,
                                        `E_score` double,
                                        `S_score` double,
                                        `G_score` double,
                                        `e_punished` int ,
                                        `e_have_accidents` int ,
                                        `e_monitored` int  ,
                                        `e_publish_idea` int ,
                                        `e_publish_goal` int ,
                                        `e_publish_regulation` int ,
                                        `e_use_emergency` int ,
                                        `e_three_wastes_measure` int ,
                                        `e_education` int ,
                                        `e_investment` decimal(10,5) ,
                                        `e_recycle_eco` int ,
                                        `e_save_resource` int ,
                                        `e_green_office` int ,
                                        `e_invention` int ,
                                        `e_useful_invention` int ,
                                        `e_action` int ,
                                        `e_product` int ,
                                        `e_certification` int ,
                                        `e_award` int ,
                                        `e_pollution` int ,
                                        `s_poverty_alleviation_amount` decimal(10,5) ,
                                        `s_poverty_escape` int ,
                                        `s_poverty_future_plan` int ,
                                        `s_poverty_activity` int ,
                                        `s_publish_staff_protection` int ,
                                        `s_publish_supplier_protection` int ,
                                        `s_publish_responsibility` int ,
                                        `s_publish_responsibility_construction` int ,
                                        `s_publish_safe_production` int ,
                                        `s_product_issue` int ,
                                        `s_donation` decimal(10,5) ,
                                        `s_support_education` int ,
                                        `s_support_charity` int ,
                                        `s_volunteer` int ,
                                        `s_international_assistance` int ,
                                        `s_activate_employment` int ,
                                        `s_promote_economy` int ,
                                        `s_quality_award` int ,
                                        `s_patent` int ,
                                        `s_research_pay` decimal(10,5) ,
                                        `s_researcher_proportion` double ,
                                        `s_skill_proportion` double ,
                                        `s_anti_corruption` int ,
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
                                        primary key (`record_id`),
                                        foreign key (`corporation_id`) references corporation_basic(`corporation_id`) on delete cascade on update cascade
)default charset=utf8;

create table corporation_esg(
        `corporation_id` int(11) not null ,
        `score` decimal(6,4) not null ,
        `ESG_total_ranking` int(11) not null ,
        `ESG_industry_ranking` int(11) not null ,
        `record_id` int(11) not null ,
        `esg_id` int not null auto_increment,
        primary key (`esg_id`),
        foreign key(`corporation_id`) references corporation_basic(`corporation_id`) on delete cascade on update cascade,
        foreign key (`record_id`) references corporation_esg_history(`record_id`) on DELETE cascade on update cascade
)default charset=utf8;

create table corporation_event(
        `corporation_id` int(11)not null,
        `time` date not null ,
        `event` text not null ,
        `event_id` int not null auto_increment,
        primary key (`event_id`),
        foreign key (`corporation_id`) references corporation_basic(`corporation_id`) on delete cascade on update cascade
)default charset=utf8;

create table corporation_opinion(
        `corporation_id` int(11) not null ,
        `time` date not null ,
        `opinion_text` text not null ,
        `opinion_score` double not null ,
        `opinion_id` int not null auto_increment,
        primary key (`opinion_id`),
        foreign key (`corporation_id`) references corporation_basic(`corporation_id`) on delete cascade on update cascade
)default charset=utf8;


create table corporation_stock(
        `corporation_id` int(11) not null ,
        `time` date not null ,
        `price` decimal not null ,
        `stock_id` int not null auto_increment,
        primary key (`stock_id`),
        foreign key (`corporation_id`) references corporation_basic(`corporation_id`) on delete cascade on update cascade
)default charset=utf8;

create view corporation_info
as
    select corporation_basic.corporation_id,name,stoke,industry,location,
           ESG_total_ranking,ESG_industry_ranking,corporation_esg.record_id,
           ESG_total_score,time
    from corporation_basic,corporation_esg,corporation_esg_history
    where corporation_basic.corporation_id=corporation_esg.corporation_id
        and corporation_esg.record_id=corporation_esg_history.record_id;