package com.xiaoshenlong.config;

import com.xiaoshenlong.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface UserClient {

    @GetMapping("userController/selectByPrimaryKey/{userId}.do")
    UserVo selectByPrimaryKey(@PathVariable("userId") Integer userId);

}
