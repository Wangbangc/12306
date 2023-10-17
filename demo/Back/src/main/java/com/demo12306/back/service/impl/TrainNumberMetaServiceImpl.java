package com.demo12306.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo12306.back.dao.RailNodeMapper;
import com.demo12306.back.dao.TrainNumberMetaMapper;
import com.demo12306.back.entity.RailNode;
import com.demo12306.back.entity.TrainNumberMeta;
import com.demo12306.back.service.RailNodeService;
import com.demo12306.back.service.TrainNumberMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainNumberMetaServiceImpl extends ServiceImpl<TrainNumberMetaMapper, TrainNumberMeta> implements TrainNumberMetaService {
    @Autowired
    RailNodeMapper railNodeMapper;
    @Override
    public boolean deleteById(Integer id) {
        LambdaQueryWrapper<RailNode> wq = new LambdaQueryWrapper<>();
        wq.eq(RailNode::getId,id);
        return railNodeMapper.delete(wq)!=0;

    }
}
