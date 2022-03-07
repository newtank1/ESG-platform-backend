package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationBasicPo;
import com.platform.esgplatformbackend.model.po.UserInterestPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserInterestMapper {
    @Insert("insert into user_interest(uid,interest_corporation_id) values(#{uid},#{interest_corporation_id})")
    int insert(UserInterestPo userInterestPo);

    @Select("select * from user_interest where uid = #{uid} and interest_corporation_id = #{interest_corporation_id}")
    UserInterestPo getUserInterest(UserInterestPo userInterestPo);

    @Delete("delete from user_interest where uid = #{uid} and interest_corporation_id = #{interest_corporation_id}")
    int delete(UserInterestPo userInterestPo);

    @Select("select * from user_interest where uid = #{uid}")
    List<UserInterestPo> getUserAllInterests(Integer uid);

}
