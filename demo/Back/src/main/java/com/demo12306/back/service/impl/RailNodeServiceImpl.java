package com.demo12306.back.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo12306.back.dao.RailNodeMapper;
import com.demo12306.back.entity.RailNode;
import com.demo12306.back.service.RailNodeService;
import org.springframework.stereotype.Service;

@Service
public class RailNodeServiceImpl extends ServiceImpl<RailNodeMapper, RailNode> implements RailNodeService {

}
