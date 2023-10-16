package com.demo12306.back.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo12306.back.dao.RailNodeMapper;
import com.demo12306.back.entity.Node;
import com.demo12306.back.entity.RailNode;
import com.demo12306.back.entity.TrainNumber;
import com.demo12306.back.service.RailNodeService;
import com.demo12306.back.service.TrainNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TrainNumberServiceImpl implements TrainNumberService {
    @Autowired
    RailNodeService railNodeService;
    @Autowired
    RailNodeMapper railNodeMapper;
    public Page<TrainNumber> getTrainsNumberPage(int currentPage,int pageSize,Integer id){
        List<RailNode> allRailnode = railNodeMapper.getAllRailnode();
        Map<Integer, List<RailNode>> collect = allRailnode.stream().collect(Collectors.groupingBy(RailNode::getId));
        ArrayList<TrainNumber> trainNumbers = new ArrayList<>();
        for (Map.Entry<Integer, List<RailNode>> entry : collect.entrySet()) {
            TrainNumber trainNumber = new TrainNumber();
            trainNumbers.add(new TrainNumber(entry.getKey(),null,entry.getValue()));
        }
        if(id!=null){
            List<TrainNumber> res = trainNumbers.stream().filter(s -> id.equals(s.getNumber())).toList();
            trainNumbers.clear();
            trainNumbers.addAll(res);

        }
        Integer totalNumber = railNodeMapper.getTotalTrainNumbers();
        Page<TrainNumber> Page = new Page<>(currentPage,pageSize,totalNumber);
        Page.setRecords(trainNumbers);
        return Page;
    }

    @Override
    public boolean save(List<Node> nodes) {
        return false;
    }

    @Override
    public List<TrainNumber> selectAll() {
        return null;
    }

    @Override
    public TrainNumber selectById() {
        return null;
    }
}
