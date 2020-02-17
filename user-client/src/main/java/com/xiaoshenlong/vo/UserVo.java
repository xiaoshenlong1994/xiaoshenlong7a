package com.xiaoshenlong.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class UserVo implements Serializable {

    private Integer userId;

    private String username;

    private Integer sex;

    private Integer age;

    private String hobby;

}
