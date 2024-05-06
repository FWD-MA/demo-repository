package com.test.FWD.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.FWD.dtos.User;
import com.test.FWD.mapper.LoginMapper;
import com.test.FWD.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, User> implements LoginService {

    @Override
    public User getByName(User user) {
        return getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername,user.getUsername()));
    }

    @Override
    public void saveUser(User user) {
        save(user);
    }
}
