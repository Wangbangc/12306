package com._12306.back.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@TableName("user")
@Data
@NoArgsConstructor
public class User {
    @TableId
    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String city;

    private Integer status;

    private Boolean minister;

}