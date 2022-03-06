package com.platform.esgplatformbackend.dao;

import com.platform.esgplatformbackend.model.po.CorporationBasicPo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CorporationBasicMapper {

    @Select("select * from corporation_basic")
    List<CorporationBasicPo> getAllCorporation();

    @Select("select * from corporation_basic where corporation_id = #{id}")
    CorporationBasicPo getCorporationById(Integer id);

    @Select("<script>" +
            "select * from corporation_basic " +
            "where 1=1 " +
            "<if test='name!=null'> and name like '%${name}%' </if>" +
            "<if test='industry!=null'>and industry = #{industry} </if>" +
            "<if test='location!=null'>and location = #{location} </if>" +
            "</script>")
    List<CorporationBasicPo> getCorporationBySearch(String name,String industry,String location);

    @Insert("insert into corporation_basic(name,stoke,industry,location) values(#{name},#{stoke},#{industry},#{location})")
    @Options(useGeneratedKeys = true,keyProperty = "corporation_id")
    int insert(CorporationBasicPo po);

    @Update("update corporation_basic set name=#{name},stoke=#{stoke},industry=#{industry},location=#{location}" +
            " where corporation_id=#{id}" )
    int update(String name,Integer stoke,String industry,String location,Integer id);

    @Delete("delete from corporation_basic where corporation_id = #{id}")
    int delete(Integer id);
}
