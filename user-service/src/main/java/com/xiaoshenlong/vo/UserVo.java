package com.xiaoshenlong.vo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Table(name = "t_user")
public class UserVo {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer userId;

    private String username;

    private Integer sex;

    private Integer age;

    @Transient
    private String hobby;

}
