package com.demo12306.back.service.impl;

import com.demo12306.back.dao.UserMapper;
import com.demo12306.back.entity.User;
import com.demo12306.back.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

}
