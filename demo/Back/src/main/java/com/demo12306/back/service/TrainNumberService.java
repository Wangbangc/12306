package com.demo12306.back.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo12306.back.entity.Node;
import com.demo12306.back.entity.RailNode;
import com.demo12306.back.entity.TrainNumber;

import java.util.List;

public interface TrainNumberService  {
    Page<TrainNumber> getTrainsNumberPage(int currentPage,int pageSize,Integer id);
    boolean save(List<RailNode> nodes);
    boolean delete(Integer id);
    public List<TrainNumber> findTrainsBetweenStations(Integer start,Integer end);

}
