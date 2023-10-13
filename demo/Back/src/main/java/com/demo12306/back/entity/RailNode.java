package com.demo12306.back.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@TableName("rail_node")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RailNode {

    private Integer id;
    private Timestamp startTime;
    private Integer startStationId;
    private Timestamp endTime;
    private Integer endStationId;
}
