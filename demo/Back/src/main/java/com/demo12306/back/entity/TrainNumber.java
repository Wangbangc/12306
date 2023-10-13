package com.demo12306.back.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainNumber {
    private Integer number;
    private ArrayList<RailNode> routes;
}
