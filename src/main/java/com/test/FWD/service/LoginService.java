package com.test.FWD.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.FWD.dtos.User;
import org.springframework.stereotype.Service;

public interface LoginService extends IService<User> {


    void saveUser(User user);

    User getByName(User user);
}
