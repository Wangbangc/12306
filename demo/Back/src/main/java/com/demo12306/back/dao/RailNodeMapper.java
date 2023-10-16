package com.demo12306.back.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo12306.back.entity.RailNode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RailNodeMapper extends BaseMapper<RailNode> {

    @Select("select * from rail_node order by id, start_time;")
    List<RailNode> getAllRailnode();
    @Select("select count(distinct id) from rail_node;")
    Integer getTotalTrainNumbers();
}
