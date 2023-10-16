package com.demo12306.back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo12306.back.common.R;
import com.demo12306.back.entity.Node;
import com.demo12306.back.entity.RailNode;
import com.demo12306.back.entity.TrainNumber;
import com.demo12306.back.service.RailNodeService;
import com.demo12306.back.service.TrainNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/number")
public class TrainNumberController {
    @Autowired
    TrainNumberService trainNumberService;
    /*@PostMapping
    public R<String> save(@RequestBody List<RailNode> nodes){
        railNodeService.saveBatch(nodes);
        return null;
    }*/
    @GetMapping("/page")
    public R<Page> page(@RequestParam Integer page,@RequestParam Integer pageSize,@RequestParam(required = false) Integer id){
       return R.success(trainNumberService.getTrainsNumberPage(page,pageSize,id));

    }
}
