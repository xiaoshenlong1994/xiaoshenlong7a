package com.xiaoshenlong.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiaoshenlong.config.UserClient;
import com.xiaoshenlong.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/userController")
@Slf4j
@DefaultProperties(defaultFallback = "userFallback")
public class UserController {

    @Autowired
    private UserClient userClient;

    @RequestMapping("/selectByPrimaryKey/{userId}.do")
    @ResponseBody
    //配置线程熔断
    /*@HystrixCommand(commandProperties = {
            //配置线程熔断的实验次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            //开启后的休眠时间窗,即10秒后进入半开半闭状态，放一些请求重新进入判断是否请求成功
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //开启熔断的实验次数百分比
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")
    })*/
    @HystrixCommand
    public UserVo selectByPrimaryKey(@PathVariable("userId") Integer userId){
        if(userId % 2==0){
            throw new RuntimeException("");
        }
        UserVo userVo = userClient.selectByPrimaryKey(userId);
        log.debug("retUserVo:"+userVo);
        return userVo;
    }

    /*public UserVo selectByPrimaryKeyFallBack(Integer userId){
        UserVo userVo = new UserVo();
        userVo.setUsername("不好意思系统拥挤,查询:"+userId+"用户信息异常！");
        return userVo;
    }*/

    public UserVo userFallback(){
        UserVo userVo = new UserVo();
        userVo.setUsername("不好意思系统拥挤,查询用户信息异常！");
        return userVo;
    }

}
