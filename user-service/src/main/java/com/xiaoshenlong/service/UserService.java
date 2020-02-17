package com.xiaoshenlong.service;

import com.xiaoshenlong.dao.UserDao;
import com.xiaoshenlong.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserVo selectByPrimaryKey(Integer userId){
        return userDao.selectByPrimaryKey(userId);
    }

    @Transactional
    public int insert(UserVo userVo){
        return userDao.insert(userVo);
    }

}
