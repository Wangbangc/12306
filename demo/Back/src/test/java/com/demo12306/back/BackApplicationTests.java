package com.demo12306.back;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.demo12306.back.dao.RailNodeMapper;
import com.demo12306.back.dao.UserMapper;
import com.demo12306.back.entity.Node;
import com.demo12306.back.entity.RailNode;
import com.demo12306.back.entity.User;
import com.demo12306.back.service.NodeService;
import com.demo12306.back.service.RailNodeService;
import com.demo12306.back.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
class BackApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Autowired
    RailNodeService railNodeService;
    @Autowired
    NodeService nodeService;
    @Test
    void contextLoads() {
        System.out.println(nodeService.save(new Node(1, "test")));
        /*System.out.println(userMapper.selectByName("root"));*/
    }
    @Test
    void MybatisPlusGenerate(){
        FastAutoGenerator.create(url,username,password)
                .globalConfig(builder -> {
                    builder.author("MadPsycho");
                })
                .packageConfig(builder -> {
                    builder.parent("com.demo12306.back")
                            .entity("entity")
                            .mapper("dao")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller");
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user");
                })
                .strategyConfig(builder -> {
                    builder.addInclude("rail_node");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
