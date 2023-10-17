package com.demo12306.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo12306.back.entity.TrainNumberMeta;

public interface TrainNumberMetaService extends IService<TrainNumberMeta> {
    boolean deleteById(Integer id);
}
