package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationEventPo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
@Mapper
public interface CorporationEventMapper {

    @Select("select * from corporation_event where corporation_id=#{corporation_id}")
    List<CorporationEventPo> getEvents(Integer corporation_id);

    @Select("select * from corporation_event where corporation_id=#{corporation_id} and to_days(now())-to_days(time) <= #{day}")
    List<CorporationEventPo> getEventsByTime(Integer corporation_id,Integer day);

    @Select("select * from corporation_event where event_id=#{event_id}")
    CorporationEventPo getEventByEventId(Integer event_id);

    @Insert("insert into corporation_event(corporation_id,time,event) values(#{corporation_id},#{time},#{event})")
    @Options(useGeneratedKeys = true,keyProperty = "event_id")
    int insert(CorporationEventPo po);

    @Update("update corporation_event set event=#{event} where event_id=#{event_id}")
    int update(String event,Integer event_id);

    @Delete("delete from corporation_event where event_id=#{event_id}")
    int delete(Integer event_id);
}
