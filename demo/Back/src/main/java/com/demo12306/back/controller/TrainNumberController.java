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
    @PostMapping
    public R<String> save(@RequestBody List<RailNode> nodes){
        for (RailNode node : nodes) {
            System.out.println(node);
        }
        if( trainNumberService.save(nodes)){
            return R.success("添加成功");
        }
        return R.error("添加失败");
    }
    @GetMapping("/page")
    public R<Page> page(@RequestParam Integer page,@RequestParam Integer pageSize,@RequestParam(required = false) Integer id){
        Page<TrainNumber> Page = trainNumberService.getTrainsNumberPage(page, pageSize, id);
        if(Page!=null){
            return R.success(Page);

        }
            return R.error("查询失败");
    }
    @GetMapping
    public  R<List<TrainNumber>> find(@RequestParam Integer start,@RequestParam Integer end){
        List<TrainNumber> res = trainNumberService.findTrainsBetweenStations(start, end);
        if(res!=null)return R.success(res);
        return R.error("查找出错");
    }
    @DeleteMapping("/{id}")
    public R<String> delete(@PathVariable Integer id){
        if(trainNumberService.delete(id))return R.success("删除成功");
        return R.error("删除失败");
    }
}
