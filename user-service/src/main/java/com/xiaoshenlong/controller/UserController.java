package com.xiaoshenlong.controller;

import com.xiaoshenlong.service.UserService;
import com.xiaoshenlong.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/userController")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/selectByPrimaryKey/{userId}.do")
    @ResponseBody
    public UserVo selectByPrimaryKey(@PathVariable("userId") Integer userId){
        UserVo userVo = userService.selectByPrimaryKey(userId);
        log.debug("userVo:"+userVo);
        return userVo;
    }

    @RequestMapping("/insert.do")
    @ResponseBody
    public int insert(){
        UserVo userVo = new UserVo();
        userVo.setUsername("xsl");
        userVo.setSex(5);
        userVo.setAge(40);
        userVo.setHobby("xsl basketball");
        int count = userService.insert(userVo);
        log.debug("count="+count);
        return count;
    }

}
