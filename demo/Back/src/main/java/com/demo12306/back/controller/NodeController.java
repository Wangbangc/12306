package com.demo12306.back.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.demo12306.back.common.R;
import com.demo12306.back.entity.Node;
import com.demo12306.back.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/node")
public class NodeController {
    @Autowired
    NodeService nodeService;

    @PostMapping
    public R<String> save(@RequestBody Node node) {
        LambdaQueryWrapper<Node> qw = new LambdaQueryWrapper<>();
        qw.eq(Node::getId, node.getId());
        if (nodeService.getOne(qw) == null){
            nodeService.save(node);
            return R.success("添加成功");
        }
        return R.error("已经存在该条数据");
    }
    @GetMapping
    public R<List<Node>> select(){
        List<Node> list = nodeService.list();
        return R.success(list);
    }
    @DeleteMapping("/{id}")
    public R<String> drop(@PathVariable Integer id){
        LambdaQueryWrapper<Node> qw = new LambdaQueryWrapper<>();
        qw.eq(Node::getId,id);
        if(nodeService.remove(qw)){
            return R.success("删除成功");
        }
        return R.error("删除失败");
    }

}
