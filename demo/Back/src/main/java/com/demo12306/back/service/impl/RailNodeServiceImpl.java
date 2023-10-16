package com.demo12306.back.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo12306.back.dao.RailNodeMapper;
import com.demo12306.back.entity.RailNode;
import com.demo12306.back.service.RailNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RailNodeServiceImpl extends ServiceImpl<RailNodeMapper, RailNode> implements RailNodeService {
    @Autowired
    RailNodeMapper railNodeMapper;

    @Override
    public List<RailNode> selectGroupById() {
        LambdaQueryWrapper<RailNode> lq = new LambdaQueryWrapper<>();
        lq.select(RailNode::getId).groupBy(RailNode::getId);
        return railNodeMapper.selectList(lq);
    }
}
