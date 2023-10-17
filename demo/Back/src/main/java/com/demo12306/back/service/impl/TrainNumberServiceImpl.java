package com.demo12306.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo12306.back.dao.RailNodeMapper;
import com.demo12306.back.dao.TrainNumberMetaMapper;
import com.demo12306.back.entity.Node;
import com.demo12306.back.entity.RailNode;
import com.demo12306.back.entity.TrainNumber;
import com.demo12306.back.entity.TrainNumberMeta;
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


    private List<TrainNumber> getAllTrainNumbers() {
        List<RailNode> allRailnode = railNodeMapper.getAllRailnode();
        Map<Integer, List<RailNode>> collect = allRailnode.stream().collect(Collectors.groupingBy(RailNode::getId));
        ArrayList<TrainNumber> trainNumbers = new ArrayList<>();
        for (Map.Entry<Integer, List<RailNode>> entry : collect.entrySet()) {
            TrainNumber trainNumber = new TrainNumber();
            trainNumbers.add(new TrainNumber(entry.getKey(), entry.getValue()));
        }
        return trainNumbers;
    }

    public List<TrainNumber> findTrainsBetweenStations(Integer start, Integer end) {
        return getAllTrainNumbers().stream().filter(trainNumber ->
                trainNumber.getRoutes().stream().anyMatch(railNode -> railNode.getStartStationId().equals(start)) &&
                        trainNumber.getRoutes().stream().anyMatch(railNode -> railNode.getEndStationId().equals(end))
        ).collect(Collectors.toList());

    }


    public Page<TrainNumber> getTrainsNumberPage(int currentPage, int pageSize, Integer id) {
        List<TrainNumber> trainNumbers = getAllTrainNumbers();
        if (id != null) {
            List<TrainNumber> res = trainNumbers.stream().filter(s -> id.equals(s.getNumber())).toList();
            trainNumbers.clear();
            trainNumbers.addAll(res);

        }
        Integer totalNumber = railNodeMapper.getTotalTrainNumbers();
        Page<TrainNumber> Page = new Page<>(currentPage, pageSize, totalNumber);
        Page.setRecords(trainNumbers);
        return Page;
    }

    @Override
    public boolean save(List<RailNode> nodes) {
        int insert = 0;
        for (RailNode node : nodes) {
            insert += railNodeMapper.insert(node);
        }
        return insert != 0;
    }

    @Override
    public boolean delete(Integer id) {
        LambdaQueryWrapper<RailNode> qw = new LambdaQueryWrapper<>();
        qw.eq(RailNode::getId, id);
        return railNodeMapper.delete(qw) != 0;
    }


}
