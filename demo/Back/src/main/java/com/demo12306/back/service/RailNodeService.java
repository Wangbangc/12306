package com.demo12306.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo12306.back.entity.RailNode;

import java.util.List;

public interface RailNodeService extends IService<RailNode> {
    List<RailNode> selectGroupById();
}
