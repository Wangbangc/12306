package com._12306.back.controller;

import com._12306.back.common.R;
import com._12306.back.entity.User;
import com._12306.back.service.UserService;
import com._12306.back.utils.JwtUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public R<String> login(@RequestBody User user){
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        qw.eq(User::getUsername,user.getUsername());
        User user1 = userService.getOne(qw);
        if(user1.getPassword().equals(user.getPassword())){
            String token = JwtUtils.generateToken(user.getUsername());
            return R.success(token);
        }else return R.error("密码不正确");

    }
    @PostMapping
    public R<String> save(@RequestBody User user){
        userService.save(user);
        return R.success("添加成功");
    }
    @GetMapping("/page")
    public R<Page> page(@RequestParam Integer page,@RequestParam Integer pageSize,@RequestParam String name){
        Page pageInfo = new Page(page, pageSize);
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        qw.like(StringUtils.isNoneEmpty(name),User::getUsername,name);
        qw.orderByAsc(User::getId);
        userService.page(pageInfo,qw);
        return R.success(pageInfo);
    }

}
