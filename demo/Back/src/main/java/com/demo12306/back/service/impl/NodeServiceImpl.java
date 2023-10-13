package com.demo12306.back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo12306.back.dao.NodeMapper;
import com.demo12306.back.entity.Node;
import com.demo12306.back.service.NodeService;
import org.springframework.stereotype.Service;

@Service
public class NodeServiceImpl extends ServiceImpl<NodeMapper, Node> implements NodeService {
}
